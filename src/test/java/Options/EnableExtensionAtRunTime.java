package Options;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class EnableExtensionAtRunTime {
	//"D:\CRX files\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx"
	WebDriver driver ; 
	@Test(priority=1)
	public void test_setup() {
		ChromeOptions options = new ChromeOptions();
		File selectorHub = new File("D:\\CRX files\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
		File adblock = new File("D:\\CRX files\\uBlock-Origin-Chrome-Web-Store.crx");
		options.addExtensions(selectorHub);
		//options.addExtensions(adblock);
		driver = new ChromeDriver(options);
		driver.get("https://text-compare.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}	
}
