package com.example.HumanResourcesApp;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class HumanResourcesAppApplication {
	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\ysimsek\\Downloads\\HumanResourcesApp" +
				"\\HumanResourcesApp\\Human_Resources_Application_Files");
		if (!file.exists()) {
			if (file.mkdir()) { System.out.println("File is created successfully."); }
			else { System.out.println("File is not created. Check the problem."); }
		}
		SpringApplication.run(HumanResourcesAppApplication.class, args);

	}

}
