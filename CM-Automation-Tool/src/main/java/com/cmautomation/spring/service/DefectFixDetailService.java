package com.cmautomation.spring.service;

import java.util.List;

import com.cmautomation.spring.entity.DefectFixDetail;

public interface DefectFixDetailService {

	public List<DefectFixDetail> getDefectList();

	public void saveDefectFixDetail(DefectFixDetail theDefectFixDetail);

	public DefectFixDetail getDefectFixDetail(int defect_Id);

}
