package com.qaprosoft.demo.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qaprosoft.demo.EbayPage;

public class EbayTest
{
	private static final String ITEM = "Electric Guitar";

	private WebDriver driver;

	@BeforeTest
	public void setup()
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void testEbayItemSearch()
	{
		EbayPage ebayPage = PageFactory.initElements(driver, EbayPage.class);
		ebayPage.open(driver);
		ebayPage.searchItem(ITEM);
		System.out.printf("Price of %s is %s\n", ITEM, ebayPage.getItemPriceByIndex(0));
	}

	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
