package Luma_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class ProdDetailsPage extends AbstractClass{
	
	WebDriver driver;
	
	public ProdDetailsPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[id*='size']:nth-child(2)")
	WebElement size;
	
	@FindBy(css="[id*='color']:nth-child(3)")
	WebElement color;
	
	@FindBy(id="qty")
	WebElement quantity;
	
	@FindBy(id="product-addtocart-button")
	WebElement addToCart;
	
	@FindBy(css="[role='alert']")
	WebElement toastMsg;
	
	public CustDetailsPage selectProdDetails() throws InterruptedException
	{
		waitForElement(size);
		size.click();
		color.click();
		quantity.clear();
		quantity.sendKeys("7");
		addToCart.click();
		waitForElement(toastMsg);
		boolean alert = toastMsg.isDisplayed();
		return clickOnCart();
	}

}
