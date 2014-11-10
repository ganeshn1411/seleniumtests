package tests.parsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumFunctions {
	public static void selectAndWait(String path, String method, WebDriver driver) throws InterruptedException {
		select(path, method, driver);
		Thread.sleep(10000);
	}
	
	public static void select(String path, String method, WebDriver driver) {
		By by = getByObject(method, path);
		driver.findElement(by).click();
	}

	private static By getByObject(String method, String path) {
		if (method.equalsIgnoreCase("id")) {
			return By.id(path);
		}else if (method.equalsIgnoreCase("name")) {
			return By.name(path);
		}else if (method.equalsIgnoreCase("linkText")) {
			return By.linkText(path);
		}
		return null;
	}
}
