package Luma_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class SignInPage extends AbstractClass {

	WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="pass")
	WebElement password; 
	
	@FindBy(id="send2")
	WebElement signIn;
	
	@FindBy(css="[class='logged-in']")
	WebElement greeting;
	
	public String signIn(String Email, String pwd) throws InterruptedException
	{
		waitForElement(email);
		email.sendKeys(Email);
		password.sendKeys(pwd);
		signIn.click();
		//waitForElement(greeting);
		Thread.sleep(2000);
		String greetingMsg = greeting.getText();
		return greetingMsg;
	}

	public String MyAcc()
	{
		MyAccountPage myAcc = myAccount();
		return myAcc.getGreetingName();
	}
	
	public String SignOut()
	{
		HomePage home = signOut();
		return home.homeUrl();
	}
}
