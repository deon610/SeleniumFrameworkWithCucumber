package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest
{
	public static WebDriver driver;
	public static Properties prop;
	public static String url;
	public static String user;
	public static String pass;
	
	public BaseTest(){
		try {
			prop = new Properties();
			String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
			String propertiesPath = currentPath + "\\src\\main\\resources\\config.properties";
			FileInputStream fis = new FileInputStream(propertiesPath);
			prop.load(fis);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver initialization(){
		String browserName = prop.getProperty("browser");
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
		url = prop.getProperty("URL");
		user = prop.getProperty("username");
		pass = prop.getProperty("password");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	

}
