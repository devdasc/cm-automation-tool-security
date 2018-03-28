package com.cmautomation.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmautomation.spring.dao.DeploymentPlanDAO;
import com.cmautomation.spring.entity.DeploymentPlan;

@Service
public class DeploymentPlanServiceImpl implements DeploymentPlanService {

	@Autowired 
	private DeploymentPlanDAO deploymentPlanDAO;
	
	@Override
	@Transactional
	public List<DeploymentPlan> getDeploymentPlanList() {
		
		return deploymentPlanDAO.getDeploymentPlanList();
		
		
		
	}

	@Override
	@Transactional
	public void saveDeploymentPlan(DeploymentPlan theDeploymentPlan) {
		
		deploymentPlanDAO.saveDeploymentPlan(theDeploymentPlan);
	}

}
