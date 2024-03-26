package com.service;

import com.model.Building;

import org.springframework.stereotype.Service;

@Service 
//use appropriate annotation to configure BuildingService as Service
public class BuildingService {
	
	public double calculateBCR(Building obj)
	{
		double bcr=0.0;
		
		bcr=(obj.getBuildingArea()/obj.getSiteArea())*100.0;
		
		if(obj.getBuildingType().equals("Commercial"))
		{
		    if(bcr>85.5)
		    {
		        obj.setApprovalStatus("Not Approved");
		    }
		    else 
		    {
		        obj.setApprovalStatus("Approved");
		    }
		}
		else if(obj.getBuildingType().equals("Residential"))
		{
		    if(bcr>75.5)
		    {
		        obj.setApprovalStatus("Not Approved");
		    }
		    else 
		    {
		        obj.setApprovalStatus("Approved");
		    }
		}
		return bcr;
	}

}
