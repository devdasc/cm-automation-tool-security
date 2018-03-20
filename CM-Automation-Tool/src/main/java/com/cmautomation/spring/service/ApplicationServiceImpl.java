package com.cmautomation.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmautomation.spring.dao.ApplicationDAO;
import com.cmautomation.spring.entity.Application;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationDAO applicationDAO;
	
	@Override
	@Transactional
	public List<Application> getApplications() {
		
		return applicationDAO.getApplications();
	}

	@Override
	@Transactional
	public void saveApplication(Application application) {
		
		applicationDAO.saveApplication(application);
		
	}

	@Override
	@Transactional
	public Application getApplication(int appId) {
		
		 return applicationDAO.getApplication(appId);
	}

	@Override
	@Transactional
	public void deleteApplication(int appId) {
		
		applicationDAO.deleteApplication(appId);
		
	}

}