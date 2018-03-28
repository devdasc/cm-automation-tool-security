package com.cmautomation.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmautomation.spring.entity.DeploymentPlan;

@Repository
public class DeploymentPlanDAOImpl implements DeploymentPlanDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<DeploymentPlan> getDeploymentPlanList() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<DeploymentPlan> theQuery = currentSession.createQuery("from DeploymentPlan", DeploymentPlan.class);

		// execute query and get result list
		List<DeploymentPlan> deploymentPlanList = theQuery.getResultList();
		
		return deploymentPlanList;
	}

	@Override
	public void saveDeploymentPlan(DeploymentPlan theDeploymentPlan) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theDeploymentPlan);
	}

}
