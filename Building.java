package com.model;


import org.springframework.stereotype.Component;
import javax.validation.constraints.Min;
//use appropriate annotation to configure the Building class as Component
@Component
public class Building {
	
	private String buildingType;
	//fill the code
	@Min(value=1,message="Building Area should be minimum one")
	private double buildingArea;
	//fill the code
	@Min(value=1,message="Site Area should be minimum one")
	private double siteArea;
	private String approvalStatus;
	
	public String getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}
	public double getBuildingArea() {
		return buildingArea;
	}
	public void setBuildingArea(double buildingArea) {
		this.buildingArea = buildingArea;
	}
	public double getSiteArea() {
		return siteArea;
	}
	public void setSiteArea(double siteArea) {
		this.siteArea = siteArea;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
	

}
