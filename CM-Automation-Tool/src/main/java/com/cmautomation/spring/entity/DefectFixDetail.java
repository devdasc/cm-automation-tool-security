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
	@Column(name="Defect_Id")
	private int defect_id;
	
	@Column(name="Title")
	private String title;
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="Application_Id")
	private Application application;
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="Vendor_Id")
	private Vendor vendor;
	
	@Column(name="DefectCreationDate")
	@Temporal(TemporalType.DATE)
	private Date defectCreationdate;
	
	@Column(name="Description")
	@Lob
	private String description;
	
	@Column(name="DependentDefect_Id")
	private int dependentDefect_Id;
	
	@Column(name="Status")
	private int status;
	
	@Column(name="FixRecieveDate")
	@Temporal(TemporalType.DATE)
	private Date fixReceivedate;
	
	@Column(name="ImpactedComponent")
	private String impactedComponent;
	
	@Column(name="deploymentPackageLocation")
	private String deploymentPackageLocation;/*--*/
	
	@Column(name="IsTestCaseprovided")
	private int isTestcaseprovided;
	
	@Column(name="IsDeploymentInstructionProvided")
	private int isDeploymentInstructionProvided;
	
	@Column(name="ReviewDate")
	@Temporal(TemporalType.DATE)
	private Date reviewDate;
	
	public DefectFixDetail() {
		
	}
	

	public DefectFixDetail(int defect_id, String title, Application application, Vendor vendor, Date defectCreationdate,
			String description, int dependentDefect_Id, int status, Date fixReceivedate, String impactedComponent,
			String deploymentPackageLocation, int isTestcaseprovided, int isDeploymentInstructionProvided,
			Date reviewDate) {
		
		this.defect_id = defect_id;
		this.title = title;
		this.application = application;
		this.vendor = vendor;
		this.defectCreationdate = defectCreationdate;
		this.description = description;
		this.dependentDefect_Id = dependentDefect_Id;
		this.status = status;
		this.fixReceivedate = fixReceivedate;
		this.impactedComponent = impactedComponent;
		this.deploymentPackageLocation = deploymentPackageLocation;
		this.isTestcaseprovided = isTestcaseprovided;
		this.isDeploymentInstructionProvided = isDeploymentInstructionProvided;
		this.reviewDate = reviewDate;
	}


	public int getDefect_id() {
		return defect_id;
	}

	public void setDefect_id(int defect_id) {
		this.defect_id = defect_id;
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

	public Date getDefectCreationdate() {
		return defectCreationdate;
	}

	public void setDefectCreationdate(Date defectCreationdate) {
		this.defectCreationdate = defectCreationdate;
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

	public Date getFixReceivedate() {
		return fixReceivedate;
	}

	public void setFixReceivedate(Date fixReceivedate) {
		this.fixReceivedate = fixReceivedate;
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

	public int getIsTestcaseprovided() {
		return isTestcaseprovided;
	}

	public void setIsTestcaseprovided(int isTestcaseprovided) {
		this.isTestcaseprovided = isTestcaseprovided;
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
		return "DefectFixDetail [defect_id=" + defect_id + ", title=" + title + ", application=" + application
				+ ", vendor=" + vendor + ", defectCreationdate=" + defectCreationdate + ", description=" + description
				+ ", dependentDefect_Id=" + dependentDefect_Id + ", status=" + status + ", fixReceivedate="
				+ fixReceivedate + ", impactedComponent=" + impactedComponent + ", deploymentPackageLocation="
				+ deploymentPackageLocation + ", isTestcaseprovided=" + isTestcaseprovided
				+ ", isDeploymentInstructionProvided=" + isDeploymentInstructionProvided + ", reviewDate=" + reviewDate
				+ "]";
	}
	
	
}
