package com.Amazon.Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Amazon.Utilities.ElementHelper;

public class ProductSearchPage {

	private final WebDriver driver;
	private final ElementHelper elementHelper;

	private final By productLink = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");

	public ProductSearchPage(WebDriver driver) {
		this.driver = driver;
		this.elementHelper = new ElementHelper(driver);
	}

	 public void selectProduct(int index) {
	        try {
	            Assert.assertTrue(elementHelper.findElements(productLink).size() > index,
	                    "Product link at index " + index + " does not exist");
	            elementHelper.click(productLink, index);
	        } catch (NoSuchElementException e) {
	            System.out.println("Product link not found.");
	            e.printStackTrace();
	        }
	    }

}