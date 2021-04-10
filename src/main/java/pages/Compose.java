package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Hello world!
 *
 */
public class Compose 
{
	WebDriver driver;
    @FindBy(name="identifier")
    WebElement username;
    
    
    
    @FindBy(className="VfPpkd-RLmnJb")
    WebElement nextBtn;
    
    @FindBy(name="password")
    WebElement password;
    
    
    @FindBy(className="T-I T-I-KE L3")
    WebElement composebtn;
    
    

    @FindBy(className="T-I J-J5-Ji aoO v7 T-I-atl L3")
    WebElement sendBtn;
    
    @FindBy(xpath="//textarea[@name='to']")
    WebElement to;
  
    @FindBy(xpath="//input[@name='subjectbox']")
    WebElement subject;
    
    @FindBy(xpath="//div[@class='Am Al editable LW-avf']")
    WebElement body;
    
    @FindBy(className="J-Ke n0")
    WebElement sentLink;
    
    @FindBy(className="bog")
    List<WebElement> sentSubject;
    
    public Compose(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    public void login(String un, String pwd)
    {
    	username.sendKeys(un);
    	nextBtn.click();
    	password.sendKeys(pwd);
    	nextBtn.click();
    }
    
    public void sendMailwithoutReceipient()
    {
    	composebtn.click();
    	sendBtn.click();
    }
    public String verifymessage()
    {
    	String msg=driver.switchTo().activeElement().getText();
    	return msg;
    	
    }
    public void sendEmail(String email,String sub,String bobyEmail)
    {
    	to.sendKeys(email);
    	subject.sendKeys(sub);
    	body.sendKeys(bobyEmail);
    	sendBtn.click();
    }
    public void verifySendEmail(String bodymsg)
    {
    	sentLink.click();
    	for (WebElement element : sentSubject) {
    		if (element.getText().equalsIgnoreCase(bodymsg))
    		{
    			System.out.println("Email found in sentbox");
    		}
    	}
    }
}
