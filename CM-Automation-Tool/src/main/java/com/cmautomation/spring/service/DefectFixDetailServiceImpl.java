package com.cmautomation.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmautomation.spring.dao.DefectFixDetailDAO;
import com.cmautomation.spring.entity.DefectFixDetail;
@Service
public class DefectFixDetailServiceImpl implements DefectFixDetailService {

	@Autowired
	private DefectFixDetailDAO defectFixDetailDAO;
	
	@Override
	@Transactional
	public List<DefectFixDetail> getDefectList() {
		
		return defectFixDetailDAO.getDefectList();
	}

}
