package com.cmautomation.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmautomation.spring.entity.DeploymentEnvironment;
import com.cmautomation.spring.entity.DeploymentPlan;
import com.cmautomation.spring.entity.QACheckList;
import com.cmautomation.spring.service.DefectFixDetailService;
import com.cmautomation.spring.service.DeploymentEnvironmentService;
import com.cmautomation.spring.service.DeploymentPlanService;
import com.cmautomation.spring.service.QACheckListService;

@Controller
@RequestMapping("/qa/checkList")
public class QACheckListController {
	
	@Autowired
	private QACheckListService qaCheckListservice;
	
	@Autowired
	private DefectFixDetailService defectFixDetailService;
	
	@Autowired
	private DeploymentPlanService deploymentPlanService; 
	
	@Autowired
	private DeploymentEnvironmentService deploymentEnvironmentService;
	
	//shows the list of qa checklists
	@GetMapping("/list")
	public String getQACheckList(Model theQACheckListModel) {
		
		List<QACheckList> qaCheckList=qaCheckListservice.getQACheckList();
		
		theQACheckListModel.addAttribute("qaCheckList",qaCheckList);
				
		return "qa-checklist";
	}
	// renders the add qa checklist form to insert data
	@GetMapping("/QACheckListAddForm")
	public String showQACheckListAddForm(Model theQACheckListModel) {
		
		QACheckList theQACheckList=new QACheckList();		
		List<DeploymentPlan> deploymentPlan=deploymentPlanService.getDeploymentPlanList();
		List<DeploymentEnvironment> deploymentEnvironmentList=deploymentEnvironmentService.getEnvironmentList();
		
		theQACheckListModel.addAttribute("theQACheckListDetail",theQACheckList);
		
		theQACheckListModel.addAttribute("deploymentPlan",deploymentPlan);
		
		theQACheckListModel.addAttribute("deploymentEnvironmentList",deploymentEnvironmentList);
				
		return "qaChecklist-form";
	}
	//saves a new record
	@PostMapping("/saveQACheckList")
	public String saveQACheckListForm(@ModelAttribute("theQACheckListDetail") QACheckList qaCheckList) {
		
		qaCheckListservice.saveQACheckList(qaCheckList);
		
		return "redirect:/qa/checkList/list";
		
	}
	

}
