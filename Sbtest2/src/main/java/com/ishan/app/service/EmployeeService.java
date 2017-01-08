package com.ishan.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ishan.app.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeCrud ec;
	
	public List<Employee> getAll(){
		
		List<Employee> e = new ArrayList();
		ec.findAll().forEach(e::add);
		return e;
				
	}
	
	public Employee getE(Long i)
	{
		return ec.findOne(i);
	}
	public void addE(Employee e)
	{
		ec.save(e);
	}
	public void update(Long id, Employee e)
	{
		
		ec.save(e);
	}
	public void del(Long id)
	{
		ec.delete(id);
	}

}
