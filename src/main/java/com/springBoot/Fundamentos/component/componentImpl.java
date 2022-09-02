package com.springBoot.Fundamentos.component;

import org.springframework.stereotype.Service;

@Service
public class componentImpl implements ComponentDependencia{
    @Override
    public void saludar() {
        System.out.println("Hola component");
    }
}
