package com.tka.OrganizationWorkflow.entity;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


//use lombok library/dependency 
//this dependency is reduce code of writting constructor,getter-setter,tostring() etc
//when this dependecy use then install them in c/user/dell/.m2/repository/org/projectlambok.lambok/version-ex.1.18.30/lombok-1.18.30
//this dependency work if machin environment variable have jre and jdk install
@Entity
@Data
// @Data is lambok annotation 
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String mobileno;
	private String emailid;
	
	private String createdBy;
	private Date createdDate;
	
	private String updatedBy;
	private Date updatedDate;
	
	private String status;
	private String department;
	private double salary;
	
	
	@ManyToOne
	@JoinColumn(name = "C_Id")
	private Country country;
	

}
