package com.tj.erp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.tj.erp.dao.EmployeeDao;
import com.tj.erp.model.Employee;



@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	private EntityManager entityManager;
	
	

	public EmployeeDaoImpl(EntityManager theEntityManager) {
	
		entityManager = theEntityManager;
	}
	

	@Override
	public List<Employee> findAll() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Employee> theQuery = 
				session.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findBYID(int theId) {
		Session session = entityManager.unwrap(Session.class);
		
		Employee theEmployee = 
				session.get(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Session session = entityManager.unwrap(Session.class);
				session.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
		Session session = entityManager.unwrap(Session.class);
		
		Query theQuery = 
				session.createQuery(
						"delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
		
		
	}

}
