package tests.selenium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import jxl.read.biff.BiffException;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import tests.parsers.ExcelReader;
import tests.parsers.SeleniumActions;

public class EstoreOrder {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  Map<String, List<String>> xlsValues;

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://estore-dev.cisco.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void testEstoreOrder(String service) throws Exception {
	List<String> values;
 	xlsValues = ExcelReader.readWorkBook("bin/tests/excels/credentials.xls", ExcelReader.getSheets("bin/tests/excels/credentials.xls")[0]);
	String userName = xlsValues.get("user").get(0);
	String password = xlsValues.get("password").get(0);
	String[] sheets = ExcelReader.getSheets("bin/tests/excels/"+service+".xls");
	for(String sheetName : sheets){
		xlsValues = ExcelReader.readWorkBook("bin/tests/excels/"+service+".xls", sheetName);
		String estoreService = xlsValues.get("estoreOrder").get(0);
		String handler = xlsValues.get("handlerClass").get(0);
		driver.get(baseUrl+"/RequestCenter/servicecatalog/servicecatalog.do");
		xlsValues = ExcelReader.readWorkBook("bin/tests/excels/estoreOrders.xls", ExcelReader.getSheets("bin/tests/excels/estoreOrders.xls")[0]);
		driver.findElement(By.id("userInput")).clear();
		driver.findElement(By.id("userInput")).sendKeys(userName);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.cssSelector("form > input[type=\"submit\"]")).click();
		Thread.sleep(30000);
		values = xlsValues.get("1");
	    SeleniumActions.doAction(values, driver);
	    driver.findElement(By.name("q")).sendKeys(estoreService + Keys.ENTER);
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.linkText(estoreService))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    values = xlsValues.get("2");
	    //SeleniumActions.doAction(values.get(0), values.get(1), values.get(2), driver);
	    driver.findElement(By.linkText(estoreService)).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.linkText("Order"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    SeleniumActions.doAction(values, driver);
	    //driver.findElement(By.linkText("Order")).click();
	    Thread.sleep(30000);
	    WebElement iframe = driver.findElements(By.tagName("iframe")).get(0);
	    WebElement form = driver.findElement(By.id("psc-order-form-modal"));
	    driver.switchTo().frame(iframe);
	    //Class<?> handlerClass = Class.forName("tests.selenium."+handler);
	    //Order order = (Order)handlerClass.newInstance();
	    estoreOrder(sheetName);
	    driver.switchTo().parentFrame().findElement(By.xpath("//div[@id='psc-order-form-modal']/div[3]/button[2]")).click();
	}   
  }

  @After
  public void tearDown() throws Exception {
    //driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  
  public void estoreOrder(String xlsFile) throws BiffException, IOException, InterruptedException {
	  Map<String, List<String>> serviceXLSValues;
		 List<String> values;
		 List<Long> names = new ArrayList<Long>();
		 String[] sheetNames = ExcelReader.getSheets("bin/tests/excels/"+xlsFile+".xls");
		 for (String sheetName : sheetNames) {
			 serviceXLSValues = ExcelReader.readWorkBook("bin/tests/excels/"+xlsFile+".xls", sheetName);
			 for (String key : serviceXLSValues.keySet()) {
				 names.add(Long.parseLong(key));
			 }
		 	 Collections.sort(names);
		 	 System.out.println(names);
		 	 Iterator<Long> itr = names.iterator();
		 	 while(itr.hasNext()) {
		 		 values = xlsValues.get(Long.toString(itr.next()));
		 		 SeleniumActions.doAction(values, driver);
		 	 }
		 }
  }
  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  
  
}
