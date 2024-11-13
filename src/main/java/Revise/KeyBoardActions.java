package Revise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KeyBoardActions {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver() ;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize(); 
	}
	@Test(priority=1)
	public void keyboardActions() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("aravind");
		WebElement textarea = driver.findElement(By.id("textarea"));
		Actions action = new Actions(driver);
		//ctrl A
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		//ctrl c
		action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
				
		//tab
		action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		//ctrl v
		action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		WebElement simpleAlert = driver.findElement(By.id("alertBtn"));
		action.click(simpleAlert);
	}
	
}
