package com.Amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Amazon.Utilities.ElementHelper;

public class CartConfirmationPage {

	private final WebDriver driver;
	private final ElementHelper elementHelper;

	private final By cartItem = By.xpath("//span[@class='a-truncate-cut span.a-truncate-full']");

	public CartConfirmationPage(WebDriver driver) {
		this.driver = driver;
		this.elementHelper = new ElementHelper(driver);
	}

	public boolean isProductInCart(String productName) {
		String cartItemText = elementHelper.getText(cartItem);
		return cartItemText.toLowerCase().contains(productName.toLowerCase());
	}
}
