package com.cmautomation.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vendor")
public class Vendor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vendor_Id")
	private int vendor_Id;
	
	@Column(name="vendorName")
	private String vendorName;
	
	@Column(name = "description")
	private String description;
	

	@OneToMany(mappedBy="vendor",cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<DefectFixDetail> defectFixDetail;
	
	public Vendor() {
		
	}


	public Vendor(int vendor_Id, String vendorName, List<DefectFixDetail> defectFixDetail) {
		
		this.vendor_Id = vendor_Id;
		this.vendorName = vendorName;
		this.defectFixDetail = defectFixDetail;
	}


	public void addDefectFixDetail(DefectFixDetail theDefectFixDetail) {
		if(defectFixDetail==null) {
			defectFixDetail=new ArrayList<>();
			}
		defectFixDetail.add(theDefectFixDetail);
	}
	public int getVendor_Id() {
		return vendor_Id;
	}


	public void setVendor_Id(int vendor_Id) {
		this.vendor_Id = vendor_Id;
	}


	public String getVendorName() {
		return vendorName;
	}


	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public List<DefectFixDetail> getDefectFixDetail() {
		return defectFixDetail;
	}

	public void setDefectFixDetail(List<DefectFixDetail> defectFixDetail) {
		this.defectFixDetail = defectFixDetail;
	}

	@Override
	public String toString() {
		return "Vendor [vendorid=" + vendor_Id + ", vendorName=" + vendorName + ", Description "+description+"]";
	}
	

}
