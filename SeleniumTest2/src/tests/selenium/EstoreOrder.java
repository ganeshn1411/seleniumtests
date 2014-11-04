package tests.selenium;

import java.util.Map;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import tests.parsers.ExcelReader;

public class EstoreOrder {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://estore-dev.cisco.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void testEstoreOrder() throws Exception {
	String service = "mmx";
	Map<String, String> credentials = ExcelReader.readWorkBook("bin/tests/excels/credentials.xls", ExcelReader.getSheets("bin/tests/excels/credentials.xls")[0]);
	String userName = credentials.get("user");
	String password = credentials.get("password");
	String[] sheets = ExcelReader.getSheets("bin/tests/excels/"+service+".xls");
	for(String sheetName : sheets){
		Map<String, String> serviceDetails = ExcelReader.readWorkBook("bin/tests/excels/"+service+".xls", sheetName);
		String estoreService = serviceDetails.get("estoreOrder");
		String handler = serviceDetails.get("handlerClass");
		driver.get(baseUrl+"/RequestCenter/servicecatalog/servicecatalog.do");
		driver.findElement(By.id("userInput")).clear();
		driver.findElement(By.id("userInput")).sendKeys(userName);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.cssSelector("form > input[type=\"submit\"]")).click();
		Thread.sleep(30000);
	    driver.findElement(By.name("q")).click();
	    driver.findElement(By.name("q")).sendKeys(service + Keys.ENTER);
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.linkText(estoreService))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.linkText(estoreService)).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.linkText("Order"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    driver.findElement(By.linkText("Order")).click();
	    Thread.sleep(30000);
	    WebElement iframe = driver.findElements(By.tagName("iframe")).get(0);
	    WebElement form = driver.findElement(By.id("psc-order-form-modal"));
	    driver.switchTo().frame(iframe);
	    Class<?> handlerClass = Class.forName("tests.selenium."+handler);
	    Order order = (Order)handlerClass.newInstance();
	    order.estoreOrder(driver);
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
