package BasicPackage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;

public class Alert_Practice {
	
	
	
	WebDriver driver;
	String messgae ;
	
	
	
	@Test(priority=1)
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(priority=2)
	public void normalAlert() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(2000);
		
		//switch the driver from web page to Normal Alert
		Alert normalAlert = driver.switchTo().alert();
		System.out.println(normalAlert.getText());
		normalAlert.accept();
		
		//message
		messgae = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
		System.out.println(messgae);
		
		
	}
	
	@Test(priority=3)
	public void confirmPopup() throws InterruptedException {
		//clicking confirm pop up
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Thread.sleep(2000);
	
		//switching web to alert
		Alert confirmAlert = driver.switchTo().alert();
		System.out.println(confirmAlert.getText());
		//accept
		confirmAlert.accept();
		
		//message
		messgae = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
		System.out.println(messgae);
		
		//clicking confirm pop up
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Thread.sleep(2000);
		
		Alert confirmAlert2 = driver.switchTo().alert();
		//dismiss
		confirmAlert2.dismiss();
		
		//message
	    messgae = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
		System.out.println(messgae);
	}
	@Test(priority=4)
	public void promptAlert() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement promptButton = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		promptButton.click();
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("One");
		
		//accept
		promptAlert.accept();

		messgae = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();		
		System.out.println(messgae);
	
		promptButton.click();
		
		//reject
		promptAlert.sendKeys("One");
		promptAlert.accept();
	
		//messgae
		messgae = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
		System.out.println(messgae);
		

		
	}
}
