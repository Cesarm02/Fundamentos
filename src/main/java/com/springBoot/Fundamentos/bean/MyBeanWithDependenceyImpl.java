package com.springBoot.Fundamentos.bean;

public class MyBeanWithDependenceyImpl implements  MyBeanWithDependency{

    private MyOperation myOperation;

    public MyBeanWithDependenceyImpl(MyOperation myOperation){
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int numero = 1;
        System.out.println(myOperation.sum(numero));
        System.out.println("Implementacion Bean Operation");
    }
}
