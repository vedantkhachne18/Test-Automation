
package com.neova;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neova.TestDataBean.SynchronizationHandle;

public class CommonFunctions extends LoadableComponent<CommonFunctions> implements SynchronizationHandle {

	// Global variables
	private TestBase objTestBase;

	public CommonFunctions(TestBase testBase) {
		this.objTestBase = testBase;

	}

	public void waitForElementPresence(By locator) throws NotFoundException {
		WebDriverWait getWebDriverWait = new WebDriverWait(objTestBase.getDriver(), midwait);
		getWebDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	
	public void waitForElementToBeClickable(By locator) throws NotFoundException {
		WebDriverWait getWebDriverWait = new WebDriverWait(objTestBase.getDriver(), midwait);
		getWebDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitForElementVisibilityLocated(By locator) throws NotFoundException {
		WebDriverWait getWebDriverWait = new WebDriverWait(objTestBase.getDriver(), midwait);
		getWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForElementVisibility(WebElement webElement) throws NotFoundException {
		WebDriverWait getWebDriverWait = new WebDriverWait(objTestBase.getDriver(), midwait);
		getWebDriverWait.until(ExpectedConditions.visibilityOf(webElement));
	}

	
	public boolean waitFor(int timeUnitSeconds) {
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(timeUnitSeconds, TimeUnit.SECONDS));
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public boolean click(By locator) {
		try {
			waitForElementToBeClickable(locator);
			WebElement weElement = objTestBase.getDriver().findElement(locator);
			weElement.click();
			return true;
		} catch (Exception exception) {
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

	public boolean setText(By locator, String fieldValue) {
		try {
			waitForElementPresence(locator);
			waitForElementVisibilityLocated(locator);
			WebElement webElement = objTestBase.getDriver().findElement(locator);
			clearText(webElement);
			webElement.sendKeys(fieldValue);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public void clearText(WebElement webElement) {
		webElement.clear();
	}

	public boolean selectRadioButton(By locator, boolean status) {
		try {
			waitForElementPresence(locator);
			WebElement webElement = objTestBase.getDriver().findElement(locator);
			if (webElement.getAttribute("type").equals("radio")) {
				if ((webElement.isSelected() && !status) || (!webElement.isSelected() && status))
					webElement.click();
				return true;
			} else
				return false;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public boolean checkElementDisplayed(By locator) {
		try {
			return objTestBase.getDriver().findElement(locator).isDisplayed();
		} catch (Exception exception) {
			return false;
		}
	}

	public boolean scrollToView(By locator) {
		try {
			waitForElementPresence(locator);
			WebElement webElement = objTestBase.getDriver().findElement(locator);
			((JavascriptExecutor) objTestBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					webElement);
			return true;
		} catch (Exception exception) {
			return false;
		}
	}

	public boolean selectCheckBox(By locator, boolean status) {
		try {
			WebElement webElement = objTestBase.getDriver().findElement(locator);
			if (webElement.getAttribute("type").equals("checkbox")) {
				if ((webElement.isSelected() && !status) || (!webElement.isSelected() && status))
					webElement.click();
				return true;
			} else
				return false;
		} catch (Exception exception) {
			return false;
		}
	}

	public boolean checkElementEnabled(By locator) {
		try {
			return objTestBase.getDriver().findElement(locator).isEnabled();
		} catch (Exception exception) {
			return false;
		}
	}

	public boolean selectDropDownOption(By locator, String option) {
		try {
			WebElement webElement = objTestBase.getDriver().findElement(locator);
			waitForElementVisibility(webElement);
			Select sltDropDown = new Select(webElement);
			sltDropDown.selectByVisibleText(option);
			return true;
			
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

}