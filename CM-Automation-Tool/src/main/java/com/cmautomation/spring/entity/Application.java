package com.cmautomation.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "applications")
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "application_Id")
	private int application_Id;

	@Column(name = "applicationName")
	private String applicationName;	
	
	@Column(name = "description")
	private String description;
	
	// cascade=
	// {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
	//@JoinColumn(name="Application_Id")
	@OneToMany(mappedBy="application",cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<DeploymentPlan> deploymentPlan;
	
	@OneToMany(mappedBy="application",cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@LazyCollection(LazyCollectionOption.FALSE)
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
	
	public Application(int application_Id, String applicationName, List<DeploymentPlan> deploymentPlan,
			List<DefectFixDetail> defectFixDetail) {
		super();
		this.application_Id = application_Id;
		this.applicationName = applicationName;
		this.deploymentPlan = deploymentPlan;
		this.defectFixDetail = defectFixDetail;
	}
	public int getApplication_Id() {
		return application_Id;
	}
	public void setApplication_Id(int application_Id) {
		this.application_Id = application_Id;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		return "Application [application_Id=" + application_Id + ", applicationName=" + applicationName + ", Description "+description+"]";
	}

}
