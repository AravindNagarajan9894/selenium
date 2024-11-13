package BasicPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Assignment_MultiSelectDropDown {
	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void a_setUp() {
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
	}
	@Test
	public void b_multiSelectCheckBox() {
		WebElement colour = driver.findElement(By.id("colors"));
		Select multiSelectDropDown_Colour = new Select(colour);
		multiSelectDropDown_Colour.selectByVisibleText("Red");
		multiSelectDropDown_Colour.selectByVisibleText("Blue");
	}

}
