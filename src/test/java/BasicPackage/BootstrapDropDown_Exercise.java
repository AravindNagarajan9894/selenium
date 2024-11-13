package BasicPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BootstrapDropDown_Exercise {
	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void a_setup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette");
	
	}
	@Test
	public void b_bootstrapDrop() {
		driver.findElement(By.id("justAnInputBox")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement op = driver.findElement(By.xpath("//div[@id='comboTree147811DropDownContainer']//li[@class='ComboTreeItemChlid']//span[text()='choice 1  ']"));
		op.click();
				   //div[@id='comboTree147811DropDownContainer']//li[@class="ComboTreeItemChlid"]//span[text()='choice 1  ']
	}
}
//