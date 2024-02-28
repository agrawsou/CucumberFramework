package com.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private String title;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get(
				"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is : " + title);

	}

	@Then("the title should be {string}")
	public void the_title_should_be(String expectedtitle) {
		Assert.assertEquals(title, expectedtitle);

	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotpwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String userName) {
		loginPage.enterUserName(userName);
	}

	@When("enters password {string}")
	public void enters_password(String pass) {
		loginPage.enterPassword(pass);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickLogin();
	}

}
