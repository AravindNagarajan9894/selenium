package BasicPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoSuggestDropDown {
	
	WebDriver driver;

	@Test
	public void a_SetUp() {
		driver = new ChromeDriver();
		driver.get("https://www.bjs.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void b_autoSuggestDropDown() {
		driver.findElement(By.name("search")).sendKeys("burger");
		List<WebElement> options = driver.findElements(By.xpath("//div[@class=\"list-item border-0 list-group-item\"]/span"));
		System.out.println(options.size());
		
		
	}
}
