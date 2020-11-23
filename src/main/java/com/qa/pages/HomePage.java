package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BaseTest;

public class HomePage extends BaseTest
{

	@FindBy(xpath = "(//div[@class='inventory_item'])[1]//button[text()='ADD TO CART']")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//button[text()='Open Menu']")
	WebElement openMenuBtn;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutBtn;

	public WebDriverWait wait;
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 5);
	}
	
	public void addProductToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
		addToCartBtn.click();
	}
	
	public String verifyTitle(String title) {
		return driver.getTitle();
	}
	
	public void logout() {
		openMenuBtn.click();
		wait.until(ExpectedConditions.visibilityOf(logoutBtn));
		wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
		logoutBtn.click();
	}
}
