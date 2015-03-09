package com.cgwy.lbs.service;


import com.cgwy.lbs.entity.Restaurant;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-persist.xml", "/application-context.xml"})
public class RestaurantServiceTest{

    @Autowired
    private RestaurantService restaurantService;

    @Test
    public void testGetRestaurants() throws Exception {
        final List<Restaurant> restaurants = restaurantService.getRestaurants(Arrays.asList(16l, 25l, 26l));

        Assert.assertEquals(3, restaurants.size());
    }

    @Test
    public void testGetRestaurantsHavingOrders() throws Exception {
        final List<Restaurant> restaurantsHavingOrders = restaurantService.getRestaurantsHavingOrders(DateUtils.parseDate("2015-03-01", new String[]{"yyyy-MM-dd"}),
                DateUtils.parseDate("2015-03-07", new String[]{"yyyy-MM-dd"}));

        Assert.assertFalse(restaurantsHavingOrders.isEmpty());


    }
}