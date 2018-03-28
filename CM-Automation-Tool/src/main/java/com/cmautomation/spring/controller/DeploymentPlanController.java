package com.cmautomation.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmautomation.spring.entity.Application;
import com.cmautomation.spring.entity.DefectFixDetail;
import com.cmautomation.spring.entity.DeploymentPlan;
import com.cmautomation.spring.service.ApplicationService;
import com.cmautomation.spring.service.DefectFixDetailService;
import com.cmautomation.spring.service.DeploymentPlanService;

@Controller
@RequestMapping("/cma/deploymentPlan")
public class DeploymentPlanController {
	
	
	@Autowired
	private DeploymentPlanService deploymentPlanService; 
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private DefectFixDetailService defectFixDetailService;
	
	
	
	@GetMapping("/list")//works
	public String getDeploymentPlan(Model theDeploymentPlanModel) {
	
		List<DeploymentPlan> theDeploymentPlan = deploymentPlanService.getDeploymentPlanList();
		
		theDeploymentPlanModel.addAttribute("theDeploymentPlanList",theDeploymentPlan);
		
		return "list-deployment";
	}
	
	@GetMapping("/addForm")
	public String showPlanAddForm(Model theDeploymentPlanModel) {
		
		DeploymentPlan theDeploymentPlan =new DeploymentPlan();
		
		List<Application> applications=applicationService.getApplications();
		
		List<DefectFixDetail>listDefectFixDetail=defectFixDetailService.getDefectList();
		
		theDeploymentPlanModel.addAttribute("deploymentPlanDetail",theDeploymentPlan);
		theDeploymentPlanModel.addAttribute("applications",applications);
		theDeploymentPlanModel.addAttribute("listDefects",listDefectFixDetail);
		
		
		return "deploymentPlan-form";
	}
	
	@PostMapping("/saveDeploymentPlan")
	public String saveDeploymentPlan(@ModelAttribute("deploymentPlanDetail") DeploymentPlan theDeploymentPlan) {
		
		deploymentPlanService.saveDeploymentPlan(theDeploymentPlan);
		
		return "redirect:/cma/deploymentPlan/list";
		
	}

}
