package com.example.HumanResourcesApp;

import com.example.HumanResourcesApp.entity.Manager;
import com.example.HumanResourcesApp.repository.IManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HumanResourcesAppApplication {

	@Autowired
	private IManagerRepository managerRepository;

	public static void main(String[] args) {
		SpringApplication.run(HumanResourcesAppApplication.class, args);
	}


}
