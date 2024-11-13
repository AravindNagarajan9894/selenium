package BasicPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



//Assignment
//1) Handle country dropdown with/without using Select class:
//https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/
//a) count total number of options.
//b) print all the options
//c) select one option

public class Assignment_CheckBox_2 {
	
	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void a_setUp() {
		driver = new ChromeDriver();
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
	}
	@Test
	public void b_checkBox() {
		WebElement country = driver.findElement(By.id("country-list"));
		Select chk = new Select(country);
		
		List<WebElement> options =chk.getOptions();
		System.out.println("Total number of options is :"+ options.size());
		
		for(int i=0;i<options.size();i++){
			System.out.println(options.get(i).getText());
		} 
		chk.selectByValue("2");
	}

}
