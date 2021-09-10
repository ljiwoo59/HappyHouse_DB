package com.customer.dao;

import java.util.List;

import com.customer.vo.Interest;

public interface InterestDAO {
	List<Interest> selectAll();
	Interest selectInterest(String num, String dongcode);
	Interest insertInterest(String num, String dongcode, String city, String gugun, String dong );
	Interest updateInterest(String num, String origin, String dongcode, String city, String gugun, String dong );
	void deleteInterest(String num, String dongcode);
}
