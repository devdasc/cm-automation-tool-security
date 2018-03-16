package com.cmautomation.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="application")
public class Application {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="application_Id")
	private int appId;
	
	@Column(name="applicationName")
	private String appName;
	
	public Application() {
		
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	@Override
	public String toString() {
		return "Application [appId=" + appId + ", appName=" + appName + "]";
	}
	
}
