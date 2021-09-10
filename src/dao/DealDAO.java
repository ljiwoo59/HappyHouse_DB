package com.customer.dao;

import java.util.List;

import com.customer.vo.Deal;
import com.customer.vo.HouseInfo;

public interface DealDAO {
	List<Deal> selectDongDeal(String dongName);
	List<Deal> selectAptDeal(String aptName);
	void insertDeal(String dong, String AptName, String code, String dealAmount, String buildYear, String dealYear, String dealMonth, String dealDay, String area, String floor, String jibun, String type, String rentMoney);
	List<HouseInfo> manageinfo(List<Deal> list);
}
