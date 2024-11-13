package BasicPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment_CheckBox {

	WebDriver driver;
	@Test
	public void a_setup() {
		driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
	}
	@Test
	public void b_SelectAllCheckBox() {
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//table[@id=\"productTable\"]/tbody/descendant::td/input[@type=\"checkbox\"]"));
		for(WebElement checkBox : checkBoxes) {
			checkBox.click();
		}
		System.out.println("b_SelectAllCheckBox Finish");
	}
	@Test
	public void c_SelectLastThreeCheckBox() {
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//table[@id=\"productTable\"]/tbody/descendant::td/input[@type=\"checkbox\"]"));
		
		
//		for(WebElement checkBox: checkBoxes) {
//			if(checkBox.isSelected()) {
//				checkBox.click();
//			}
//		}
//		for(int i=2;i<checkBoxes.size();i++) {
//			checkBoxes.get(i).click();
//		}
		
		for(int i=0;i<checkBoxes.size();i++) {
			if(i>=0 && i<=1) {
				if(checkBoxes.get(i).isSelected()) {
					checkBoxes.get(i).click();
				}
			}
		}
		System.out.println("c_SelectLastThreeCheckBox Finish");
	}
	
	@Test
	public void d_selectFirtThirdFifthCheckBox() {
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//table[@id=\"productTable\"]/tbody/descendant::td/input[@type=\"checkbox\"]"));
		
		for(int i=0;i<checkBoxes.size();i++) {
			if(i%2==0) {
				if(checkBoxes.get(i).isSelected()) {
					continue;
				}
				else {
					checkBoxes.get(i).click();
				}
			}
			else {
				if(checkBoxes.get(i).isSelected()) {
					checkBoxes.get(i).click();
				}
			}
		}
		
	}
	
}
