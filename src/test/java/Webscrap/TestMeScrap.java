package Webscrap;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import TestMeApp.Driver989;
import junit.framework.Assert;

public class TestMeScrap {
	WebDriver driver;
  @Test(enabled=true)
  public void frames() {
	  driver = Driver989.getDriver("chrome");
	  driver.manage().window().maximize();
	  
	  driver.get("http://10.232.237.143:443/TestMeApp/");
	  
	  WebElement Trgt_E1 = driver.findElement(By.xpath("//*[@id=\'menu3\']/li[3]/a"));
	  Actions act1 = new Actions(driver);
	  act1.moveToElement(Trgt_E1).build().perform();
	  
	  WebElement Trgt_E2 = driver.findElement(By.xpath("//*[@id=\'menu3\']/li[3]/ul/li/a"));
	  Actions act2 = new Actions(driver);
	  act2.moveToElement(Trgt_E2).build().perform();
	  
	  WebElement Trgt_E3 = driver.findElement(By.xpath("//*[@id=\'menu3\']/li[3]/ul/li/ul/li[1]/a"));
	  Actions act3 = new Actions(driver);
	  act3.moveToElement(Trgt_E3).click().perform();
	  Set<String> wid = driver.getWindowHandles();    
	  Object[] obj = wid.toArray();
	  driver.switchTo().window((String)obj[1]);
	  Assert.assertEquals(driver.getTitle(), "Contact Us");
	  driver.switchTo().frame(driver.findElement(By.name("main_page")));
	  String address = driver.findElement(By.id("demo3")).getText();
	  System.out.println(address);
	  driver.close();
	  //Assert.assertTrue(address.contains("chennai"));
	  }
  }