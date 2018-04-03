package com.cmautomation.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmautomation.spring.dao.QACheckListDAO;
import com.cmautomation.spring.entity.QACheckList;
@Service
public class QACheckListServiceImpl implements QACheckListService {

	@Autowired
	private QACheckListDAO qaCheckListDAO;
	
	@Override
	@Transactional
	public List<QACheckList> getQACheckList() {
		
		
		return qaCheckListDAO.getQACheckList();
	}

	@Override
	public void saveQACheckList(QACheckList qaCheckList) {
		// TODO Auto-generated method stub
		
	}

}
