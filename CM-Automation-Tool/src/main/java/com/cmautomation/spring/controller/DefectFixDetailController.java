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

import com.cmautomation.spring.entity.DefectFixDetail;
import com.cmautomation.spring.service.DefectFixDetailService;

@Controller
@RequestMapping("/cma")
public class DefectFixDetailController {
	
	@Autowired
	private DefectFixDetailService defectFixDetailService;
	
	//render defect list
	@GetMapping("/defect/list")//works fine
	private String getDefectFixList(Model theDefectFixDetailModel) {
		
		List<DefectFixDetail> theDefectFixDetail=defectFixDetailService.getDefectList();
		
		theDefectFixDetailModel.addAttribute("theDefectFixList",theDefectFixDetail);
		
		return "list-defectFixDetail";
	}
	//render the defectAddForm
	@GetMapping("/defect/defectAddForm")//works fine
	public String showDefectAddForm(Model theDefectFixDetailModel) {
		
		DefectFixDetail theDefectFixDetail=new DefectFixDetail();
		
		theDefectFixDetailModel.addAttribute("theDefectFixDetail",theDefectFixDetail);
		
		return "defect-form";
	}
	// saves a new record in the defect fix table
	@PostMapping("/defect/saveDefectFixDetail")//works fine
	public String saveDefectFixDetail(@ModelAttribute("theDefectFixDetail") DefectFixDetail defectFixDetail) {
		
		defectFixDetailService.saveDefectFixDetail(defectFixDetail);
		
		return "redirect:/cma/defect/list";
	}
	//update defect
	@GetMapping("/defect/defectUpdateForm")
	public String defectUpdateForm(@RequestParam("defectId") int defect_Id, Model theDefectFixDetailModel) {
		try {
			DefectFixDetail theDefectFixDetail=defectFixDetailService.getDefectFixDetail(defect_Id);
			
			theDefectFixDetailModel.addAttribute("theDefectFixDetail",theDefectFixDetail);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return "defect-form";
	}
	//delete defect fix detail
	@GetMapping("/defect/delete")//works fine
	public String deleteDefectForm(@RequestParam("defectId") int defect_Id) {
		
		defectFixDetailService.deleteDefectFixDetail(defect_Id);
		
		return "redirect:/cma/defect/list";
		
	}
	

}
