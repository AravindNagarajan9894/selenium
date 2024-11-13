package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Assignment_ReadingDataFromProperties {

	WebDriver driver;
	@Test(priority=1)
	public void setup() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\DataDrivenTesting\\TestData\\Congurations.properties");
		prop.load(fis);
		
		String browser = prop.getProperty("Browser");
		//Read Browser from Properties File
		if(browser.equals("Chrome"))
			driver = new ChromeDriver();
		else if(browser.equals("Edge"))
			driver = new EdgeDriver();
		else if(browser.equals("FireFox"))
			driver = new FirefoxDriver();
		
		driver.get(prop.getProperty("CitUrl"));
		driver.manage().window().maximize();
	}
	@Test(priority=2)
	public void calc() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String filePath = System.getProperty("user.dir")+"\\Excel\\Cit.com.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		int rowCount = UtilityFile.getRowCount(filePath, "Sheet1");
		
		WebElement initialDepositAmount_Locator = driver.findElement(By.id("mat-input-0"));
		WebElement length_Locator  = driver.findElement(By.id("mat-input-1"));
		WebElement interestRate_Locator = driver.findElement(By.id("mat-input-2"));
//		WebElement compounding_Locator = driver.findElement(By.id("mat-select-value-1"));
 		WebElement run_Locator = driver.findElement(By.id("CIT-chart-submit"));
		WebElement CdWorth = driver.findElement(By.id("displayTotalValue"));
	
		for(int i=1;i<=rowCount;i++) {
			
			//Reading Data
			String initialDepositAmount = UtilityFile.getCellData(filePath, "Sheet1", i, 0);
			String length = UtilityFile.getCellData(filePath, "Sheet1", i, 1);
			String interestRate = UtilityFile.getCellData(filePath, "Sheet1", i, 2);
//			String compounding = UtilityFile.getCellData(filePath, "Sheet1", i, 3);
			String total = UtilityFile.getCellData(filePath, "Sheet1", i, 4);
			
			//clearing Field
			initialDepositAmount_Locator.clear();
			length_Locator.clear();
			interestRate_Locator.clear();
			
			//passing values
			initialDepositAmount_Locator.sendKeys(initialDepositAmount);
			length_Locator.sendKeys(length);
			interestRate_Locator.sendKeys(interestRate);
//			compounding_Locator.sendKeys(compounding);
			run_Locator.click();
			String ActualOutput = CdWorth.getText();
			System.out.print(ActualOutput);
			
			//output
			if(total.equals(ActualOutput))
				System.out.print("Pass");
			else
				System.out.print("Fail");

		}
	}
}
