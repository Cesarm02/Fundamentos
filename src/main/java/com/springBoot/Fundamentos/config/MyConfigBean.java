package com.springBoot.Fundamentos.config;

import com.springBoot.Fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigBean {

    @Bean
    public MyBean beanOperation(){
        return new MyBeanTwoImpl();
    }

    @Bean
    public MyOperation beanOperationOperation(){
        return new MyOperationImpl();
    }

    @Bean
    public MyBeanWithDependency beanOperationOPerationWithDependency(MyOperation myOperation){
        return new MyBeanWithDependenceyImpl(myOperation);
    }
}
