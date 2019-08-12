package TestMeApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Login {
	WebDriver driver;
	ExtentHtmlReporter  htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	@BeforeTest
	public void startReport() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/LoginReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);		
		htmlReporter.config().setDocumentTitle("Extent Report");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, YYYY, hh:mm a '('zzz')'");
	}
	@Test
	public void f() throws IOException {
		test = extent.createTest("Login Check","TestMeAPP");
		File src = new File("C:\\Users\\sonu.x.kumar\\Desktop\\ExcelReading\\login.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		int rowcount = sheet1.getLastRowNum();
		System.out.println("Total no of Row = " + rowcount);
		driver = Driver989.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp/");
		for (int i = 0; i <= rowcount; i++) {
			String username = sheet1.getRow(i).getCell(0).getStringCellValue();
			String password = sheet1.getRow(i).getCell(1).getStringCellValue();
			driver.navigate().to("http://10.232.237.143:443/TestMeApp/login.htm");
			driver.findElement(By.id("userName")).sendKeys(username);//username
			driver.findElement(By.id("password")).sendKeys(password);//Password
			driver.findElement(By.name("Login")).click();
			Assert.assertEquals(driver.getTitle(), "Home");
			
			driver.findElement(By.xpath("//*[@id='header']/div[1]/div/div/div[2]/div/ul/a")).click();
		}
		wb.close();
	}
	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if(result.getStatus()==2) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED", ExtentColor.RED));
			TakesScreenshot snapshot = (TakesScreenshot)driver;
			File src =snapshot.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
			String Path = System.getProperty("user.dir") +"/test-output/screens/"+result.getName()+".png";
			FileUtils.copyFile(src, new File(Path));
			test.addScreenCaptureFromPath(Path,result.getName());
			test.fail(result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED", ExtentColor.GREEN));
		}
		else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED", ExtentColor.YELLOW));
			test.skip(result.getThrowable());
		}
	}
	@AfterTest
	public void tearDown() {
		extent.flush();
	}
}
