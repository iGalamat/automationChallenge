package com.costco.stepDefinitions;

import com.costco.testbase.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public void startTest() {
		BaseClass.setUp();
	}

	@After
	public static void endTest(Scenario scenario) {
		BaseClass.tearDown();
	}
}
