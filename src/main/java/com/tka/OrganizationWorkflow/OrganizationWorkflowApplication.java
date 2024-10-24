package com.tka.OrganizationWorkflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tka.OrganizationWorkflow.dao.MainDao;
import com.tka.OrganizationWorkflow.entity.Employee;

@SpringBootApplication
public class OrganizationWorkflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationWorkflowApplication.class, args);
		System.out.println("Application Started...");
		
	}

}
