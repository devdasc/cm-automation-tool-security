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
	@Column(name="environment_Id")
	private Integer environment_Id;
	
	@Column(name="environmentName")
	private String environmentName;
	
	public DeploymentEnvironment() {
		
	}

	public DeploymentEnvironment(Integer environment_Id, String environmentName) {
		super();
		this.environment_Id = environment_Id;
		this.environmentName = environmentName;
	}

	public Integer getEnvironment_Id() {
		return environment_Id;
	}

	public void setEnvironment_Id(Integer environment_Id) {
		this.environment_Id = environment_Id;
	}

	public String getEnvironmentName() {
		return environmentName;
	}

	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}

	@Override
	public String toString() {
		return "DeploymentEnvironment [environment_Id=" + environment_Id + ", environmentName=" + environmentName + "]";
	}



}
