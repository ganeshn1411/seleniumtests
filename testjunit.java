package com.cisco.com;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testjunit {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://estore-dev.cisco.com/";
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testJunit() throws Exception {
    
	driver.get(baseUrl + "/RequestCenter/servicecatalog/servicecatalog.do");  
	driver.findElement(By.id("userInput")).clear();
	
	//Authentication
	driver.findElement(By.id("userInput")).sendKeys("");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("");
	    driver.findElement(By.cssSelector("form > input[type=\"submit\"]")).click();
	    
	//end Authentication
	//wait for estore home page to load
	    WebDriverWait wait = new WebDriverWait(driver, 10000);
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
	    	    
    driver.findElement(By.name("q")).click();
    driver.findElement(By.name("q")).sendKeys("bpim" + Keys.ENTER);
    
    WebDriverWait wait1 = new WebDriverWait(driver, 10000);
    WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Business Process Management - Create")));
    
   driver.findElement(By.linkText("Business Process Management - Create")).click();
   
   WebDriverWait wait2 = new WebDriverWait(driver, 10000);
   WebElement element2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Order")));
   
    driver.findElement(By.linkText("Order")).click();
    
    //WebDriverWait wait3 = new WebDriverWait(driver, 10000);
    //WebElement element3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnOrderSubmit")));
    
    //driver.switchTo().frame(driver.findElement(By.id("psc-service-form")));
    //driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='psc-service-form']/div/p/iframe")));
    WebElement iframe = driver.findElements(By.tagName("iframe")).get(0);
    driver.switchTo().frame(iframe);
    
    driver.findElement(By.id("ProjectAccount.SelectProjectAccount")).click();
    new Select(driver.findElement(By.id("ProjectAccount.SelectProjectAccount"))).selectByVisibleText("PaaS Self Funded FY15");
    driver.findElement(By.cssSelector("option[value=\"PaaS Self Funded FY15\"]")).click();
    driver.findElement(By.id("ProjectAccount.SelectProjectAccount")).click();
    new Select(driver.findElement(By.id("ProjectAccount.SelectProjectAccount"))).selectByVisibleText("PaaS - Self Funded");
    driver.findElement(By.cssSelector("option[value=\"PaaS - Self Funded\"]")).click();
    driver.findElement(By.id("ProjectAccount.PropelID.Input")).click();
    driver.findElement(By.id("PaaSBPMAppInfo.AppId")).click();
    driver.findElement(By.id("PaaSBPMAppInfo.AppId")).clear();
    driver.findElement(By.id("PaaSBPMAppInfo.AppId")).sendKeys("zzgan21");
    driver.findElement(By.id("PaaSBPMAppInfo.AppId.Input")).click();
    driver.findElement(By.id("PaaSBPMAppInfo.Lifecycle")).click();
    new Select(driver.findElement(By.id("PaaSBPMAppInfo.Lifecycle"))).selectByVisibleText("Dev");
    driver.findElement(By.cssSelector("option[value=\"Dev\"]")).click();
    driver.findElement(By.id("PaaSBPMAppInfo.AppId.Message_INFO")).click();
    driver.findElement(By.id("PaaSBPMConfigInfo.CompType")).click();
    new Select(driver.findElement(By.id("PaaSBPMConfigInfo.CompType"))).selectByVisibleText("BW");
    driver.findElement(By.cssSelector("option[value=\"BW\"]")).click();
    driver.findElement(By.id("PaaSBPMAppInfo.Lifecycle.Input")).click();
    driver.findElement(By.id("PaaSBPMConfigInfo.InstanceDev")).click();
    driver.findElement(By.id("PaaSBPMConfigInfo.InstanceDev")).click();
    driver.findElement(By.id("PaaSBPMConfigInfo.HeapsizeMaxBW")).click();
    new Select(driver.findElement(By.id("PaaSBPMConfigInfo.HeapsizeMaxBW"))).selectByVisibleText("512M");
    driver.findElement(By.cssSelector("option[value=\"512M\"]")).click();
    driver.findElement(By.id("PaaSBPMConfigInfo.JavaHeapSizeMin.Message_INFO")).click();
    driver.findElement(By.id("PaaSBPMConfigInfo.InstanceDev")).click();
    driver.findElement(By.id("PaaSBPMConfigInfo.InstanceDev")).click();
    driver.findElement(By.id("PaaSBPMConfigInfo.VersionConfig")).click();
    new Select(driver.findElement(By.id("PaaSBPMConfigInfo.VersionConfig"))).selectByVisibleText("default");
    driver.findElement(By.cssSelector("option[value=\"default\"]")).click();
    driver.findElement(By.id("PaaSBPMConfigInfo.HeapsizeMaxBW.Input")).click();
    driver.findElement(By.id("PaaSAccessControlMgmt.GroupMailerAlias")).click();
    driver.findElement(By.id("PaaSAccessControlMgmt.GroupMailerAlias")).clear();
    driver.findElement(By.id("PaaSAccessControlMgmt.GroupMailerAlias")).sendKeys("paas-india");
    driver.findElement(By.id("PaaSAccessControlMgmt.AdminUsersADGrp.Input")).click();
    driver.findElement(By.id("PaaSOperationalInfo.SearchPattern")).click();
    driver.findElement(By.id("PaaSOperationalInfo.SearchPattern")).click();
    driver.findElement(By.id("PaaSOperationalInfo.SearchPattern")).clear();
    driver.findElement(By.id("PaaSOperationalInfo.SearchPattern")).sendKeys("ccp");
    driver.findElement(By.xpath("(//input[@id='EmanApplication'])[7]")).click();
    driver.findElement(By.cssSelector("center > input[type=\"button\"]")).click();
    driver.findElement(By.id("btnOrderSubmit")).click();
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
