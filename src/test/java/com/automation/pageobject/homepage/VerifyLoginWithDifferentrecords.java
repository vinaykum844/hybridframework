package com.automation.pageobject.homepage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pageobject.testbase.TestBase;
import com.automation.pageobject.uiActions.HomePage;

public class VerifyLoginWithDifferentrecords extends TestBase {
	HomePage homepage;

	@DataProvider(name = "logindata")
	public String[][] getTestData() {
		String[][] data = getData("TestData", "testdata");
		return data;

	}

	@BeforeClass
	public void setUp() {

		init();
	}

	@Test(dataProvider = "logindata")
	public void testLogin(String email, String password, String runMode) {
		if (runMode.equalsIgnoreCase("n"))
			System.out.println("this is marked for no run");
		else {
			homepage = new HomePage(driver);
			homepage.loginToApplication(email, password);
			getScreenShot("logindata" + email + "_");
			Assert.assertEquals(homepage.authMessage(), "Authentication failed.");
		}
	}

	@AfterClass
	public void endTest() {
		driver.close();
	}

}
