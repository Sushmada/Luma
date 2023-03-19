package Luma_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class ConfirmationPage extends AbstractClass{
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[class='base']")
	WebElement confirmMsg;
	
	public String confirmOrder() throws InterruptedException {
		//waitForElement(confirmMsg);
		Thread.sleep(3000);
		return confirmMsg.getText();
	}

}
