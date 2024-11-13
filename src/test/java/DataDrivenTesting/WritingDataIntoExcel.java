package DataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WritingDataIntoExcel {
	@Test
	public void test_writrStaticData() throws IOException {
		XSSFWorkbook workbook  = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook.createSheet("My File");
		XSSFRow row1 = sheet1.createRow(0);
			row1.createCell(0).setCellValue("Name");
			row1.createCell(1).setCellValue("Roll Num");
			row1.createCell(2).setCellValue("Mark");
			
		XSSFRow row2 = sheet1.createRow(1);
			row2.createCell(0).setCellValue("Aravind");
			row2.createCell(1).setCellValue(001);
			row2.createCell(2).setCellValue(100);
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\Excel\\NewExcel.xlsx");	
		workbook.write(file);
		workbook.close();
		file.close();
	}
}
