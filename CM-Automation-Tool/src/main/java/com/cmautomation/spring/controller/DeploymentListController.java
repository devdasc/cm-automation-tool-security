package com.cmautomation.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cma/deployment")
public class DeploymentListController {
	
	@GetMapping("/list")
	public String getDeploymentList() {
		
		return "list-deployment";
	}

}
