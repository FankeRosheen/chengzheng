package com.cgwy.lbs.controller;

import com.cgwy.lbs.entity.Restaurant;
import com.cgwy.lbs.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: xudong
 * Date: 3/9/15
 * Time: 5:49 PM
 */
@Controller
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    @ResponseBody
    public List<Restaurant> restaurants(@RequestParam("id") List<Long> ids) {
        return restaurantService.getRestaurants(ids);
    }
    
    //返回show.jsp页面
    @RequestMapping(value="/check",method=RequestMethod.GET)
    public String showMap(){
    	return "show";
    }
	
    //处理来自show.jsp中的ajax请求
	@RequestMapping(value="/show",method=RequestMethod.GET)
	@ResponseBody
	public void showAllAtMap(){
			restaurantService.getAllRestaurants();
	}
	
    
    
}
