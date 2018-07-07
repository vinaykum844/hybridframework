package com.automation.pageobject.homepage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pageobject.testbase.TestBase;
import com.automation.pageobject.uiActions.HomePage;

public class VerifyLoginWithIncorrectCredentials extends TestBase {

	HomePage homepage;

	@BeforeClass
	public void setUp() {

		init();
	}

	@Test
	public void verifyLoginWithIncorrectCredentials() {
		homepage = new HomePage(driver);
		homepage.loginToApplication("test@gmail.com", "password123");
		Assert.assertEquals(homepage.authMessage(), "Authentication failed.");
	}

	// @AfterClass
	// public void endTest() {
	// driver.close();
	// }

}
