package org.stepdefinition;

import org.utility.CommonUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonUtility {

	@Before
	public void setup() {
		openBrowser(getPropertyValue("browsername"));
		driver.manage().deleteAllCookies();
	}

	@After
	public void tearDown(Scenario sc) {
		takeScreenShot(sc.getName());
		closeBrowser();

	}
}
