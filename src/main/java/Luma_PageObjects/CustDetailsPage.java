package Luma_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class CustDetailsPage extends AbstractClass{

	WebDriver driver;

	public CustDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[id='customer-email']")
	WebElement emailField;

	@FindBy(css="[name*='firstname']:last-of-type")
	WebElement fName;

	@FindBy(css="[name*='lastname']:last-of-type")
	WebElement lName;

	@FindBy(css="[class*='street'] [name*='shippingAddress'] [class='control'] [class*='text']")
	WebElement address;

	@FindBy(css="[name*='city'] [class='control'] [class*='text']")
	WebElement city;

	@FindBy(css="[name*='region_id'] [class='control'] [class='select']")
	WebElement stateDropdown;

	@FindBy(css="[name*='postcode'] [class='control'] [class*='text']")
	WebElement zipCode;

	@FindBy(css="[name*='country_id'] [class='control'] [class='select']")
	WebElement countryDropdown;

	@FindBy(css="[name*='telephone'] [class*='control'] [class*='text']")
	WebElement phnNo;

	@FindBy(css = "[class='radio']")
	WebElement shippingMethod;
	
	@FindBy(css="[class*='continue']")
	WebElement nextBtn;
	
	public ReviewPage custDetails() {
		waitForElement(emailField);
		emailField.sendKeys("abc@g.com");
		waitForElement(fName);
		fName.sendKeys("A");
		lName.sendKeys("S");
		address.sendKeys("xyz");
		city.sendKeys("bang");
		dropDown(stateDropdown, "Alaska");
		zipCode.sendKeys("12345");
		//dropDown(countryDropdown, "India");
		phnNo.sendKeys("143");
		shippingMethod.click();
		nextBtn.click();
		return new ReviewPage(driver);
	}

}
