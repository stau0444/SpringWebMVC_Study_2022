package com.study.springmvc_2022;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class ReflectionTests {
    @Test
    void objectCreateAndMethodCall() throws Exception{
        //보편적인 객체 접근
        Duck duck = new Duck();
        duck.quack();
        //리플렉션을 이용한 객체 접근
        Class<?> duckClass = Class.forName(ReflectionTests.Duck.class.getName());
        Object duckInstance = duckClass.getDeclaredConstructor().newInstance();
        Method quack = duckInstance.getClass().getDeclaredMethod("quack", new Class<?>[0]);
        quack.invoke(duckInstance);

    }
    static class Duck{
        void quack(){
            System.out.println("꽥꽥");
        }
    }
}
