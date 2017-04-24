

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.WebElement;

import org.junit.Before;

public class LoginPageJunit {

	private static InternetExplorerDriver driver;
	WebElement element;
	
	@Before
	public void openBrowser() {
		System.setProperty("webdriver.ie.driver","C:/Users/270509/Desktop/Sunil Darur/QE&A Assignment/Selenium jars/IEDriverServer.exe"); 
 		driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

	@Test
	public void ValidLogin() {
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
        driver.get("http://localhost:8080/SampleServlet/BankLogin.jsp");
        driver.findElement(By.name("username")).sendKeys("sunil");
        driver.findElement(By.name("password")).sendKeys("sunil");
        driver.findElement(By.xpath("/html/body/form/fieldset/table/tbody/tr[3]/td/input")).click();         
        try{
			 element = driver.findElement(By.xpath("//*[contains(text(), 'Applicant Information')]"));
			 //Assert.assertTrue("Login Successful", true);
		 }catch (Exception e){
			}
	     Assert.assertNotNull(element);
	     System.out.println("Login Successful with Valid Test Data ");
	     System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@Test
    public void invalid_testlogin() {
		 System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	     driver.get("http://localhost:8080/SampleServlet/Hello.jsp");
	     driver.findElement(By.name("email")).sendKeys("sunil@g.com");
	     driver.findElement(By.name("pass")).sendKeys("sunil");
	     driver.findElement(By.xpath("/html/body/form/fieldset/table/tbody/tr[3]/td/input")).click();         
	     try{
	    	 element = driver.findElement(By.id("welcome"));
	    	 //Assert.assertTrue("Login Failed", false);
	     }catch (Exception e){
			}
	     Assert.assertNull(element);
	     System.out.println("Login not Successful with InValid Test Data ");
	     System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }
	
	@After
	 public static void closeBrowser(){
		 driver.quit();
	 }
}
