package BasicPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstProgram {

	public static void main(String [] args)  {
		WebDriver driver = new ChromeDriver();
		driver.get("https://ccaas.worktual.co.uk/login");
		driver.manage().window().maximize();
	    driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("lewoyeh156@jadsys.com");
	    driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("Vectone@123");
	    driver.findElement(By.xpath("//span[text()='Login']")).click();
	}	//lewoyeh156@jadsys.com placeholder="Password"

}

