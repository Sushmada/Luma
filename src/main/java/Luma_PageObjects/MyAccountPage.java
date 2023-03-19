package Luma_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class MyAccountPage extends AbstractClass {
	
	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Edit")
	WebElement edit;
	
	@FindBy(id="lastname")
	WebElement lstName;
	
	@FindBy(id="firstname")
	WebElement frstName;
	
	@FindBy(className="logged-in")
	WebElement welcomeMsg;
	
	public String getGreetingName()
	{
		edit.click();
		String Fname = frstName.getAttribute("value");
		String Lname = lstName.getAttribute("value");
		String name = Fname+" "+Lname;
		return name;
	}
	

}
