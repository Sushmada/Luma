package Luma_PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class HomePage extends AbstractClass{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Create an Account")
	WebElement createAccount;
	
	@FindBy(partialLinkText="Sign In")
	WebElement signIn;
	
	public CreateAccountPage createAccount()
	{
		waitForElement(createAccount);
		createAccount.click();
		return new CreateAccountPage(driver);
	}
	
	public SignInPage signIn()
	{ 
		waitForElement(signIn);
		signIn.click();
		return new SignInPage(driver);
	}
	
	public String homeUrl()
	{
		return driver.getCurrentUrl();
	}

}
