package com.Numitry.in;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Numitry.in.Entity.Employee;
import com.Numitry.in.Repository.EmployeeRepository;

@SpringBootApplication
public class SpringToPdfApplication {
	
//	 @Autowired
//	    EmployeeRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringToPdfApplication.class, args);
	}
	
//	 public void run(String... args) throws Exception {

//	        if (repository.count() == 0) {
//	            // save a list of Employees
//	            repository.saveAll(Arrays.asList(
//	                        new Employee("Adam", "John"), 
//	                           new Employee("Sibin", "M"),
//	                             new Employee("Arun", "Mohan"), 
//	                                new Employee("Scott", "Morrison"),
//	                                   new Employee("Hikaru", "Nakamura"), 
//	                                     new Employee("Ishivaka", "Yusuke")));
//	        }
//
//	    }

}
