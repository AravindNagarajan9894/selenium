package KeyBoardActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class KeyBoardActionBasic {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		//driver.get("https://text-compare.com/");
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	}
	//@Test(priority=1)
	public void textCompare() {
		//text area
		driver.findElement(By.id("inputText1")).sendKeys("hello , i am aravind");
		
		Actions act = new Actions(driver);
		
		//ctrl+A
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		//ctrl+c
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		//Tab
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		//ctrl+V
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		//compare
		driver.findElement(By.xpath("//div[text()='Compare!']")).click();
		
		String actualMessage = driver.findElement(By.xpath("//span[@class=\"messageForUser\"]")).getText();
		String expectedMessage = "The two texts are identical!";
		
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	@Test(priority=2)
	public void threeKeys() {
		
		Actions act = new Actions(driver);
		
//		driver.navigate().to("https://demo.nopcommerce.com/");
		
		WebElement dropdown = driver.findElement(By.linkText("Dropdown"));
		act.keyDown(Keys.CONTROL).click(dropdown).keyUp(Keys.CONTROL).perform();
		
		Set<String> windowIds = driver.getWindowHandles();
		List<String> windowIdsList = new ArrayList(windowIds);
		
		driver.switchTo().window(windowIdsList.get(1));
		System.out.println(driver.getCurrentUrl());
		
		driver.switchTo().newWindow(WindowType.WINDOW);
	}
}
