package Luma_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class ReviewPage extends AbstractClass {
	
	WebDriver driver;
	
	public ReviewPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[class*='checkout']")
	WebElement placeOrder;
	
	@FindBy(css="[class*='opc-block']")
	WebElement detailsBlock;
	
	@FindBy(css="[class*='items-in-cart']")
	WebElement cartItem;
	
	//@FindBy(css="[alt='Loading...']")
	//WebElement loading;
	
	public ConfirmationPage placeOrder() throws InterruptedException
	{
//		waitForElement(detailsBlock);
//		cartItem.click();
		Thread.sleep(7000);
		waitForElementToClick(placeOrder);
		placeOrder.click();
		return new ConfirmationPage(driver);
	}

}
