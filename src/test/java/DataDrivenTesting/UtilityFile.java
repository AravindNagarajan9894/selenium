package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class UtilityFile {
	static FileInputStream fis;
	static FileOutputStream fos;
	static XSSFWorkbook xssfW;
	static XSSFSheet xssfS;
	static XSSFRow xssfR;
	static XSSFCell xssfC;
	
	public void readData() throws IOException {
		String filePath = System.getProperty("user.dir")+"\\Excel\\NewExcel.xlsx";
		String sheetName = "My File";
		fis = new FileInputStream(filePath);
		xssfW = new XSSFWorkbook(fis);
		xssfS = xssfW.getSheet(sheetName);
		xssfR = xssfS.getRow(0);
		int rowCount = getRowCount(filePath,sheetName);	
		for(int row=0;row<=rowCount;row++) {
			XSSFRow currentRow = xssfS.getRow(row);
			int colCount = getCellCount(filePath,sheetName, row);
			for(int col=0;col<colCount;col++) {				
				System.out.print(getCellData(filePath,sheetName, row,col)+"\t");
			}
			System.out.println();
		}
	}

	public void createExcelFile() throws IOException {
		String file = System.getProperty("user.dir")+"\\Excel\\NewExcel.xlsx";
		setCelldata(file,"My File",2,0,"Value1");
	}
	public static int getRowCount(String file , String sheetName) throws IOException {
		fis = new FileInputStream(file);
		xssfW = new XSSFWorkbook(fis);
		xssfS = xssfW.getSheet(sheetName);
		int Rowcount = xssfS.getLastRowNum();
		xssfW.close();
		fis.close();
		return Rowcount;
	}
	public int getCellCount(String file , String sheetName, int rowNum) throws IOException {
		fis = new FileInputStream(file);
		xssfW = new XSSFWorkbook(fis);
		xssfS = xssfW.getSheet(sheetName);
		int cellCount = xssfS.getRow(rowNum).getLastCellNum();
		xssfW.close();
		fis.close();
		return cellCount;
		
	}
	public static String getCellData(String file , String sheetName, int rowNum, int cellNum) throws IOException {
		fis = new FileInputStream(file);
		xssfW = new XSSFWorkbook(fis);
		xssfS = xssfW.getSheet(sheetName);
		xssfR = xssfS.getRow(rowNum);
		xssfC = xssfR.getCell(cellNum);
		String cellContent;
		try {
			DataFormatter formatter = new DataFormatter();
			cellContent = formatter.formatCellValue(xssfC);
		}
		catch(Exception e) {
			cellContent="";
		}
		xssfW.close();
		fis.close();
		return cellContent;
	}
	public void  setCelldata(String file, String sheetName ,int rowIndex, int cellIndex, String value) throws IOException {
		fis = new FileInputStream(file);
		xssfW = new XSSFWorkbook(fis);
		xssfS = xssfW.getSheet(sheetName);
		xssfR = xssfS.createRow(rowIndex);
		xssfC = xssfR.createCell(cellIndex);
		xssfC.setCellValue(value);
		xssfW.write(fos);
		xssfW.close();
		fos.close();
		
	}
}
