package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// Locators
	private By emailId = By.id("email");
	private By password = By.id("pass");
	private By signInButton = By.id("send2");
	private By forgotPwdLink = By.xpath("//span[text()='Forgot Your Password?111']");

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// pageActions

	public String getLoginPageTitle() {
		return driver.getTitle();

	}

	public boolean isForgotpwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String userName) {
		driver.findElement(emailId).sendKeys(userName);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLogin() {
		driver.findElement(signInButton).click();
	}
}
