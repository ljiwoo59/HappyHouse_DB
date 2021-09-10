package com.customer.dao;

import java.util.List;

import com.customer.vo.Customer;

public interface CustomerDAO {
	List<Customer> selectAll();
	Customer selectCustomer(String num);
	Customer insertCustomer(String num, String name, String address, String email, String tel, int interest);
	Customer updateCustomer(String num, String name, String address, String email, String tel, int interest);
	void deleteCustomer(String num, String email);
}
