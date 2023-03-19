package StepDefinition;

import java.io.IOException;

import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import Luma_PageObjects.ConfirmationPage;
import Luma_PageObjects.CreateAccountPage;
import Luma_PageObjects.CustDetailsPage;
import Luma_PageObjects.ItemListPage;
import Luma_PageObjects.ProdDetailsPage;
import Luma_PageObjects.ReviewPage;
import Luma_PageObjects.SignInPage;
import Luma_TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImplemention extends BaseTest {
	
	ConfirmationPage confirmationPage;
	SignInPage signIn;
	String greeting;
	String alert;
	String confirmMsg;
	SoftAssert softAssert = new SoftAssert();
	
	@Given("I landed on the Home page")
	public void i_landed_on_the_Home_page() throws IOException
	{
		initializeApp();
	}
	
	@When("^I logged in to the app with email (.+) and password (.+)$")
	public void i_logged_in_to_the_app_with_email_and_password(String email, String password) throws InterruptedException
	{
		signIn = homepage.signIn();
		greeting = signIn.signIn(email, password);
	}
	
	@When("^I create an account giving firstname (.+), lastname (.+), email (.+) and password (.+) which already exists$")
	public void i_create_an_account_giving_firstname_lastname_email_password_which_already_exists(String firstname, String lastname, String email, String password)
	{
		CreateAccountPage createAcc = homepage.createAccount();
		alert = createAcc.CreateAcc(firstname, lastname, email, password);
	}
	
	@When("I place order")
	public void i_place_order() throws InterruptedException
	{
		ItemListPage itemlist = homepage.searchItems();
		ProdDetailsPage prodDetails = itemlist.selectProd();
		CustDetailsPage custDetails = prodDetails.selectProdDetails();
		ReviewPage reviewPage = custDetails.custDetails();
		confirmationPage = reviewPage.placeOrder();
	}
	
	@Then("Greeting message {string} is displayed")
	public void greeting_message_is_displayed(String string)
	{
		signIn.MyAcc();
		softAssert.assertTrue(greeting.contains(string));
		softAssert.assertAll();
		driver.close();
	}
	
	@Then("Alert Message {string} should be displayed")
	public void alert_message_should_be_displayed(String string)
	{
		Assert.assertTrue(alert.contains("There is already an account with this email address. If you are sure that it is your email address"));
		driver.close();
	}
	
	@Then("Confirmation message {string} is displayed")
	public void confirmation_message_is_displayed(String string) throws InterruptedException
	{
		confirmMsg = confirmationPage.confirmOrder();
		Assert.assertEquals(confirmMsg, "Thank you for your purchase!");
		driver.close();
	}
	
}
