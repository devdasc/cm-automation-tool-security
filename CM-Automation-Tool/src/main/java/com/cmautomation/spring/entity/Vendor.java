package com.cmautomation.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	public Vendor() {
		
	}

	public Vendor(int vendorId, String vendorName) {
		
		this.vendorId = vendorId;
		this.vendorName = vendorName;
	}

	public int getVendorid() {
		return vendorId;
	}

	public void setVendorid(int vendorid) {
		this.vendorId = vendorid;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	@Override
	public String toString() {
		return "Vendor [vendorid=" + vendorId + ", vendorName=" + vendorName + "]";
	}
	

}
