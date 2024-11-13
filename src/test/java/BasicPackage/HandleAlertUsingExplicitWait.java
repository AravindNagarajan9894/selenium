package BasicPackage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HandleAlertUsingExplicitWait {
	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void a_setup() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
	}
	@Test
	public void b_handleAlert() {
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert promtWait = wait.until(ExpectedConditions.alertIsPresent());
		promtWait.sendKeys("hello");
		promtWait.accept();
		
		//message
		String messgae = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
		System.out.println(messgae);
		
	}

}
