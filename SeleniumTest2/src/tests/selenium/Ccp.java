package tests.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Ccp {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://wwwin-tools-dev.cisco.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCcp4() throws Exception {
    driver.get(baseUrl + "/portal/main.event");
    driver.findElement(By.cssSelector("img[title=\"Select BPM Service to View/Modify Applications.\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='widget_filterApp']/div/div"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("filterApp")).clear();
    driver.findElement(By.id("filterApp")).sendKeys("zzadgan");
    driver.findElement(By.id("filterRefreshButton")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='dojox_grid__TreeView_1']/div/div/div/div/table/tbody/tr/td"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("div.dojoxGridExpandoNode")).click();
    driver.findElement(By.xpath("//div[@id='dojox_grid__TreeView_1']/div/div/div/div/table/tbody/tr/td")).click();
    driver.findElement(By.xpath("//div[@id='dojox_grid__TreeView_1']/div/div/div/div/table/tbody/tr[2]/td")).click();
    driver.findElement(By.xpath("//div[@id='dojox_grid__TreeView_1']/div/div/div/div/table/tbody/tr[2]/td[5]/font")).click();
    
    
    
    driver.findElement(By.id("CCPErrorButton")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("td.dojoxGridCell.dojoxGridCellOver"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//div[@id='dojox_grid__View_3']/div/div/div/table/tbody/tr/td[4]")).click();
    driver.findElement(By.id("CCPCRCloseButton")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='dojox_grid__View_3']/div/div/div/table/tbody/tr/td[4]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("CCPCRCloseButton")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
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
