package Cucmber;

import org.openqa.selenium.WebDriver;
import TestMeApp.Driver989;
import io.cucumber.java.en.Given;

public class launchApp {
	WebDriver driver;
	@Given("Launchapp")
	public void launchapp() {
		driver = Driver989.getDriver("chrome");
		driver.get("https://www.google.com/");
		System.out.println("Succsess");
		//Assert.assertEquals("Google", driver.getTitle());
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}
}
