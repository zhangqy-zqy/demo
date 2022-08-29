package com.example.demo.utils;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName ReaderConfigPropertiesUtils.java
 * @Description TODO
 * @createTime 2021年02月20日 17:47:00
 */
public class ReaderConfigPropertiesUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReaderConfigPropertiesUtils.class);

    /**
     * 类加载时 初始化配置的文件信息
     *
     * @param path 读取的文件存放地址r
     */
    public static synchronized String readerConfigPropertiesMethod(String path) {
        FileReader fileReader = null;
        BufferedReader br = null;
        StringBuilder stb=new StringBuilder();
        try {
            fileReader = new FileReader(path);
            br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null) {
                if (Strings.isNotEmpty(line)) {
                    stb.append(line);
                }
            }
        } catch (Exception e) {
            LOGGER.error("ReaderConfigPropertiesUtils -> readerConfigPropertiesMethod path {} 错误信息：{}", path,e.getMessage());
        } finally {
            closeCloseable(br, fileReader);
        }
        return stb.toString();
    }

    /**
     * 关闭流
     *
     * @param closeable close
     */
    public static void closeCloseable(Closeable... closeable) {
        if (closeable != null) {
            for (Closeable c : closeable) {
                try {
                    if (c != null) {
                        c.close();
                    }
                } catch (IOException ignored) {
                }
            }
        }
    }
}
