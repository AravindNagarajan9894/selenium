package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AssignmentReadingData {
	@Test
	public void test() throws IOException {
		FileInputStream DataDrivenTestingExcel = new FileInputStream(System.getProperty("user.dir")+"\\Excel\\DataDrivenTesting.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(DataDrivenTestingExcel);
		XSSFSheet sheet1 = workbook.getSheet("Sheet1");
		int rows = sheet1.getLastRowNum();
		int cells = sheet1.getRow(0).getLastCellNum();
		for(int i=0;i<=rows;i++) {
			XSSFRow row = sheet1.getRow(i);
			for(int j=0;j<cells;j++) {
				XSSFCell cell = row.getCell(j);
				System.out.print(cell.toString()+"\t");
			}
			System.out.println();
		}
	}
}
