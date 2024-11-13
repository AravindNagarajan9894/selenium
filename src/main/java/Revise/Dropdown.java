package Revise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Dropdown {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver() ;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize(); 
	}
	
	public void bootstrap_Dropdowns() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[contains(@class,\"multiselect\")]")).click();
		driver.findElement(By.xpath("//label[text()=' jQuery']")).click();
	}
	@Test
	public void hiddenDropdowns() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://qapricing.qaworktual.co.uk/ccaas_pricing/purchaseflow/companydetails/");
		driver.findElement(By.id("postcode")).sendKeys("e145nr");
		driver.findElement(By.xpath("//a[text()='Find']")).click();
	//	driver.findElement(By.xpath("//span[@class=\"ant-select-selection-item\"]")).click();
		driver.findElement(By.xpath("(//input[@class=\"ant-select-selection-search-input\"])[3]")).sendKeys("G 4 S 40");
		driver.findElement(By.xpath("//div[contains(text(),'4 S 40 Bank Street')]")).click();
		
	}
}
