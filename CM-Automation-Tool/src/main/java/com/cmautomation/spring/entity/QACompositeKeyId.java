package com.cmautomation.spring.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class QACompositeKeyId implements Serializable{
	
	@Column(name="Deployment_Id")
	private int deployment_id;
	
	@Column(name="Environment_Id")
	private int environment_id;
	
	public QACompositeKeyId() {
		
	}

	public int getDeployment_id() {
		return deployment_id;
	}

	public void setDeployment_id(int deployment_id) {
		this.deployment_id = deployment_id;
	}

	public int getEnvironment_id() {
		return environment_id;
	}

	public void setEnvironment_id(int environment_id) {
		this.environment_id = environment_id;
	}

	public QACompositeKeyId(int deployment_id, int environment_id) {
		super();
		this.deployment_id = deployment_id;
		this.environment_id = environment_id;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QACompositeKeyId)) return false;
        QACompositeKeyId that = (QACompositeKeyId) o;
        return Objects.equals(getDeployment_id(), that.getEnvironment_id()) &&
                Objects.equals(getDeployment_id(), that.getEnvironment_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeployment_id(), getEnvironment_id());
    }

}
