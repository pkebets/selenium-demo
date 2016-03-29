package com.qaprosoft.demo.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qaprosoft.demo.GmailPage;

public class GmailTest
{
	private static final String EMAIL = "changeme";
	private static final String PASSWORD = "changeme";
	
	private WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test
	public void testGmailLogin()
	{
		GmailPage gmailPage = PageFactory.initElements(driver, GmailPage.class);
		gmailPage.open(driver);
		gmailPage.login(EMAIL, PASSWORD);
		Assert.assertTrue(gmailPage.isLoggedIn(), "User not logged in!");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
