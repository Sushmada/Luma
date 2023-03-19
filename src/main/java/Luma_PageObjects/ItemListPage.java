package Luma_PageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class ItemListPage extends AbstractClass {

	WebDriver driver;

	public ItemListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class='product-item-info']")
	List<WebElement> products;
	
	By prodImg = By.cssSelector("[class*='product-image']");
	
	public ProdDetailsPage selectProd() {
		//waitForListOfElement(products);
		waitForElementLocator(prodImg);
		List<WebElement> s = products.stream()
				.filter(a -> a.findElement(By.cssSelector("[class='price']")).getText().contains("22"))
				.collect(Collectors.toList());
		s.get(0).findElement(prodImg).click();
		// .map(s -> s.findElement(By.cssSelector("[type='submit']")).click());
		return new ProdDetailsPage(driver);
	}

}
