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

import com.cmautomation.spring.entity.Application;
import com.cmautomation.spring.entity.DeploymentEnvironment;
import com.cmautomation.spring.service.DeploymentEnvironmentService;

@Controller
@RequestMapping("/environment")
public class DeploymentEnvironmentController {

	@Autowired
	private DeploymentEnvironmentService deploymentEnvironmentService;

	@GetMapping("/list")
	public String listDeploymentEnvironments(Model theEnvModel) {

		List<DeploymentEnvironment> deploymentEnvironment = deploymentEnvironmentService.getEnvironmentList();

		theEnvModel.addAttribute("environments", deploymentEnvironment);

		return "list-deploymentEnvironment";
	}

	@GetMapping("/envAddForm")
	public String showAddForm(Model theEnvModel) {

		DeploymentEnvironment environments = new DeploymentEnvironment();

		theEnvModel.addAttribute("environments", environments);
		// theEnvModel.addAttribute("title", "applicationForm");

		return "environment-form";
	}

	@PostMapping("/saveEnvironment")
	public String saveEnvironment(@ModelAttribute("environments") DeploymentEnvironment deploymentEnvironment) {

		deploymentEnvironmentService.saveEnvironment(deploymentEnvironment);

		return "redirect:/environment/list";
	}

	@GetMapping("/envUpdateForm")
	public String envUpdateForm(@RequestParam("environmentId") int envId, Model theEnvModel) {

		// get the application from aplicationService
		DeploymentEnvironment environments = deploymentEnvironmentService.getDeploymentEnvironment(envId);

		// set application as a model to pre-populate the update form
		theEnvModel.addAttribute("environments", environments);

		//theEnvModel.addAttribute("title", "applicationForm");

		return "environment-form";
	}
	@GetMapping("/delete")
	public String deleteForm(@RequestParam("environmentId") int envId) {
		//delete the application
		deploymentEnvironmentService.deleteEnvironment(envId);
		
		return "redirect:/environment/list";
	}

}
