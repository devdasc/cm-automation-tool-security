package com.cmautomation.spring.dao;

import java.util.List;

import com.cmautomation.spring.entity.QACheckList;

public interface QACheckListDAO {

	List<QACheckList> getQACheckList();

	public void saveQACheckList(QACheckList qaCheckList);

}
