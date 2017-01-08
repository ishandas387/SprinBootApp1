package com.ishan.app.service;

import org.springframework.data.repository.CrudRepository;

import com.ishan.app.entity.Employee;

public interface EmployeeCrud extends CrudRepository<Employee,Long> {

}
