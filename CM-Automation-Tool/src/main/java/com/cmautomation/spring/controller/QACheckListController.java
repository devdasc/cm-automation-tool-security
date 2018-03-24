package com.cmautomation.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qa/checkList")
public class QACheckListController {
	
	@GetMapping("/list")
	public String getQACheckList() {
		
		
		return "qa-checklist";
	}

}
