package com.cgwy.lbs.service;

import com.cgwy.lbs.dao.OrderDao;
import com.cgwy.lbs.dao.RestaurantDao;
import com.cgwy.lbs.entity.Order;
import com.cgwy.lbs.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * User: xudong
 * Date: 3/9/15
 * Time: 5:37 PM
 */
@Service
public class RestaurantService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private RestaurantDao restaurantDao;

    public List<Restaurant> getRestaurants(Collection<Long> ids) {
        return restaurantDao.getRestaurants(ids);
    }

    public List<Restaurant> getAllRestaurants(){
        return restaurantDao.getAllRestaurants();
    }


    public List<Restaurant> getRestaurantsHavingOrders(Date start, Date end) {
        final List<Order> orders = orderDao.getUncanceledOrderCreateTimeBetween(start, end);

        Set<Long> restaurantIds = new HashSet<Long>();
        for (Order order : orders) {
            restaurantIds.add(order.getRestaurantId());
        }

        return getRestaurants(restaurantIds);
    }
    
    
	@Transactional
	public void saveLocInfo(Long restaurantId, String location) {
		restaurantDao.saveLocInfo(restaurantId,location);
	}

}
