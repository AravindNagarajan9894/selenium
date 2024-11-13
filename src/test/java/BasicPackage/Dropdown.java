package BasicPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Dropdown {
	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void a_setup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
	}
	//@Test
	public void b_selectDropdown() {
		WebElement dropdown = driver.findElement(By.id("country"));
		Select drop = new Select(dropdown);
		//drop.selectByVisibleText("India");
		drop.selectByValue("india");
		//drop.selectByIndex(8);
	}
	@Test
	public void c_countDropDown(){
		WebElement dropdown = driver.findElement(By.id("country"));
		Select drop = new Select(dropdown);
		List<WebElement> valuesOfDropdown = drop.getOptions();
		System.out.println(valuesOfDropdown.size());
		for(WebElement i : valuesOfDropdown ) {
			System.out.println(i.getText());
		}
	}
	

}
