package com.itheima.aop;

public class Target implements TargetInterface, TargetInterface1 {
    public void save() {
        System.out.println("save running.....");
//        int i = 1/0;
    }

    public void save1() {
        System.out.println("save1 running test!...");
    }
}
