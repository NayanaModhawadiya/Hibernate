package com.rest.HibernateCache.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.rest.HibernateCache.entity.Employee;
import com.rest.HibernateCache.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public Employee addEmployee(Employee emp) {
		
		employeeRepo.save(emp);
		
		return emp;
		
	}
	
	@Cacheable("employee")
	public List<Employee> getEmployee(){
		List<Employee> empList= employeeRepo.findAll();
		
		return empList;
	}
	
	public Employee updateEmployee(Employee emp) {
		return employeeRepo.save(emp);
	}

	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
		
	}

}
