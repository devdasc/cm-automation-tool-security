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
	
	@ManyToMany(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name="deployement_defectlist",
			   joinColumns=@JoinColumn(name="deployement_Id"),
			   inverseJoinColumns=@JoinColumn(name="defect_Id"))
	private List<DefectFixDetail> listDefectFixDetail;
	
	
	public DeploymentPlan() {
		
	}
	
	public DeploymentPlan(Integer deployment_Id, String title, Application application, Date planDate,
			Date dev_DeploymentDate, Date sdf_DeploymentDate, Date ist1_DeploymentDate, Date ist2_DeploymentDate,
			Date prod_DeploymentDate, String comment, List<DefectFixDetail> listDefectFixDetail) {
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
		this.listDefectFixDetail = listDefectFixDetail;
	}


	//convenience method to add defect fix detail
	public void addDefectFixDetail(DefectFixDetail defectFixDetail) {
		if(listDefectFixDetail==null) {
			listDefectFixDetail=new ArrayList();
		}
		listDefectFixDetail.add(defectFixDetail);
	}

	public List<DefectFixDetail> getListDefectFixDetail() {
		return listDefectFixDetail;
	}



	public void setListDefectFixDetail(List<DefectFixDetail> listDefectFixDetail) {
		this.listDefectFixDetail = listDefectFixDetail;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((application == null) ? 0 : application.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((deployment_Id == null) ? 0 : deployment_Id.hashCode());
		result = prime * result + ((dev_DeploymentDate == null) ? 0 : dev_DeploymentDate.hashCode());
		result = prime * result + ((ist1_DeploymentDate == null) ? 0 : ist1_DeploymentDate.hashCode());
		result = prime * result + ((ist2_DeploymentDate == null) ? 0 : ist2_DeploymentDate.hashCode());
		result = prime * result + ((listDefectFixDetail == null) ? 0 : listDefectFixDetail.hashCode());
		result = prime * result + ((planDate == null) ? 0 : planDate.hashCode());
		result = prime * result + ((prod_DeploymentDate == null) ? 0 : prod_DeploymentDate.hashCode());
		result = prime * result + ((sdf_DeploymentDate == null) ? 0 : sdf_DeploymentDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeploymentPlan other = (DeploymentPlan) obj;
		if (application == null) {
			if (other.application != null)
				return false;
		} else if (!application.equals(other.application))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (deployment_Id == null) {
			if (other.deployment_Id != null)
				return false;
		} else if (!deployment_Id.equals(other.deployment_Id))
			return false;
		if (dev_DeploymentDate == null) {
			if (other.dev_DeploymentDate != null)
				return false;
		} else if (!dev_DeploymentDate.equals(other.dev_DeploymentDate))
			return false;
		if (ist1_DeploymentDate == null) {
			if (other.ist1_DeploymentDate != null)
				return false;
		} else if (!ist1_DeploymentDate.equals(other.ist1_DeploymentDate))
			return false;
		if (ist2_DeploymentDate == null) {
			if (other.ist2_DeploymentDate != null)
				return false;
		} else if (!ist2_DeploymentDate.equals(other.ist2_DeploymentDate))
			return false;
		if (listDefectFixDetail == null) {
			if (other.listDefectFixDetail != null)
				return false;
		} else if (!listDefectFixDetail.equals(other.listDefectFixDetail))
			return false;
		if (planDate == null) {
			if (other.planDate != null)
				return false;
		} else if (!planDate.equals(other.planDate))
			return false;
		if (prod_DeploymentDate == null) {
			if (other.prod_DeploymentDate != null)
				return false;
		} else if (!prod_DeploymentDate.equals(other.prod_DeploymentDate))
			return false;
		if (sdf_DeploymentDate == null) {
			if (other.sdf_DeploymentDate != null)
				return false;
		} else if (!sdf_DeploymentDate.equals(other.sdf_DeploymentDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DeploymentPlan [deployment_Id=" + deployment_Id + ", title=" + title + ", application=" + application
				+ ", planDate=" + planDate + ", dev_DeploymentDate=" + dev_DeploymentDate + ", sdf_DeploymentDate="
				+ sdf_DeploymentDate + ", ist1_DeploymentDate=" + ist1_DeploymentDate + ", ist2_DeploymentDate="
				+ ist2_DeploymentDate + ", prod_DeploymentDate=" + prod_DeploymentDate + ", comment=" + comment + "]";
	}
}
