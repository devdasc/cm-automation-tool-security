package com.cmautomation.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tsa/checkList")
public class DeploymentChecklistController {
	
	@GetMapping("/list")
	public String getDeploymentCheckList() {
		
		return "deployment-checklist";
	}

}
