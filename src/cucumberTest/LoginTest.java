package cucumberTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LoginTest {
	private static WebDriver driver = null;
	//static WebElement element;
	public static void main(String[] args) {
		// Initialization
		System.setProperty("webdriver.ie.driver","C:/Users/270509/Desktop/Sunil Darur/QE&A Assignment/Selenium jars/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/Assignment270509/BankLogin.jsp");
		//Login Page
		driver.findElement(By.name("username")).sendKeys("sunil");
        driver.findElement(By.name("password")).sendKeys("sunil");
        driver.findElement(By.xpath("html/body/form/fieldset/table/tbody/tr[3]/td/input")).click();         
        //driver.findElement(By.xpath("html/body/form/fieldset/legend"));
        //element = driver.findElement(By.xpath("//*[contains(text(), 'Applicant Information')]"));
        if(driver.findElement(By.id("appinfo")).getText().equalsIgnoreCase("Applicant Information")){
        	System.out.println("Login Successfully");
        }else {
        	System.out.println("Login Failed");
        }
        driver.quit();
	}

}
