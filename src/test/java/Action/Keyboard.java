package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import TestMeApp.Driver989;

public class Keyboard {
  WebDriver driver;
	@Test
  public void f() throws InterruptedException {
	 driver = Driver989.getDriver("chrome");
	 driver.manage().window().maximize();
	 driver.get("http://google.co.in/");
	 WebElement trgt = driver.findElement(By.name("q"));
	 trgt.sendKeys("Accenture");
	 Thread.sleep(4000);
	 
	 Actions act= new Actions(driver);
	 act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
  }
}
