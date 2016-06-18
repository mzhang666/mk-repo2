package webTesting.test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.factory.LoginPage;
import page.factory.SearchPage;
import page.factory.ResultPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RedFinStepDefinition {
	
	
	protected WebDriver driver;	
	
	 @Before
	    public void setup() {
	        //driver = new FirefoxDriver();
		 	System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
		 	driver = new ChromeDriver();
	}
		
	@Given("^I open Redfin$")
	public void open_Redfin() {
		//Set implicit wait of 10 seconds and launch google
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.redfin.com/");
	}
	
	@When("^I log in using Username \"(.*)\" and password \"(.*)\"$")	
	public void log_in(String user, String pwd) throws Throwable{
		
		LoginPage loginpage = new LoginPage(driver);		
		loginpage.loginTo(user, pwd);
		System.out.println("pass login");
	}
	
		
	@When("^I search using address \"(.*)\"$")
	public void property_search(String address) {
		
		SearchPage searchpage = new SearchPage(driver);
		searchpage.search(address);		
		System.out.println("pass search");
	}
	
	@Then("^Property should show up \"(.*)\"$")
	public void verifyResult(String inputAddress) {
		ResultPage resultpage = new ResultPage(driver);
		resultpage.verify(inputAddress);
		System.out.println("pass result");
		
	}
	
	 @After
	    public void closeBrowser() {
		 	driver.close();
	        driver.quit();
	 }

}


