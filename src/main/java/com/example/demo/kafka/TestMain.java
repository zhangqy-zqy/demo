package com.example.demo.kafka;


import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.Future;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName TestMain.java
 * @Description TODO
 * @createTime 2021年09月10日 11:24:00
 */
public class TestMain {

    @Test
    public void testProducer() throws Exception {


        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "node02:9092,node01:9092,node03:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());


        properties.setProperty(ProducerConfig.LINGER_MS_CONFIG,"0");  //




        properties.setProperty(ProducerConfig.BUFFER_MEMORY_CONFIG,"33554432");//32M
        properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG,"16384"); //16k 要调整的,分析我们msg的大小，尽量触发批次发送，减少内存碎片，和系统调用的复杂度
        properties.setProperty(ProducerConfig.MAX_REQUEST_SIZE_CONFIG,"1048576");
        //message.max.bytes





        properties.setProperty(ProducerConfig.MAX_BLOCK_MS_CONFIG,"60000"); //60秒

        //发送5次  kafka没有返回
        properties.setProperty(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION,"5");

        properties.setProperty(ProducerConfig.SEND_BUFFER_CONFIG,"32768");  //32K   -1
        properties.setProperty(ProducerConfig.RECEIVE_BUFFER_CONFIG,"32768"); //32k  -1
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String topic = "msb-items";
                String key = "key:" + j;
                String value = "value:" + i;
                ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, value);
                System.out.println("key:" + key + " value:" + value);
                Future<RecordMetadata> send = producer.send(record);
                RecordMetadata recordMetadata = send.get();
                recordMetadata.partition();
                recordMetadata.offset();
                recordMetadata.timestamp();

            }

        }
    }

    @Test
    public void testConsumer() {


        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "node02::9092,node01:9092,node03:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "xxoo-group");

        properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        //properties.setProperty(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "5");
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        //properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "");


        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList("msb-items"), new ConsumerRebalanceListener() {
            //撤销的分区
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
                System.out.println("---onPartitionsRevoked:");
                Iterator<TopicPartition> iter = partitions.iterator();
                while(iter.hasNext()){
                    System.out.println(iter.next().partition());
                }

            }

            //分配的分区
            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
                System.out.println("---onPartitionsAssigned:");
                Iterator<TopicPartition> iter = partitions.iterator();

                while(iter.hasNext()){
                    System.out.println(iter.next().partition());
                }


            }
        });

        while (true) {

            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            Set<TopicPartition> partitions = records.partitions();
            partitions.forEach(topicPartition->{
                List<ConsumerRecord<String, String>> recordList = records.records(topicPartition);
                int size = recordList.size();
                recordList.forEach(consumerRecord->{
                    long offset = consumerRecord.offset();
                    String key = consumerRecord.key();
                    String value = consumerRecord.value();
                    System.out.println("key:" + key + " value:" + value + " partition:" + consumerRecord.partition() + " offset:" + offset);

                });
                ConsumerRecord<String, String> consumerRecord = recordList.get(size - 1);
                long offset = consumerRecord.offset();
                OffsetAndMetadata offsetAndMetadata=new OffsetAndMetadata(offset+1);
                final Map<TopicPartition, OffsetAndMetadata> offsets=new HashMap<>();
                offsets.put(topicPartition,offsetAndMetadata);
                consumer.commitSync(offsets);
            });
            consumer.commitSync();


            /*Iterator<ConsumerRecord<String, String>> iterator = records.iterator();
            while (iterator.hasNext()) {
                ConsumerRecord<String, String> record = iterator.next();
                int partition = record.partition();
                long offset = record.offset();
                String key = record.key();
                String value = record.value();
                System.out.println("key:" + key + " value:" + value + " partition:" + partition + " offset:" + offset);
                OffsetAndMetadata offsetAndMetadata=new OffsetAndMetadata(offset+1);
                TopicPartition topicPartition=new TopicPartition(topic,partition);
                final Map<TopicPartition, OffsetAndMetadata> offsets=new HashMap<>();
                offsets.put(topicPartition,offsetAndMetadata);
                consumer.commitSync(offsets);
            }
            consumer.commitSync();*/

        }

    }

}
