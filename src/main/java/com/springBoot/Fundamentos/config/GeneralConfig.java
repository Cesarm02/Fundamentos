package com.springBoot.Fundamentos.config;

import com.springBoot.Fundamentos.bean.MyBeanWithProperties;
import com.springBoot.Fundamentos.bean.MyBeanWithPropertiesImpl;
import com.springBoot.Fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfig {

    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String jdbcDriver;

    @Value("${username}")
    private String jdbcUsername;

    @Value("${password}")
    private String jdbcPassword;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImpl(name, apellido);
    }

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(jdbcDriver);
        dataSourceBuilder.url(jdbcUrl);
        dataSourceBuilder.username(jdbcUsername);
        dataSourceBuilder.password(jdbcPassword);
        return dataSourceBuilder.build();
    }

}
