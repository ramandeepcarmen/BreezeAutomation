package com.carmensol.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.carmensol.utilities.TestListener;
import com.carmensol.utilities.utility1;

public class LogIn extends utility1

{

	
	public static ExtentReports report;
	public ExtentTest test;
	public Properties prop;
	
	public LogIn(WebDriver driver, ExtentTest test) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.test = test;

	}
	
	@FindBy(how = How.CSS, using = "input[type='text']") public WebElement Username;
	@FindBy(how = How.CSS, using = "input[type='password']") public WebElement Password;
	@FindBy(how = How.CSS, using = "button#loginButton") public WebElement Login;
	@FindBy(how = How.CSS, using = "img[src='../../assets/Images/policy.png']") public WebElement PolicyLogo;
	@FindBy(how = How.CSS, using = "") public WebElement Logout;
	@FindBy(how = How.XPATH, using = "//*[@id='mainForm']/form/div/ng-transclude/transaction-history-section/div[2]/div[1]/a") public WebElement TransactionHistoryLink;
	
	
	public void Login(String data, String data1)
	{
		
		try {	
			
			sendKeys(Username, data);
			sendKeys(Password, data1);
			click(Login);	
			waitForElementToBeClickable(PolicyLogo);
			click(PolicyLogo);
			SwitchToNewWindow();
			if(driver.getClass().getName().contains("Internet"))
			driver.manage().window().maximize();			
			
		} catch (Exception e) {
	
			e.printStackTrace();
			
		}
			
	}
	
	public void logout()
	{
		driver.switchTo().defaultContent();
		click(PolicyLogo);
		click(Logout);
	}
	
	
	public void IEaction() throws InterruptedException, IOException
	{
		prop = new Properties();
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\resources\\Configuration.properties");			
		prop.load(fs);
		
		if(prop.getProperty("Browser_Name").equalsIgnoreCase("IE"))
		{
		
				scrollToBottom();
				scrollUp("-100");
				waitForElementToBeClickable(TransactionHistoryLink);	
				click(TransactionHistoryLink);
				Thread.sleep(1000);	
		
		}
	}
		
	public void screenShotPass(String details) throws IOException
	{
		String screenShotPath =  System.getProperty("user.dir")+"\\Screenshot\\screen " +GetCurrentTimeStamp().replace(":","_").replace(".","_");
		TakeSnapshot(driver, screenShotPath); 
	  	TestListener.test.pass(details, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath+".png").build());

	}
}
