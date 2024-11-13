package DatePicker;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PastFuture {
	WebDriver driver;
	WebDriverWait wait ;
	
	@Test
	public void a_setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
	}
	
	@Test
	public void b_Handling_DatePicker_CombinationOfDropdown_and_Test() {
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.switchTo().frame("frame-one796456169");
		
		WebElement span = driver.findElement(By.xpath("//span[@class='icon_calendar']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", span);
		String auctualMonth = driver.findElement(By.xpath("//div[@class=\"ui-datepicker-title\"]/span")).getText();
		System.out.println(auctualMonth);
	}
}
