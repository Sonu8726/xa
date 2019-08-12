package Action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import TestMeApp.Driver989;

public class Dragndrop {
	WebDriver driver;
  @Test
  public void f() {
	  driver=Driver989.getDriver("chrome");
	  driver.get("http://www.globalsqa.com/demo-site/draganddrop/");

	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='post-2669']/div[2]/div/div/div[1]/p/iframe")));
	  WebElement src= driver.findElement(By.xpath("//img[@src='images/high_tatras_min.jpg']")); //box1
	  WebElement src1= driver.findElement(By.xpath("//*[text()='Trash']")); //box2
	  Actions a2= new Actions(driver); //
	  a2.dragAndDrop(src, src1).build().perform();
  }
}
