package tests.parsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumFunctions {
	void selectAndWait(String path, String method, WebDriver driver) throws InterruptedException {
		select(path, method, driver);
		Thread.sleep(10000);
	}
	
	void select(String path, String method, WebDriver driver) {
		By by = getByObject(method, path);
		driver.findElement(by).click();
	}

	private By getByObject(String method, String path) {
		if(method.equalsIgnoreCase("id")) {
			return By.id(path);
		}
		return null;
	}
}
