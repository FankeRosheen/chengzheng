package com.cgwy.lbs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cgwy.lbs.service.RestLocService;

@Controller
public class RestLocController{
	@Autowired
	private RestLocService restLocService;
	@RequestMapping(value ="/commit",method=RequestMethod.GET)
	public String commit(@RequestParam("restaurantId") Long restaurantId){
		return "commit";
	}
	
	
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public void saveRestLoc(@RequestParam("id")  Long restaurantId,
			@RequestParam("location") String location){
		restLocService.saveLocInfo(restaurantId, location);
	}

	

}
