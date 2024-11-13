package BasicPackage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Assignment_Alerts {
	WebDriver driver;
	@Test
	public void a_setup() {
		driver= new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void b_handleAlertUsingAlertClass() throws InterruptedException {
		driver.findElement(By.name("proceed")).click();
		Alert rediffsignInAlert = driver.switchTo().alert();
		Thread.sleep(2000);
		rediffsignInAlert.accept();
	}
	
	@Test
	public void c_handleAlertUsingExplicitWait() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.name("proceed")).click();
		
		Alert rediffsignInAlert = wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		rediffsignInAlert.accept();
	}
}
