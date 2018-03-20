package com.cmautomation.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="deployment_environments")
public class DeploymentEnvironment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Environment_Id")
	private int environmentId;
	
	@Column(name="EnvironmentName")
	private String environmentName;
	
	public DeploymentEnvironment() {
		
	}

	public DeploymentEnvironment(int environmentId, String environmentName) {
		
		this.environmentId = environmentId;
		this.environmentName = environmentName;
	}

	public int getEnvironmentId() {
		return environmentId;
	}

	public void setEnvironmentId(int environmentId) {
		this.environmentId = environmentId;
	}

	public String getEnvironmentName() {
		return environmentName;
	}

	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}

	@Override
	public String toString() {
		return "DeploymentEnvironment [environmentId=" + environmentId + ", environmentName=" + environmentName + "]";
	}

	
	

}
