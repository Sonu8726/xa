package Webshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import TestMeApp.Driver989;

public class DemoWeb {
	WebDriver driver;
  @Test(priority=1)
  public void Launch() {
	  driver = Driver989.getDriver("chrome");
	  driver.get("http://demowebshop.tricentis.com/");
	  driver.navigate().to("http://demowebshop.tricentis.com/register");
	  driver.manage().window().maximize();
  }
//  @Test(priority=2)
//  public void register() {
//	  driver.findElement(By.cssSelector("input[id='gender-male']")).click();//Male select
//	  driver.findElement(By.id("FirstName")).sendKeys("Sonu");//Firstname
//	  driver.findElement(By.id("LastName")).sendKeys("Kumar");//Lastname
//	  driver.findElement(By.id("Email")).sendKeys("Sonu@monu.com");//Email
//	  driver.findElement(By.id("Password")).sendKeys("Sonu123");//Password
//	  driver.findElement(By.id("ConfirmPassword")).sendKeys("Sonu123");//ConfirmPassword
//	  driver.findElement(By.id("register-button")).click();
//  }
  @Test(priority=3)
  public void login() {
	  driver.navigate().to("http://demowebshop.tricentis.com/login");
	  driver.findElement(By.id("Email")).sendKeys("Sonu@monu.com");//Email
	  driver.findElement(By.id("Password")).sendKeys("Sonu123");//Password
	  driver.findElement(By.cssSelector("input.login-button")).click();
  }
  @Test(priority=4)
  public void addToCart() {
	  driver.findElement(By.xpath("//a[text()='14.1-inch Laptop']")).click();
	  driver.findElement(By.id("add-to-cart-button-31")).click();
	  driver.navigate().to("http://demowebshop.tricentis.com/cart");
	  driver.findElement(By.id("CountryId")).sendKeys("41");//country
	  driver.findElement(By.id("StateProvinceId")).sendKeys("0");//country
	  driver.findElement(By.name("estimateshipping")).click();
	  driver.findElement(By.name("termsofservice")).click();
	  driver.findElement(By.id("checkout")).click();
  }
  
//  @Test(priority=5)
//  public void checkOut() {
//	  driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("Accenture");
//	  driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("41");
//	  driver.findElement(By.id("BillingNewAddress_StateProvinceId")).sendKeys("0");
//	  driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Gurugram");
//	  driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Atul katariya chowk");
//	  driver.findElement(By.id("BillingNewAddress_Address2")).sendKeys("Sector 13");
//	  driver.findElement(By.cssSelector("input#BillingNewAddress_ZipPostalCode")).sendKeys("122001");
//	  driver.findElement(By.cssSelector("input#BillingNewAddress_PhoneNumber")).sendKeys("1234567890");
//  }
}
