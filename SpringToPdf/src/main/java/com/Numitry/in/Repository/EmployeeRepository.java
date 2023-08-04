package com.Numitry.in.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Numitry.in.Entity.Employee;

public interface EmployeeRepository 
             extends CrudRepository<Employee, Long> {
}