package com.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.customer.util.DBClose;
import com.customer.util.DBConnection;
import com.customer.vo.Interest;

public class InterestDAOImpl implements InterestDAO {

	private static InterestDAOImpl dao;

	private InterestDAOImpl() {}

	public static InterestDAO getInstance() {
		if (dao == null)
			dao = new InterestDAOImpl();
		return dao;
	}

	@Override
	public List<Interest> selectAll() {
		List<Interest> list = new ArrayList<>();
		try {
			Connection conn = DBConnection.getConnection();
			String sql = "select * from interest";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String num = rs.getString(1);
				String dongcode = rs.getString(2);
				String city = rs.getString(3);
				String gugun = rs.getString(4);
				String dong = rs.getString(5);
				Interest i = new Interest(num, dongcode, city, gugun,dong);
				list.add(i);
			}
			
			DBClose.close(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	@Override
	public Interest selectInterest(String searchNum, String searchDong) {
		Interest tmp = null; 
		try {
			Connection conn = DBConnection.getConnection();
			String sql = "select * from interest where num=? and dongcode=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchNum);
			pstmt.setString(2, searchDong);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String num = rs.getString(1);
				String dongcode = rs.getString(2);
				String city = rs.getString(3);
				String gugun = rs.getString(4);
				String dong = rs.getString(5);
				tmp = new Interest(num, dongcode, city, gugun,dong);
			}
			
			DBClose.close(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tmp;
	}

	

	@Override
	public Interest insertInterest(String num, String dongcode, String city, String gugun, String dong ) {
		Interest tmp = null; 
		try {
			Connection conn = DBConnection.getConnection();
			String sql = "insert into interest values ( ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			pstmt.setString(2, dongcode);
			pstmt.setString(3, city);
			pstmt.setString(4, gugun);
			pstmt.setString(5, dong);
			
			pstmt.executeUpdate();
			
			String sql2 = "select interest from customer where num=?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, num);
			ResultSet rs = pstmt.executeQuery();
			int cnt = 0;
			while (rs.next()) {
				cnt = rs.getInt(1);
			}
			
			String sql3 = "update customer set interest=? where num=?";
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, cnt+1);
			pstmt.setString(2, num);
			pstmt.executeUpdate();
			
			System.out.println(num+"님의 "+dongcode+" 관심 지역 등록 성공");			
			DBClose.close(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tmp;
	}
	
	@Override
	public Interest updateInterest(String num, String origin, String dongcode, String city, String gugun, String dong ) {
		Interest tmp = null; 
		try {
			Connection conn = DBConnection.getConnection();
			String sql = "update interest set dongcode=?, city=?, gugun=?, dong=? where num=? and dongcode=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dongcode);
			pstmt.setString(2, city);
			pstmt.setString(3, gugun);
			pstmt.setString(4, dong);
			pstmt.setString(5, num);
			pstmt.setString(6, origin);
			
			pstmt.executeUpdate();
			
			System.out.println("no."+num+" "+origin+": 업데이트 성공");			
			DBClose.close(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tmp;
	}
	
	@Override
	public void deleteInterest(String num, String ddongcode) {
		try {
			Connection conn = DBConnection.getConnection();
			String sql = "delete from interest where num=? and dongcode=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			pstmt.setString(2, ddongcode);
			pstmt.executeUpdate();
			

			String sql2 = "select interest from customer where num=?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, num);
			ResultSet rs = pstmt.executeQuery();
			int cnt = 0;
			while (rs.next()) {
				cnt = rs.getInt(1);
			}
			
			String sql3 = "update customer set interest=? where num=?";
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, cnt-1);
			pstmt.setString(2, num);
			pstmt.executeUpdate();
			
			System.out.println(num+": "+ddongcode+" 삭제 성공");			
			DBClose.close(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
