package BasicPackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice {
	public static void main(String [] args)
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //navigate to
        driver.navigate().to("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.xpath("//button[text()='New Browser Window']")).click();

       Set<String> windowIds = driver.getWindowHandles();
       List<String> windowIdList = new ArrayList<>(windowIds);
       driver.switchTo().window(windowIdList.get(1));
       try{
    	   
    	   for(String id : windowIds){
    		   String title = driver.switchTo().window(id).getTitle();
               if(title.equals("Your Store")){
                   String url = driver.getCurrentUrl();
                   System.out.println(url);
               }
           }
//           if(driver.getTitle().equals("Your Store")){
//               String url = driver.getCurrentUrl();
//               System.out.println(url);
//           }
       }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
     
//       driver.switchTo().window(windowIdList.get(0));
//       
//       driver.navigate().back();
//       
//       //filling form
//	     driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("Aravind");
//	     WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
//	
//	     WebElement email = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"userEmail\"]")));
//	     email.sendKeys("aravind.n@worktual.com");
//	    
//	     try 
//	     {
//	    	 driver.findElement(By.xpath("//input[@id='currentAddress']")).sendKeys("test currentAddress");
//		     driver.findElement(By.xpath("//input[@id='permanentAddress']")).sendKeys("Test permanentAddress");
//	    	 WebElement submit = waits.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
//		     submit.click();
//	     }
//	     catch(Exception e) {
//	    	 e.getMessage();
//	     }
	     System.out.println("Code Sucessfully runs");

       
    }

}
