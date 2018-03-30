package com.cmautomation.spring.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Embeddable
public class QACompositeKeyId implements Serializable{
	/*
	private Integer deployment_Id;
	
	private Integer environment_Id;
	*/
	
	/*
	@Column(name="deployment_Id")
	private Integer deployment_Id;
	
	@Column(name="environment_Id")
	private Integer environment_Id;
	*/
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="deployment_Id",insertable = false, updatable = false)
	private DeploymentPlan deploymentPlan;	
	
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="environment_Id",insertable = false, updatable = false)
	private DeploymentEnvironment deploymentEnvironment;

	public QACompositeKeyId() {
		
	}
	

	public QACompositeKeyId(DeploymentPlan deploymentPlan, DeploymentEnvironment deploymentEnvironment) {
		super();
		this.deploymentPlan = deploymentPlan;
		this.deploymentEnvironment = deploymentEnvironment;
	}


	/*
	public QACompositeKeyId(Integer deployment_Id, Integer environment_Id) {
		super();
		this.deployment_Id = deployment_Id;
		this.environment_Id = environment_Id;
	}


	public Integer getDeployment_Id() {
		return deployment_Id;
	}


	public void setDeployment_Id(Integer deployment_Id) {
		this.deployment_Id = deployment_Id;
	}


	public Integer getEnvironment_Id() {
		return environment_Id;
	}


	public void setEnvironment_Id(Integer environment_Id) {
		this.environment_Id = environment_Id;
	}

*/
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QACompositeKeyId)) return false;
        QACompositeKeyId that = (QACompositeKeyId) o;
        return Objects.equals(getDeploymentPlan(), that.getDeploymentEnvironment()) &&
                Objects.equals(getDeploymentPlan(), that.getDeploymentEnvironment());
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

	@Override
    public int hashCode() {
        return Objects.hash(getDeploymentPlan(), getDeploymentEnvironment());
    }

}
