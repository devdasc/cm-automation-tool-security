package com.cmautomation.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmautomation.spring.entity.DefectFixDetail;
import com.cmautomation.spring.service.DefectFixDetailService;

@Controller
@RequestMapping("/cma")
public class DefectFixDetailController {
	
	@Autowired
	private DefectFixDetailService defectFixDetailService;
	
	@GetMapping("/defect/list")
	private String listDefectFixDetail(Model theDefectFixDetailModel) {
		
		List<DefectFixDetail> theDefectFixDetail=defectFixDetailService.getDefectList();
		theDefectFixDetailModel.addAttribute("theDefectFixList",theDefectFixDetail);
		
		return "list-defectFixDetail";
	}

}
