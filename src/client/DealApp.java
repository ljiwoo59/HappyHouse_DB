package com.customer.client;

import java.util.List;

import com.customer.dao.DealDAO;
import com.customer.dao.DealDAOImpl;
import com.customer.vo.Deal;
import com.customer.vo.HouseInfo;

public class DealApp {

	public static void main(String[] args) {
		DealDAO dao = DealDAOImpl.getInstanceDeal();
		
		// 동 검색 (ex. 교북동)
		List<Deal> list = dao.selectDongDeal("교북동");
		
		for (Deal deal : list) {
			System.out.println(deal);
		}
		
		
		// 아파트 검색 (ex 경희) 포함 검색 가능
		List<Deal> list1 = dao.selectAptDeal("경희");
		
		for (Deal deal : list1) {
			System.out.println(deal);
		}
		
		
		// 거래가 등록 및 조회
		dao.insertDeal("testdong", "testapt", "testcode", "testAmount", "buildYear", "dealYear", "dealMonth", "dealDay", "area", "floor", "jibun", "type", "rentMoney");
		List<Deal> list2 = dao.selectAptDeal("test");
		for (Deal deal : list2) {
			System.out.println(deal);
		}
		
		// 얻은 거래가 리스트에서 아파트 정보 조회
		List<HouseInfo> list3 = dao.manageinfo(list);
		for (HouseInfo h : list3) {
			System.out.println(h);
		}
	}

}
