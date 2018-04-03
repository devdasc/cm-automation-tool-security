package com.cmautomation.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmautomation.spring.entity.QACheckList;
import com.cmautomation.spring.entity.QACompositeKeyId;

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

	@Override
	public QACheckList getQACheckListDetail(int qaComp_Id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		QACheckList qaCheckList = currentSession.get(QACheckList.class, qaComp_Id);

		return qaCheckList;
	}

	@Override
	public void deleteQaCheckList(int qaComp_Id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// delete query
		Query deleteQuery = currentSession.createQuery("delete from QACheckList where qachecklist_id=:qaComp_Id");

		deleteQuery.setParameter("qaComp_Id", qaComp_Id);

		deleteQuery.executeUpdate();

	}

}
