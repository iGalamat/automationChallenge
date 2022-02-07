package com.costco.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.costco.utils.CommonMethods;
import com.costco.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCardWorkflowStepDefinitions extends CommonMethods {

	@Given("Verify landed on the right url and page loaded successfully")
	public void verify_landed_on_the_right_url_and_page_loaded_successfully() {
		Assert.assertEquals(driver.getTitle(), ConfigsReader.getPropValue("title"));
		Assert.assertEquals(driver.getCurrentUrl(), ConfigsReader.getPropValue("applicationUrl"));

	}

	@When("Search for any product name {string} that would display more than once page of results")
	public void search_for_any_product_name_that_would_display_more_than_once_page_of_results(String productName) {
		sendText(homePageElements.searchField, productName);
		homePageElements.searchField.sendKeys(Keys.ENTER);
	}

	@Then("Check the search results in all pages ensuring every product item has the product name {string} in its title")
	public void check_the_search_results_in_all_pages_ensuring_every_product_item_has_the_product_name_in_its_title(String productName) {
		int j = 0;
		while (j < 3) {
			for (int i = 0; i < sResults.searchResults.size(); i++) {
				String formattedXpath = String.format("//a[contains(@automation-id, 'productDescriptionLink_%d')]", i);
				WebElement element = driver.findElement(By.xpath(formattedXpath));
				Assert.assertTrue(element.getText().toLowerCase().contains(productName));
			}
			jsClick(sResults.nextButtonArrow);
			j++;
		}
	}

	@Then("Add the last of found items to Cart")
	public void add_the_last_of_found_items_to_Cart() {
		jsClick(sResults.lastElement);
		jsClick(addToCart.addToCart);
	}

	@Then("Open cart and increase quantity to {int} and verify the total price for the items is accurate")
	public void open_cart_and_increase_quantity_to(Integer quantity) throws InterruptedException {
		waitForClickability(addToCart.viewCart);
		jsClick(addToCart.viewCart);
		//Getting price for single item and converting it to integer
		int priceForSingleItem=Integer.parseInt(shCart.totalPrice.getText());
		waitForClickability(shCart.quantityForm);
		shCart.quantityForm.clear();
		String quantityConvertedToString=String.valueOf(quantity);
		waitForClickability(shCart.quantityForm);
		shCart.quantityForm.sendKeys(quantityConvertedToString);
		waitForClickability(shCart.quantityForm);
		shCart.quantityForm.sendKeys(Keys.ENTER);
		
		//Getting total price after changing quantity to 5
		int totalPriceForAll=Integer.parseInt(shCart.totalPrice.getText());
		//Verify the total price for the items is accurate
		Assert.assertEquals(priceForSingleItem,totalPriceForAll/5);
	}
}
