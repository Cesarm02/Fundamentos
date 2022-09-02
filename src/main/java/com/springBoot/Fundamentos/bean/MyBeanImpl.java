package com.springBoot.Fundamentos.bean;

public class MyBeanImpl implements  MyBean{
    @Override
    public void print() {
        System.out.println("Hola MyBeanImpl");
    }
}
