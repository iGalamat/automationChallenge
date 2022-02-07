Feature: Add to Card Workflow verification

@smoke123
  Scenario: Add to card Workflow
    Given Verify landed on the right url and page loaded successfully
    When Search for any product name "tv" that would display more than once page of results
		Then Check the search results in all pages ensuring every product item has the product name "tv" in its title
		Then Add the last of found items to Cart
		And Open cart and increase quantity to 5 and verify the total price for the items is accurate

