package BasicPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nopcommerce_Register {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("My account")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("aravind");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Nagarajan");
		driver.findElement(By.cssSelector("input#Email")).sendKeys("abc@gmail.com");
		driver.findElement(By.cssSelector("#Company")).sendKeys("abc company");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("Aravind");
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("Aravind");
		driver.findElement(By.cssSelector("button[name=\"register-button\"]")).click();

	}

}
