package com.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.customer.util.DBClose;
import com.customer.util.DBConnection;
import com.customer.vo.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	private static CustomerDAOImpl dao;

	private CustomerDAOImpl() {}

	public static CustomerDAO getInstance() {
		if (dao == null)
			dao = new CustomerDAOImpl();
		return dao;
	}

	@Override
	public List<Customer> selectAll() {
		List<Customer> list = new ArrayList<>();

		try {
			Connection conn = DBConnection.getConnection();
			String sql = "select * from customer";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String email = rs.getString(4);
				String tel = rs.getString(5);
				int interest = rs.getInt(1);
				Customer c = new Customer(num, name, address, email, tel, interest);

				list.add(c);
			}
			
			DBClose.close(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	@Override
	public Customer selectCustomer(String searchNum) {
		Customer tmp = null; 
		try {
			Connection conn = DBConnection.getConnection();
			String sql = "select * from customer where num =";
			sql += ( "'"+searchNum+"'" );
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String email = rs.getString(4);
				String tel = rs.getString(5);
				int interest = rs.getInt(1);
				tmp = new Customer(num, name, address, email, tel, interest);
			}
			
			DBClose.close(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tmp;
	}

	

	@Override
	public Customer insertCustomer(String num, String name, String address, String email, String tel, int interest) {
		Customer tmp = null; 
		try {
			Connection conn = DBConnection.getConnection();
			String sql = "insert into customer values (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			pstmt.setString(2, name);
			pstmt.setString(3, address);
			pstmt.setString(4, email);
			pstmt.setString(5, tel);
			pstmt.setInt(6, interest);
			
			pstmt.executeUpdate();
			
			System.out.println(name+" 회원 가입 성공");			
			DBClose.close(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tmp;
	}
	
	@Override
	public Customer updateCustomer(String num, String name, String address, String email, String tel, int interest) {
		Customer tmp = null; 
		try {
			Connection conn = DBConnection.getConnection();
			String sql = "update customer set name=?, address=?, tel=?, interest=? where num=? and email=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, address);
			pstmt.setString(3, tel);
			pstmt.setInt(4, interest);
			pstmt.setString(5, num);
			pstmt.setString(6, email);
			
			pstmt.executeUpdate();
			
			System.out.println("no."+num+" "+name+": 업데이트 성공");			
			DBClose.close(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tmp;
	}
	
	@Override
	public void deleteCustomer(String num, String email) {
		try {
			Connection conn = DBConnection.getConnection();
			String sql = "delete from customer where num=? and email=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			pstmt.setString(2, email);
			
			pstmt.executeUpdate();
			
			System.out.println(num+": 탈퇴 성공");			
			DBClose.close(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
