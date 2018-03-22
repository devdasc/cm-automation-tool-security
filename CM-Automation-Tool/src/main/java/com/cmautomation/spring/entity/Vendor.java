package com.cmautomation.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(name="Vendor_Id")
	private int vendorId;
	
	@Column(name="VendorName")
	private String vendorName;
	

	@OneToMany(mappedBy="vendor",cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<DefectFixDetail> defectFixDetail;
	
	public Vendor() {
		
	}

	
	public Vendor(int vendorId, String vendorName, List<DefectFixDetail> defectFixDetail) {
		
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.defectFixDetail = defectFixDetail;
	}

	public void addDefectFixDetail(DefectFixDetail theDefectFixDetail) {
		if(defectFixDetail==null) {
			defectFixDetail=new ArrayList<>();
			}
		defectFixDetail.add(theDefectFixDetail);
	}
		
	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public List<DefectFixDetail> getDefectFixDetail() {
		return defectFixDetail;
	}

	public void setDefectFixDetail(List<DefectFixDetail> defectFixDetail) {
		this.defectFixDetail = defectFixDetail;
	}

	@Override
	public String toString() {
		return "Vendor [vendorid=" + vendorId + ", vendorName=" + vendorName + "]";
	}
	

}
