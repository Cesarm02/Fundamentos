package com.springBoot.Fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependenceyImpl implements  MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependenceyImpl.class);

    private MyOperation myOperation;

    public MyBeanWithDependenceyImpl(MyOperation myOperation){
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Ingreso al metodo MyBeanWithDependenceyImpl");
        int numero = 1;
        LOGGER.debug("EL numero eviado " + numero );
        System.out.println(myOperation.sum(numero));
        System.out.println("Implementacion Bean Operation");
    }
}
