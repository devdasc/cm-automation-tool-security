package com.cmautomation.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(name="qachecklist")
//public class QACheckList {
//	// need to add composite primary keys
//	
//	@EmbeddedId
//	private QACompositeKeyId qaCompositeKeyId;
//	/*
//	private DeploymentPlan deploymentPlan;	
//	private DeploymentEnvironment deploymentEnvironment;
//	*/
//	
//	@Column(name="TestDate")
//	@Temporal(TemporalType.DATE)
//	private Date testDate;
//	
//	@Column(name="TestStatus")
//	private int testStatus;
//	
//	@Lob
//	@Column(name="Comment")
//	private String comment;
//	
//	@Column(name="TestedBy")
//	private int testedBy;
//	
//	
//
//}
