package com.tj.erp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.tj.erp.dao.ProjectDao;
import com.tj.erp.model.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao {
	
	private EntityManager entityManager;
	
	

	public ProjectDaoImpl(EntityManager theEntityManager) {
	
		entityManager = theEntityManager;
	}
	

	@Override
	public List<Project> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Project> theQuery = 
				session.createQuery("from Project", Project.class);
		
		List<Project> projects = theQuery.getResultList();
		
		return projects;
	}

	@Override
	public Project findBYID(int theId) {
		Session session = entityManager.unwrap(Session.class);
		
		Project theProject = 
				session.get(Project.class, theId);
		
		return theProject;
	}

	@Override
	public void save(Project theProject) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(theProject);

	}

	@Override
	public void deleteByProjectId(int theId) {
		Session session = entityManager.unwrap(Session.class);
		
		Query theQuery = 
				session.createQuery(
						"delete from Project where projectId=: projectId");
		theQuery.setParameter("projectId", theId);
		
		theQuery.executeUpdate();

	}

}
