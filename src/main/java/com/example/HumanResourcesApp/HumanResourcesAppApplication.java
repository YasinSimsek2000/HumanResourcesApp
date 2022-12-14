package com.example.HumanResourcesApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;

@SpringBootApplication
public class HumanResourcesAppApplication {
	public static void main(String[] args) {

		String path = "C:\\Users\\simse\\IdeaProjects\\HumanResourcesApp\\Human_Resources_Application_Files";
		File file = new File(path);
		if (!file.exists()) {
			if (file.mkdir()) { System.out.println("Human_Resources_Application_Files is created successfully."); }
			else { System.out.println("File is not created. Check the problem."); }
		}

		file = new File(path + "\\Departments");
		if (!file.exists()) {
			if (file.mkdir()) { System.out.println("Departments is created successfully."); }
			else { System.out.println("File is not created. Check the problem."); }
		}

		file = new File(path + "\\Employees");
		if (!file.exists()) {
			if (file.mkdir()) { System.out.println("Employees is created successfully."); }
			else { System.out.println("File is not created. Check the problem."); }
		}

		file = new File(path + "\\Managers");
		if (!file.exists()) {
			if (file.mkdir()) { System.out.println("Managers is created successfully."); }
			else { System.out.println("File is not created. Check the problem."); }
		}

		file = new File(path + "\\Projects");
		if (!file.exists()) {
			if (file.mkdir()) { System.out.println("Projects is created successfully."); }
			else { System.out.println("File is not created. Check the problem."); }
		}

		SpringApplication.run(HumanResourcesAppApplication.class, args);

	}

}
