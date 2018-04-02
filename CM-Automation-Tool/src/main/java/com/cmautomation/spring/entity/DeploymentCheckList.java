package com.cmautomation.spring.entity;

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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "deploymentchecklist")
public class DeploymentCheckList {
	
	@Id
	@Column(name="deploymentChecklist_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deploymentChecklist_Id; 
	

	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn(name="deployment_Id",updatable=false)
	private DeploymentPlan deploymentPlan;	
	
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn(name="environment_Id",updatable=false)
	private DeploymentEnvironment deploymentEnvironment;
	
	@Column(name="actualDeploymentDate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date actualDeploymentDate;
	
	@Column(name="isPackageDeployed",length=1, columnDefinition="CHAR")
	private char isPackageDeployed;
	
	@Lob
	@Column(name="deployedPackageInfo")
	private String deployedPackageInfo;
	
	@Column(name="isParameterDeployed",length=1, columnDefinition="CHAR")
	private char isParameterDeployed;
	
	@Lob
	@Column(name="deployedParameterInfo")
	private String deployedParameterInfo;
	
	@Column(name="isDBScriptExecuted",length=1, columnDefinition="CHAR")
	private char isDBScriptExecuted;
	
	@Lob
	@Column(name="dBScriptInfo")
	private String dBScriptInfo;
	
	@Lob
	@Column(name="otherDeploymentInfo")
	private String otherDeploymentInfo;
	
	@Column(name="deployedBy")
	private String deployedBy;
	
	public DeploymentCheckList() {
		
	}

	public DeploymentCheckList(Integer deploymentChecklist_Id, DeploymentPlan deploymentPlan,
			DeploymentEnvironment deploymentEnvironment, Date actualDeploymentDate, char isPackageDeployed,
			String deployedPackageInfo, char isParameterDeployed, String deployedParameterInfo, char isDBScriptExecuted,
			String dBScriptInfo, String otherDeploymentInfo, String deployedBy) {
		super();
		this.deploymentChecklist_Id = deploymentChecklist_Id;
		this.deploymentPlan = deploymentPlan;
		this.deploymentEnvironment = deploymentEnvironment;
		this.actualDeploymentDate = actualDeploymentDate;
		this.isPackageDeployed = isPackageDeployed;
		this.deployedPackageInfo = deployedPackageInfo;
		this.isParameterDeployed = isParameterDeployed;
		this.deployedParameterInfo = deployedParameterInfo;
		this.isDBScriptExecuted = isDBScriptExecuted;
		this.dBScriptInfo = dBScriptInfo;
		this.otherDeploymentInfo = otherDeploymentInfo;
		this.deployedBy = deployedBy;
	}

	public Integer getDeploymentChecklist_Id() {
		return deploymentChecklist_Id;
	}

	public void setDeploymentChecklist_Id(Integer deploymentChecklist_Id) {
		this.deploymentChecklist_Id = deploymentChecklist_Id;
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

	public Date getActualDeploymentDate() {
		return actualDeploymentDate;
	}

	public void setActualDeploymentDate(Date actualDeploymentDate) {
		this.actualDeploymentDate = actualDeploymentDate;
	}

	public char getIsPackageDeployed() {
		return isPackageDeployed;
	}

	public void setIsPackageDeployed(char isPackageDeployed) {
		this.isPackageDeployed = isPackageDeployed;
	}

	public String getDeployedPackageInfo() {
		return deployedPackageInfo;
	}

	public void setDeployedPackageInfo(String deployedPackageInfo) {
		this.deployedPackageInfo = deployedPackageInfo;
	}

	public char getIsParameterDeployed() {
		return isParameterDeployed;
	}

	public void setIsParameterDeployed(char isParameterDeployed) {
		this.isParameterDeployed = isParameterDeployed;
	}

	public String getDeployedParameterInfo() {
		return deployedParameterInfo;
	}

	public void setDeployedParameterInfo(String deployedParameterInfo) {
		this.deployedParameterInfo = deployedParameterInfo;
	}

	public char getIsDBScriptExecuted() {
		return isDBScriptExecuted;
	}

	public void setIsDBScriptExecuted(char isDBScriptExecuted) {
		this.isDBScriptExecuted = isDBScriptExecuted;
	}

	public String getdBScriptInfo() {
		return dBScriptInfo;
	}

	public void setdBScriptInfo(String dBScriptInfo) {
		this.dBScriptInfo = dBScriptInfo;
	}

	public String getOtherDeploymentInfo() {
		return otherDeploymentInfo;
	}

	public void setOtherDeploymentInfo(String otherDeploymentInfo) {
		this.otherDeploymentInfo = otherDeploymentInfo;
	}

	public String getDeployedBy() {
		return deployedBy;
	}

	public void setDeployedBy(String deployedBy) {
		this.deployedBy = deployedBy;
	}

	@Override
	public String toString() {
		return "DeploymentCheckList [deploymentChecklist_Id=" + deploymentChecklist_Id + ", deploymentPlan="
				+ deploymentPlan + ", deploymentEnvironment=" + deploymentEnvironment + ", actualDeploymentDate="
				+ actualDeploymentDate + ", isPackageDeployed=" + isPackageDeployed + ", deployedPackageInfo="
				+ deployedPackageInfo + ", isParameterDeployed=" + isParameterDeployed + ", deployedParameterInfo="
				+ deployedParameterInfo + ", isDBScriptExecuted=" + isDBScriptExecuted + ", dBScriptInfo="
				+ dBScriptInfo + ", otherDeploymentInfo=" + otherDeploymentInfo + ", deployedBy=" + deployedBy + "]";
	}
	
	
	
	
	
	

}