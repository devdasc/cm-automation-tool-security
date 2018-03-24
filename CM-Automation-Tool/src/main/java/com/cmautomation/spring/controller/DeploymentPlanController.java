package com.cmautomation.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cma/deployment")
public class DeploymentPlanController {
	
	@GetMapping("/plan")
	public String getDeploymentPlan(Model theDeploymentPlanModel) {
	
		
		
		return "deploymentPlan";
	}

}
