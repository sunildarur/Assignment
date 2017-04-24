package cucumberTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class EndtoEndTest {

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
        driver.findElement(By.name("password")).sendKeys("sunil");
        driver.findElement(By.xpath("html/body/form/fieldset/table/tbody/tr[3]/td/input")).click();         
        //Verify Successful Login
        if(driver.findElement(By.id("appinfo")).getText().equalsIgnoreCase("Applicant Information")){
        	System.out.println("Login Successful with Valid Credentials");
        }
        //Fill Applicant Info Error Scenarios
        driver.findElement(By.id("firstname")).sendKeys("Ravindra");
        driver.findElement(By.id("next")).click();
        if(driver.findElement(By.id("firstname_error")).getText().equalsIgnoreCase("Please enter your First Name")){
        	System.out.println("Required Field Error Displayed for Firstname");
        }
        //Fill Applicant Valid Info
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys("Ravindra");
        driver.findElement(By.id("middlename")).sendKeys("Kumar");
        driver.findElement(By.id("lastname")).sendKeys("Darur");
        driver.findElement(By.id("address")).sendKeys("735 Mallard Ln");
        driver.findElement(By.id("addressline2")).sendKeys("Apt 1C");
        driver.findElement(By.id("city")).sendKeys("Chicago");
        driver.findElement(By.id("state")).sendKeys("IL");
        driver.findElement(By.id("zipcode")).sendKeys("60090");
        driver.findElement(By.id("next")).click();
        if(driver.findElement(By.id("incpage")).getText().equalsIgnoreCase("Income Information")){
        	System.out.println("Applicant Information Filled Successfully");
        }
        driver.quit();
	
	}

}
