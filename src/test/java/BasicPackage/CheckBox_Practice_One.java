package BasicPackage;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class CheckBox_Practice_One {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//select single check box
		//driver.findElement(By.id("sunday")).click();
		
		//select all check boxes
		List<WebElement> checkboxes =  driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox'] "));
//		for(WebElement checkbox : checkboxes ) {
//			checkbox.click();
//		}
		
		//selecting particular checkboxes
//		for(int i=0;i<checkboxes.size();i++) {
//			if(i==0||i==1||i==2){
//				checkboxes.get(i).click();
//			}
//		}
		
		//How to select the last three checkboxes?
		
		for(int i=4;i<checkboxes.size();i++) {
			checkboxes.get(i).click();
		}
		
		//How to uncheck the checkboxes?
		WebElement saturdayCheck = driver.findElement(By.id("saturday"));
		if(saturdayCheck.isSelected()) {
			saturdayCheck.click();
		}
	}

}
