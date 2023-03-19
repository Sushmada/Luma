package Luma_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class CreateAccountPage extends AbstractClass {
	
	WebDriver driver;
	String alertMsg;
	
	public CreateAccountPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="firstname")
	WebElement fName;
	
	@FindBy(id="lastname")
	WebElement lName;
	
	@FindBy(id="email_address")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="password-confirmation")
	WebElement confirmPassword;
	
	@FindBy(css="[class*='submit']")
	WebElement createAccBtn;
	
	@FindBy(css="[role='alert'] div div")
	WebElement alert;
	
	public String CreateAcc(String Fname, String Lname, String Email, String pwd)
	{
		waitForElement(fName);
		fName.sendKeys(Fname);
		lName.sendKeys(Lname);
		email.sendKeys(Email);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(pwd);
		createAccBtn.click();
		waitForElement(alert);
		alertMsg = alert.getText();
		return alertMsg;
	}
	
}
