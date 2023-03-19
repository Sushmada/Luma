package Luma_Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
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

public class SignIn_Excel_Test extends BaseTest {
	
	ArrayList<String> email = new ArrayList<String>();
	ArrayList<String> password = new ArrayList<String>();
	
	@Test(dataProvider="getDataSignIn")
	public void SignIn(String e) throws InterruptedException
	{
		SoftAssert softAssert = new SoftAssert();
		SignInPage signIn = homepage.signIn();
		String greeting = signIn.signIn(e, "sushshay@143");
		String name = signIn.MyAcc();
		softAssert.assertEquals(greeting, "Welcome, "+name+"!");
		HomePage url = signIn.signOut();
		//softAssert.assertEquals(url,"https://magento.softwaretestingboard.com/customer/account/logoutSuccess/");
		softAssert.assertAll();
	}
	/*
	@DataProvider
	public Object getDataSignIn() throws IOException 
	{
		DataFormatter formatter = new DataFormatter();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\W10-Lenovo\\Downloads\\login_data.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("login");
		int rows = sheet.getPhysicalNumberOfRows();
		XSSFRow rowVal = sheet.getRow(0);
		int cols = rowVal.getLastCellNum();
		
		Object[][] data = new Object[rows-1][cols];
		for(int i=0; i<rows-1; i++)
		{
			rowVal = sheet.getRow(i+1);
			for(int j=0; j<cols; j++)
			{
				//data[i][j]=rowVal.getCell(j).getStringCellValue();
				data[i][j]=formatter.formatCellValue(rowVal.getCell(j));
			}
		}
		return data;
	}
*/
	
	@DataProvider(name="getDataSignIn")
	public Object[] getDataSignIn() throws IOException 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\W10-Lenovo\\Downloads\\login_data.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("login");
		Iterator<Row> rowIterator = sheet.iterator();
		
	//	Object[][] data = {{email},{password}};
		Object[] data = {email};
		while(rowIterator.hasNext())
		{
			Row firstCol = rowIterator.next();
			if(firstCol.getCell(0).getStringCellValue().equalsIgnoreCase("email"))
			{
				Iterator<Cell> emailVals = firstCol.cellIterator();
				emailVals.next();
				while(emailVals.hasNext())
				{
					email.add(emailVals.next().getStringCellValue());
				}
			}
/*			if(firstCol.getCell(0).getStringCellValue().equalsIgnoreCase("password"))
			{
				Iterator<Cell> passwordVals = firstCol.cellIterator();
				while(passwordVals.hasNext())
				{
					password.add(passwordVals.next().getStringCellValue());
				}
			} */
		}
		return data;
		
	}
}
