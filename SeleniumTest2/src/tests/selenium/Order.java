package tests.selenium;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.openqa.selenium.WebDriver;

public interface Order {
	public void estoreOrder(WebDriver driver)throws InterruptedException, BiffException, IOException;
}
