package com.costco.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.costco.testbase.BaseClass;

public class AddToCardPageElements extends BaseClass {

	@FindBy(id = "add-to-cart-btn")
	public WebElement addToCart;

	@FindBy(xpath = "//*[@automation-id=\"viewCartButton\"]")
	public WebElement viewCart;

	public AddToCardPageElements() {
		PageFactory.initElements(driver, this);
	}

}
