package TestMeApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CountLink {
	WebDriver driver;
	@Test
	public void count() {
		driver = Driver989.getDriver("chrome");
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		List<WebElement> Elm = driver.findElements(By.cssSelector("td[class='mouseOut']"));
		int T_link = Elm.size();
		System.out.println("Total links are : "+T_link);
		
		for(int i=0;i<T_link;i++) {
			String D_link = Elm.get(i).getText();
			System.out.println("Your "+ i +" link is ="+D_link);
		}
		driver.close();
	}

}
