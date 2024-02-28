package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver driver;

	// Locators
	private By listItems = By.cssSelector(".level-top.ui-corner-all");

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// pageActions
	
	public String getTitle() {
		return driver.getTitle();
	}

	public int getListCount() {
		return driver.findElements(listItems).size();
	}
	
	public List<String> getListNames() {
		
		List<String> homePageListNames = new ArrayList<String>();
		List<WebElement> homePageList = driver.findElements(listItems);
		for(WebElement e : homePageList) {
			homePageListNames.add(e.getText());
		}
		return homePageListNames;
	}
	

}
