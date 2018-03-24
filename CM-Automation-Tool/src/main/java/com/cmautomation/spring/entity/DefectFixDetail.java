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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="defect_fix_detail")
public class DefectFixDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="defect_Id")
	private int defect_Id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="application_Id")
	private Application application;
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="vendor_Id")
	private Vendor vendor;
	
	@Column(name="defectCreationDate")
	@Temporal(TemporalType.DATE)
	private Date defectCreationDate;
	
	@Column(name="description")
	@Lob
	private String description;
	
	@Column(name="dependentDefect_Id")
	private int dependentDefect_Id;
	
	@Column(name="status")
	private int status;
	
	@Column(name="fixRecieveDate")
	@Temporal(TemporalType.DATE)
	private Date fixRecieveDate;
	
	@Column(name="impactedComponent")
	private String impactedComponent;
	
	@Column(name="deploymentPackageLocation")
	private String deploymentPackageLocation;/*--*/
	
	@Column(name="isTestCaseprovided")
	private int isTestCaseprovided;
	
	@Column(name="isDeploymentInstructionProvided")
	private int isDeploymentInstructionProvided;
	
	@Column(name="reviewDate")
	@Temporal(TemporalType.DATE)
	private Date reviewDate;
	
	public DefectFixDetail() {
		
	}
	
	public DefectFixDetail(int defect_Id, String title, Application application, Vendor vendor, Date defectCreationDate,
			String description, int dependentDefect_Id, int status, Date fixRecieveDate, String impactedComponent,
			String deploymentPackageLocation, int isTestCaseprovided, int isDeploymentInstructionProvided,
			Date reviewDate) {
		
		this.defect_Id = defect_Id;
		this.title = title;
		this.application = application;
		this.vendor = vendor;
		this.defectCreationDate = defectCreationDate;
		this.description = description;
		this.dependentDefect_Id = dependentDefect_Id;
		this.status = status;
		this.fixRecieveDate = fixRecieveDate;
		this.impactedComponent = impactedComponent;
		this.deploymentPackageLocation = deploymentPackageLocation;
		this.isTestCaseprovided = isTestCaseprovided;
		this.isDeploymentInstructionProvided = isDeploymentInstructionProvided;
		this.reviewDate = reviewDate;
	}

	public int getDefect_Id() {
		return defect_Id;
	}

	public void setDefect_Id(int defect_Id) {
		this.defect_Id = defect_Id;
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

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Date getDefectCreationDate() {
		return defectCreationDate;
	}

	public void setDefectCreationDate(Date defectCreationDate) {
		this.defectCreationDate = defectCreationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDependentDefect_Id() {
		return dependentDefect_Id;
	}

	public void setDependentDefect_Id(int dependentDefect_Id) {
		this.dependentDefect_Id = dependentDefect_Id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getFixRecieveDate() {
		return fixRecieveDate;
	}

	public void setFixRecieveDate(Date fixRecieveDate) {
		this.fixRecieveDate = fixRecieveDate;
	}

	public String getImpactedComponent() {
		return impactedComponent;
	}

	public void setImpactedComponent(String impactedComponent) {
		this.impactedComponent = impactedComponent;
	}

	public String getDeploymentPackageLocation() {
		return deploymentPackageLocation;
	}

	public void setDeploymentPackageLocation(String deploymentPackageLocation) {
		this.deploymentPackageLocation = deploymentPackageLocation;
	}

	public int getIsTestCaseprovided() {
		return isTestCaseprovided;
	}

	public void setIsTestCaseprovided(int isTestCaseprovided) {
		this.isTestCaseprovided = isTestCaseprovided;
	}

	public int getIsDeploymentInstructionProvided() {
		return isDeploymentInstructionProvided;
	}

	public void setIsDeploymentInstructionProvided(int isDeploymentInstructionProvided) {
		this.isDeploymentInstructionProvided = isDeploymentInstructionProvided;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Override
	public String toString() {
		return "DefectFixDetail [defect_Id=" + defect_Id + ", title=" + title + ", application=" + application
				+ ", vendor=" + vendor + ", defectCreationDate=" + defectCreationDate + ", description=" + description
				+ ", dependentDefect_Id=" + dependentDefect_Id + ", status=" + status + ", fixRecieveDate="
				+ fixRecieveDate + ", impactedComponent=" + impactedComponent + ", deploymentPackageLocation="
				+ deploymentPackageLocation + ", isTestCaseprovided=" + isTestCaseprovided
				+ ", isDeploymentInstructionProvided=" + isDeploymentInstructionProvided + ", reviewDate=" + reviewDate
				+ "]";
	}
	
	
}
