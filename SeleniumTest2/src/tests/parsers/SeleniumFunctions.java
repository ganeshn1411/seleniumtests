package tests.parsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumFunctions {
	public static void selectAndWait(String path, String method, WebDriver driver) throws InterruptedException {
		select(path, method, driver);
		Thread.sleep(10000);
	}
	
	public static void select(String path, String method, WebDriver driver) {
		By by = getByObject(method, path);
		driver.findElement(by).click();
	}

	public static By getByObject(String method, String path) {
		if (method.equalsIgnoreCase("id")) {
			return By.id(path);
		}else if (method.equalsIgnoreCase("name")) {
			return By.name(path);
		}else if (method.equalsIgnoreCase("linkText")) {
			return By.linkText(path);
		}else if (method.equalsIgnoreCase("xpath")) {
			return By.xpath(path);
		}else if (method.equalsIgnoreCase("cssSelector")) {
			return By.cssSelector(path);
		}
		return null;
	}

	public static void selectByVisibleText(String path, String method, String text, WebDriver driver) {
		WebElement element = getWebElement(path, method, driver);
		new Select(element).selectByVisibleText(text);
		
	}

	public static WebElement getWebElement(String path, String method, WebDriver driver) {
		By by = getByObject(method, path);
		return driver.findElement(by);
	}

	public static void sendkeys(String path, String method, String action, String data, WebDriver driver) {
		By by = getByObject(method, path);
		driver.findElement(by).sendKeys(data);
	}
}