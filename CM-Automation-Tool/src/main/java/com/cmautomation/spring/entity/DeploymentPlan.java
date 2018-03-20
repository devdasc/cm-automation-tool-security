package com.cmautomation.spring.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="deploymentplan")
public class DeploymentPlan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Deployment_Id")
	private int deploymentId;
	
	@Column(name="Title")
	private String title;
	
	@OneToOne(cascade= {CascadeType.DETACH,
			CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="Application_Id")
	private Application application;
	
	@Column(name="PlanDate")
	@Temporal(TemporalType.DATE)
	private Date planDate;
	
	@Lob
	@Column(name="Comment")
	private String comment;
	
	public DeploymentPlan() {
		
	}

	public DeploymentPlan(String title, Application application, Date planDate, String comment) {
		
		//this.deploymentId = deploymentId;
		this.title = title;
		this.application = application;
		this.planDate = planDate;
		this.comment = comment;
	}

	public int getDeploymentId() {
		return deploymentId;
	}

	public void setDeploymentId(int deploymentId) {
		this.deploymentId = deploymentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "DeploymentPlan [deploymentId=" + deploymentId + ", title=" + title + ", application=" + application
				+ ", planDate=" + planDate + ", comment=" + comment + "]";
	}
	
	

}
