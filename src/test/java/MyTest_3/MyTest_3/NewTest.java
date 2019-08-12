package MyTest_3.MyTest_3;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class NewTest {
  
  @Parameters({"Browser","OS"})
  @Test
  public void login(String Browser, String OS) {
	  System.out.print("Code for login");
	  System.out.print(Browser);
	  System.out.print(OS);
  }
  @Parameters({"Browser","OS"})
  @Test
  public void logout(String Browser, String OS) {
	  System.out.print("Code for login");
	  System.out.print(Browser);
	  System.out.print(OS);
  }  
}
