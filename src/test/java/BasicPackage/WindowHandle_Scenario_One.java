package BasicPackage;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WindowHandle_Scenario_One {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//find search and click search
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("House of Dragons");
		driver.findElement(By.xpath("//input[@class=\"wikipedia-search-button\"]")).click();
		
		//finding the result links
		List<WebElement> links = driver.findElements(By.xpath("//*[@id='wikipedia-search-result-link']/a"));
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//loop through each web element and clicking the links
		for(int i=0;i<links.size();i++) {
			wait.until(ExpectedConditions.visibilityOf(links.get(i))).click();	
		}
		
		//Finding window ids
		Set<String> windowIds = driver.getWindowHandles();
		List<String> windows = new ArrayList(windowIds);
		
		
		for(String id : windows ) {
			String title  =  driver.switchTo().window(id).getTitle();
			
			//closing particular window
			if(title.equals("House of the Dragon - Wikipedia")|| title.equals("Casa de los Dragones - Wikipedia")) {
				driver.close();		
			}
		}
		
		
		//switching to house of dragos window
		Set windowIds2 = driver.getWindowHandles();
		List<String> ids = new ArrayList(windowIds2);
		driver.switchTo().window(ids.get(1));
		
		
		//Go to wikipedia home page
		driver.findElement(By.xpath("//span[@class=\"mw-logo-container skin-invert\"]")).click();
		
		//getting the current title
		System.out.println("result must be \"Wikipedia, the free encyclopedia\" : "+ driver.getTitle());
		
		driver.switchTo().window(ids.get(0));
		System.out.println("result must be \"Automation Testing Practice\" : "+ driver.getTitle());
		
		System.out.println("finish");
		driver.quit();
	}

}
