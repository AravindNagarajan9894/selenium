package BasicPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class MoneyRefiff {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		String mainPageTitle = driver.getTitle();
		System.out.println("title "+ mainPageTitle);
		
		String currentPageUrl = driver.getCurrentUrl();
		System.out.println("Url "+ currentPageUrl);
		
		System.out.println(driver.getPageSource());
		
		String windowId ;
		windowId = driver.getWindowHandle();
		System.out.println(windowId);
		
		Thread.sleep(4000);
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
	
		String PageTitle = driver.getTitle();
		System.out.println("title "+PageTitle);
		
		String currentPageUrl1 = driver.getCurrentUrl();
		System.out.println("Url "+ currentPageUrl1);
		
		//System.out.println(driver.getPageSource());
		
		Set<String> windowIds = driver.getWindowHandles();
		System.out.println(windowIds);
		
		
	}

}
	