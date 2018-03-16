package com.cmautomation.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmautomation.spring.entity.Application;
import com.cmautomation.spring.service.ApplicationService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ApplicationService applicationService;

	// add request mapping for system admins
	@GetMapping("/app/list") // this is the view name
	public String listApplications(Model theAppModel) {

		List<Application> theApplications = applicationService.getApplications();

		// add the applications to the model
		theAppModel.addAttribute("applications", theApplications);

		return "list-apps";// this is the jsp file to be rendered
	}

}
