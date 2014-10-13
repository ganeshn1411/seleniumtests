package tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MMXDestinationCreate {
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
  public void testMMXDestinationCreate() throws Exception {
    driver.get(baseUrl+"/RequestCenter/servicecatalog/servicecatalog.do");
    driver.findElement(By.id("userInput")).clear();
    driver.findElement(By.id("userInput")).sendKeys("jayca");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Reverso131!!");
    driver.findElement(By.cssSelector("form > input[type=\"submit\"]")).click();
    Thread.sleep(30000);
    driver.findElement(By.name("q")).click();
    driver.findElement(By.name("q")).sendKeys("mmx" + Keys.ENTER);
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.linkText("MMX Destination - Create"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.linkText("MMX Destination - Create")).click();
    /*for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.linkText("Order"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }*/
    waitAndSelect(By.linkText("Order"));
    //driver.findElement(By.linkText("Order")).click();
    //waitAndSelect(By.xpath("//body/div[7]"));
    //driver.findElement(By.xpath("//body/div[7]")).click();
    WebElement iframe = driver.findElements(By.tagName("iframe")).get(0);
    driver.switchTo().frame(iframe);
    //driver.findElement(By.xpath("//body/div[7]")).click();
    //waitAndSelect(By.cssSelector("div.modal-body"));
    waitAndSelect(By.xpath("//span[@id='ProjectAccount.SelectProjectAccount.Value']/select"));
    //waitAndSelect(By.xpath("//span[@id='ProjectAccount.SelectProjectAccount.Value']/select"));
    //driver.findElement(By.xpath("//span[@id='ProjectAccount.SelectProjectAccount.Value']/select")).click();
    new Select(driver.findElement(By.xpath("//span[@id='ProjectAccount.SelectProjectAccount.Value']/select"))).selectByVisibleText("PaaS - Self Funded");
    driver.findElement(By.cssSelector("option[value=\"PaaS - Self Funded\"]")).click();
    waitAndSelect(By.id("PaaSMMXQDestiConfig.DestinationType"));
    //driver.findElement(By.id("PaaSMMXQDestiConfig.DestinationType")).click();
    new Select(driver.findElement(By.id("PaaSMMXQDestiConfig.DestinationType"))).selectByVisibleText("Queue");
    driver.findElement(By.cssSelector("option[value=\"Queue\"]")).click();
    driver.findElement(By.id("PaaSMMXQDestiConfig.DestiName")).click();
    driver.findElement(By.id("PaaSMMXQDestiConfig.DestiName")).clear();
    driver.findElement(By.id("PaaSMMXQDestiConfig.DestiName")).sendKeys("paastes5.queue.1");
    waitAndSelect(By.id("PaaSMMXQDestiConfig.Lifecycle.Input"));
    //driver.findElement(By.id("PaaSMMXQDestiConfig.Lifecycle.Input")).click();
    driver.findElement(By.id("PaaSMMXQDestiConfig.Lifecycle")).click();
    new Select(driver.findElement(By.id("PaaSMMXQDestiConfig.Lifecycle"))).selectByVisibleText("DEV");
    driver.findElement(By.cssSelector("option[value=\"DEV\"]")).click();
    Thread.sleep(30000);
    if(isAlertPresent()) {
    	assertEquals("Currently Environment Freeze is enforced, it is recommended not to make any changes during this period in dev lifecycle. \nAs a Webmaster you are exempted from this freeze, if you have necessary management approval you can proceed with the changes.", closeAlertAndGetItsText());
    }
    driver.findElement(By.id("PaaSMMXQDestiConfig.MaximumMessageSize")).click();
    new Select(driver.findElement(By.id("PaaSMMXQDestiConfig.MaximumMessageSize"))).selectByVisibleText("ExtraLarge (Between 4MB to 20MB)");
    driver.findElement(By.cssSelector("option[value=\"Standard (Less than 600KB)\"]")).click();
    driver.findElement(By.id("PaaSMMXAppInfo.AppName")).click();
    driver.findElement(By.id("PaaSMMXAppInfo.AppName")).clear();
    driver.findElement(By.id("PaaSMMXAppInfo.AppName")).sendKeys("paastes5");
    driver.findElement(By.id("PaaSAccessControlMgmt.GroupMailerAlias")).click();
    driver.findElement(By.id("PaaSAccessControlMgmt.GroupMailerAlias")).clear();
    driver.findElement(By.id("PaaSAccessControlMgmt.GroupMailerAlias")).sendKeys("paas-dev-errors");
    waitAndSelect(By.id("PaaSMMXAppInfo.AppEnvironment"));
    //driver.findElement(By.id("PaaSMMXAppInfo.AppEnvironment")).click();
    new Select(driver.findElement(By.id("PaaSMMXAppInfo.AppEnvironment"))).selectByVisibleText("OTHERS");
    driver.findElement(By.cssSelector("option[value=\"OTHERS\"]")).click();
    driver.findElement(By.id("PaaSMMXAppInfo.SSLIdentity")).click();
    driver.findElement(By.id("PaaSMMXAppInfo.SSLIdentity")).clear();
    driver.findElement(By.id("PaaSMMXAppInfo.SSLIdentity")).sendKeys("default");
    driver.findElement(By.id("PaaSAccessControlMgmt.NonAdminUsersADGrp")).click();
    driver.findElement(By.id("PaaSAccessControlMgmt.NonAdminUsersADGrp")).click();
    driver.findElement(By.id("PaaSAccessControlMgmt.NonAdminUsersADGrp")).clear();
    driver.findElement(By.id("PaaSAccessControlMgmt.NonAdminUsersADGrp")).sendKeys("ccp-users");
    driver.findElement(By.id("PaaSFreezeWaiverSIDB.Reference")).click();
    driver.findElement(By.id("PaaSFreezeWaiverSIDB.Reference")).clear();
    driver.findElement(By.id("PaaSFreezeWaiverSIDB.Reference")).sendKeys("INC");
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
  
  private void waitAndSelect(By element) throws InterruptedException {
	  Thread.sleep(15000);
	  driver.findElement(element).click();	  
  }
}