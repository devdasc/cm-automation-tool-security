package com.cmautomation.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	@Override
	public void saveDefectFixDetail(DefectFixDetail theDefectFixDetail) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theDefectFixDetail);

	}

	@Override
	public DefectFixDetail getDefectFixDetail(int defect_Id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		DefectFixDetail theDefectFixDetail = currentSession.get(DefectFixDetail.class, defect_Id);

		return theDefectFixDetail;
	}

	// delete
	@Override
	public void deleteDefectFixDetail(int defectId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// delete query
		Query deleteQuery = currentSession.createQuery("delete from DefectFixDetail where defect_Id=:defectId");

		deleteQuery.setParameter("defectId", defectId);

		deleteQuery.executeUpdate();

	}

	//search
	@Override
	public List<DefectFixDetail> searchDefects(String theSearchName) {

		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// search query
		Query searchQuery = null;
		// search by name if theSearchName is not empty
		if (theSearchName != null && theSearchName.trim().length() > 0) {
		// search the defect name--case insensetive
		searchQuery = currentSession.createQuery("from DefectFixDetail where lower(title) like:theName",DefectFixDetail.class);
		searchQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		} else {
			searchQuery = currentSession.createQuery("from DefectFixDetail", DefectFixDetail.class);
		}
		// execute query and get result list
		List<DefectFixDetail> listDefects = searchQuery.getResultList();

		return listDefects;
	}
	
	

}
