package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class DragAndDrop {
	WebDriver driver;
	Actions action ;
	Actions action2;
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable");
		driver.manage().window().maximize();
	}
	
	//@Test
	public void test_DragAndDrop() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		action = new Actions(driver);
		Action dragAndDropAction = action.dragAndDrop(draggable, droppable).build();
		dragAndDropAction.perform();
	}
	@Test
	public void test_demoGuru() {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://demo.guru99.com/test/drag_drop.html");
		WebElement bankDrag = driver.findElement(By.id("credit2"));
	    WebElement Drag5000 = driver.findElement(By.xpath("//a[text()=' 5000']"));
	//	WebElement account = driver.findElement(By.xpath("(//div[@class=\"ui-widget-content\"])[2]"));
		//WebElement amount = driver.findElement(By.id("amt7"));
		
		action = new Actions(driver);
		action.dragAndDrop(bankDrag, Drag5000).build().perform();
	
	}

}
