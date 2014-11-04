package tests.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MMXDestinationCreate implements Order {
	private WebDriver driver;
	public void estoreOrder(WebDriver drvr) throws InterruptedException {
		this.driver = drvr;
		new Select(driver.findElement(By.xpath("//span[@id='ProjectAccount.SelectProjectAccount.Value']/select"))).selectByVisibleText("PaaS - Self Funded");
	    selectAndWait(By.cssSelector("option[value=\"PaaS - Self Funded\"]"));
	    Thread.sleep(15000);
	    //selectAndWait(By.id("PaaSMMXQDestiConfig.DestinationType"));
	    //selectAndWait(By.id("PaaSMMXQDestiConfig.DestinationType"));
	    //driver.findElement(By.id("PaaSMMXQDestiConfig.DestinationType")).click();
	    new Select(driver.findElement(By.id("PaaSMMXQDestiConfig.DestinationType"))).selectByVisibleText("Queue");
	    driver.findElement(By.cssSelector("option[value=\"Queue\"]")).click();
	    selectAndWait(By.id("PaaSMMXQDestiConfig.DestiName"));
	    //driver.findElement(By.id("PaaSMMXQDestiConfig.DestiName")).click();
	    //driver.findElement(By.id("PaaSMMXQDestiConfig.DestiName"));
	    //driver.findElement(By.id("PaaSMMXQDestiConfig.DestiName")).clear();
	    driver.findElement(By.id("PaaSMMXQDestiConfig.DestiName")).sendKeys("paaste44.queue.1");
	    selectAndWait(By.id("PaaSMMXAppInfo.AppName"));
	    //driver.findElement(By.id("PaaSMMXQDestiConfig.Lifecycle")).click();
	    //selectAndWait(By.id("PaaSMMXQDestiConfig.Lifecycle"));
	    //driver.findElement(By.id("PaaSMMXQDestiConfig.Lifecycle.Input")).click();
	    new Select(driver.findElement(By.id("PaaSMMXQDestiConfig.Lifecycle"))).selectByVisibleText("DEV");
	    selectAndWait(By.cssSelector("option[value=\"DEV\"]"));
	    //driver.findElement(By.cssSelector("option[value=\"DEV\"]")).click();
	    /*for(int second=0;second<60;second++) {
	    	Thread.sleep(1000);
	    	if(isAlertPresent()) {
	    		assertEquals("Currently Environment Freeze is enforced, it is recommended not to make any changes during this period in dev lifecycle. \nAs a Webmaster you are exempted from this freeze, if you have necessary management approval you can proceed with the changes.", closeAlertAndGetItsText());
	    		break;
	    	}
	    }*/
	    //driver.findElement(By.id("PaaSMMXQDestiConfig.MaximumMessageSize")).click();
	    new Select(driver.findElement(By.id("PaaSMMXQDestiConfig.MaximumMessageSize"))).selectByVisibleText("Standard (Less than 600KB)");
	    driver.findElement(By.cssSelector("option[value=\"Standard (Less than 600KB)\"]")).click();
	    driver.findElement(By.id("PaaSMMXAppInfo.AppName")).click();
	    driver.findElement(By.id("PaaSMMXAppInfo.AppName")).clear();
	    driver.findElement(By.id("PaaSMMXAppInfo.AppName")).sendKeys("paaste44");
	    selectAndWait(By.id("PaaSAccessControlMgmt.GroupMailerAlias"));
	    //driver.findElement(By.id("PaaSAccessControlMgmt.GroupMailerAlias")).click();
	    //driver.findElement(By.id("PaaSAccessControlMgmt.GroupMailerAlias")).clear();
	    //driver.findElement(By.id("PaaSAccessControlMgmt.GroupMailerAlias")).sendKeys("paas-dev-errors");
	    //selectAndWait(By.id("PaaSMMXAppInfo.AppEnvironment"));
	    //driver.findElement(By.id("PaaSMMXAppInfo.AppEnvironment")).click();
	    new Select(driver.findElement(By.id("PaaSMMXAppInfo.AppEnvironment"))).selectByVisibleText("OTHERS");
	    driver.findElement(By.cssSelector("option[value=\"OTHERS\"]")).click();
	    driver.findElement(By.id("PaaSMMXAppInfo.SSLIdentity")).click();
	    driver.findElement(By.id("PaaSMMXAppInfo.SSLIdentity")).clear();
	    driver.findElement(By.id("PaaSMMXAppInfo.SSLIdentity")).sendKeys("default");
	    driver.findElement(By.id("PaaSAccessControlMgmt.GroupMailerAlias")).click();
	    driver.findElement(By.id("PaaSAccessControlMgmt.GroupMailerAlias")).clear();
	    driver.findElement(By.id("PaaSAccessControlMgmt.GroupMailerAlias")).sendKeys("paas-dev-errors");
	    driver.findElement(By.id("PaaSAccessControlMgmt.NonAdminUsersADGrp")).click();
	    driver.findElement(By.id("PaaSAccessControlMgmt.NonAdminUsersADGrp")).click();
	    driver.findElement(By.id("PaaSAccessControlMgmt.NonAdminUsersADGrp")).clear();
	    driver.findElement(By.id("PaaSAccessControlMgmt.NonAdminUsersADGrp")).sendKeys("ccp-users");
	    if(driver.findElement(By.id("PaaSFreezeWaiverSIDB.Reference")).isDisplayed())
	    {
	    	driver.findElement(By.id("PaaSFreezeWaiverSIDB.Reference")).click();
	    	driver.findElement(By.id("PaaSFreezeWaiverSIDB.Reference")).clear();
	    	driver.findElement(By.id("PaaSFreezeWaiverSIDB.Reference")).sendKeys("INC");
	    }
	    driver.findElement(By.id("PaaSAccessControlMgmt.AdminUsersADGrp")).click();
	    //driver.findElement(By.id("PaaSAccessControlMgmt.AdminUsersADGrp")).submit();
	    //iframe.submit();
	   
	    //driver.findElement(By.xpath("//div[@id='psc-order-form-modal']/div[3]/button[2]")).click();
	}
	
	private void selectAndWait(By element) throws InterruptedException {
		  driver.findElement(element).click();
		  Thread.sleep(15000);
	  }
}

