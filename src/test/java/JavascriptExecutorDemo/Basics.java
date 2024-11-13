package JavascriptExecutorDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
public class Basics {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		driver = new EdgeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void test_Click() {
		WebElement nameTextField = driver.findElement(By.id("name"));
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','Aravind')", nameTextField);
		

		WebElement maleRadio = driver.findElement(By.id("male"));
		js.executeScript("arguments[0].click()", maleRadio);
	}
}
