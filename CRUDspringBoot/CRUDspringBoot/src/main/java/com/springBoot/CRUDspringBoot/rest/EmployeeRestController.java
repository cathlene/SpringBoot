package com.springBoot.CRUDspringBoot.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springBoot.CRUDspringBoot.dao.EmployeeDAO;
import com.springBoot.CRUDspringBoot.entity.Employee;
import com.springBoot.CRUDspringBoot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
	 this.employeeService= employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		List<Employee> employees =employeeService.findAll();
		return employees;
	}
	
	@GetMapping("/employees/{customerId}")
	public Employee getEmployee(@PathVariable int customerId){
		
		Employee customer = employeeService.findById(customerId);
		
		if(customer ==null) {
			throw new RuntimeException("Student id not found"+customerId);
		}
		return customer;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee customer){
		
		customer.setId(0);
		employeeService.save(customer);
		return customer;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee customer){
		
		employeeService.save(customer);
		return customer;
	}
	
	@DeleteMapping("/employees/{customerId}")
	public Employee deleteEmployee(@PathVariable int customerId){
		
		Employee customer = employeeService.findById(customerId);
		
		if(customer ==null) {
			throw new RuntimeException("Student id not found"+customerId);
		}
		employeeService.delete(customerId);
		return customer;
	}




}
