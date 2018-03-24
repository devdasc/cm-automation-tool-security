package com.cmautomation.spring.dao;

import java.util.List;

import com.cmautomation.spring.entity.DefectFixDetail;

public interface DefectFixDetailDAO {

	List<DefectFixDetail> getDefectList();

	public void saveDefectFixDetail(DefectFixDetail theDefectFixDetail);

	public DefectFixDetail getDefectFixDetail(int defect_Id);

}
