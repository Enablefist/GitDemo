package com.controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import javax.validation.Valid;

import com.model.Building;
import com.service.BuildingService;
//use appropriate annotation to configure BuildingController as Controller
@Controller 
public class BuildingController {
    @Autowired
    private BuildingService service;
	
	//invoke the service class - calculateBuildingCoverageRatio method.
	
	@RequestMapping(value="/BCRPage",method=RequestMethod.GET)
	public String calculateBCRPage(@ModelAttribute("building") Building building)
	{
	    return "BCRpage";
	}
	
	@ModelAttribute("buildingList")
	public Map<String,String> buildState()
	{
	    Map<String,String> serviceMap=new HashMap<>();
	    serviceMap.put("Commercial","Commercial");
	    serviceMap.put("Residential","Residential");
	    return serviceMap;
	}
	
	@RequestMapping(value="/result",method=RequestMethod.POST)
	public String calculateBuildingCoverageRatio(@Valid @ModelAttribute("building") Building building, 
			BindingResult result,ModelMap map){
			    
			        double cost=service.calculateBCR(building);
			        String status=building.getApprovalStatus();
			        map.addAttribute("cost",cost);
			        map.addAttribute("status",status);
			        return result.hasErrors()?"BCRpage":"result";
			
	}

}
