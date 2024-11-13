package MouseActions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class MouseActionBasics {
	
	Actions action;
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void test_ActionsHover() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Laptops  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Laptops & Notebooks']")));
		
		WebElement mac = driver.findElement(By.xpath("//a[text()='Windows (0)']"));
		action = new Actions(driver);
		action.moveToElement(Laptops).moveToElement(mac).click().build().perform();
	}
	
	@Test(priority=2)
	public void test_ActionsRightClick() {	
		//second web site
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement rightClickMe2 = driver.findElement(By.xpath("//span[text()='right click me']"));
		action.contextClick(rightClickMe2).perform();
		WebElement copy = driver.findElement(By.xpath("//span[text()='Copy']"));
		copy.click();
		
		Alert copyAlert = driver.switchTo().alert();
		copyAlert.accept();
	}
	
	@Test(priority=3)
	public void test_DoubleClick() {
		//third website
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		WebElement copyTextButton = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		
		action = new Actions(driver);
		action.doubleClick(copyTextButton).perform();
		
		//clear the contents and add new content in the box 1
		WebElement field1 = driver.findElement(By.id("field1"));
		WebElement field2 = driver.findElement(By.id("field2"));
		field1.clear();
		field1.sendKeys("Aravind N");
		
		action.doubleClick(copyTextButton).perform(); 
		
		//initialze object
		Assert.assertEquals(field1.getText(), field2.getText());	
	}
	@Test(priority=4)
	public void test_DragAndDrop() {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		
		action = new Actions(driver);
		Action drgdrp = action.dragAndDrop(source, destination).build();
		drgdrp.perform();
	}

}
