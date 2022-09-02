package com.springBoot.Fundamentos.bean;

public class MyOperationImpl implements  MyOperation{
    @Override
    public int sum(int numero) {
        return numero+1;
    }
}
