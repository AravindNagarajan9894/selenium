package Screenshots;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;

import dev.failsafe.internal.util.Durations;
public class FullPage {
	WebDriver driver ; 
	@Test(priority=1)
	public void test_setup() {
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	//@Test(priority=2)
	public void test_fullpageScreenshot() {
		getScreenshot(driver,System.getProperty("user.dir")+"\\screenshots\\fullpage1.png");
	}
	public static void getScreenshot(WebDriver driver, String Location) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(Location);
		source.renameTo(target);
	}
	//@Test(priority=3)
	public void test_specificpage() {
		WebElement EAD = driver.findElement(By.xpath("(//div[@class=\"widget HTML\"])[1]"));
		getSpecificScreenshot(driver,System.getProperty("user.dir")+"\\screenshots\\EAD.png",EAD );
		
	}
	public static void getSpecificScreenshot(WebDriver driver, String Location,WebElement element) {
		File EADScreenshot = element.getScreenshotAs(OutputType.FILE);
		File target = new File(Location);
		EADScreenshot.renameTo(target);
	}
	@Test(priority=4)
	public void test_webelementScreenshot() {
		WebElement colorLabel = driver.findElement(By.xpath("//label[text()='Colors:']"));
		File colorLabelFile = colorLabel.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\screenshots\\color.png");
		colorLabelFile.renameTo(target);
		
	}
}
