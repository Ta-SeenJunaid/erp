package com.tj.erp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.tj.erp.dao.EmployeeProjectDao;
import com.tj.erp.model.EmployeeProject;

@Repository
public class EmployeeProjectDaoImpl implements EmployeeProjectDao {
	
	private EntityManager entityManager;
	
	

	public EmployeeProjectDaoImpl(EntityManager theEntityManager) {
	
		entityManager = theEntityManager;
	}

	@Override
	public List<EmployeeProject> findAll() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<EmployeeProject> theQuery = 
				session.createQuery("from EmployeeProject", EmployeeProject.class);
		
		List<EmployeeProject> employeeProjects = theQuery.getResultList();
		
		return employeeProjects;
	}

	@Override
	public EmployeeProject findBYID(int theId) {
		Session session = entityManager.unwrap(Session.class);
		
		EmployeeProject theEmployeeProject = 
				session.get(EmployeeProject.class, theId);
		
		return theEmployeeProject;
	}

	@Override
	public void save(EmployeeProject theEmployeeProject) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(theEmployeeProject);

	}

	@Override
	public void deleteById(int theId) {
		Session session = entityManager.unwrap(Session.class);
		
		Query theQuery = 
				session.createQuery(
						"delete from EmployeeProject where employeeProjectId=:id");
		theQuery.setParameter("id", theId);
		
		theQuery.executeUpdate();

	}

}
