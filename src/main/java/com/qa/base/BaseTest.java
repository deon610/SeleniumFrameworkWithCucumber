package com.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import com.qa.utility.DriverFactoryUtility;

public class BaseTest
{
	public static WebDriver driver;
	public static String url;
	public static String user;
	public static String pass;
	
	
	public WebDriver initialization(){
		DriverFactoryUtility driverFactory = new DriverFactoryUtility();
		driver=driverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	

}
