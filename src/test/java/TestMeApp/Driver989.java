package TestMeApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver989 {

	public static WebDriver getDriver(String browser) {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonu.x.kumar\\Downloads\\chromedriver.exe");
			return new ChromeDriver();
		}
		else if(browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\sonu.x.kumar\\Downloads\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		else if(browser.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sonu.x.kumar\\Downloads\\geckodriver.exe");
			return new FirefoxDriver();
		}
		else {
			return null;
		}		
	}
}
