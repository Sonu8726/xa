package Reports;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Report_2 {
	@Test
	public void f() throws IOException {
		XSSFWorkbook wordbook = new XSSFWorkbook();
		FileOutputStream out = new FileOutputStream(new File("Sonu/Selenium TOC01.xlsx"));
		wordbook.write(out);
		System.out.print("Writing Success");
		wordbook.close();
	}
}
