package Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingFrames {
	WebDriver driver;
	@Test
	public void a_setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");
	}
	
	@Test
	public void b_frameOne() {
		WebElement frameOne =  driver.findElement(By.xpath("//frame[@src=\"frame_1.html\"]"));
		driver.switchTo().frame(frameOne);
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Hello");
	}
	@Test
	public void c_switchingFrame() {
		driver.switchTo().defaultContent();
		
		WebElement frameTwo = driver.findElement(By.xpath("//frame[@src=\"frame_2.html\"]"));
		driver.switchTo().frame(frameTwo);
		driver.findElement(By.name("mytext2")).sendKeys("Hello");
	}
	
	@Test
	public void d_nestedFrame() {
		driver.switchTo().defaultContent();
		WebElement frameThree = driver.findElement(By.xpath("//frame[@src=\"frame_3.html\"]"));
		driver.switchTo().frame(frameThree);
		driver.findElement(By.name("mytext3")).sendKeys("Hello");
		
		WebElement innerFrame = driver.findElement(By.xpath("//iframe[contains(@src,'https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5')]"));
		driver.switchTo().frame(innerFrame);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//div[@class=\"AB7Lab Id5V1\"])[1]")).click();
		
		driver.switchTo().defaultContent();
		WebElement frameFour = driver.findElement(By.xpath("//frame[@src=\"frame_4.html\"]"));
		driver.switchTo().frame(frameFour);
		driver.findElement(By.name("mytext4")).sendKeys("hello");
	}
	
	@Test
	public void e_lastFrame() {
		driver.switchTo().defaultContent();
		WebElement frameFive = driver.findElement(By.xpath("//frame[@src=\"frame_5.html\"]"));
		driver.switchTo().frame(frameFive);
		driver.findElement(By.xpath("//a[@href=\"https://a9t9.com\"]")).click();
		
		//WebElement iframe = driver.findElement(By.xpath("//iframe[@data-tagging-id=\"G-VJNCDYRXBP\"]"));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frameFive);	
		driver.findElement(By.xpath("//button[@class=\"new-topic-btn btn btn-primary\"]")).click();
	}
}
