package Options;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Headless {
	WebDriver driver ; 
	@Test(priority=1)
	public void test_setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		driver = new ChromeDriver(options);
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}	
	@Test(priority=2)
	public void test_script() {
		driver.findElement(By.id("name")).sendKeys("aravind");
		driver.findElement(By.id("email")).sendKeys("Aravind.n@worktual.com");
		System.out.println("finish");
	}
}
