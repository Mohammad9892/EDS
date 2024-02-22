package com.Amazon.Test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Amazon.Pages.AmazonHomePage;
import com.Amazon.Pages.CartConfirmationPage;
import com.Amazon.Pages.CartPage;
import com.Amazon.Pages.ProductSearchPage;
import com.Amazon.Utilities.BaseTest;
import com.Amazon.Utilities.JsonDataReader;

public class AmazonTest extends BaseTest {

	@Test
	public void searchAndAddToCartTest() {
		logger = report.createTest("Amazon India Product Search and Add to Cart Test");

		AmazonHomePage homePage = new AmazonHomePage(driver);
		ProductSearchPage searchPage = new ProductSearchPage(driver);
		CartConfirmationPage cartConfirmationPage = new CartConfirmationPage(driver);
		CartPage cartPage = new CartPage(driver);

		List<String> searchQueries = JsonDataReader.getProductSearchQueries("testData.json");

		Assert.assertFalse(searchQueries.isEmpty(), "No search queries found in the test data.");

		for (String searchQuery : searchQueries) {

			homePage.searchProduct(searchQuery);
			Assert.assertTrue(driver.getTitle().contains(searchQuery),
					"Search page title does not contain search query: " + searchQuery);

			searchPage.selectProduct(0);
			cartPage.addToCart();
			Assert.assertTrue(driver.getTitle().contains("Added to Cart"), "Product not successfully added to cart.");

			cartPage.goToCart();
			Assert.assertTrue(driver.getTitle().contains("Shopping Cart"), "Could not navigate to shopping cart.");

			boolean isProductInCart = cartConfirmationPage.isProductInCart(searchQuery);
			Assert.assertTrue(isProductInCart, "Product '" + searchQuery + "' not found in the cart");

			driver.navigate().back();
		}

		logger.info("Test completed successfully.");
	}
}
