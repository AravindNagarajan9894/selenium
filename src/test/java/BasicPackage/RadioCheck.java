package BasicPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement maleRadio = driver.findElement(By.xpath("//input[@id=\"male\"]"));
		boolean maleRadioStatus = maleRadio.isSelected();
		if(!maleRadioStatus) {
			maleRadio.click();
		}

	}

}
