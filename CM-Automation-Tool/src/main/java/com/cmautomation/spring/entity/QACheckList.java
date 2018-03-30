package com.cmautomation.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="qachecklist")
public class QACheckList implements Serializable{
	// need to add composite primary keys
	
	@EmbeddedId
	private QACompositeKeyId qaCompositeKeyId;
	
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="deployment_Id",insertable = false, updatable = false)
	private DeploymentPlan deploymentPlan;	
	
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="environment_Id",insertable = false, updatable = false)
	private DeploymentEnvironment deploymentEnvironment;
	
	
	@Column(name="testDate")
	@Temporal(TemporalType.DATE)
	private Date testDate;
	
	@Column(name="TestStatus")
	private int testStatus;
	
	@Lob
	@Column(name="comment")
	private String comment;
	
	@Column(name="testedBy")
	private String testedBy;
	
	
	public QACheckList() {
		
	}

	public QACheckList(QACompositeKeyId qaCompositeKeyId, DeploymentPlan deploymentPlan,
			DeploymentEnvironment deploymentEnvironment, Date testDate, int testStatus, String comment,
			String testedBy) {
		super();
		this.qaCompositeKeyId = qaCompositeKeyId;
		this.deploymentPlan = deploymentPlan;
		this.deploymentEnvironment = deploymentEnvironment;
		this.testDate = testDate;
		this.testStatus = testStatus;
		this.comment = comment;
		this.testedBy = testedBy;
	}
	public DeploymentPlan getDeploymentPlan() {
		return deploymentPlan;
	}


	public void setDeploymentPlan(DeploymentPlan deploymentPlan) {
		this.deploymentPlan = deploymentPlan;
	}


	public DeploymentEnvironment getDeploymentEnvironment() {
		return deploymentEnvironment;
	}


	public void setDeploymentEnvironment(DeploymentEnvironment deploymentEnvironment) {
		this.deploymentEnvironment = deploymentEnvironment;
	}


	public Date getTestDate() {
		return testDate;
	}


	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}


	public int getTestStatus() {
		return testStatus;
	}


	public void setTestStatus(int testStatus) {
		this.testStatus = testStatus;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}

	public QACompositeKeyId getQaCompositeKeyId() {
		return qaCompositeKeyId;
	}

	public void setQaCompositeKeyId(QACompositeKeyId qaCompositeKeyId) {
		this.qaCompositeKeyId = qaCompositeKeyId;
	}

	public String getTestedBy() {
		return testedBy;
	}
	public void setTestedBy(String testedBy) {
		this.testedBy = testedBy;
	}

	@Override
	public String toString() {
		return "QACheckList [qaCompositeKeyId=" + qaCompositeKeyId + ", deploymentPlan=" + deploymentPlan
				+ ", deploymentEnvironment=" + deploymentEnvironment + ", testDate=" + testDate + ", testStatus="
				+ testStatus + ", comment=" + comment + ", testedBy=" + testedBy + "]";
	}


}
