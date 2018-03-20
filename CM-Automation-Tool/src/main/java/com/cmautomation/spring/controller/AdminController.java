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
import com.cmautomation.spring.service.ApplicationService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ApplicationService applicationService;

	// this method shows the application list
	@GetMapping("/app/list") // this is the view name
	public String listApplications(Model theAppModel) {

		List<Application> theApplications = applicationService.getApplications();

		// add the applications to the model
		theAppModel.addAttribute("applications", theApplications);

		return "list-apps";// this is the jsp file to be rendered
	}
	// this method renders the app-form and binds the fields with the model
	@GetMapping("/app/appAddForm")
	public String showAppAddForm(Model theAppModel) {
		
		Application application=new Application();
		theAppModel.addAttribute("application",application);
		
		return "app-form";
	}
	
	// this method saves the application
	@PostMapping("/app/saveApplication")
	public String saveApplication(@ModelAttribute("application") Application application) {
		
		applicationService.saveApplication(application);
		
		return "redirect:/admin/app/list";
	}
	//this method updates the application
	@GetMapping("/app/appUpdateForm")
	public String appUpdateForm(@RequestParam("applicationId") int appId, Model theAppModel) {
		
		//get the application from aplicationService
		Application application=applicationService.getApplication(appId);
		
		//set application as a model to pre-populate the update form
		theAppModel.addAttribute("application", application);
		
		return "app-form";
	}
	//method to delete the application
	@GetMapping("/app/delete")
	public String deleteForm(@RequestParam("applicationId") int appId) {
		//delete the application
		applicationService.deleteApplication(appId);
		
		return "redirect:/admin/app/list";
	}


}
