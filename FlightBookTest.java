package com.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.neova.TestBase;
import com.neova.TestDataBean.HomePageTestData;
import com.pageFactory.HomePage;

public class FlightBookTest extends TestBase implements HomePageTestData{
	
	// Global variables
		TestBase objTestBase = new TestBase();
		HomePage objHomePage=new HomePage(objTestBase);
		

		@AfterClass
		public void tearDownEnvironment() {
		//	objTestBase.terminate();
		}

		@BeforeClass
		public void initilizeEnvironment() {
			objTestBase.initialization();
		}

		@BeforeMethod
		public void redirectToHomePage() {
			
			System.out.println("redirectToMeHomePage !!!!");
		} 

		@Test(priority=1)
		public void TCID_111() {
			objHomePage.commonRadioButtonSelectTripWay(strRBText);
			objHomePage.commonSelectFormAirport(strFlightName);
			objHomePage.commonSelectToAirport(strToFlightName);
			objHomePage.commonPickDepartDateFromDatePicker(intDepartFuturDate, intCurrentMonthDaysFlag);
			objHomePage.commonPickReturnDateFromDatePicker(intReturnFuturDate, intCurrentMonthDaysFlag);
			objHomePage.selectDropdownAdultValue(strAdult);
			objHomePage.clickSearchFlight();
			objHomePage.commonSelectStop(strStop);
			objHomePage.selectRadioIndigoFlightBySeuanceIndex(strIndex);
			objHomePage.selectRadioIndigoFlightBySeuanceIndex_1(strIndex_1);
			objHomePage.clickBook();
			objHomePage.checkPolicyCheckBox();
			objHomePage.clickContinueBooking();
			objHomePage.setEmailID(strEmail);
			objHomePage.clickContinue();
			objHomePage.selectAdultTitle(strAdultTextTitle_1, strTitleMr);
			objHomePage.selectAdultTitle(strAdultTextTitle_2, strTitleMs);
			objHomePage.setFirstAndLastName(strAdult_1, strFnameId, strSetFname);
			objHomePage.setFirstAndLastName(strAdult_1, strAdultLnameId, strSetLName);
			objHomePage.setFirstAndLastName(strAdult_2, strFnameId_2, strSetFname_2);
			objHomePage.setFirstAndLastName(strAdult_2, strAdultLnameId_2, strSetLName_2);
			objHomePage.setMobileNumber(strMobileNo);
			objHomePage.clickContinueOnNamePage();
			objHomePage.selectPaymentType(strPaymentType);
			objHomePage.selectBankCard(strCardId);
			objHomePage.clickMakePayment();
			
		}


	}