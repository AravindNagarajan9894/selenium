package Options;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Incognito {
	WebDriver driver ; 
	@Test(priority=1)
	public void test_setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}	
}
