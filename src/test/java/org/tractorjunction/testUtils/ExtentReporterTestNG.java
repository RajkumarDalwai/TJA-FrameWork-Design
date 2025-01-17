package org.tractorjunction.testUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterTestNG {

	static ExtentReports extent;
	
	public static ExtentReports getReporterObject()
	{
//		ExtentReports , ExtentSparkReporter
		String path = System.getProperty("user.dir")+"./reports/Extentreport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("TJA Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rajkumar Dalwai");
		return extent;	
	}
}
