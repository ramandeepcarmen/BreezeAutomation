package com.carmensol;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.Status;
import com.carmensol.data.Data.LoginData;
import com.carmensol.data.Data.NewPolicyDetail;
import com.carmensol.data.Data.PolicyDetailData;
import com.carmensol.pages.LogIn;
import com.carmensol.utilities.TestListener;


public class BaseTest implements LoginData, PolicyDetailData, NewPolicyDetail{
	
		
		public WebDriver driver;
		public Properties prop;
		LogIn po = new LogIn(driver, TestListener.test);
		String screenShotPath =  System.getProperty("user.dir")+"\\Screenshot\\screen " +po.GetCurrentTimeStamp().replace(":","_").replace(".","_");
		 	
	@BeforeMethod
	public void setUp() 
	{ 		
	System.out.println("BeforeClass");
	try {
			prop = new Properties();
			FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\resources\\Configuration.properties");			
			prop.load(fs);		

	if (prop.getProperty("Browser_Name").equalsIgnoreCase("chrome"))
		{
		
			System.setProperty("webdriver.chrome.driver", prop.getProperty("Chrome_Exe"));
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.setExperimentalOption("useAutomationExtension", false);
			//options.addArguments("--user-data-dir=c:\\foo\\UserData");
			driver = new ChromeDriver(options);
			driver.get(prop.getProperty("URL"));
		
		} 
		else if (prop.getProperty("Browser_Name").equalsIgnoreCase("IE"))
		{ 		
			
			 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		     capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		     capabilities.setCapability("nativeEvents", false);    
		     capabilities.setCapability("unexpectedAlertBehaviour", "accept");
		     capabilities.setCapability("disable-popup-blocking", true);
		     capabilities.setCapability("enablePersistentHover", true);
	
			System.setProperty("webdriver.ie.driver", prop.getProperty("IE_exe"));
			driver = new InternetExplorerDriver();
			driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();
		} 	
		System.out.println("BeforeMethod");
		
		} 	
			
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	} 

	//@BeforeMethod
	public void Login()
	{
		System.out.println("BeforeMethod");
		
		try {
			Thread.sleep(1000);
			LogIn po = new LogIn(driver, TestListener.test);			  
			po.Login(USERNAME,PASSWORD);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			TestListener.test.log(Status.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

	@AfterMethod(alwaysRun = true) 
	public void Logout() throws IOException, InterruptedException
	{
		driver.close();
		Thread.sleep(1000);
		if(driver.getClass().getName().contains("Internet"))	
		driver.switchTo().alert().accept();
		driver.quit();
	}

	//@AfterTest
	public void afterMainMethod() 
	{ 
		System.out.println("AfterTest");		
		driver.quit();
	
	
	}

}
