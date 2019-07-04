package com.genericFunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.genericFunction.DataBean.SynchronizationHandle;

public class CommonFunctions extends LoadableComponent<CommonFunctions> implements SynchronizationHandle {

	private TestBase objTestBase;
	
	public CommonFunctions(TestBase testBase) {

		this.objTestBase=testBase;

	}
	
	
	public void waitForElementPresence(By locator) throws NotFoundException{
		
		WebDriverWait getWebDriverWait=new WebDriverWait(objTestBase.getDriver(), midwait);
		getWebDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	public void waitForElementVisibilityLocated(By locator) throws NotFoundException{
		
		WebDriverWait getWebDriverWait= new WebDriverWait(objTestBase.getDriver(), midwait);
		getWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public void waitForElementClickable(By locator) throws NotFoundException {
		
		WebDriverWait getWebDriverWait= new WebDriverWait(objTestBase.getDriver(), midwait);
		getWebDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
	
	}
	
	public boolean waitFor(int timeUnitInSecond){
		
		try {
			
			Thread.sleep(TimeUnit.MILLISECONDS.convert(timeUnitInSecond, TimeUnit.SECONDS));
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public boolean click(By locator){
		
		try {
			
			this.waitForElementClickable(locator);
			WebElement element=objTestBase.getDriver().findElement(locator);
			element.click();
			return true;
			
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean setText(By locator,String fieldValue){
		try {
			
			this.waitForElementPresence(locator);
			this.waitForElementVisibilityLocated(locator);
			WebElement element=objTestBase.getDriver().findElement(locator);
			element.clear();
			element.sendKeys(fieldValue);
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean checkElemetDisplayed(By locator){
		
		try {
			
			this.waitForElementPresence(locator);
			return objTestBase.getDriver().findElement(locator).isDisplayed();
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean selectDropdownValue(By locator,String drpOption){
		
		try {
			
			this.checkElemetDisplayed(locator);
			WebElement element = objTestBase.getDriver().findElement(locator);
			Select select=new Select(element);
			select.selectByVisibleText(drpOption);
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		
		}
	}
	
	
	
	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

}
