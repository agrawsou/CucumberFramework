package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver(String browser) {
		System.out.println("Browser value is : " + browser);
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\10701116\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			tlDriver.set(new FirefoxDriver());
		} else {
			System.out.println("Please pass the correct browser name");
		}
		
		driver = getDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
