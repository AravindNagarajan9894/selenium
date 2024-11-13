package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Slider {
	WebDriver driver;
	Actions act;
	WebDriverWait wait;
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
	}
	
	//@Test(priority=1)
	public void test_slider() {
		WebElement minslider = driver.findElement(By.xpath("(//span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"])[1]"));
		WebElement maxSlider = driver.findElement(By.xpath("(//span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"])[2]"));
		/*
		 * System.out.println(minslider.getLocation().getX());
		 * System.out.println(maxSlider.getLocation().getX());
		 */
		
		int currentPositionOfMinSlider = minslider.getLocation().getX();
		int currentPositionOfMaxSlider = maxSlider.getLocation().getX();
		
		act = new Actions(driver);
		act.dragAndDropBy(minslider, 100, 249).perform();
		act.dragAndDropBy(maxSlider, -100, 249).perform();
		/*
		 * System.out.println(minslider.getLocation());
		 * System.out.println(maxSlider.getLocation());
		 */
	}
	@Test(priority=2)
	public void test_slider2() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://demoqa.com/slider");
//		WebElement slider  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"range-slider range-slider--primary\"]")));
//		System.out.println(slider.getLocation());
//		
//		act = new Actions(driver);
//		act.dragAndDropBy(slider, -10, 522).perform();
//		System.out.println("current location: " + slider.getLocation());
		
	    // Locate the slider
        WebElement slider = driver.findElement(By.id("sliderId")); // Replace with actual slider locator
        
        // Get the width of the slider
        int sliderWidth = slider.getSize().getWidth();
        
        // Calculate the offset (e.g., move to 50% of the slider's width)
        int xOffset = (int) (sliderWidth * 0.5);
        
        // Use Actions class to move the slider
        Actions moveSlider = new Actions(driver);
        moveSlider.clickAndHold(slider)
                  .moveByOffset(xOffset, 0) // Move horizontally by the offset
                  .release()
                  .perform();
	}
}
