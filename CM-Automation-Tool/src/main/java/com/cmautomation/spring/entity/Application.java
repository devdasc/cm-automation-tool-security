package com.cmautomation.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="applications")
public class Application {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Application_Id")
	private int appId;
	
	@Column(name="ApplicationName")
	private String appName;
	
	public Application() {
		
	}
	
	public Application(int appId, String appName) {
		
		this.appId = appId;
		this.appName = appName;
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
