package com.Amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Amazon.Utilities.ElementHelper;

public class CartPage {

	private final WebDriver driver;
	private final ElementHelper elementHelper;

	private final By cartButton = By.name("submit.add-to-cart");
	private final By cartIcon = By.id("nav-cart");

	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.elementHelper = new ElementHelper(driver);
	}

	public void addToCart() {
        WebElement addToCartButton = driver.findElement(cartButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
        elementHelper.click(cartButton);
        Assert.assertTrue(driver.getTitle().contains("Added to Cart"),
                "Product not successfully added to cart.");
    }

    public void goToCart() {
        elementHelper.click(cartIcon);
        Assert.assertTrue(driver.getTitle().contains("Shopping Cart"),
                "Could not navigate to shopping cart.");
    }
}
