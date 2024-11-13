package BasicPackage;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class WindowHandle_Scenario_Two {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		//get url
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//maximize
		driver.manage().window().maximize();
		
		//search House of Dragons and click
		search("House of Dragons", driver);
		
		//clicks the first link
		List<WebElement> linksOfHOD = driver.findElements(By.xpath("//div[@id= \"wikipedia-search-result-link\"]/a"));
		
//		for(WebElement links :linksOfHOD ) {
//			
//			String targetTitle = "House of Dragons";
//			if(links.getText().equals(targetTitle)) {
//				links.click();
//			}
//		}
		
		linksOfHOD.get(0).click();
		
		//SWITCH to new window
		Set windowHandleIds = driver.getWindowHandles();
		List<String> ids = new ArrayList(windowHandleIds);
		
		driver.switchTo().window(ids.get(1));
		
		System.out.println(" expected title must be \"Casa de los Dragones\": "+driver.getTitle());
		
		//switch to parent window
		driver.switchTo().window(ids.get(0));
		
		//title
		System.out.println(" expected title must be \"Automation Testing Practice\": "+driver.getTitle());
		
		//refresh the parent page
		driver.navigate().refresh();
		
		//search rhaenyra targaryen in parent window
		search("rhaenyra targaryen", driver);
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@id= \"wikipedia-search-result-link\"]/a"));
		links.get(0).click();
		
		
		
		Set updatedWindowHandleIds = driver.getWindowHandles();
		List<String> updatedids = new ArrayList(updatedWindowHandleIds);
		
		//switch to new tab
		driver.switchTo().window(updatedids.get(2));
		
		//title
		System.out.println(" expected title must be \"The Princess and the Queen - Wikipedia\": "+ driver.getTitle());
			
		System.out.println("finish");
	}
	
	public static void search(String content, WebDriver driver){
		driver.findElement(By.xpath("//input[@id = \"Wikipedia1_wikipedia-search-input\"]")).sendKeys(content);
		driver.findElement(By.xpath("//input[@class=\"wikipedia-search-button\"]")).click();
	}

}
