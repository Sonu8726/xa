package Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import TestMeApp.Driver989;

public class Handlealert {
	WebDriver driver;
	  @Test(enabled=true)
	  public void frames() {
		  driver = Driver989.getDriver("chrome");
		  driver.manage().window().maximize();
		  driver.get("https://www.tsrtconline.in/oprs-web/");
		  driver.findElement(By.xpath("//input[@name='searchBtn']")).click();
		  if(ExpectedConditions.alertIsPresent()!=null) {
			Alert alrt = driver.switchTo().alert();
			String S = alrt.getText();
			System.out.println(S);
			alrt.accept();
		  }else
		  {
			  System.out.println("No alert in this page");
		  }
  }
}
