package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(name = "uid")
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(name = "btnLogin")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void setUserID(String userID) {
		username.sendKeys(userID);
	}
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickLogin() {
		loginButton.click();
	}
}