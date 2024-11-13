package BasicPackage;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		
		
		
		//implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//url
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//new page
		//driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		WebElement orangeHrmLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("OrangeHRM, Inc")));
		orangeHrmLink.click();
		
		
		
		Set<String> windowIds = driver.getWindowHandles();
		
		for(String id : windowIds) {
			String title = driver.switchTo().window(id).getTitle();
			if(title.equals("Human Resources Management Software | OrangeHRM")) {
				System.out.println(driver.getCurrentUrl());
				driver.close();
			}
		}
		

	}

}
