package BasicPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AuthenticationPopUp {
	WebDriver driver;
	@Test
	public void a_setup() {
		driver = new ChromeDriver();
		try {
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		String message = driver.findElement(By.xpath("//div[@id=\"content\"]/descendant::p")).getText();
		System.out.println(message);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
