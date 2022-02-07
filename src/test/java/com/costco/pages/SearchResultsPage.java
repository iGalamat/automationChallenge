package com.costco.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.costco.testbase.BaseClass;

public class SearchResultsPage extends BaseClass {

	@FindBy(xpath = "//a[contains(@automation-id, 'productDescriptionLink_')]")
	public List<WebElement> searchResults;
	
	@FindBy(xpath = "//*[@automation-id='nextPageNavigationLink']")
	public WebElement nextButtonArrow;
	
	@FindBy(xpath = "//*[@automation-id=\"subCategoryLabel_75 in & Above TVs\"]")
	public WebElement subCategory75;
	
	@FindBy(xpath = "//*[@automation-id=\"productDescriptionLabel_23\"]")
	public WebElement lastElement;
	
	public SearchResultsPage() {
		PageFactory.initElements(driver, this);
	}

}
