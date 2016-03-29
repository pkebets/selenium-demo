package com.qaprosoft.demo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EbayPage
{
	@FindBy(id = "gh-ac")
	private WebElement searchInput;

	@FindBy(id = "gh-btn")
	private WebElement searchButton;

	@FindBy(xpath = "//ul[@id='ListViewInner']//h3/a")
	private List<WebElement> itemLinks;

	@FindBy(id = "prcIsum")
	private WebElement priceLabel;
	
	public void open(WebDriver driver)
	{
		driver.get("http://www.ebay.com");
	}

	public void searchItem(String itemName)
	{
		searchInput.sendKeys(itemName);
		searchButton.click();

	}

	public String getItemPriceByIndex(int itemIndex)
	{
		itemLinks.get(itemIndex).click();
		return priceLabel.getText();
	};
}
