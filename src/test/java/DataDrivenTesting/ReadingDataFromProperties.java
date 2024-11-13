package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ReadingDataFromProperties {
	WebDriver driver;
	@Test
	public void test() throws IOException {
		//Opening file in Reading form
		FileInputStream  fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\DataDrivenTesting\\TestData\\Congurations.properties");
		
		//create object for Properties class
		Properties prp = new Properties();
		
		//this statement will load the file
		prp.load(fis);
		
		//Reading data from properties
		System.out.println(prp.getProperty("Browser"));
		
		//close
		fis.close();
	}
}
