package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import TestMeApp.Driver989;

public class Action_handle {
  WebDriver driver;
	@Test(enabled=false)
  public void f() {
		driver = Driver989.getDriver("chrome");
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		WebElement Trgt_El = driver.findElement(By.xpath("//a[text()='Add-Ons']"));
		Actions act = new Actions(driver);
		act.moveToElement(Trgt_El).build().perform();
  }
	@Test
	  public void drgndrop() throws InterruptedException {
			driver = Driver989.getDriver("chrome");
			driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
			driver.manage().window().maximize();
			WebElement Trgt_E1 = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_RadTreeView1\"]/ul/li/ul/li[3]/ul/li[3]/div/div/span"));
			WebElement Trgt_E2 = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_RadGrid1_ctl00\"]/tbody/tr/td"));
			Actions act = new Actions(driver);
			
			act.dragAndDrop(Trgt_E1, Trgt_E2).build().perform();
			Thread.sleep(5000);
			String newPrice = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_RadGrid1_ctl00']/tfoot/tr/td[2]")).getText();
			System.out.println(newPrice);
			driver.close();
	  }
}
