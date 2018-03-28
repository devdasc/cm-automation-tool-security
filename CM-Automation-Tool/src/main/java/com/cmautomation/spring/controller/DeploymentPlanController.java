package com.cmautomation.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmautomation.spring.entity.DeploymentPlan;
import com.cmautomation.spring.service.DeploymentPlanService;

@Controller
@RequestMapping("/cma/deploymentPlan")
public class DeploymentPlanController {
	
	
	@Autowired
	private DeploymentPlanService deploymentPlanService; 
	
	
	@GetMapping("/list")//works
	public String getDeploymentPlan(Model theDeploymentPlanModel) {
	
		List<DeploymentPlan> theDeploymentPlan = deploymentPlanService.getDeploymentPlanList();
		
		theDeploymentPlanModel.addAttribute("theDeploymentPlanList",theDeploymentPlan);
		
		return "list-deployment";
	}
	
	@GetMapping("/addForm")
	public String showPlanAddForm(Model theDeploymentPlanModel) {
		
		DeploymentPlan theDeploymentPlan =new DeploymentPlan();
		
		theDeploymentPlanModel.addAttribute("deploymentPlanDetail",theDeploymentPlan);
		
		return "deploymentPlan-form";
	}

}
