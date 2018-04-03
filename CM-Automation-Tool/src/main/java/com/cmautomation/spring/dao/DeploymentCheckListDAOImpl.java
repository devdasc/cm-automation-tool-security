package com.cmautomation.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmautomation.spring.entity.DefectFixDetail;
import com.cmautomation.spring.entity.DeploymentCheckList;

@Repository
public class DeploymentCheckListDAOImpl implements DeploymentCheckListDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<DeploymentCheckList> getDeploymentCheckList() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<DeploymentCheckList> theQuery = currentSession.createQuery("from DeploymentCheckList",
				DeploymentCheckList.class);

		// execute query and get result list
		List<DeploymentCheckList> theDeploymentCheckList = theQuery.getResultList();

		return theDeploymentCheckList;
	}

	// save
	@Override
	public void saveDeploymentCheckList(DeploymentCheckList theDeploymentCheckList) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theDeploymentCheckList);

	}

	// update
	@Override
	public DeploymentCheckList getDeploymentCheckListDetail(int dpCkeck_Id) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		DeploymentCheckList theDeploymentCheckList=currentSession.get(DeploymentCheckList.class, dpCkeck_Id);
		
		return theDeploymentCheckList;
	}

	// delete
	@Override
	public void deleteDeploymentCheckList(int dpCkeck_Id) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// delete query
		Query deleteQuery = currentSession
				.createQuery("delete from DeploymentCheckList where deploymentChecklist_Id=:dpCkeck_Id");

		deleteQuery.setParameter("dpCkeck_Id", dpCkeck_Id);

		deleteQuery.executeUpdate();
	}

}
