package com.customer.client;

import java.util.List;

import com.customer.dao.CustomerDAO;
import com.customer.dao.CustomerDAOImpl;
import com.customer.vo.Customer;

public class CustomerApp {

	public static void main(String[] args) {
		CustomerDAO dao = CustomerDAOImpl.getInstance();
		
		// 현재 회원 정보 조회
		List<Customer> list = dao.selectAll();
		for (Customer c : list) {
			System.out.println(c.getNum() + ":" + c.getName() + ":" + c.getAddress());
		}
		System.out.println();
		
		// 회원 추가
		dao.insertCustomer("6", "강본사", "경기도 수원시 영통구 삼성로 129(매탄동) ", "suwon@samsung.com", "82-31-200-1114", 0);
		list = dao.selectAll();
		for (Customer c : list) {
			System.out.println(c.getNum() + ":" + c.getName() + ":" + c.getAddress());
		}
		System.out.println();
		
		// 회원 정보 수정
		dao.updateCustomer("6", "강수원", "경기도 수원시 영통구 삼성로 129(매탄동)", "suwon@samsung.com","82-31-200-1114", 0);
		System.out.println(dao.selectCustomer("6"));
		System.out.println();
		
		
		// 회원 삭제		
		dao.deleteCustomer("6", "suwon@samsung.com");
		list = dao.selectAll();
		for (Customer c : list) {
			System.out.println(c.getNum() + ":" + c.getName() + ":" + c.getAddress());
		}
		System.out.println();
	}

}
