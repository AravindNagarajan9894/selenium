package WebTables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Assignment_BootstrapWebTables {
	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void a_setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test
	public void b_login() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	}
	@Test
	public void c_admin() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//admin
		driver.findElement(By.xpath("(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[1]")).click();
		
		//column size
		List<WebElement> columns= driver.findElements(By.xpath("//div[@role=\"table\"]//div[@role=\"columnheader\"]"));
		int columnSize = columns.size();
		System.out.println("columnSize "+ columnSize);
		
		//row size
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class=\"oxd-table-card\"]"));
		int rowSize = rows.size();
		System.out.println("rowSize "+ rowSize);
		
		for(int i=1;i<=rowSize;i++) {
			
			WebElement userRole = driver.findElement(By.xpath("(//div[@class=\"oxd-table-card\"]//div[3]/div)["+i+"]"));
			System.out.println(userRole.getText());
			
			if(userRole.getText().equals("ESS")) {
				WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"oxd-table-card\"]//div[6]//button[1])["+i+"]")));
				delete.click();
				System.out.println(i);
			
				driver.findElement(By.xpath("//button[contains(@class,\"label-danger orangehrm-button-margin\")]")).click();
			}
		}
		
	}

}
