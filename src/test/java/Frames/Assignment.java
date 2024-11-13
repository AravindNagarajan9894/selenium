package Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment {
	WebDriver driver;
	@Test
	public void a_setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
	}
	
	@Test
	public void b_frameOne() {
		WebElement frameLeft =  driver.findElement(By.xpath("//frame[@src=\"/frame_left\"]"));
		driver.switchTo().frame(frameLeft);
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Hello");
	}
}
