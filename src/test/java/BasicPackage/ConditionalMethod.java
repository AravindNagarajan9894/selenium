package BasicPackage;
import java.util.Arrays;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
public class ConditionalMethod {

	public static void main(String[] args) throws Exception{
		WebDriver driver = new ChromeDriver();
//		driver.get("https://demoqa.com/text-box");
//		driver.manage().window().maximize();
//		WebElement fullName = driver.findElement(By.id("userName"));
//		if(fullName.isDisplayed() && fullName.isEnabled() ) {
//			fullName.sendKeys("Aravind");
//		}
//		
//		//Email
//		WebElement emailId= driver.findElement(By.xpath("//input[@id=\"userEmail\"]"));
//		if(emailId.isDisplayed()&&emailId.isEnabled()) {
//			emailId.sendKeys("aravind@gmail.com");
//		}
//		
//		//currentAddress
//		WebElement currentAddress = driver.findElement(By.id("currentAddress"));
//		if(currentAddress.isDisplayed()&& currentAddress.isEnabled()) {
//			currentAddress.sendKeys("no 7, sri ganesh appartments, nanganallur");
//		}
//		
//		//permanentAddress
//		WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
//		if(permanentAddress.isDisplayed() && permanentAddress.isEnabled()) {
//			permanentAddress.sendKeys("no 7, sri ganesh appartments, nanganallur");
//		}
//		
//		Thread.sleep(6000);
//		//id="submit"
//		driver.findElement(By.id("submit")).click();
//		
//		WebElement staticKey = driver.findElement(By.xpath("//h1[text()='Text Box']"));
//		System.out.println(staticKey.isEnabled());
	
		driver.get("https://demoqa.com/radio-button");
		driver.manage().window().maximize();
		
		
		boolean [] isRadioButtonsSelected = new boolean[3];
		isRadioButtonsSelected[0] = driver.findElement(By.id("yesRadio")).isSelected();
		isRadioButtonsSelected[1] = driver.findElement(By.id("impressiveRadio")).isSelected();
		isRadioButtonsSelected[2] = driver.findElement(By.id("noRadio")).isSelected();
		
		System.out.println(Arrays.toString(isRadioButtonsSelected));
		Thread.sleep(4000);
		WebElement yesRadio = driver.findElement(By.xpath("//input[@id=\"yesRadio\"]"));
		yesRadio.click();
		System.out.println("yes radio is selected");
		isRadioButtonsSelected[0] = driver.findElement(By.id("yesRadio")).isSelected();
		isRadioButtonsSelected[1] = driver.findElement(By.id("impressiveRadio")).isSelected();
		isRadioButtonsSelected[2] = driver.findElement(By.id("noRadio")).isSelected();
		System.out.println(Arrays.toString(isRadioButtonsSelected));
		
		driver.findElement(By.xpath("//label[@for=\"impressiveRadio\"]")).click();
		System.out.println("impressiveRadio is selected");
		isRadioButtonsSelected[0] = driver.findElement(By.id("yesRadio")).isSelected();
		isRadioButtonsSelected[1] = driver.findElement(By.id("impressiveRadio")).isSelected();
		isRadioButtonsSelected[2] = driver.findElement(By.id("noRadio")).isSelected();
		System.out.println(Arrays.toString(isRadioButtonsSelected));
		
		WebElement noRadio = driver.findElement(By.xpath("//label[@for=\"noRadio\"]"));
		if(noRadio.isEnabled()) {
			noRadio.click();
			System.out.println("no radio is selected");
			isRadioButtonsSelected[0] = driver.findElement(By.id("yesRadio")).isSelected();
			isRadioButtonsSelected[1] = driver.findElement(By.id("impressiveRadio")).isSelected();
			isRadioButtonsSelected[2] = driver.findElement(By.id("noRadio")).isSelected();
			System.out.println(Arrays.toString(isRadioButtonsSelected));
		}
		else {
			System.out.println("No radio button is disabled");
		}
		
		
	}

}
