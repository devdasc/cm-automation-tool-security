package com.cmautomation.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmautomation.spring.entity.Application;
import com.cmautomation.spring.entity.DefectFixDetail;

@Repository
public class DefectFixDetailDAOImpl implements DefectFixDetailDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<DefectFixDetail> getDefectList() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<DefectFixDetail> theQuery = currentSession.createQuery("from DefectFixDetail", DefectFixDetail.class);

		// execute query and get result list
		List<DefectFixDetail> defectFixDetailList = theQuery.getResultList();
		
		return defectFixDetailList;
	}
	

}
