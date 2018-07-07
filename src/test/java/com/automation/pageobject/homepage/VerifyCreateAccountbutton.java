package com.automation.pageobject.homepage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pageobject.testbase.TestBase;
import com.automation.pageobject.uiActions.HomePage;

public class VerifyCreateAccountbutton extends TestBase {

	HomePage homepage;
	WebElement createAccount;

	@BeforeClass
	public void setUp() {

		init();
	}

	@Test
	public void VerifyCreateAccountbutton() {
		homepage = new HomePage(driver);
		homepage.clickElement();
		boolean w = homepage.isDisplayed();
		Assert.assertEquals(w, true);
	}

	@AfterClass
	public void endTest() {
		driver.close();
	}
}
