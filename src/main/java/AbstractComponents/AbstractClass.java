package AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Luma_PageObjects.CustDetailsPage;
import Luma_PageObjects.HomePage;
import Luma_PageObjects.ItemListPage;
import Luma_PageObjects.MyAccountPage;

public class AbstractClass {

	WebDriver driver;

	public AbstractClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class*='showcart']")
	WebElement cart;

	@FindBy(css = "[id*='checkout']")
	WebElement checkOut;
	
	@FindBy(id="search")
	WebElement searchField;
	
	@FindBy(css="[id*='qs-option']")
	List<WebElement> options;

	@FindBy(css="button[class*='switch']")
	WebElement dropdown;
	
	@FindBy(partialLinkText="Sign Out")
	WebElement signOut;
	
	@FindBy(partialLinkText="My Account")
	WebElement myAccount; 
	
	public HomePage signOut()
	{
		dropdown.click();
		signOut.click();
		return new HomePage(driver);
	}
	
	public MyAccountPage myAccount()
	{
		dropdown.click();
		myAccount.click();
		return new MyAccountPage(driver);
	}
	
	
	public ItemListPage searchItems() throws InterruptedException
	{
		searchField.sendKeys("tshirt");
		waitForListOfElement(options);
		options.get(0).click();
		Thread.sleep(5000);
		return new ItemListPage(driver);
	}
	
	public void waitForElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}

	public void waitForElementToInvisible(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}

	public void waitForListOfElement(List<WebElement> elements) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		
	}

	public void waitForElementLocator(By element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void waitForElementToClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

	public CustDetailsPage clickOnCart() throws InterruptedException {
		//waitForElement(cart);
		Thread.sleep(3000);
		cart.click();
		waitForElement(checkOut);
		checkOut.click();
		return new CustDetailsPage(driver);
	}

	public void dropDown(WebElement ele, String text) {
		Select dropDown = new Select(ele);
		dropDown.selectByVisibleText(text);

	}
	
	public void scrollDropdown(WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript()
		
	}

}
