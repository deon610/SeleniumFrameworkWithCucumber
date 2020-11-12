package com.qa.base;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utility.PropertyUtility;

public class BaseTest
{
	public static WebDriver driver;
	public static String url;
	public static String user;
	public static String pass;
	
	
	public static WebDriver initialization(){
		String browserName = PropertyUtility.getProperty("browser");
		String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
		
		if(browserName.equals("Chrome")){
			String chromeDriverPath = currentPath + "\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FireFox")){
			String fireFoxPath = currentPath + "\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", fireFoxPath);	
			driver = new FirefoxDriver(); 
		}	
		url = PropertyUtility.getProperty("URL");
		user = PropertyUtility.getProperty("username");
		pass = PropertyUtility.getProperty("password");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	

}
