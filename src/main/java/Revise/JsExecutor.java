package Revise;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JsExecutor {

	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers");
		driver.manage().window().maximize();
	} 
	@Test
	public void jsExecutorUseCases() throws InterruptedException {
		WebElement top25Schemes = driver.findElement(By.xpath("//a[text()='Top 25 schemes']"));
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", top25Schemes);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click()", top25Schemes);
		WebElement search_textfld = driver.findElement(By.id("srchword"));
		WebElement search_btn = driver.findElement(By.xpath("//input[@class = \"msprite newsrchbtn\"]"));
		
		js.executeScript("arguments[0].setAttribute('value','Reliance ')", search_textfld);
		js.executeScript("arguments[0].click()", search_btn);
//		js.executeScript("document.body.style.zoom='150%'");
//		js.executeScript("alert('Hello');");
//		Thread.sleep(2000);
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
		
		
	
	}
}
