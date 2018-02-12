package com.cmautomation.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	// add request mapping for leaders
	
	@GetMapping("/leaders")
	public String showLeaders() {
		return "LEAD";
	}
	// add request mapping for system admins
	@GetMapping("/systems")
	public String showSystems() {
		return "systems";
	}
}
