package com.cmautomation.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmautomation.spring.entity.Application;

@Repository
public class ApplicationDAOImpl implements ApplicationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Application> getApplications() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Application> theQuery = currentSession.createQuery("from Application", Application.class);

		// execute query and get result list
		List<Application> applications = theQuery.getResultList();

		// return the results
		return applications;
	}

}
