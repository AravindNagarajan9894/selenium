package Revise;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TsScreenshots {
	WebDriver driver;
	JavascriptExecutor js;
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers");
		driver.manage().window().maximize();
	} 

	public void takeFullPageScreenshot(String ss_name) {
		String location = System.getProperty("user.dir")+"\\Screenshots\\"+ss_name+".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(location);
		source.renameTo(target);
		
	}
	public void takeWebElementScreenshot(String ss_name, WebElement element ) {
		String location = System.getProperty("user.dir")+"\\Screenshots\\"+ss_name+".png";
		File source = element.getScreenshotAs(OutputType.FILE);
		File target = new File(location);
		source.renameTo(target);
	}
	@Test
	public void screenShots() {
		js = (JavascriptExecutor)driver;
		
		WebElement top25Schemes = driver.findElement(By.xpath("//a[text()='Top 25 schemes']"));
		WebElement moremoney = driver.findElement(By.id("moremoney"));
		js.executeScript("arguments[0].style.backgroundColor = 'yellow'", moremoney);
		//takeWebElementScreenshot("moremoney",moremoney );
		takeFullPageScreenshot("yellow");
	}
	
}
