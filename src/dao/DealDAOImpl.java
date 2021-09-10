package com.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.customer.util.DBClose;
import com.customer.util.DBConnection;
import com.customer.vo.Deal;
import com.customer.vo.HouseInfo;

public class DealDAOImpl implements DealDAO {
	private static DealDAOImpl dao;
	
	private DealDAOImpl() {}
	
	public static DealDAO getInstanceDeal() {
		if (dao == null)
			dao = new DealDAOImpl();
		return dao;
	}

	@Override
	public List<Deal> selectDongDeal(String dongName) {
		List<Deal> list = new ArrayList<>();

		try {
			Connection conn = DBConnection.getConnection();
			String sql = "select * from housedeal \n";
			sql += "where dong = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dongName);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String dong = rs.getString(2);
				String AptName = rs.getString(3);
				String code = rs.getString(4);
				String dealAmount = rs.getString(5);
				String buildYear = rs.getString(6);
				String dealYear = rs.getString(7);
				String dealMonth = rs.getString(8);
				String dealDay = rs.getString(9);
				String area = rs.getString(10);
				String floor = rs.getString(11);
				String jibun = rs.getString(12);
				String type = rs.getString(13);
				String rentMoney = rs.getString(14);
				Deal d = new Deal(dong, AptName, code, dealAmount, buildYear, dealYear, dealMonth, dealDay, area, floor, jibun, type, rentMoney);

				list.add(d);
			}
			
			DBClose.close(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Deal> selectAptDeal(String aptName) {
		List<Deal> list = new ArrayList<>();

		try {
			Connection conn = DBConnection.getConnection();
			String sql = "select * from housedeal where AptName like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			String newapt = "%";
			newapt += aptName + "%";
			pstmt.setString(1, newapt);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String dong = rs.getString(2);
				String AptName = rs.getString(3);
				String code = rs.getString(4);
				String dealAmount = rs.getString(5);
				String buildYear = rs.getString(6);
				String dealYear = rs.getString(7);
				String dealMonth = rs.getString(8);
				String dealDay = rs.getString(9);
				String area = rs.getString(10);
				String floor = rs.getString(11);
				String jibun = rs.getString(12);
				String type = rs.getString(13);
				String rentMoney = rs.getString(14);
				Deal d = new Deal(dong, AptName, code, dealAmount, buildYear, dealYear, dealMonth, dealDay, area, floor, jibun, type, rentMoney);

				list.add(d);
			}
			
			DBClose.close(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void insertDeal(String dong, String AptName, String code, String dealAmount, String buildYear, String dealYear, String dealMonth, String dealDay, String area, String floor, String jibun, String type, String rentMoney) {
		try {
			Connection conn = DBConnection.getConnection();
			String checksql = "select * from housedeal";
			PreparedStatement pstmt = conn.prepareStatement(checksql, ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			int lastIndex = -1;
			if (rs.last())
				lastIndex = rs.getInt(1);
			
			String sql = "insert into housedeal values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lastIndex + 1);
			pstmt.setString(2, dong);
			pstmt.setString(3, AptName);
			pstmt.setString(4, code);
			pstmt.setString(5, dealAmount);
			pstmt.setString(6, buildYear);
			pstmt.setString(7, dealYear);
			pstmt.setString(8, dealMonth);
			pstmt.setString(9, dealDay);
			pstmt.setString(10, area);
			pstmt.setString(11, floor);
			pstmt.setString(12, jibun);
			pstmt.setString(13, type);
			pstmt.setString(14, rentMoney);
			pstmt.executeUpdate();

			DBClose.close(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<HouseInfo> manageinfo(List<Deal> list) {
		List<HouseInfo> infolist = new ArrayList<>();

		try {
			Connection conn = DBConnection.getConnection();
			String sql = "";
			for (Deal deal : list) {
				sql = "select dong, AptName, code, buildYear, jibun, lat, lng, img \n";
				sql += "from houseinfo \n";
				sql += "where dong = ? and Aptname = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, deal.getDong());
				pstmt.setString(2, deal.getAptName());
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				
				String dong = rs.getString(1);
				String AptName = rs.getString(2);
				String code = rs.getString(3);
				String buildYear = rs.getString(4);
				String jibun = rs.getString(5);
				String lat = rs.getString(6);
				String lng = rs.getString(7);
				String img = rs.getString(8);
				HouseInfo h = new HouseInfo(dong, AptName, code, buildYear, jibun, lat, lng, img);

				infolist.add(h);
			}
			
			DBClose.close(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return infolist;
		
	}

}
