package com.cisco.com;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class popup {

	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	
	/**
	 * @param args
	 */
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://wwwin-tools-dev.cisco.com/";
	    Runtime.getRuntime().exec("C:\\Users\\ganagend\\Desktop\\test.exe");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @Test
	  public void testCcp() throws Exception {
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
	    Thread.sleep(1000);
	    	    
	    String step1 = driver.findElement(By.xpath("//div[@id='dojox_grid__View_1']/div/div/div/table/tbody/tr/td[2]")).getText();
	    System.out.println(step1);
	    String step11 = driver.findElement(By.xpath("//div[@id='dojox_grid__View_1']/div/div/div/table/tbody/tr/td[3]")).getText();
	    System.out.println(step11);
	    String step12 = driver.findElement(By.xpath("//div[@id='dojox_grid__View_1']/div/div/div/table/tbody/tr/td[4]")).getText();
	    System.out.println(step12);
	    String step13 = driver.findElement(By.xpath("//div[@id='dojox_grid__View_1']/div/div/div/table/tbody/tr/td[5]")).getText();
	    System.out.println(step13);
	    String step14 = driver.findElement(By.xpath("//div[@id='dojox_grid__View_1']/div/div/div/table/tbody/tr/td[6]")).getText();
	    System.out.println(step14);
	    
	    driver.findElement(By.id("CCPCRCloseButton")).click();
	    	Thread.sleep(1000);
	    
	  }
	        
	  private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }  
}
