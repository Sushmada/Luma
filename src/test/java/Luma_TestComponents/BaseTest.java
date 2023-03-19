package Luma_TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Luma_PageObjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public HomePage homepage;
	
	public WebDriver initializeBrowser() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Resources//resources.properties");
		prop.load(fis);
		
		String browserName = System.getProperty("browser")!= null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		}
		
		else if (browserName.contains("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		else if (browserName.contains("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
			
	}
	
	@BeforeTest
	public void initializeApp() throws IOException
	{
		driver=initializeBrowser();
		driver.get("https://magento.softwaretestingboard.com/");
		homepage = new HomePage(driver);
	}
	
	@AfterTest
	public void closeApp()
	{
		driver.quit();
	}
	
	public String getScreenshot(String testcaseName) throws IOException
	{
		TakesScreenshot shot = (TakesScreenshot)driver;
		File src = shot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//Screenshots"+testcaseName+".png");
		FileUtils.copyFile(src, dest);
		
		return System.getProperty("user.dir")+"//Screenshots"+testcaseName+".png";
	}
	
	public List<HashMap<String, String>> getJsonData(File filePath) throws IOException
	{
		String jsonData = FileUtils.readFileToString(filePath, StandardCharsets.UTF_8);
		ObjectMapper map = new ObjectMapper();
		List<HashMap<String, String>> data = map.readValue(jsonData, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}

}
