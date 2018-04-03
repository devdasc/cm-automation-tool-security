package com.cmautomation.spring.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="deploymentplan")
public class DeploymentPlan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="deployment_Id")
	private Integer deployment_Id;
	
	@Column(name="title")
	private String title;
		
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="application_Id")
	private Application application;
	
	@Column(name="planDate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date planDate;
	
	@Column(name="dev_DeploymentDate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dev_DeploymentDate;
	
	@Column(name="sdf_DeploymentDate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date sdf_DeploymentDate;
	
	@Column(name="ist1_DeploymentDate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date ist1_DeploymentDate;
	
	@Column(name="ist2_DeploymentDate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date ist2_DeploymentDate;
	
	@Column(name="prod_DeploymentDate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date prod_DeploymentDate;
	
	@Lob
	@Column(name="comment")
	private String comment;
	
	/*@OneToMany(cascade={CascadeType.ALL})
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name="deployement_defectlist",
			   joinColumns=@JoinColumn(name="deployement_Id"),
			   inverseJoinColumns=@JoinColumn(name="defect_Id"))
	private List<DeploymentDefectList> listDeploymentDefects;*/
	
	
	@ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "deployement_defectlist",
            joinColumns = { @JoinColumn(name = "deployement_Id") },
            inverseJoinColumns = { @JoinColumn(name = "defect_Id") })
    private  List<DefectFixDetail> listDeploymentDefects;
	
	@Transient
	private List<String> defects=new ArrayList<>();
	

	
	
	public DeploymentPlan() {
		
	}
	
	public DeploymentPlan(Integer deployment_Id, String title, Application application, Date planDate,
			Date dev_DeploymentDate, Date sdf_DeploymentDate, Date ist1_DeploymentDate, Date ist2_DeploymentDate,
			Date prod_DeploymentDate, String comment, List<DefectFixDetail> listDeploymentDefects) {
		super();
		this.deployment_Id = deployment_Id;
		this.title = title;
		this.application = application;
		this.planDate = planDate;
		this.dev_DeploymentDate = dev_DeploymentDate;
		this.sdf_DeploymentDate = sdf_DeploymentDate;
		this.ist1_DeploymentDate = ist1_DeploymentDate;
		this.ist2_DeploymentDate = ist2_DeploymentDate;
		this.prod_DeploymentDate = prod_DeploymentDate;
		this.comment = comment;
		this.listDeploymentDefects = listDeploymentDefects;
	}


	//convenience method to add defect fix detail
	public void addDefectFixDetail(DefectFixDetail deploymentDefect) {
		if(listDeploymentDefects==null) {
			listDeploymentDefects=new ArrayList();
		}
		listDeploymentDefects.add(deploymentDefect);
	}

	public List<DefectFixDetail> getListDeploymentDefects() {
		return listDeploymentDefects;
	}



	public void setListDeploymentDefects(List<DefectFixDetail> listDeploymentDefects) {
		this.listDeploymentDefects = listDeploymentDefects;
	}
	
	public List<String>  getDefects() {
		return defects;
	}
	public void setDefects(List<String> defects) {
		this.defects = defects;
	}
	
	public Integer getDeployment_Id() {
		return deployment_Id;
	}


	public void setDeployment_Id(Integer deployment_Id) {
		this.deployment_Id = deployment_Id;
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

	public Date getDev_DeploymentDate() {
		return dev_DeploymentDate;
	}

	public void setDev_DeploymentDate(Date dev_DeploymentDate) {
		this.dev_DeploymentDate = dev_DeploymentDate;
	}

	public Date getSdf_DeploymentDate() {
		return sdf_DeploymentDate;
	}

	public void setSdf_DeploymentDate(Date sdf_DeploymentDate) {
		this.sdf_DeploymentDate = sdf_DeploymentDate;
	}

	public Date getIst1_DeploymentDate() {
		return ist1_DeploymentDate;
	}

	public void setIst1_DeploymentDate(Date ist1_DeploymentDate) {
		this.ist1_DeploymentDate = ist1_DeploymentDate;
	}

	public Date getIst2_DeploymentDate() {
		return ist2_DeploymentDate;
	}

	public void setIst2_DeploymentDate(Date ist2_DeploymentDate) {
		this.ist2_DeploymentDate = ist2_DeploymentDate;
	}

	public Date getProd_DeploymentDate() {
		return prod_DeploymentDate;
	}

	public void setProd_DeploymentDate(Date prod_DeploymentDate) {
		this.prod_DeploymentDate = prod_DeploymentDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	

	@Override
	public String toString() {
		return "DeploymentPlan [deployment_Id=" + deployment_Id + ", title=" + title + ", application=" + application
				+ ", planDate=" + planDate + ", dev_DeploymentDate=" + dev_DeploymentDate + ", sdf_DeploymentDate="
				+ sdf_DeploymentDate + ", ist1_DeploymentDate=" + ist1_DeploymentDate + ", ist2_DeploymentDate="
				+ ist2_DeploymentDate + ", prod_DeploymentDate=" + prod_DeploymentDate + ", comment=" + comment + "]";
	}
}
