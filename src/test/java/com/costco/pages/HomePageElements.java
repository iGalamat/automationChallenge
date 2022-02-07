package com.costco.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.costco.testbase.BaseClass;

public class HomePageElements extends BaseClass {
	@FindBy(id = "search-field")
	public WebElement searchField;

	public HomePageElements() {
		PageFactory.initElements(driver, this);
	}
}
