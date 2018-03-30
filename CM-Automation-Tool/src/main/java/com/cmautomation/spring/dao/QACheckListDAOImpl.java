package com.cmautomation.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmautomation.spring.entity.QACheckList;

@Repository
public class QACheckListDAOImpl implements QACheckListDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<QACheckList> getQACheckList() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<QACheckList> theQuery = currentSession.createQuery("from QACheckList", QACheckList.class);

		// execute query and get result list
		List<QACheckList> qaCheckList = theQuery.getResultList();

		return qaCheckList;

	}

	@Override
	public void saveQACheckList(QACheckList qaCheckList) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(qaCheckList);
	}

}
