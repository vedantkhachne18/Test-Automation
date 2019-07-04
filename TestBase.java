package com.genericFunction;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class TestBase {
	
	public Properties objConfig;
	public FileInputStream objFIS;
	public WebDriver webDriver;
	public CommonFunctions objCommonFunctions;
	
	
	
	
	
	
	public void initilize_Properties_And_Web_Environment(){
		
		this.initilize_Properties();
		objCommonFunctions=new CommonFunctions(this);
		
		this.logReporter("Start initilize Web Environment ....", true);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver.exe");
		webDriver=new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.get(objConfig.getProperty("AUT_URL"));
		this.logReporter("Open AUT URL - ",objConfig.getProperty("AUT_URL"), true);
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.logReporter("Verify HomePage Title - ", objConfig.getProperty("AUT_TITLE"), webDriver.getTitle().trim(), objConfig.getProperty("AUT_TITLE").equals(webDriver.getTitle().trim()));
		

	}
	
	
	public void tearDown_Web_Environment(){
		
		webDriver.quit();
		
	}
	
	
	public  WebDriver getDriver(){
		
		return webDriver;
	}
	
	
	public CommonFunctions getObjCommonFunctions(){
		
		return objCommonFunctions;
	}
	
	
	
	
	
	
	public void initilize_Properties(){
		try {
			
			objConfig=new Properties();
			objFIS=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
			objConfig.load(objFIS);
			
		} catch (Exception e) {

		 System.out.println("I got exception while initilization of properties.");
		e.printStackTrace();
		
		}
		
		
		
	}
	
	public void logReporter(String strMessage, boolean result) {
		
		if (result) {
			Reporter.log("Step Description ----> " + strMessage, true);
			Assert.assertTrue(true);
		} else {
			Reporter.log("Step Description ----> " + strMessage, true);
			Assert.assertTrue(false);
		}
	}
	
	public void logReporter(String strMessage,String inputValue, boolean result) {
		
		if (result) {
			Reporter.log("Step Description ----> " + " || InputValue || " + inputValue+" ." + strMessage, true);
			Assert.assertTrue(true);
		} else {
			Reporter.log("Step Description ----> " + " || InputValue || " + inputValue+" ." + strMessage, true);
			Assert.assertTrue(false);
		}
	}
	
	
	public void logReporter(String strMessage,String ExpectedValue,String ActualValue, boolean result) {
		
		if (result) {
			Reporter.log("Step Description ----> " + " || ExpectedValue || " + ExpectedValue+ " || ActualValue || "+ ActualValue + " ." + strMessage, true);
			Assert.assertTrue(true);
		} else {
			Reporter.log("Step Description ----> " + " || ExpectedValue || " + ExpectedValue+ " || ActualValue || "+ ActualValue + " ." + strMessage, true);
			Assert.assertTrue(false);
		}
	}
	
	
	

}
