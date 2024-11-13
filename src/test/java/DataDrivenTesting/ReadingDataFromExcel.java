package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ReadingDataFromExcel {
	@Test
	public void test() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\Excel\\DataDrivenTesting.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet1 = workbook.getSheet("Sheet1");
		int rows = sheet1.getLastRowNum();
		System.out.println(rows);
		int cells = sheet1.getRow(0).getLastCellNum();
		System.out.println(cells);
		for(int i=0;i<=rows;i++) {
			XSSFRow currentRow = sheet1.getRow(i);
			for(int j=0;j<cells;j++) {
				XSSFCell cell = currentRow.getCell(j);
				System.out.print(cell);
				System.out.print(" ");
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}
}
