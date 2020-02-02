package com.springBoot.CRUDspringBoot.dao;

import java.util.List;

import com.springBoot.CRUDspringBoot.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee e);
	public void delete(int id);
}
