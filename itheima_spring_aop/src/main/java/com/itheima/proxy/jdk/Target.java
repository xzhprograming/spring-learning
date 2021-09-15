package com.itheima.proxy.jdk;

public class Target implements TargetInterface, TargetInterface1 {
    public void save() {
        System.out.println("TargetInterface   save running.....");
    }

    public void save1() {
        System.out.println("TargetInterface1  save running..... ");
    }
}
