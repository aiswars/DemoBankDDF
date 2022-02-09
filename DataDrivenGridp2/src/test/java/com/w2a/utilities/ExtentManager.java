package com.w2a.utilities;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance(){
		
		if(extent==null){
			//Thu 30:20:00
			Date d = new Date();
			String fileName = "jenkins_"+d.toString().replace(":", "_").replace(" ", "_")+".html"; //configured in jenkins> index pages> to pick any files with jenkins in reports filename 
		// maven reports	extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
		//maven reports	    extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\",true,DisplayOrder.OLDEST_FIRST); //reports in target folder
			extent = new ExtentReports(System.getProperty("user.dir")+"\\reports\\"+fileName,true,DisplayOrder.OLDEST_FIRST); // reports in reports folder
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
	
		}
		
		return extent;
		
	}

}
