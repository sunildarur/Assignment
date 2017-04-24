package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {
	private static WebDriver driver = null;
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.ie.driver","C:/Users/270509/Desktop/Sunil Darur/QE&A Assignment/Selenium jars/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/Assignment270509/BankLogin.jsp");
	}

	@When("^User Navigate to Login Page$")
	public void user_Navigate_to_Login_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^User enters Username and Password$")
	public void user_enters_Username_and_Password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("username")).sendKeys("sunil");
        driver.findElement(By.name("password")).sendKeys("sunil");
        driver.findElement(By.xpath("html/body/form/fieldset/table/tbody/tr[3]/td/input")).click();
	}

	@When("^User enters invalid Username and Password$")
	public void user_enters_invalid_Username_and_Password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("username")).sendKeys("sunil");
        driver.findElement(By.name("password")).sendKeys("suni");
        driver.findElement(By.xpath("html/body/form/fieldset/table/tbody/tr[3]/td/input")).click();
	}
	
	@When("^User doesnot enter FirstName$")
	public void User_doesnot_enter_FirstName() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("firstname")).sendKeys("Ravindra");
        driver.findElement(By.id("next")).click();
    }
	
	@When("^User enters Applicant Information$")
	public void User_enters_Applicant_Information() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
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
    }

	@Then("^Message displayed Login Successful$")
	public void message_displayed_Login_Successful() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(driver.findElement(By.id("appinfo")).getText().equalsIgnoreCase("Applicant Information")){
        	System.out.println("Login Successful");
        }else {
        	System.out.println("Login Failed");
        }
		driver.quit();
	}
	
	@Then("^Message displayed LoginApp Successful$")
	public void message_displayed_LoginApp_Successful() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(driver.findElement(By.id("appinfo")).getText().equalsIgnoreCase("Applicant Information")){
        	System.out.println("Login Successful");
        }
	}
	
	@Then("^Message displayed Please fill FirstName$")
	public void Message_displayed_Please_fill_FirstName() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(driver.findElement(By.id("firstname_error")).getText().equalsIgnoreCase("Please enter your First Name")){
        	System.out.println("Required Field Error Displayed for Firstname");
        }
	}
	
	@Then("^Message displayed Applicant Information Saved$")
	public void Message_displayed_Applicant_Information_Saved() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(driver.findElement(By.id("incpage")).getText().equalsIgnoreCase("Income Information")){
        	System.out.println("Applicant Information Filled Successfully");
        }
        driver.quit();
	}
	
	@Then("^Message displayed Login UnSuccessful$")
	public void message_displayed_Login_UnSuccessful() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(driver.findElement(By.id("invcred")).getText().equalsIgnoreCase("Invalid Credentials!")){
        	System.out.println("Login not Successful with Invalid Credentials");
        }else {
        	System.out.println("Login Failed");
        }
        driver.quit();
	}
}
