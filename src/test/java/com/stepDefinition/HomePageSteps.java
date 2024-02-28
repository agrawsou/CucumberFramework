package com.stepDefinition;

import java.util.List;
import java.util.Map;

import com.factory.DriverFactory;
import com.pages.HomePage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class HomePageSteps {
	
	private LoginPage login = new LoginPage(DriverFactory.getDriver());
	private HomePage home = new HomePage(DriverFactory.getDriver());
	private String title;
	
	@Given("user has already logged in to the application")
	public void user_has_already_logged_in_to_the_application(DataTable dataTable) {
		List<Map<String,String>> credList = dataTable.asMaps(String.class,String.class);
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
		login.enterUserName(userName);
		login.enterPassword(password);
		login.clickLogin();
		
	}

	@Given("user is on homepage")
	public void user_is_on_homepage() {
	   System.out.println("User is on homepage");
	}
	
	@When("user gets the title of the home page")
	public void user_gets_the_title_of_the_home_page() {
		title = home.getTitle();
	}
	
	@Then("the home title should be {string}")
	public void the_home_title_should_be(String expectedTitle) {
		Assert.assertEquals(title, expectedTitle);
	}

	@Then("user gets links names")
	public void user_gets_links_names(DataTable dataTable) {
		List<String> expectedHomePageList = dataTable.asList();
		System.out.println("Expected home page headers list : " + expectedHomePageList);
		List<String> actualHomePageList = home.getListNames();
		System.out.println("Actual home page headers list : " + actualHomePageList);
		Assert.assertTrue(expectedHomePageList.containsAll(actualHomePageList));
	}

	@Then("the links count should be {int}")
	public void the_links_count_should_be(int actualListCount) {
	   Assert.assertEquals(home.getListCount(), actualListCount);
	}

}
