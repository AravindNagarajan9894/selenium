package DatePicker;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DatePicker_CombinationOfDropdown_and_Test {
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
		
		String ExpectedMonth = "November";
		String [] Months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November" , "December"};
		
		List<String> monthsList = new ArrayList();
		for(String monthLoop: Months) {
			monthsList.add(monthLoop);
		}
		System.out.println(monthsList);
		
		
		for(int i=0;i< Months.length;i++) {
			String auctualMonth = driver.findElement(By.xpath("//div[@class=\"ui-datepicker-title\"]/span")).getText();
			System.out.println("auctualMonth :"+ auctualMonth);
			int auctualMonthIndex = monthsList.indexOf(auctualMonth);
			System.out.println("auctualMonthIndex : "+ auctualMonthIndex);
			
			int ExpectedMonthIndex = monthsList.indexOf(ExpectedMonth);
			System.out.println("ExpectedMonthIndex :"+ ExpectedMonthIndex);
			
			if(auctualMonthIndex > ExpectedMonthIndex){
				driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-w\"]")).click();
				if(auctualMonth.equals(ExpectedMonth)) {
					break;
				}
			}
			else if(auctualMonthIndex < ExpectedMonthIndex){
				driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-e\"]")).click();
				if(auctualMonth.equals(ExpectedMonth)) {
					break;
				}
			}
			else {
				if(auctualMonth.equals(ExpectedMonth)) {
					break;
				}
			}
		}
		
	}

}
