package BasicPackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Assignement_Static_WebTable {
	
	WebDriver driver;

	@Test
	public void a_SetUp() {
		driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void b_findFlight() {
		
		//departure city
		WebElement fromPort = driver.findElement(By.name("fromPort"));
		System.out.println("is dropdown is already selected : "+ fromPort.isSelected());
		Select fromPortIns = new Select(fromPort);
		fromPortIns.selectByValue("Paris");
		
		//destination city
		WebElement toPort = driver.findElement(By.name("toPort"));
		System.out.println("is dropdown is already selected : "+ toPort.isSelected());
		Select toPortIns = new Select(toPort);
		toPortIns.selectByValue("London");
		
		//findFlights
		driver.findElement(By.xpath("//input[@value=\"Find Flights\"]")).click();
	}
	
	@Test
	public void c_CheapestPrices() {
		List<WebElement> Rows = driver.findElements(By.xpath("//table[@class=\"table\"]/tbody/tr"));
		int numberOfRows = Rows.size();
		List<Double> listOfPrices = new ArrayList();
		for(int i=1;i<=numberOfRows;i++) {
			String prices = driver.findElement(By.xpath("//table[@class=\"table\"]/tbody/tr["+i+"]/td[6]")).getText();
			System.out.println(prices.substring(1));
			listOfPrices.add(Double.parseDouble(prices.substring(1)));
			
		}
		
		double lowestPrice =0.0; 
		for(int i=0;i<listOfPrices.size()-1;i++) {
			if(listOfPrices.get(i)<listOfPrices.get(i+1)) {
				lowestPrice=listOfPrices.get(i);
				
			}
		}
		System.out.println("Lowest price is : "+lowestPrice);
		
		for(int i=1;i<=numberOfRows;i++) {
		
			String price =driver.findElement(By.xpath("//table[@class=\"table\"]/tbody/tr["+i+"]/td[6]")).getText();
			String expected = "$"+lowestPrice;
			if(price.equals(expected)){
				
				WebElement chooseflight = driver.findElement(By.xpath("//table[@class=\"table\"]/tbody/tr["+i+"]/td[1]//input[@type=\"submit\"]"));
				chooseflight.click();
				break;
			}
			
		}
	}
	@Test
	public void d_form() {
		String succesMessage = driver.findElement(By.xpath("(//div[@class=\"container\"])[2]/h2")).getText();
		System.out.println(succesMessage);
		
		driver.findElement(By.id("inputName")).sendKeys("Aravind");
		driver.findElement(By.id("address")).sendKeys("abc apartments");
		driver.findElement(By.id("city")).sendKeys("chennai");
		driver.findElement(By.id("state")).sendKeys("tamil nadu");
		driver.findElement(By.id("zipCode")).sendKeys("600061");
		WebElement cardType = driver.findElement(By.id("cardType"));
		Select card = new Select(cardType);
		card.selectByValue("visa");
		driver.findElement(By.id("creditCardNumber")).sendKeys("44909293600061");
		
		driver.findElement(By.id("nameOnCard")).sendKeys("Aravind");
		driver.findElement(By.id("rememberMe")).click();
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	}

}
