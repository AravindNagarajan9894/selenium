package Revise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class Options {
	WebDriver driver;
	@Test
	public void setup() {
		ChromeOptions option = new ChromeOptions();
		//option.addArguments("--headless=new");
		driver = new ChromeDriver(option);
		driver.get("https://www.tutorialspoint.com/selenium/practice/upload-download.php");
		driver.manage().window().maximize();
		driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\QA Team\\Documents\\DataDrivenTesting.xlsx");
	} 
	
}
