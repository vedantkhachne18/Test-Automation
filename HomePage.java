package com.pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neova.TestBase;
import com.neova.CommonFunctions;

public class HomePage {
	
	
	// Local variables
	private TestBase objTestBase;
	private CommonFunctions getObjCommonFunctions;
	private String strReturnVal="";
	private int intVal;
	private int intGivenDate;
	private Integer intSelectDate;
	private String strFinalDate="";
		
		public HomePage(TestBase testBase) {
			this.objTestBase = testBase;
			getObjCommonFunctions=new CommonFunctions(objTestBase);
			
		}
		
		// Locators
		
		By btnSearchFlight=By.xpath("//input[@id='SearchBtn'][@type='submit']");
		By btnBook=By.xpath("//strong[text()='IndiGo']/parent::div/following::div//button[text()='Book' and @type='submit']");
		By btnContinueBooking=By.xpath("//input[@id='itineraryBtn']");
		By btnContinueBtn=By.id("travellerBtn");
		By drpAdult=By.xpath("//select[@id='Adults']");
		
		
		
		

		
		public void commonRadioButtonSelectTripWay(String strRBText){
			
			By locator=By.xpath("//strong[text()='"+strRBText+"']/preceding-sibling::input[@type='radio']");
			getObjCommonFunctions.checkElementDisplayed(locator);
			getObjCommonFunctions.checkElementEnabled(locator);
			getObjCommonFunctions.selectRadioButton(locator, true);
			
		}
		
		public void commonSelectFormAirport(String strFlightName){
			
			
			By locator=By.xpath("//a[text()='"+strFlightName+"']");
			By locatorTXTBX=By.xpath("//input[@id='FromTag']");
		getObjCommonFunctions.checkElementDisplayed(locatorTXTBX);
		objTestBase.logReporter("Set Airport flight name ", getObjCommonFunctions.setText(locatorTXTBX, strFlightName));
		getObjCommonFunctions.checkElementDisplayed(locator);
		objTestBase.logReporter("click flight name ", getObjCommonFunctions.click(locator));
			
		}
		
		public void commonSelectToAirport(String strToFlightName){
			
			By locator=By.xpath("//a[text()='"+strToFlightName+"']");
			By locatorTXTBX=By.xpath("//input[@id='ToTag']");
		getObjCommonFunctions.checkElementDisplayed(locatorTXTBX);
		objTestBase.logReporter("Set Airport flight name ",getObjCommonFunctions.setText(locatorTXTBX, strToFlightName));
		getObjCommonFunctions.checkElementDisplayed(locator);
		objTestBase.logReporter("click flight name ",getObjCommonFunctions.click(locator));
		
			
		}
		
		
		public void commonPickDepartDateFromDatePicker(int intFuturDate, int intCurrentMonthDays){
			
			By locator=By.xpath("//div[@id='ui-datepicker-div']//table[@class='calendar']//tr/td/a[@class='ui-state-default ui-state-highlight ui-state-active ']");
			By locatorList=By.xpath("//div[@id='ui-datepicker-div']//table[@class='calendar']//tr/td/a");
			
			if(objTestBase.getDriver().findElement(locator).getAttribute("class").contains("ui-state-default ui-state-highlight ui-state-active ")){
				strReturnVal=objTestBase.getDriver().findElement(locator).getText();
				intVal=Integer.parseInt(strReturnVal);
				 intGivenDate=intVal+intFuturDate;
				intSelectDate=intGivenDate-intCurrentMonthDays;
				strFinalDate=String.valueOf(intSelectDate);
				System.out.println("intSelectDate ---> "+intSelectDate);
			}
			
			
			List<WebElement> allDates=objTestBase.getDriver().findElements(locatorList);
			System.out.println("List Size -- "+allDates.size());
			for(WebElement element:allDates){
				
				String strDates=element.getText();
				
				System.out.println("Date ---> "+strDates);
				if (strDates.equals(strFinalDate)) {
					element.click();
					objTestBase.logReporter("set date - ",strDates, true);
					getObjCommonFunctions.waitFor(20);
					break;
				}
			}
			
		}
		

public void commonPickReturnDateFromDatePicker(int intFuturDate, int intCurrentMonthDays){
			
			By locator=By.xpath("//div[@id='ui-datepicker-div']//table[@class='calendar']//tr/td/a[@class='ui-state-default ui-state-active ']");
			By locatorList=By.xpath("//div[@id='ui-datepicker-div']//table[@class='calendar']//tr/td/a");
			
			if(objTestBase.getDriver().findElement(locator).getAttribute("class").contains("ui-state-default ui-state-active ")){
				strReturnVal=objTestBase.getDriver().findElement(locator).getText();
				System.out.println("Active Date ---> "+strReturnVal);
				intVal=Integer.parseInt(strReturnVal);
				 intGivenDate=intVal+intFuturDate;
				System.out.println("intSelectDate ---> "+intGivenDate);
			}
			
			
			List<WebElement> allDates=objTestBase.getDriver().findElements(locatorList);
			System.out.println("List Size -- "+allDates.size());
			for(WebElement element:allDates){
				
				String strDates=element.getText();
				
				System.out.println("Date ---> "+strDates);
				if (strDates.equals(intGivenDate)) {
					element.click();
					objTestBase.logReporter("set date - ",strDates, true);
					getObjCommonFunctions.waitFor(20);
					break;
				}
			}
			
		}

