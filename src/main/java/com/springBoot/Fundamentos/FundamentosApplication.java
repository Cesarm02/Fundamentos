package com.springBoot.Fundamentos;

import com.springBoot.Fundamentos.bean.MyBean;
import com.springBoot.Fundamentos.bean.MyBeanWithDependency;
import com.springBoot.Fundamentos.bean.MyBeanWithProperties;
import com.springBoot.Fundamentos.component.ComponentDependencia;

import com.springBoot.Fundamentos.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	private ComponentDependencia componentDependencia;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	public FundamentosApplication(@Qualifier("componentTwoImpl") ComponentDependencia componentDependencia, MyBean myBean,
								  MyBeanWithDependency myBeanWithDependency,
								  MyBeanWithProperties myBeanWithProperties,
								  UserPojo userpojo
	){
		this.componentDependencia = componentDependencia;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userpojo;
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependencia.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + " - " + userPojo.getPassword());
		LOGGER.error("Esto es un error del aplicativo");
	}
}
