package com.customer.client;

import java.util.List;

import com.customer.dao.InterestDAO;
import com.customer.dao.InterestDAOImpl;
import com.customer.vo.Interest;

public class InterestApp {

	public static void main(String[] args) {
		InterestDAO dao = InterestDAOImpl.getInstance();
		
		System.out.println("-----관심 지역-------");
		System.out.println();
		
		// 관심지역 모두 조회(사용자 구분없음)
		List<Interest> list = dao.selectAll();
		for (Interest i : list) {
			System.out.println(i.getNum() + "의 관심 지역은 " 
					+ i.getDongcode() + "로 " + i.getCity()+" "+i.getGugun()+" "+i.getDong()+"입니다.");
		}
		System.out.println();
		
		// 관심 지역 조회
		System.out.println(dao.selectInterest("1", "1111010100"));
		System.out.println();
		
		// 관심 지역 등록
		dao.insertInterest("1", "1111010700", "서울특별시", "종로구", "적선동");
		list = dao.selectAll();
		for (Interest i : list) {
			System.out.println(i.getNum() + "의 관심 지역은 " 
					+ i.getDongcode() + "로 " + i.getCity()+" "+i.getGugun()+" "+i.getDong()+"입니다.");
		}
		System.out.println();
		
		// 관심 지역 수정
		dao.updateInterest("1", "1111010700","1111010800", "서울특별시", "종로구", "통인동");
		list = dao.selectAll();
		for (Interest i : list) {
			System.out.println(i.getNum() + "의 관심 지역은 " 
					+ i.getDongcode() + "로 " + i.getCity()+" "+i.getGugun()+" "+i.getDong()+"입니다.");
		}
		System.out.println();
		
		// 관심 지역 삭제
		dao.deleteInterest("1", "1111010800");
		list = dao.selectAll();
		for (Interest i : list) {
			System.out.println(i.getNum() + "의 관심 지역은 " 
					+ i.getDongcode() + "로 " + i.getCity()+" "+i.getGugun()+" "+i.getDong()+"입니다.");
		}

		System.out.println();
	
	}

}
