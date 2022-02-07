package com.costco.testbase;

import com.costco.pages.AddToCardPageElements;
import com.costco.pages.HomePageElements;
import com.costco.pages.SearchResultsPage;
import com.costco.pages.ShoppingCartPageElements;

public class PagesInitializer extends BaseClass {

	protected static HomePageElements homePageElements;
	protected static ShoppingCartPageElements shCart;
	protected static AddToCardPageElements addToCart;
	protected static SearchResultsPage sResults;

	public static void initializePageObjects() {
		homePageElements = new HomePageElements();
		shCart = new ShoppingCartPageElements();
		addToCart = new AddToCardPageElements();
		sResults = new SearchResultsPage();
	}

}
