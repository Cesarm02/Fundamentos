package com.springBoot.Fundamentos;

import com.springBoot.Fundamentos.bean.MyBean;
import com.springBoot.Fundamentos.bean.MyBeanWithDependency;
import com.springBoot.Fundamentos.bean.MyBeanWithProperties;
import com.springBoot.Fundamentos.component.ComponentDependencia;

import com.springBoot.Fundamentos.entity.User;
import com.springBoot.Fundamentos.pojo.UserPojo;
import com.springBoot.Fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	private UserRepository userRepository;

	public FundamentosApplication(@Qualifier("componentTwoImpl") ComponentDependencia componentDependencia, MyBean myBean,
								  MyBeanWithDependency myBeanWithDependency,
								  MyBeanWithProperties myBeanWithProperties,
								  UserPojo userpojo,
								  UserRepository userRepository
	){
		this.componentDependencia = componentDependencia;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userpojo;
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteiores();
		saveUserInDatabase();
		getInformacionJpqlFromUser();
	}

	private void getInformacionJpqlFromUser(){
		/*
		LOGGER.info("Usuario con el metodo findByUserEmail "
				+ userRepository.findByUserEmail("cesar@at.com")
				.orElseThrow(()->new RuntimeException("No se encontro el usuario")));

		userRepository.findAndSort("c", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("User with method sort " + user));

		userRepository.findByName("cuatro")
				.stream().forEach(user -> LOGGER.info(user));

		LOGGER.info("Usuario con query method "  +userRepository.findByEmailAndName("cesar@at.com", "Cesar")
				.orElseThrow(()-> new RuntimeException("Usuario no encontrado")));

		//LIKE
		userRepository.findByNameLike("%c%")
				.stream()
				.forEach(user -> LOGGER.info("Usuario % LIKE " +user));

		//OR
		userRepository.findByNameOrEmail(null , "cesar@at.com")
				.stream()
				.forEach(user -> LOGGER.info("Usuario || OR  findByNameOrEmail " +user));
		*/
		//POR FECHA
		userRepository.findByBirthDateBetween(LocalDate.of(2020 ,3, 4), LocalDate.of(2022,9,10))
				.stream().forEach(user -> LOGGER.info("Fecha " + user));
	}

	private void saveUserInDatabase(){
		User user = new User("Cesar", "cesar@at.com", LocalDate.of(2022,9,03));
		User user2 = new User("cuatro", "estiven@at.com", LocalDate.of(2022,9,04));
		User user3 = new User("tres", "tres@at.com", LocalDate.of(2016,9,03));
		User user4 = new User("cuatro", "cuatro@at.com", LocalDate.of(2017,9,04));
		User user5 = new User("cinco", "cinco@at.com", LocalDate.of(2018,9,05));
		User user6 = new User("seis", "seis@at.com", LocalDate.of(2019,9,06));
		User user7 = new User("siete", "siete@at.com", LocalDate.of(2020,9,07));
		User user8 = new User("ocho", "ocho@at.com", LocalDate.of(2021,9,9));
		List<User> list = Arrays.asList(user, user2, user3,user4, user5, user6,user7, user8);
		//userRepository.saveAll(list);
		list.stream().forEach(userRepository::save);
	}

	private void ejemplosAnteiores(){
		componentDependencia.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + " - " + userPojo.getPassword());
		//Se muestra un log de error en aplicativo
		try{
			//error
			int value = 10/0;
			LOGGER.debug("Valor de " + value);
		}catch(Exception e){
			LOGGER.error("Esto es un error al dividir por cero " + e.getMessage() );
		}
	}

}
