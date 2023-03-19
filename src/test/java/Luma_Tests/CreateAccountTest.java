package Luma_Tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Luma_PageObjects.CreateAccountPage;
import Luma_TestComponents.BaseTest;
import Luma_TestComponents.Retry;

public class CreateAccountTest extends BaseTest {
	
	String alert;
	
	@Test(dataProvider="getData", retryAnalyzer=Retry.class)
	public void CreateAccount(HashMap<String, String> input)
	{
		CreateAccountPage createAcc = homepage.createAccount();
		alert = createAcc.CreateAcc(input.get("firstName"), input.get("lastName"), input.get("emailAddress"), input.get("password"));
		Assert.assertTrue(alert.contains("There is already an account with this email address. If you are sure that it is your email address"));
	}
	
	@DataProvider
	public Object[] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonData(new File(System.getProperty("user.dir")+"\\src\\test\\java\\Luma_data\\CreateAccountData.json"));
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
	
	
}
