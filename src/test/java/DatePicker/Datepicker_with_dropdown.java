package DatePicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Datepicker_with_dropdown {
	
	WebDriver driver;
	WebDriverWait wait ;
	
	@Test
	public void a_setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
	}
	
	@Test
	public void b_datepicker() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String expectedMonth="April";
		String expectedYear = "2023";
		String expectedDay = "23";
		
		WebElement datePicker= driver.findElement(By.id("dateOfBirthInput"));
		datePicker.click();
		Select dropdown ;
		
		//select month
		WebElement month = driver.findElement(By.xpath("//select[@class=\"react-datepicker__month-select\"]"));
		dropdown = new Select(month);
		dropdown.selectByVisibleText(expectedMonth);
		
		//select year
		WebElement year = driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]"));
		dropdown = new Select(year);
		dropdown.selectByVisibleText(expectedYear);
		
		//dates
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class=\"react-datepicker__month\"]/div/div"));
		
		for(WebElement e : dates) {
			if(e.getText().equals(expectedDay)) {
				e.click();
				break;
			}
		}
	}
	

}
