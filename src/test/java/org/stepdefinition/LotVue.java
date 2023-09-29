package org.stepdefinition;

import org.utility.CommonUtility;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.pageObjects.LoginPage;
import org.pageObjects.OperationsPage;

public class LotVue extends CommonUtility {
	LoginPage login;
	OperationsPage page;

	@Given("Enter url of the website {string}")
	public void enter_url_of_the_website(String url) {
		openUrl(url);

	}

	@Then("I should see {string} page with all the details")
	public void i_should_see_page_with_all_the_details(String msg) {
		assertTrue("Verify Url", getCurrentUrl().contains("abrazohomes"));
		login = new LoginPage();
		assertTrue(login.LoginPageDetails(msg));

	}

	@When("I click on the Login button without entering the login credentials")
	public void i_click_on_the_login_button_without_entering_the_login_credentials() {
		login.loginWithoutData();
	}

	@Then("I should see user validation text messages")
	public void i_should_see_user_validation_text_messages() {
		assertTrue("Verify error message", login.verifyErrorMessage());
	}

	@When("I enter the uname {string} and password {string}")
	public void i_enter_the_uname_and_password(String user, String pass) {
		login.loginWithCredentials(user, pass);

	}

	@Then("based on the entered login details it should show Error Message or Username")
	public void based_on_the_entered_login_details_it_should_show_error_message_or_username() {
		assertTrue("Verify Userprofile page", login.verifyUserProfile());
	}

	@When("After login click on the operations dropdown list")
	public void after_login_click_on_the_operations_dropdown_list() {
		page = new OperationsPage();
		page.clickOperationType();

	}

	@Then("I should be able to see the list of product type options")
	public void i_should_be_able_to_see_the_list_of_product_type_options() {
		page.listOutTheProductTypes();
	}

	@Then("Select the {string} product type from the list")
	public void select_the_product_type_from_the_list(String productType) {
		page.selectMarketingOption(productType);
	}

	@When("I click on the manage settings icon")
	public void i_click_on_the_manage_settings_icon() {
		page.clickManageIcon();

	}

	@Then("I should able to see the list of settings options")
	public void i_should_able_to_see_the_list_of_settings_options() {
		page.listOutTheSettingsOptions();
	}

	@When("I selects {string} setting option from the list")
	public void i_selects_setting_option_from_the_list(String filterType) {
		page.selectWebsiteFilter(filterType);
	}

	@Then("I should be able to see {string} page with all the information")
	public void i_should_be_able_to_see_page_with_all_the_information(String type) {
		assertTrue("Verify The filter Page Information", page.verifyFilterPage(type));
		page.listoutFilterInformation();
	}

	@When("I click on the {string} accordion")
	public void i_click_on_the_accordion(String accordingType) {
		page.selectAccordingType(accordingType);
	}

	@Then("I should be able to see all the communities in {string}")
	public void i_should_be_able_to_see_all_the_communities_in(String string) {
		page.listOutAllcommunities();
	}

	@Then("Click on the {string} specific Sales Statuses drop-downs, and from the statuses drop-down list, click on the {string} checkbox")
	public void click_on_the_specific_sales_statuses_drop_downs_and_from_the_statuses_drop_down_list_click_on_the_checkbox(
			String communitytype, String status) {
		page.selectCommunity(communitytype, status);
	}

	@Then("Save the details")
	public void save_the_details() {
		page.clickSaveButton();
	}

}
