package BasicPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicTables {
	WebDriver driver;

	@Test
	public void a_SetUp() {
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void b_paginationTable() throws InterruptedException {
		//pagination size
		List<WebElement> pages = driver.findElements(By.xpath("//div[@class=\"table-container\"]//ul/li/a"));
		System.out.println(pages.size());

		
		//getting element
		System.out.println("pages.size()"+ pages.size());
		for(int i=1;i<=pages.size();i++) {
			
			//row size may change in the last page , so we find row inside loop
			List rows = driver.findElements(By.xpath("//table[@id=\"productTable\"]//tr"));
			int rowSize = rows.size();
			System.out.println("rowSize "+rowSize);
			
			for(int j=1;j<=rowSize-1;j++) {
				//getting product list
				WebElement products = driver.findElement(By.xpath("//table[@id=\"productTable\"]//tr["+j+"]/td[2]"));
				System.out.println(products.getText());
				
				//clicking checkboxes
				WebElement checkBox = driver.findElement(By.xpath("//table[@id=\"productTable\"]//tr["+j+"]/td[4]/input"));
				checkBox.click();
			}
			
			//in page number one we have to click page number two also in page no four we don't want to click any page.
			int a=i+1;
			if(a<=pages.size()) {
				WebElement page = driver.findElement(By.xpath("//div[@class=\"table-container\"]//ul/li/a[text()="+a+"]"));
				
				System.out.println(i);
				page.click();
			}	
		}
	}
	
}
