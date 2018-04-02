package com.cmautomation.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmautomation.spring.entity.DeploymentCheckList;
import com.cmautomation.spring.entity.DeploymentEnvironment;
import com.cmautomation.spring.entity.DeploymentPlan;
import com.cmautomation.spring.service.DeploymentCheckListService;
import com.cmautomation.spring.service.DeploymentEnvironmentService;
import com.cmautomation.spring.service.DeploymentPlanService;

@Controller
@RequestMapping("/tsa/checkList")
public class DeploymentChecklistController {

	@Autowired
	private DeploymentCheckListService deploymentCheckListService;

	@Autowired
	private DeploymentPlanService deploymentPlanService;

	@Autowired
	private DeploymentEnvironmentService deploymentEnvironmentService;

	// renders the list of deployment checklist
	@GetMapping("/list")
	public String getDeploymentCheckList(Model theDeploymentCheckListModel) {

		List<DeploymentCheckList> theDeploymentCheckList = deploymentCheckListService.getDeploymentCheckList();

		theDeploymentCheckListModel.addAttribute("theDeploymentCheckList", theDeploymentCheckList);

		return "deployment-checklist";
	}

	// render form for insert a new record
	@GetMapping("/deployChecklistAddForm")
	public String showDeploymentCheckListAddForm(Model theDeploymentCheckListModel) {

		DeploymentCheckList theDeploymentCheckList = new DeploymentCheckList();

		List<DeploymentPlan> deploymentPlan = deploymentPlanService.getDeploymentPlanList();
		List<DeploymentEnvironment> deploymentEnvironmentList = deploymentEnvironmentService.getEnvironmentList();

		theDeploymentCheckListModel.addAttribute("theDeploymentCheckList", theDeploymentCheckList);
		theDeploymentCheckListModel.addAttribute("deploymentPlan", deploymentPlan);
		theDeploymentCheckListModel.addAttribute("deploymentEnvironmentList", deploymentEnvironmentList);

		return "deployment-checklist-form";
	}

	// saves a new record
	@PostMapping("/saveDeploymentCheckList")
	public String saveDeploymentCheckListForm(
			@ModelAttribute("theDeploymentCheckList") DeploymentCheckList theDeploymentCheckList) {

		deploymentCheckListService.saveDeploymentCheckList(theDeploymentCheckList);

		return "redirect:/tsa/checkList/list";
	}

	// renders the update form with pre-populated record for upate
	@GetMapping("/deploymentCheckListUpdateForm")
	public String deploymentCheckListUpdateForm(@RequestParam("deployCheckListId") int dpCkeck_Id,
			Model theDeploymentCheckListModel) {
		DeploymentCheckList theDeploymentCheckList=deploymentCheckListService.getDeploymentCheckListDetail(dpCkeck_Id);

		List<DeploymentPlan> deploymentPlan = deploymentPlanService.getDeploymentPlanList();
		List<DeploymentEnvironment> deploymentEnvironmentList = deploymentEnvironmentService.getEnvironmentList();

		theDeploymentCheckListModel.addAttribute("theDeploymentCheckList", theDeploymentCheckList);
		theDeploymentCheckListModel.addAttribute("deploymentPlan", deploymentPlan);
		theDeploymentCheckListModel.addAttribute("deploymentEnvironmentList", deploymentEnvironmentList);

		return "deployment-checklist-form";
	}

	// delete
	@GetMapping("/delete")
	public String deleteDeploymentCheckList(@RequestParam("deployCheckListId") int dpCkeck_Id,
			Model theDeploymentCheckListModel) {

		deploymentCheckListService.deleteDeploymentCheckList(dpCkeck_Id);

		return "redirect:/tsa/checkList/list";

	}

}
