package com.cgwy.lbs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LocationDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void saveLocInfo(Long restaurantId,String location) {
		String sql = "update restaurant set location = ? where id = ?";
		Object[]params = new Object[]{location,restaurantId};
		jdbcTemplate.update(sql,params);
	}

	
}
