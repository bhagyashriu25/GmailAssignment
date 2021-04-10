package stepDefinations;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pages.Compose;
import runner.TestBase;

/**
 * Unit test for simple App.
 */
public class ComposeSteps 
    
{
WebDriver driver;
Compose comp;
@Given("User is on login screen and user login to gmail.")
public void user_is_on_login_screen_and_user_login_to_gmail() throws MalformedURLException, InterruptedException {
	// System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
     //driver = new FirefoxDriver();
     
     System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
     driver = new ChromeDriver();

     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     String url="https://www.gmail.com";
     driver.get(url);
     Thread.sleep(500);
     
     comp=new Compose(driver);
     comp.login("bhagyashri@gmail.com","test");
    
	  
   


}

@When("User send message without recipient")
public void user_send_message_without_recipient() {
    comp.sendMailwithoutReceipient();
}

@Then("Validation message should displayed to user.")
public void validation_message_should_displayed_to_user() {
   Assert.assertEquals("Please specify at least one recipient.", comp.verifymessage());
}
@When("User sends an email to {string} with subject {string} and boby {string}")
public void user_sends_an_email_to_with_subject_and_boby(String email, String sub, String bodyEmail) {
    comp.sendEmail(email, sub, bodyEmail);
    System.out.println("Email sent successfully");
}

@Then("Email appears in the sent folder of gmail with subject {string}")
public void email_appears_in_the_sent_folder_of_gmail_with_subject(String msg) {
    comp.verifySendEmail(msg);
}
}
