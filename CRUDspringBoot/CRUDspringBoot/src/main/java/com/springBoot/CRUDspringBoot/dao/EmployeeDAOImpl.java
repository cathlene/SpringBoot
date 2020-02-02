package com.springBoot.CRUDspringBoot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springBoot.CRUDspringBoot.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	//define field for entityManager
	private EntityManager entitymanager;
	
	//set up constructor injection
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		entitymanager= entityManager;	

	}
	
	
	@Override
	public List<Employee> findAll() {
		
		Session session = entitymanager.unwrap(Session.class);
		
		List<Employee> employees =session.createQuery("from Employee", Employee.class).list();
		return employees;
	}


	@Override
	public Employee findById(int id) {
		Session session = entitymanager.unwrap(Session.class);
		Employee e= session.get(Employee.class,id);
		return e;
	}


	@Override
	public void save(Employee e) {
		Session session = entitymanager.unwrap(Session.class);
		session.saveOrUpdate(e);
	}


	@Override
	public void delete(int id) {
		Session session = entitymanager.unwrap(Session.class);
		//session.delete(id);
		Query query= session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
		
	}

}
