package com.cmautomation.spring.entity;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="defect_fix_detail")
public class DefectFixDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="defect_Id")
	private Integer defect_Id;
	
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
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date defectCreationDate;
	
	@Column(name="description")
	@Lob
	private String description;
	
	@Column(name="dependentDefect_Id")
	private Integer dependentDefect_Id;
	
	@Column(name="status")
	private int status;
	
	@Column(name="fixRecieveDate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy/MM/dd")
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
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date reviewDate;
	
	@ManyToMany(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name="deployement_defectlist",
			   joinColumns=@JoinColumn(name="defect_Id"),
			   inverseJoinColumns=@JoinColumn(name="deployement_Id"))
	private List<DeploymentPlan> listDeploymentPlan;
	
	public DefectFixDetail() {
		
	}
	
	
	public Integer getDefect_Id() {
		return defect_Id;
	}


	public void setDefect_Id(Integer defect_Id) {
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



	public Integer getDependentDefect_Id() {
		return dependentDefect_Id;
	}



	public void setDependentDefect_Id(Integer dependentDefect_Id) {
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
	//convenience method
	public void addDeploymentPlan(DeploymentPlan theDeploymentPlan) {
		if(listDeploymentPlan==null) {
			listDeploymentPlan=new ArrayList();
		}
		listDeploymentPlan.add(theDeploymentPlan);
	}
	

	public List<DeploymentPlan> getListDeploymentPlan() {
		return listDeploymentPlan;
	}

	public void setListDeploymentPlan(List<DeploymentPlan> listDeploymentPlan) {
		this.listDeploymentPlan = listDeploymentPlan;
	}

	
	public DefectFixDetail(Integer defect_Id, String title, Application application, Vendor vendor,
			Date defectCreationDate, String description, Integer dependentDefect_Id, int status, Date fixRecieveDate,
			String impactedComponent, String deploymentPackageLocation, int isTestCaseprovided,
			int isDeploymentInstructionProvided, Date reviewDate, List<DeploymentPlan> listDeploymentPlan) {
		super();
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
		this.listDeploymentPlan = listDeploymentPlan;
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
