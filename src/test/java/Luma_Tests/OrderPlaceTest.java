package Luma_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Luma_PageObjects.ConfirmationPage;
import Luma_PageObjects.CustDetailsPage;
import Luma_PageObjects.HomePage;
import Luma_PageObjects.ItemListPage;
import Luma_PageObjects.ProdDetailsPage;
import Luma_PageObjects.ReviewPage;
import Luma_TestComponents.BaseTest;
import Luma_TestComponents.Retry;

public class OrderPlaceTest extends BaseTest{
	
	String confirmMsg;
	
	@Test(retryAnalyzer=Retry.class)
	public void placeOder() throws InterruptedException
	{
		ItemListPage itemlist = homepage.searchItems();
		ProdDetailsPage prodDetails = itemlist.selectProd();
		CustDetailsPage custDetails = prodDetails.selectProdDetails();
		ReviewPage reviewPage = custDetails.custDetails();
		ConfirmationPage confirmationPage = reviewPage.placeOrder();
		confirmMsg = confirmationPage.confirmOrder();
		Assert.assertEquals(confirmMsg, "Thank you for your purchase!");
	}

}
