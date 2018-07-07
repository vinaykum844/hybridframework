package com.automation.pageobject.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private final static Logger log = Logger.getLogger(HomePage.class.getName());

	WebDriver driver;

	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signin;

	@FindBy(xpath = "//*[@id='email']")
	WebElement loginEmailAddress;

	@FindBy(xpath = "//*[@id='passwd']")
	WebElement password;

	@FindBy(xpath = "//*[@id='SubmitLogin']")
	WebElement submitButton;

	@FindBy(xpath = "//*[@id='center_column']/div[1]/ol/li")
	WebElement authenticationMessage;

	@FindBy(xpath = "//*[@id='SubmitCreate']")
	WebElement createbutton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String email, String pass) {
		log.info("clicking on signin");
		signin.click();
		log.info("entering email");
		loginEmailAddress.sendKeys(email);
		log.info("entering password");
		password.sendKeys(pass);
		log.info("clicking on submit");
		submitButton.click();
	}

	public String authMessage() {
		return authenticationMessage.getText();
	}

	public boolean isDisplayed() {
		if (createbutton.isDisplayed())
			return true;
		else
			return false;
	}

	public void clickElement() {
		signin.click();

	}
}