		public void clickSearchFlight(){
			
			getObjCommonFunctions.checkElementDisplayed(btnSearchFlight);
			objTestBase.logReporter("click search Flight ", getObjCommonFunctions.click(btnSearchFlight));
			getObjCommonFunctions.waitFor(20);
		}
		public void selectDropdownAdultValue(String strDrpOption){
			
			getObjCommonFunctions.checkElementDisplayed(drpAdult);
			objTestBase.logReporter("select adult ", strDrpOption, getObjCommonFunctions.selectDropDownOption(drpAdult,strDrpOption));
		}
		
		public void commonSelectStop(String strStop){
			By locator=By.xpath("//label[contains(.,'0 stop')]/preceding-sibling::input[@name='stops']/following-sibling::label[1]");
			getObjCommonFunctions.checkElementDisplayed(locator);
			objTestBase.logReporter("select stop ",strStop, getObjCommonFunctions.click(locator));
		
		
		
		}
		
		public void selectRadioIndigoFlightBySeuanceIndex(String strIndex){
			
			By locator=By.xpath("//span[contains(.,'IndiGo ')]/ancestor::table//tr/th/input[@type='radio'][@value='"+strIndex+"']");
			getObjCommonFunctions.checkElementDisplayed(locator);
			getObjCommonFunctions.checkElementEnabled(locator);
			objTestBase.logReporter("Select radio 'Indigo' ", strIndex, getObjCommonFunctions.click(locator));
		
		
		}
		
			public void selectRadioIndigoFlightBySeuanceIndex_1(String strIndex_1){
			
			By locator=By.xpath("//span[contains(.,'IndiGo ')]/ancestor::table//tr/th/input[@type='radio'][@value='"+strIndex_1+"']");
			getObjCommonFunctions.checkElementDisplayed(locator);
			getObjCommonFunctions.checkElementEnabled(locator);
			objTestBase.logReporter("Select radio 'Indigo' ", strIndex_1, getObjCommonFunctions.click(locator));
		
		
		}
			
			public void clickBook(){
				
				getObjCommonFunctions.checkElementDisplayed(btnBook);
				objTestBase.logReporter("click book button", getObjCommonFunctions.click(btnBook));
				getObjCommonFunctions.waitFor(20);
			}
			
			
			public void clickContinueBooking(){
				
				getObjCommonFunctions.checkElementDisplayed(btnContinueBooking);
				getObjCommonFunctions.scrollToView(btnContinueBooking);
				objTestBase.logReporter("click book button", getObjCommonFunctions.click(btnContinueBooking));
				getObjCommonFunctions.waitFor(20);
			}
			
