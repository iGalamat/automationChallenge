package com.costco.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.costco.testbase.BaseClass;

public class ShoppingCartPageElements extends BaseClass {
	@FindBy(xpath = "//*[@automation-id=\"quantityInput_1\"]")
	public WebElement quantityForm;
	
	@FindBy(id = "order-estimated-total")
	public WebElement totalPrice;

	public ShoppingCartPageElements() {
		PageFactory.initElements(driver, this);
	}
}
