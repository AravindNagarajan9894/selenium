package DataDrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MoneyControl_Flow {
	WebDriver driver;
	@Test
	public void test() throws IOException, InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();

		driver.findElement(By.id("wzrk-confirm")).click();
		String filePath = System.getProperty("user.dir")+"\\Excel\\Book1.xlsx";

		int rowCount = UtilityFile.getRowCount(filePath, "Sheet1");

		for(int i=0;i<=rowCount;i++) {
			String principal = UtilityFile.getCellData(filePath, "Sheet1", i, 0);
			
			String roi = UtilityFile.getCellData(filePath, "Sheet1", i, 1);
			String period = UtilityFile.getCellData(filePath, "Sheet1", i, 2);
			String ExpectedOutput = UtilityFile.getCellData(filePath, "Sheet1", i, 3);
			
			driver.findElement(By.id("principal")).sendKeys(principal);
			driver.findElement(By.id("interest")).sendKeys(roi);
			driver.findElement(By.id("tenure")).sendKeys(period);
			driver.findElement(By.xpath("//a[@onclick=\"return getfdMatVal(this);\"]")).click();
			String Output = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			if(ExpectedOutput.equals(Output)) 
				System.out.println("Passed");
			else	
				System.out.println("failed");
			
			driver.findElement(By.xpath("//a[@onclick=\"javascript:reset_fdcalcfrm();\"]")).click();
		}
	}
}
