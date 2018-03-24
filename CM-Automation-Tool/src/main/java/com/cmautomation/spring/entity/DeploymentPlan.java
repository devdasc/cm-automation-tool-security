package com.cmautomation.spring.entity;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



@Entity
@Table(name="deploymentplan")
public class DeploymentPlan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="deployment_Id")
	private int deployment_Id;
	
	@Column(name="title")
	private String title;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="application_Id")
	private Application application;
	
	@Column(name="planDate")
	@Temporal(TemporalType.DATE)
	private Date planDate;
	
	@Lob
	@Column(name="comment")
	private String comment;
	
	public DeploymentPlan() {
		
	}
	

	public DeploymentPlan(int deploymentId, String title, Application application, Date planDate, String comment) {
		
		this.deployment_Id = deploymentId;
		this.title = title;
		this.application = application;
		this.planDate = planDate;
		this.comment = comment;
	}




	public int getDeploymentId() {
		return deployment_Id;
	}

	public void setDeploymentId(int deploymentId) {
		this.deployment_Id = deploymentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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


	public Application getApplication() {
		return application;
	}


	public void setApplication(Application application) {
		this.application = application;
	}


	@Override
	public String toString() {
		return "DeploymentPlan [deployment_Id=" + deployment_Id + ", title=" + title + ", planDate=" + planDate
				+ ", comment=" + comment + "]";
	}

	
	
	

}
