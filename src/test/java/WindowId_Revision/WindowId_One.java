package WindowId_Revision;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WindowId_One {
	WebDriver driver;
	Set<String> ids ;
	WebDriverWait wait;

	@Test(priority=1)
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.royalbrothers.com/mysore/bike-rentals");
		driver.manage().window().maximize();
	
	}
	@Test(priority=2)
	public void newWindow() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.onnbikes.com/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.zoomcar.com/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://gaadibooking.com/");
		
	}
	@Test(priority=3)
	public void handlingWindows() throws InterruptedException  {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		ids = driver.getWindowHandles();
		
		// go to Zoomcar Website
		String expectedTitle = "Best Car Rental with Zoomcar | Explore & Drive Hassle-Free";
		for(String id : ids) {
			String currentPageTitle = driver.switchTo().window(id).getTitle();
			if(currentPageTitle.equals(expectedTitle)) {
					break;
			}
		}
		driver.findElement(By.xpath("//div[contains(text(),'Select Location')]")).click();
	
	
	}
	
	@Test(priority=4)
	public void closeParticularTab() {
		//close royal brother tabs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ids = driver.getWindowHandles();
		String expectedUrl = "https://www.royalbrothers.com/mysore/bike-rentals";
		for(String id : ids) {
			String CurrentUrl = driver.switchTo().window(id).getCurrentUrl();
			if(CurrentUrl.equals(expectedUrl)) {
				driver.close();
				break;
			}
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		
		
	}
	
}
