package com.neova;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class TestBase {
	
	public WebDriver webdriver;
	public Properties objConfig;
	public FileInputStream objConfigFIS;
	

	public TestBase() {

		this.initConfigProperties();
	}

	public void initialization() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.get(objConfig.getProperty("AUT_URL"));
		logReporter("AUT URL ---> " + objConfig.getProperty("AUT_URL"), true);
		webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.verifyUrlOpen();
	}

	// By Yogesh Khachane
	public void initConfigProperties() {

		objConfig = new Properties();
		try {
			objConfigFIS = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/config.properties");
			objConfig.load(objConfigFIS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebDriver getDriver() {
		return webdriver;
	}

	public void verifyUrlOpen() {

		String expectedTitle = "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.";
		String actualTitle = webdriver.getTitle();
		this.logReporter("Verified-Open Url successfully.", actualTitle, actualTitle.trim().equals(expectedTitle));

	}

	public void terminate() {

		getDriver().quit();

	}

	/*public void logReporter(String strMsg, boolean blnResult) {

		if (blnResult) {
			Reporter.log("Step Description -----> " + strMsg, blnResult);
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	public void logReporter(String strMsg, String strInputValue, boolean blnResult) {

		if (blnResult) {

			Reporter.log("Step Description -----> " + strMsg + "|| InputValue || " + strInputValue, blnResult);
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	public void logReporter(String strMsg, String strExpectedValue, String strActualValue, boolean blnResult) {

		if (blnResult) {

			Reporter.log("Step Description -----> " + strMsg + "|| expectedValue ||" + strExpectedValue
					+ "|| ActualValue ||" + strActualValue, blnResult);
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}
*/
	
	public void logReporter(String strMsg, boolean blnResult) {

			Reporter.log("Step Description -----> " + strMsg, blnResult);
			
	}

	public void logReporter(String strMsg, String strInputValue, boolean blnResult) {

		

			Reporter.log("Step Description -----> " + strMsg + "|| InputValue || " + strInputValue, blnResult);
		

	}

	public void logReporter(String strMsg, String strExpectedValue, String strActualValue, boolean blnResult) {


			Reporter.log("Step Description -----> " + strMsg + "|| expectedValue ||" + strExpectedValue
					+ "|| ActualValue ||" + strActualValue, blnResult);
		

	}

	
}
