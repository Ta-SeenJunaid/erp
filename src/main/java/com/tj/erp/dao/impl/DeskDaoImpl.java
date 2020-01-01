package com.tj.erp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.tj.erp.dao.DeskDao;
import com.tj.erp.model.Desk;


@Repository
public class DeskDaoImpl implements DeskDao {
	
	private EntityManager entityManager;
	
	

	public DeskDaoImpl(EntityManager theEntityManager) {
	
		entityManager = theEntityManager;
	}
	

	@Override
	public List<Desk> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Desk> theQuery = 
				session.createQuery("from Desk", Desk.class);
		
		List<Desk> desks = theQuery.getResultList();
		
		return desks;
	}

	@Override
	public Desk findBYID(int theId) {
		Session session = entityManager.unwrap(Session.class);
		
		Desk theDesk = 
				session.get(Desk.class, theId);
		
		return theDesk;
	}

	@Override
	public void save(Desk theDesk) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(theDesk);

	}

	@Override
	public void deleteById(int theId) {
		Session session = entityManager.unwrap(Session.class);
		
		Query theQuery = 
				session.createQuery(
						"delete from Desk where deskId=:id");
		theQuery.setParameter("id", theId);
		
		theQuery.executeUpdate();

	}

}
