package BrokenLinks;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
public class Basic {
	WebDriver driver;
	@Test(priority =1)
	public void test_SetUp() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless=new");
		driver = new ChromeDriver(option);
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	@Test(priority =2)
	public void test_Links() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> links = driver.findElements(By.xpath("//div[@id=\"maintext\"]//div[1]//li/a"));
		for(WebElement i : links) {
			System.out.println(i.getAttribute("href"));
		}
		
	}
	
}
