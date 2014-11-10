package tests.parsers;

import org.openqa.selenium.WebDriver;

public class SeleniumActions {
	public static void doAction(String path, String method, String action, WebDriver driver) {
		if (action.equalsIgnoreCase("click")) {
			SeleniumFunctions.select(path, method, driver);
		}
	}
}
