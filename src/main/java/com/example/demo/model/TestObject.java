package com.example.demo.model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestObject {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Student> studentClass = Student.class;
        Field[] declaredFields = studentClass.getDeclaredFields();
        for(Field field:declaredFields){
            System.out.println(field);
        }
        Field[] fields = studentClass.getFields();
        for(Field field:fields){
            System.out.println(field);
        }

        Student student = new Student();
        Class aClass = student.getClass();
        Field[] declaredFields1 = aClass.getDeclaredFields();
        for(Field field:declaredFields1){
            System.out.println(field);
        }

        /*Class<?> student1 = Class.forName("com.fusion.http.model.TestObject.Student");
        Field[] student1Field = student1.getDeclaredFields();
        for(Field field:student1Field){
            System.out.println(field);
        }*/
        Object obj = aClass.newInstance();

        Method[] declaredMethods = aClass.getDeclaredMethods();


        Method add = aClass.getDeclaredMethod("add", int.class);
        Object invoke = add.invoke(obj, 1);
        System.out.println(invoke);


        Object add1 = getMethods("com.fusion.http.model.Teacher", "add", 1, 2);
        System.out.println(invoke);
        Object name = getMethods("com.fusion.http.model.Teacher", "getName", "zhangsan");
        System.out.println(name);
    }

    public static Object getMethods(String className,String methodName,Object ... args){
        try{
            Class[] parameterTypes = new Class[args.length];
            for(int i =0;i<args.length;i++){
                parameterTypes[i] = args[i].getClass();
            }
            Class aClass = Class.forName(className);
            Object objectClass = aClass.newInstance();
            Method method = aClass.getMethod(methodName, parameterTypes);
            return method.invoke(objectClass, args);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    static class Student{
        private String name;
        private int age;
        public int add(int number){
           return number+1;
        };
        public int del(int number){
            return number-1;
        };
    }
}
