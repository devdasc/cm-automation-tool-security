package com.cmautomation.spring.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class QACompositeKeyId implements Serializable{
	/*
	private Integer deployment_Id;
	
	private Integer environment_Id;
	*/
	
	
	@Column(name="deployment_Id")
	private Integer deployment_Id;
	
	@Column(name="environment_Id")
	private Integer environment_Id;
	
	public QACompositeKeyId() {
		
	}

	
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


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QACompositeKeyId)) return false;
        QACompositeKeyId that = (QACompositeKeyId) o;
        return Objects.equals(getDeployment_Id(), that.getEnvironment_Id()) &&
                Objects.equals(getDeployment_Id(), that.getEnvironment_Id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeployment_Id(), getEnvironment_Id());
    }

}
