package BasicPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//Assignment
//2) Hidden dropdown
//Login to OrangeHRM--> pim--> employee status
public class Assignment_CheckBox_3 {
	WebDriver driver;
	WebDriverWait wait;
	
	@Test
	public void a_setUp() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	@Test
	public void b_login() {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		userName.sendKeys("Admin");
		
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Password\"]")));
		password.sendKeys("admin123");
		
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type=\"submit\"]")));
		submit.click();
	}
	@Test
	public void hiddenDropDown() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("(//div[@class=\"oxd-select-text-input\"])[1]")).click();
		List<WebElement> option = driver.findElements(By.xpath("//div[@class=\"oxd-select-option\"]/span"));
		for(WebElement e : option) {
			System.out.println(e.getText());
		}
		driver.findElement(By.xpath("//span[text()='Full-Time Permanent']")).click();
		
	}

}
