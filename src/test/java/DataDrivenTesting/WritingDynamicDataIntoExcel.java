package DataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;	
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WritingDynamicDataIntoExcel {
	@Test
	public void test_dynamicDataIntoExcel() throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		
		Scanner input = new Scanner(System.in);
		System.out.println("How many rows?");
		int rowCount =input.nextInt();
		
		System.out.println("How many Cells?");
		int cellCount = input.nextInt();
		
		for(int i=0;i<rowCount;i++) {
			XSSFRow currentRow = sheet.createRow(i);
			for(int j=0;j<cellCount;j++) {
				XSSFCell currentCell = currentRow.createCell(j);
				System.out.println("Enter value of cell number "+(j+1)+" of Row number "+(i+1));
				String CurrentCellValue = input.next();
				currentCell.setCellValue(CurrentCellValue);
			}
		}
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\Excel\\dynamicData.xlsx");
		workbook.write(file);
		workbook.close();
		file.close();
	}
}
