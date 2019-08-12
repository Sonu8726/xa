package Sbi_retail;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import TestMeApp.Driver989;

public class Sbiretail {
	WebDriver driver;
	
  @Test(enabled=false)
  public void f() {
	  driver = Driver989.getDriver("chrome");
	  driver.get("https://retail.onlinesbi.com/retail/login.htm");
	  String p_win_id = driver.getWindowHandle();
	  System.out.println(p_win_id);
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//*[@id=\'homeLoanButton\']/a")).click();
	  Set<String> wid = driver.getWindowHandles();
	    
	  for(String S: wid) {
		  driver.switchTo().window(S);
	  }
	  driver.findElement(By.xpath("//*[@id=\"mainMenu\"]/ul/li[8]/a")).click();
  }
  @Test(enabled=true)
  public void frames() {
	  driver = Driver989.getDriver("chrome");
	  driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_myfirst");
	  driver.manage().window().maximize();
	  driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
	  driver.findElement(By.xpath("/html/body/button"));
  }
}
