package com.erickmarques.prideDevBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan({"com.erickmarques.prideDevBank"})
@EntityScan({"com.erickmarques.prideDevBank.entity"})
@EnableJpaRepositories({"com.erickmarques.prideDevBank.repository"})
@SpringBootApplication
public class PrideDevBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrideDevBankApplication.class, args);
		
	}
}
