package Luma_Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Luma_PageObjects.HomePage;
import Luma_PageObjects.SignInPage;
import Luma_TestComponents.BaseTest;

public class SignInTest extends BaseTest {
	
	@Test(dataProvider="getDataSignIn")
	public void SignIn(HashMap<String, String> input) throws InterruptedException
	{
		SoftAssert softAssert = new SoftAssert();
		SignInPage signIn = homepage.signIn();
		String greeting = signIn.signIn(input.get("Email"), input.get("Password"));
		String name = signIn.MyAcc();
		softAssert.assertEquals(greeting, "Welcome, "+name+"!");
		HomePage url = signIn.signOut();
		//softAssert.assertEquals(url,"https://magento.softwaretestingboard.com/customer/account/logoutSuccess/");
		softAssert.assertAll();
	}
	
	@DataProvider(name="getDataSignIn")
	public Object[][] getDataSignIn() throws IOException 
	{
		List<HashMap<String, String>> data = getJsonData(new File(System.getProperty("user.dir")+"\\src\\test\\java\\Luma_data\\LoginData.json"));
		return new Object[][] {{data.get(0)}, {data.get(1)}};
		
		
	}

}
