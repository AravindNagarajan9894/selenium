package WebTables;

import java.util.List;

import javax.swing.JList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTables {
	WebDriver driver;

	@Test
	public void a_SetUp() {
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void b_webTables() {
		//No of Rows
		int noOfRows = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr")).size();
		System.out.println("No of Rows : "+noOfRows);
		
		//No of column
		int noOfCol = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr/th")).size();
		System.out.println("No Of Columns : "+ noOfCol );
		
		//Read the data from specific column
		List <WebElement> firstRowContent = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr[1]/th"));
		for(WebElement contents : firstRowContent) {
			System.out.println(contents.getText());
		}
		
		//Read the data from 5th Row and 1st column
		String data = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[5]/td[1]")).getText();
		System.out.println(data);
		
		//Read all the data
		for(int r=1;r<=1;r++) {
			for(int c=1;c<=noOfCol;c++) {
				String contents  = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]/th["+c+"]")).getText();
				System.out.print(contents+"\t");
			}
			System.out.println();
		}
		
		//get the book name of the mukesh arthor
		
		
		for(int i=2;i<noOfRows;i++) {
			String authorName = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+i+"]/td[2]")).getText();
			if(authorName.equals("Mukesh")) {
				String bookName = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+i+"]/td[1]")).getText();
				System.out.println(bookName);
			}
		}
		
		//total sum of the prices
		int SumOfPrices = 0;
		for(int i=2;i<=noOfRows;i++) {
			String prices = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+i+"]/td[4]")).getText();
			SumOfPrices += Integer.parseInt(prices);
			
		}
		System.out.println(SumOfPrices);
		
	}
	
}
