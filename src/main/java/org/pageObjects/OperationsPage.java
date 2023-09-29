package org.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.utility.CommonUtility;

public class OperationsPage extends CommonUtility {
	public OperationsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Operations' and @data-toggle='dropdown']")
	private WebElement operationDropDown;

	@FindBy(xpath = "//a[text()='Marketing']")
	private WebElement optionMarketing;

	@FindBy(xpath = "//ul[@class='sub-menu dropdown-menu pull-right']/li/a")
	private List<WebElement> listOfProductTypes;

	@FindBy(xpath = "//li[@class='dropdown settingList']")
	private WebElement manageIcon;

	@FindBy(xpath = "//div[@class='names_align']")
	private WebElement selectedFilterPage;

	@FindBy(xpath = "//ul[@id='scrollbox3']/li/a")
	private List<WebElement> settingsList;

	@FindBy(xpath = "//div[@class='filters-section']/h4")
	private List<WebElement> filterOptions;

	@FindBy(xpath = "//div[@id='collapse_body_inventory_lots_collapse']//following-sibling::label")
	private List<WebElement> allCommunities;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;

	public List<WebElement> getListOfProductTypes() {
		return listOfProductTypes;
	}

	// ---------------------//

	public WebElement getOperationDropDown() {
		return operationDropDown;
	}

	public WebElement getOptionMarketing() {
		return optionMarketing;
	}

	public WebElement getManageIcon() {
		return manageIcon;
	}

	public List<WebElement> getSettingsList() {
		return settingsList;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public List<WebElement> getFilterOptions() {
		return filterOptions;
	}

	public WebElement getSelectedFilterPage() {
		return selectedFilterPage;
	}

	public List<WebElement> getAllCommunities() {
		return allCommunities;
	}

	// -----------------------------------------------------------//
	public void clickOperationType() {
		click(getOperationDropDown());

	}

	public void listOutTheProductTypes() {
		List<WebElement> productTypes = getListOfProductTypes();
		System.out.println("Total Products available In Settings....." + productTypes.size());
		System.out.println("-----List of Product Types-----");
		for (int i = 0; i < productTypes.size(); i++) {
			System.out.println(getText(productTypes.get(i)));
		}

	}

	public void selectMarketingOption(String productType) {
		click(driver.findElement(By.xpath("//a[text()='" + productType + "']")));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickManageIcon() {
		click(getManageIcon());

	}

	public void listOutTheSettingsOptions() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> stt = getSettingsList();
		System.out.println("Total Options available In Settings....." + stt.size());
		System.out.println("----ALl Setting options--------");
		for (WebElement x : stt) {
			System.out.println(getText(x));
		}

	}

	public void selectWebsiteFilter(String filterType) {
		click(driver.findElement(By.xpath("//a[text()='" + filterType + "']")));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public boolean verifyFilterPage(String type) {
		return getText(getSelectedFilterPage()).equals(type);
	}

	public void listoutFilterInformation() {
		System.out.println("----Filter Informations---");
		List<WebElement> ft = getFilterOptions();
		for (WebElement x : ft) {
			System.out.println(getText(x));
		}

	}

	public void selectAccordingType(String accordingType) {

		click(driver.findElement(By.xpath("// span[normalize-space(text()) = '" + accordingType + "']//ancestor::a")));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void listOutAllcommunities() {
		List<WebElement> com = getAllCommunities();
		System.out.println("----All Communities-----");
		for (WebElement x : com) {
			System.out.println(getText(x));
		}

	}

	public void selectCommunity(String communitytype, String status) {
		click(driver.findElement(By.xpath("//select[@name='listing_status[" + communitytype + "][]']//parent::span")));
		WebElement chekbox = driver.findElement(By.xpath(
				"//select[@name='listing_status[Mil Colores][]']//parent::span//following-sibling::li//input[@value='"
						+ status + "']"));
		if(!chekbox.isSelected()) {
		click(chekbox);
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickSaveButton() {
		click(getSaveButton());

	}

}
