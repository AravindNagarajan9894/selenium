package Revise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import io.reactivex.rxjava3.functions.Action;

public class MouseActions {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver() ;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize(); 
	}
	@Test(priority=1)
	public void hover() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement electronics = driver.findElement(By.xpath("//span[text()='Electronics']"));
		Actions action = new Actions(driver);
		action.moveToElement(electronics).build().perform();
		
		driver.findElement(By.xpath("//a[@class='_1BJVlg _11MZbx']")).click();
	}
	@Test(priority=2)
	public void doubleClick() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		WebElement copy_text_btn = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		Actions action = new Actions(driver);
		action.doubleClick(copy_text_btn).build().perform();
	
	}
	@Test(priority=3)
	public void draganddrop() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		WebElement draggeble = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(draggeble, droppable).build().perform();
	
	}
}
