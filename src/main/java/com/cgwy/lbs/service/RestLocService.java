package com.cgwy.lbs.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cgwy.lbs.dao.LocationDao;
@Service
public class RestLocService {
	@Autowired
	private LocationDao locationDao;
	@Transactional
	public void saveLocInfo(Long restaurantId, String location) {
		locationDao.saveLocInfo(restaurantId,location);
	}




}
