package Reports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excelreading {
	@Test
	public void f() throws IOException {
		File src = new File("C:\\Users\\sonu.x.kumar\\Desktop\\ExcelReading\\log.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(1);
		int rowcount = sheet1.getLastRowNum();
		System.out.println("Total no of Row = " + rowcount);
		for (int i = 0; i <= rowcount; i++) {
			String data = sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Test data from excel sheet is:" + data);
			String data1 = sheet1.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Test data from excel sheet is:" + data1);

			sheet1.getRow(0).createCell(2).setCellValue("Result");
			sheet1.getRow(1).createCell(2).setCellValue("Valid_user");

			FileOutputStream fout = new FileOutputStream(new File("C:\\Users\\sonu.x.kumar\\Desktop\\ExcelReading\\log.xlsx"));
			wb.write(fout);
			fout.close();
		}
		wb.close();
	}
}
