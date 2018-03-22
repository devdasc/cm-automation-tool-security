package com.cmautomation.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "applications")
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Application_Id")
	private int appId;

	@Column(name = "ApplicationName")
	private String appName;
	
	// cascade=
	// {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
	//@JoinColumn(name="Application_Id")
	@OneToMany(mappedBy="application",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<DeploymentPlan> deploymentPlan;
	
	@OneToMany(mappedBy="application",cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<DefectFixDetail> defectFixDetail;
	
	public Application() {

	}
	public void addDeploymentPlan(DeploymentPlan theDeploymentPlan) {
		if(deploymentPlan==null) {
			deploymentPlan=new ArrayList<>();
			}
		deploymentPlan.add(theDeploymentPlan);
	}
	public void addDefectFixDetail(DefectFixDetail theDefectFixDetail) {
		if(defectFixDetail==null) {
			defectFixDetail=new ArrayList<>();
			}
		defectFixDetail.add(theDefectFixDetail);
	}
	
	public Application(int appId, String appName, List<DeploymentPlan> deploymentPlan,
			List<DefectFixDetail> defectFixDetail) {
		
		this.appId = appId;
		this.appName = appName;
		this.deploymentPlan = deploymentPlan;
		this.defectFixDetail = defectFixDetail;
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


	public List<DefectFixDetail> getDefectFixDetail() {
		return defectFixDetail;
	}
	public void setDefectFixDetail(List<DefectFixDetail> defectFixDetail) {
		this.defectFixDetail = defectFixDetail;
	}
	public List<DeploymentPlan> getDeploymentPlan() {
		return deploymentPlan;
	}
	public void setDeploymentPlan(List<DeploymentPlan> deploymentPlan) {
		this.deploymentPlan = deploymentPlan;
	}
	@Override
	public String toString() {
		return "Application [appId=" + appId + ", appName=" + appName + "]";
	}

}
