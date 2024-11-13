package Revise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class iframe {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver() ;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize(); 
	}

	@Test(priority=1)
	public void handling_frame() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//enter value in the frame one
		WebElement frameOne = driver.findElement(By.xpath("//frame[@src=\"frame_1.html\"]"));
		driver.switchTo().frame(frameOne);
		driver.findElement(By.name("mytext1")).sendKeys("aravind");
		
		//switch to frame three
		driver.switchTo().defaultContent();
		WebElement frameThree = driver.findElement(By.xpath("//frame[@src=\"frame_3.html\"]"));
		driver.switchTo().frame(frameThree);
		driver.findElement(By.name("mytext3")).sendKeys("aravind");
		//switch to frame inside frame
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//span[text()='Other:']")).click();
		driver.findElement(By.xpath("//input[@class=\"Hvn9fb zHQkBf\"]")).sendKeys("aravind");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Web Testing']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Form Autofilling']")).click();
		driver.findElement(By.xpath("//span[text()=\"Next\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"Submit\"]")).click();
		driver.switchTo().defaultContent();
		
		//switch to frame five
		WebElement frameFive =driver.findElement(By.xpath("//frame[@src=\"frame_5.html\"]"));
		driver.switchTo().frame(frameFive);
		driver.findElement(By.name("mytext5")).sendKeys("aravind");
		
	}
}
