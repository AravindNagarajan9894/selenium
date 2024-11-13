package JavascriptExecutorDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Scroll {
	
		WebDriver driver;
		@BeforeClass
		public void setUp() {
			driver = new EdgeDriver();
			driver.get("https://testautomationpractice.blogspot.com/");
			driver.manage().window().maximize();
		}
		@Test(priority=1)
		public void test_scrollByPixel() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
			System.out.println(js.executeScript("return window.pageYOffset;"));
		}
		@Test(priority=2)
		public void test_scrollTillVisibleElement() throws InterruptedException {
			WebElement Home = driver.findElement(By.xpath("//a[text()='Home']"));
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()",Home);
			System.out.println(js.executeScript("return window.pageYOffset;"));
			
		}
		@Test(priority=3)
		public void test_scrollTillLast() {
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			System.out.println(js.executeScript("return window.pageYOffset;"));
		}
		@Test(priority=4)
		public void test_scrollingUpToTop() {
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
			System.out.println(js.executeScript("return window.pageYOffset;"));
		}
		@Test(priority=5)
		public void test_ZoomOut() {
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("document.body.style.zoom='50%'");
		}
}
