package FileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class SingleAndMultiFileUpload {
	WebDriver driver;
	@Test(priority=1)
	public void test_setup() {
		driver = new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
	}
	@Test(priority=2)
	public void test_singlefile() {
		
		driver.findElement(By.id("filesToUpload")).sendKeys("C:\\Aravind\\text1.pdf");
		String text = driver.findElement(By.xpath("//ul[@id=\"fileList\"]/li")).getText();
		System.out.println(text);
	}
}
