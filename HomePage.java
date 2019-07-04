package com.pageFactory;

import org.openqa.selenium.By;

import com.genericFunction.TestBase;


public class HomePage {
	
	private TestBase objTestBase;
	
	public HomePage(TestBase testBase){
		
		this.objTestBase=testBase;
	}
	
	By inpFrom=By.xpath("//input[@id='FromTag']");
	By inpTo=By.xpath("//input[@id='ToTag']");
	By datePicker=By.xpath("//div[@id='ui-datepicker-div']");
	By inpPickDate=By.xpath("//i[@class='icon ir datePicker'][contains(.,'Cal')][1]");
	By drpAdult=By.xpath("//select[@id='Adults']");
	By btnSearchFlight=By.xpath("//input[@id='SearchBtn']");
	
	
	
	public void selectRadioButtonForTrip(String strRadioName){
		
		By locator=By.xpath("//nav[@class='row fieldRow tripType']/ul/li//following-sibling::label/strong[contains(text(),'"+strRadioName+"')]/preceding-sibling::input[1]");
		
		objTestBase.logReporter("select flight trip - ", strRadioName, objTestBase.getObjCommonFunctions().click(locator));
		
		
	}
	
	public void setFromCity(String strFromCity,String strAutoFromCity){
		
		By locator=By.xpath("//a[text()='"+strAutoFromCity+"']");
		objTestBase.getObjCommonFunctions().click(inpFrom);
		objTestBase.logReporter("set from city - ", strFromCity, objTestBase.getObjCommonFunctions().setText(inpFrom, strFromCity));
		objTestBase.getObjCommonFunctions().waitFor(4);
		objTestBase.getObjCommonFunctions().checkElemetDisplayed(locator);
		objTestBase.logReporter("click from city from autocomplete dropdown - ", strAutoFromCity, objTestBase.getObjCommonFunctions().click(locator));


	}
	
	public void setToCity(String strToCity,String strAutoToCity){
		
		By locator=By.xpath("//a[text()='"+strAutoToCity+"']");
		objTestBase.getObjCommonFunctions().click(inpTo);
		objTestBase.logReporter("set from city - ", strToCity, objTestBase.getObjCommonFunctions().setText(inpTo, strToCity));
		objTestBase.getObjCommonFunctions().waitFor(4);
		objTestBase.getObjCommonFunctions().checkElemetDisplayed(locator);
		objTestBase.logReporter("click from city from autocomplete dropdown - ", strAutoToCity, objTestBase.getObjCommonFunctions().click(locator));
	}
	
	public void setFromDate(int intPlusDayFromCurrent){
		
		By locGetCurrentDate=By.xpath("//table[@class='calendar']//tr//td/a[@class='ui-state-default ui-state-highlight ui-state-active ']");
		
		if(!objTestBase.getObjCommonFunctions().checkElemetDisplayed(datePicker)){
			
			objTestBase.logReporter("Click pick date input box ", objTestBase.getObjCommonFunctions().click(inpPickDate));
			String strCurrentDate=objTestBase.getDriver().findElement(locGetCurrentDate).getText().trim();
			int setDate=Integer.parseInt(strCurrentDate)+intPlusDayFromCurrent;
			By setDesiredDate=By.xpath("//table[@class='calendar']//tr//td/a[@class='ui-state-default '][text()='"+setDate+"'][1]");
			objTestBase.logReporter("Set Date from date ", objTestBase.getObjCommonFunctions().click(setDesiredDate));
		}else {
			
			String strCurrentDate=objTestBase.getDriver().findElement(locGetCurrentDate).getText().trim();
			int setDate=Integer.parseInt(strCurrentDate)+intPlusDayFromCurrent;
			By setDesiredDate=By.xpath("//table[@class='calendar']//tr//td/a[@class='ui-state-default '][text()='"+setDate+"'][1]");
			objTestBase.logReporter("Set Date from date ", objTestBase.getObjCommonFunctions().click(setDesiredDate));
		
		}
	}
	
	public void setToDate(int intPlusDayFromCurrent){
		
		By locGetCurrentDate=By.xpath("//table[@class='calendar']//tr//td/a[@class='ui-state-default ui-state-active ']");
		
		if(!objTestBase.getObjCommonFunctions().checkElemetDisplayed(datePicker)){
			
			objTestBase.logReporter("Click pick date input box ", objTestBase.getObjCommonFunctions().click(inpPickDate));
			String strCurrentDate=objTestBase.getDriver().findElement(locGetCurrentDate).getText().trim();
			int setDate=Integer.parseInt(strCurrentDate)+intPlusDayFromCurrent;
			By setDesiredDate=By.xpath("//table[@class='calendar']//tr//td/a[@class='ui-state-default '][text()='"+setDate+"'][1]");
			objTestBase.logReporter("Set Date from date ", objTestBase.getObjCommonFunctions().click(setDesiredDate));
		}else {
			
			String strCurrentDate=objTestBase.getDriver().findElement(locGetCurrentDate).getText().trim();
			int setDate=Integer.parseInt(strCurrentDate)+intPlusDayFromCurrent;
			By setDesiredDate=By.xpath("//table[@class='calendar']//tr//td/a[@class='ui-state-default '][text()='"+setDate+"'][1]");
			objTestBase.logReporter("Set Date from date ", objTestBase.getObjCommonFunctions().click(setDesiredDate));
		
		}
	}
	
	public void setDropdownValue(String strDropdownOption){
		
		objTestBase.logReporter("Set Adult dropdown ", strDropdownOption, objTestBase.getObjCommonFunctions().selectDropdownValue(drpAdult, strDropdownOption));
	}
	
	
	public void clickSearchButton(){
		
		objTestBase.logReporter("click search flight button ", objTestBase.getObjCommonFunctions().click(btnSearchFlight));
	}
	

	
}
