package tests.parsers;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumActions {
	public static WebElement element;
	
	public static void doAction(List<String> values, WebDriver driver) throws InterruptedException {
		String path = values.get(0);
		String method = values.get(1);
		String action = values.get(2);
		
		if (action.equalsIgnoreCase("click")) {
			SeleniumFunctions.select(path, method, driver);
		}else if(action.equalsIgnoreCase("selectAndWait")) {
			SeleniumFunctions.selectAndWait(path, method, driver);
		}else if (action.equalsIgnoreCase("selectByVisibleText")) {
			SeleniumFunctions.selectByVisibleText(path, element);
		}else if (action.isEmpty()) {
			element = SeleniumFunctions.getWebElement(path, method, driver);
		}else if (action.equalsIgnoreCase("sendKeys")) {
			String data = values.get(3);
			SeleniumFunctions.sendkeys(path, method, action, data, driver);
		}
	}
}
