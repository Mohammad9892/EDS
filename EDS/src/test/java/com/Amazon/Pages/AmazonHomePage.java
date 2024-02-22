package com.Amazon.Pages;

import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Amazon.Utilities.ElementHelper;

public class AmazonHomePage {

	private final WebDriver driver;
	private final ElementHelper elementHelper;

	private final By searchBox = By.id("twotabsearchtextbox");
	private final By searchButton = By.id("nav-search-submit-button");

	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		this.elementHelper = new ElementHelper(driver);
	}

	public void searchProduct(String productName) {
		elementHelper.sendKey(searchBox, productName);
		elementHelper.click(searchButton);
		Assert.assertTrue(driver.getTitle().contains(productName),
				"Search page title does not contain search query: " + productName);
	}

	public void searchProduct(List<String> productNames) {
		for (String productName : productNames) {
			searchProduct(productName);
		}
	}
}
