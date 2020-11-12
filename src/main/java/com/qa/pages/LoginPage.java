package com.qa.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BaseTest;

public class LoginPage extends BaseTest
{
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "login-button")
	WebElement loginBtn;
	
	@FindBy(xpath = "//form//h3")
	WebElement loginError;
	
	private WebDriverWait wait;
	
	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 5);
	}
	
	public void login(String user, String pass) {
		wait.until(ExpectedConditions.elementToBeClickable(username));
		username.sendKeys(user);
		password.sendKeys(pass);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
	}
	
	public void verifyUserCantLogin() {
		assertTrue(loginError.getText().contains("Username and password do not match any user in this service"));
	}
	
}
