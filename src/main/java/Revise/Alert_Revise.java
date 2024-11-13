package Revise;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Alert_Revise {
	WebDriver driver;
	Alert alert;
	
	
	@BeforeClass()
	public void setUp() {
		driver = new ChromeDriver() ;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize(); 
	}
	
	@Test(priority=1)
	public void handling_NormalAlert() throws InterruptedException {
		WebElement alertButton = driver.findElement(By.id("alertButton"));
		//clicking alertButton
		alertButton.click();
		alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		
		
	}
	@Test(priority=2)
	public void confrimAlert_Accept() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//confirmButton
		WebElement confirmButton = driver.findElement(By.id("confirmButton"));	
		confirmButton.click();
		alert = driver.switchTo().alert();
		alert.accept();
		String confrimPromptText = driver.findElement(By.id("confirmResult")).getText();
		Assert.assertEquals(confrimPromptText, "You selected Ok");
	}
	@Test(priority=3)
	public void confrimAlert_Reject() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//confirmButton
		WebElement confirmButton = driver.findElement(By.id("confirmButton"));	
		confirmButton.click();
		alert = driver.switchTo().alert();
		alert.dismiss();
		String confrimPromptText = driver.findElement(By.id("confirmResult")).getText();
		Assert.assertEquals(confrimPromptText, "You selected Cancel");
	}
	@Test(priority=4)
	public void promptAlert_Accept() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement propmtButton = driver.findElement(By.id("promtButton"));
		propmtButton.click();
		alert = driver.switchTo().alert();
		alert.sendKeys("Hey");
		alert.accept();
		String PromptText = driver.findElement(By.id("promptResult")).getText();
		Assert.assertEquals(PromptText, "You entered Hey");
	}
	@Test(priority=5)
	public void promptAlert_dismiss() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement propmtButton = driver.findElement(By.id("promtButton"));
		propmtButton.click();
		alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.dismiss();
		
	}
}
