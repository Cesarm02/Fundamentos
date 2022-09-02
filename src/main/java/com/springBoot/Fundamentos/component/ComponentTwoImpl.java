package com.springBoot.Fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImpl implements ComponentDependencia{

    @Override
    public void saludar() {
        System.out.println("2 Component");
    }
}
