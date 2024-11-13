package DatePicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DatePicker_Practice {
	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void a_setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");
	}
	
	@Test
	public void b_datePicker() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//switch to iframe
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		
		//clicking datepicker
		driver.findElement(By.id("datepicker")).click();
		
		String expectedMonth="April";
		String expectedYear = "2023";
		String expectedDay = "23";
		
		//first we need to find the xpath to locate year and month, so we can compare them with expected output.
		while(true) {
			String month = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText();
			String year = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText();
			
			if(expectedMonth.equals(month)&&expectedYear.equals(year)) {
				break;
			}
			
			WebElement prev = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"ui-datepicker-prev ui-corner-all\"]")));
			WebElement next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"ui-datepicker-next ui-corner-all\"]")));
			
			prev.click();
		}
		
		//selecting day, first we need to find location of the all dates.
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]/tbody/tr/td/a"));
		
		for(int i=1;i<dates.size();i++) {
			if(dates.get(i).getText().equals(expectedDay)) {
				dates.get(i).click();
				break;
			}
		}
	}
}
