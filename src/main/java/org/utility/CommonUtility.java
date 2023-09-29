package org.utility;

import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility {
	public static WebDriver driver;

	public static void openBrowser(String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid Browser");
			throw new WebDriverException();
		}

	}

	public static void openUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	public static void sendKeys(WebElement e, String va) {
		try {
			e.sendKeys(va);
		} catch (Exception ex) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value','" + va + ")", e);
			ex.printStackTrace();
		}
	}

	public static void sendKeys(WebElement e, String va, Keys k) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.visibilityOf(e));
		try {
			e.sendKeys(va, k);
		} catch (Exception ex) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value','" + va + ")", e);
			ex.printStackTrace();
		}
	}

	public static void switchWindow(int i) {
		String id = driver.getWindowHandle();
		List<String> li = new LinkedList<String>(driver.getWindowHandles());
		driver.switchTo().window(li.get(i));

	}

	public static void click(WebElement e) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.elementToBeClickable(e));
		try {
			e.click();
		} catch (Exception ex) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", e);
			ex.printStackTrace();
		}

	}

	public static void closeBrowser() {
		driver.quit();

	}

	public static String getCurrentUrl() {
		return driver.getCurrentUrl();

	}

	public static String getText(WebElement e) {
		return e.getText();
	}

	public static String getAttribute(WebElement e) {
		return e.getAttribute("value");

	}

	public String getPropertyValue(String key) {
		String value = null;
		try {
			Properties p = new Properties();
			FileReader f = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Config\\config.properties");
			p.load(f);
			value = p.get(key).toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return value;
	}

	public static void takeScreenShot(String image) {
		try {
			TakesScreenshot tk = (TakesScreenshot) driver;
			FileUtils.copyFile(tk.getScreenshotAs(OutputType.FILE), new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Screenshots\\" + image + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
