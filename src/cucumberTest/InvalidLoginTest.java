package cucumberTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InvalidLoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		// Initialization
		System.setProperty("webdriver.ie.driver","C:/Users/270509/Desktop/Sunil Darur/QE&A Assignment/Selenium jars/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/Assignment270509/BankLogin.jsp");
		//Login Page
		driver.findElement(By.name("username")).sendKeys("sunil");
        driver.findElement(By.name("password")).sendKeys("suni");
        driver.findElement(By.xpath("html/body/form/fieldset/table/tbody/tr[3]/td/input")).click();         
        //Verify Successful Login
        if(driver.findElement(By.id("invcred")).getText().equalsIgnoreCase("Invalid Credentials!")){
        	System.out.println("Login not Successful with Invalid Credentials");
        }else {
        	System.out.println("Login Failed");
        }
        driver.quit();
	
	}

}
