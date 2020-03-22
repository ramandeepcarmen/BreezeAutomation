package com.carmensol.pages;

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

public class DashboardMenu extends utility1

{

	
	public static ExtentReports report;
	public ExtentTest test;
	public Properties prop;
	
	public DashboardMenu(WebDriver driver, ExtentTest test) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.test = test;

	}
	
	@FindBy(how=How.XPATH, using="//span[text()='FIND/NEW']") public WebElement FindNew;
	@FindBy(how=How.XPATH, using="//*[@id=\"ctl00_mstr_megaMenu_m_menu_i1_i0_ctl01\"]/ul/li[2]/ul/li[2]/a") public WebElement Application;
	@FindBy(how=How.XPATH, using="//span[text()='CLAIMS']") public WebElement Claims;
	@FindBy(how=How.XPATH, using="//a[text()='New Claim']") public WebElement NewClaim;
	@FindBy(how=How.XPATH, using="//a[text()='Search Claim/Case']") public WebElement SearchClaim;
	@FindBy(how = How.CSS, using = "button#loginButton") public WebElement Login;
	@FindBy(how = How.CSS, using = "img[src='../../assets/Images/policy.png']") public WebElement PolicyLogo;
	
	public void ClickClaims()
	{
		
		try {	
			click(Claims);	
			waitForElementToBeClickable(NewClaim);
			TestListener.test.pass("Clicked 'Claims' tab on Dashboard. Verified that CLaims menu list appears.");		
			
		} catch (Exception e) {
	
			e.printStackTrace();
			
		}
			
	}
		
	public void screenShotPass(String details) throws IOException
	{
		String screenShotPath =  System.getProperty("user.dir")+"\\Screenshot\\screen " +GetCurrentTimeStamp().replace(":","_").replace(".","_");
		TakeSnapshot(driver, screenShotPath); 
	  	TestListener.test.pass(details, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath+".png").build());

	}
}
