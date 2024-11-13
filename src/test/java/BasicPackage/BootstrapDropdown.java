package BasicPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BootstrapDropdown {
	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void a_setup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
	}
	@Test
	public void b_bootstrapDrop() {
		driver.findElement(By.xpath("//button[contains(@class,\"multiselect\")]")).click();
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,\"multiselect\")]//label[@class=\"checkbox\"]"));
		System.out.println("size:"+ options.size());
		for(WebElement i : options ) {
			System.out.println(i.getText());
		}
		System.out.println();
	}
	@Test
	public void c_SelectBootstrapDrop() {
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,\"multiselect\")]//label[@class=\"checkbox\"]"));
		for(WebElement op : options)
		{
			String text = op.getText();
			
			if(op.getText().equals("HTML")||op.getText().contentEquals("CSS")) {
				op.click();
			}
		}
		System.out.println();
	}
}
//