			By btnContinue=By.xpath("//input[@id='LoginContinueBtn_1']");
			public void clickContinue(){
				
				getObjCommonFunctions.checkElementDisplayed(btnContinue);
				getObjCommonFunctions.scrollToView(btnContinue);
				objTestBase.logReporter("click continue", getObjCommonFunctions.click(btnContinue));
				getObjCommonFunctions.waitFor(20);
			}
			
			By btnMakePayment=By.xpath("//input[@id='paymentSubmit']");
			
			public void clickMakePayment(){
				
				getObjCommonFunctions.checkElementDisplayed(btnMakePayment);
				getObjCommonFunctions.scrollToView(btnMakePayment);
				objTestBase.logReporter("click continue", getObjCommonFunctions.click(btnMakePayment));
				getObjCommonFunctions.waitFor(20);
			}
			
			
			
			public void clickContinueOnNamePage(){
				
				getObjCommonFunctions.checkElementDisplayed(btnContinueBtn);
				getObjCommonFunctions.scrollToView(btnContinueBtn);
				objTestBase.logReporter("click continue", getObjCommonFunctions.click(btnContinueBtn));
				getObjCommonFunctions.waitFor(20);
			}
			
			public void checkPolicyCheckBox(){
				By locator=By.xpath("//input[@id='insurance_confirm']");
				getObjCommonFunctions.checkElementDisplayed(locator);
				getObjCommonFunctions.checkElementEnabled(locator);
				getObjCommonFunctions.scrollToView(locator);
				objTestBase.logReporter("Accept policy checkbox ", getObjCommonFunctions.click(locator));
				
			}
			
			By inpEmailID=By.xpath("//input[@id='username']");
			public void setEmailID(String strEmail){
				
				objTestBase.logReporter("Set Email Id ",strEmail, getObjCommonFunctions.setText(inpEmailID, strEmail));
			}
			
			public void selectAdultTitle(String strAdultText,String strDrpOption){
				
				By locator=By.xpath("//label[text()='"+strAdultText+"']/parent::dt/following-sibling::dd//select[1]");
				
				getObjCommonFunctions.checkElementDisplayed(locator);
				objTestBase.logReporter("Set Name Title - ",strDrpOption, getObjCommonFunctions.selectDropDownOption(locator,strDrpOption));
			}
			
			public void setFirstAndLastName(String strAdult_1,String strFnameId,String strSetFname){
				
				By locator=By.xpath("//label[text()='"+strAdult_1+"']/parent::dt/following-sibling::dd//input[contains(@id,'"+strFnameId+"')]");
				getObjCommonFunctions.checkElementDisplayed(locator);
				objTestBase.logReporter("Set Passenger First Name - ", strSetFname, getObjCommonFunctions.setText(locator, strSetFname));
		
			}
			
			public void setMobileNumber(String strMobileNo){
				
				By locator=By.xpath("//input[@id='mobileNumber'][@data-name='mobileNumber']");
				getObjCommonFunctions.checkElementDisplayed(locator);
				objTestBase.logReporter("Set Mobile Number - ", strMobileNo, getObjCommonFunctions.setText(locator, strMobileNo));
				
			}
			
			
			public void selectPaymentType(String strPaymentType){
				
				By locator=By.xpath("//nav[@id='paymentTypes']/ul/li/a[text()='"+strPaymentType+"']");
				getObjCommonFunctions.checkElementDisplayed(locator);
				objTestBase.logReporter("select payment type ", strPaymentType, getObjCommonFunctions.click(locator));
			
			}
			
			public void selectBankCard(String strCardId){
				
				By locator=By.xpath("//nav[@id='popularBanks']/ul/li/label/input[@id='"+strCardId+"']");
				getObjCommonFunctions.checkElementDisplayed(locator);
				objTestBase.logReporter("select payment type ", strCardId, getObjCommonFunctions.click(locator));
				
			}
			

		
}
