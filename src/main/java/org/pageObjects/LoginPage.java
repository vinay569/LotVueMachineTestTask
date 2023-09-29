package org.pageObjects;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.CommonUtility;

public class LoginPage extends CommonUtility {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "tbluser_email")
	WebElement username;

	@FindBy(xpath = "//form[@id='sign_in_check']/h2")
	WebElement login;

	@FindBy(id = "tbluser_password")
	private WebElement password;

	@FindBy(name = "commit")
	private WebElement loginButton;

	@FindBy(xpath = "//span[contains(@for,'tbluser')]")
	private List<WebElement> errormessage;

	@FindBy(xpath = "//li[@id='admin']")
	private WebElement adminIcon;

	@FindBy(xpath = "//li[@id='admin']//span[@class='Pname']")
	private WebElement adminName;

	// ------------------------------//

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public List<WebElement> getErrormessage() {
		return errormessage;
	}

	public WebElement getAdminIcon() {
		return adminIcon;
	}

	public WebElement getAdminName() {
		return adminName;
	}

	public WebElement getLogin() {
		return login;
	}

	// -----------------------//

	public boolean LoginPageDetails(String msg) {
		String m = getText(getLogin());
		System.out.println(m);
		return m.contains(msg);

	}

	public void loginWithoutData() {
		click(getLoginButton());
	}

	public void loginWithCredentials(String user, String pass) {
		sendKeys(getUsername(), user);
		sendKeys(getPassword(), pass);
		click(getLoginButton());
	}

	public boolean verifyUserProfile() {

		click(getAdminIcon());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String name = getText(getAdminName());
		if (name.equals(getPropertyValue("profilename"))) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyErrorMessage() {
		String usernameMsg = "Enter Your Email";
		String passwordMsg = "Enter Your Password";
		List<String> expected = new LinkedList<String>();
		expected.add(usernameMsg);
		expected.add(passwordMsg);

		List<WebElement> errorMsg = getErrormessage();
		List<String> actual = new LinkedList<String>();
		for (int i = 0; i < errorMsg.size(); i++) {
			actual.add(getText(errorMsg.get(i)));

		}
		System.out.println(actual);
		if (expected.equals(actual)) {
			return true;
		} else {
			return false;
		}

	}
}
