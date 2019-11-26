package com.qaprosoft.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPage
{
	@FindBy(id = "Email")
	private WebElement emailInput;

	@FindBy(id = "Passwd")
	private WebElement passwordInput;

	@FindBy(id = "next")
	private WebElement nextButton;

	@FindBy(id = "signIn")
	private WebElement signInButton;

	@FindBy(xpath = "//a[contains(@class, 'gb_b') and contains(@title, 'Google Account')]")
	private WebElement userIcon;

	public void open(WebDriver driver)
	{
		driver.get("http://gmail.com");
	}
	
	public void login(String email, String password)
	{
		emailInput.sendKeys(email);
		nextButton.click();
		passwordInput.sendKeys(password);
		signInButton.click();
	}
	
	public boolean isLoggedIn()
	{
		return userIcon.isDisplayed();
	}
}


