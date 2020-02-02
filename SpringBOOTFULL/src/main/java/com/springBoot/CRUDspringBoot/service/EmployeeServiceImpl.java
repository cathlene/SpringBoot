package com.springBoot.CRUDspringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springBoot.CRUDspringBoot.dao.EmployeeDAO;
import com.springBoot.CRUDspringBoot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeedao) {
		employeeDAO = employeedao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return employeeDAO.findById(id);

	}

	@Override
	@Transactional
	public void save(Employee e) {
		employeeDAO.save(e);
	}

	@Override
	@Transactional
	public void delete(int id) {
		employeeDAO.delete(id);
	}

}
