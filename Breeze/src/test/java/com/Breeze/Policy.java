package com.Breeze;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.carmensol.BaseTest;
import com.carmensol.pages.DashboardMenu;
import com.carmensol.pages.LogIn;
import com.carmensol.pages.NewApplication;
import com.carmensol.pages.NewClaimScreen;
import com.carmensol.utilities.TestListener;
import com.carmensol.utilities.utility1;

@Listeners(com.carmensol.utilities.TestListener.class)
public class Policy  extends BaseTest{
	
	@Test(priority=0)
    public void CreateNewApplicationWithRiskStatNCVA() 
    {   
		LogIn po = new LogIn(driver, TestListener.test);
		NewApplication nc = new NewApplication(driver, TestListener.test);
		DashboardMenu dm = new DashboardMenu(driver, TestListener.test);
		NewClaimScreen ncs = new NewClaimScreen(driver, TestListener.test);
	    String screenShotPath =  System.getProperty("user.dir")+"\\Screenshot\\screen " +utility1.GetCurrentTimeStamp().replace(":","_").replace(".","_");
	    try 
	    {			
	    	DateFormat dateFormat = new SimpleDateFormat("M/d/");
			Date date = new Date();
			String todayDate = dateFormat.format(date).toString();
			
	    	dm.click(dm.FindNew);
	    	dm.click(dm.Application);
	    	ncs.waitForElementToBeClickable(nc.Name);
			po.screenShotPass("Verified that system is navigated to 'General Information' wizard");
			nc.sendKeys(nc.Name, "Test NC");
			nc.click(nc.ApplicationSource);
			nc.ClickTextName2("li", "Email");
			nc.click(nc.NameType);
			nc.ClickTextName2("li", "Commercial");
			nc.sendKeys(nc.Agent, "Ruth Heffner");
			Thread.sleep(2000);
			nc.ClickTextName1("li", "First State ");

			nc.sendKeys(nc.Address1, "3300 Morganton Rd.");
			nc.sendKeys(nc.CityStateCountry, "Fayetteville, NC, 28303, Cumberland");
			Thread.sleep(2000);
			nc.ClickTextName1("em", "Fayetteville, NC, 28303, Cumberland");
			
			nc.sendKeys(nc.FirstName, "Peter");
			nc.sendKeys(nc.LastName, "Norton");


			nc.click(nc.BusinessType);
			nc.ClickTextName2("li", "Corporation");
			nc.sendKeys(nc.YearsInBusiness,"3");
			nc.sendKeys(nc.FEIN,"759986587");
			//nc.sendKeys(nc.OtherBusinessType, "OtherBusinessType");
			
			nc.sendKeys(nc.NAIC,"Flat Glass");
			Thread.sleep(2000);
			nc.ClickTextName1("li", "/3210");
			
			nc.sendKeys(nc.EffectiveDate,todayDate+"2019");

			
			
			ncs.click(nc.Next);
			TestListener.test.log(Status.PASS, "Verified that user is able to enter the required information in General Information screen. And filled all the required fields. Clicked on Next button");
			
			nc.click(nc.AddExperienceMod);
			Thread.sleep(2000);
			nc.sendKeys(nc.Modifier, "0.86");
			nc.click(nc.RatingType);
			nc.ClickTextName2("li", "Interstate Rated");
			nc.click(nc.SaveButton);
			
			//Add Unit
			nc.click(nc.AddUnit);
			nc.click(nc.GoverningState);
			nc.ClickTextName1("li", "Virginia");
			nc.sendKeys(nc.UnitName,"Test VA");
			
			nc.sendKeys(nc.FirstName1, "Peter");
			nc.sendKeys(nc.LastName1, "Norton");
			nc.sendKeys(nc.Address1_, "10 San Jose Drive");
			nc.scrollIntoView(nc.Business);
			nc.sendKeys(nc.CityStateZip, "Newport News, VA, 23606, Newport News City");
			Thread.sleep(2000);
			nc.ClickTextName2("em", "Newport News, VA, 23606, Newport News City");
			nc.sendKeys(nc.Business, "Business");
			nc.sendKeys(nc.MailingAddress1_, "10 San Jose Drive");
			nc.scrollIntoView(nc.BusinessRecord);
			nc.sendKeys(nc.MailingCityStateZip, "Newport News, VA, 23606, Newport News City");
			Thread.sleep(2000);
			nc.ClickTextName2("em", "Newport News, VA, 23606, Newport News City");
			nc.sendKeys(nc.BusinessRecord, "Business");
			nc.sendKeys(nc.PhysicalAddress1_, "10 San Jose Drive");
			nc.sendKeys(nc.PhysicalCityStateZip, "Newport News, VA, 23606, Newport News City");
			Thread.sleep(2000);
			nc.ClickTextName1("em", "Newport News, VA, 23606, Newport News City");
			nc.click(nc.SaveButton1);
	    
	    	Thread.sleep(1500);
	    	WebElement Body = nc.CurrentUnitTable.findElement(By.tagName("tbody"));
	    	List <WebElement> rows_= Body.findElements(By.tagName("tr"));
	    	int size = rows_.size();
	    	Assert.assertTrue(size==2);
			for(WebElement item : rows_.subList(1,2))
			{				
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size1 = columns.size();
				String UnitName = columns.get(3).getText();
				Assert.assertTrue(UnitName.contains("Test VA"));
				po.screenShotPass("Verified that  Second unit for VA have been added and displayed both units in the grid");
				
			}
			nc.click(nc.Next);
			nc.waitForElementToBeClickable(nc.UnitDD);
			po.screenShotPass("Clicked on Next button. Verified that Workplace wizard opens up");
			nc.click(nc.Next);

			nc.sendKeys(nc.ClassificationCode, "8810");
			Thread.sleep(2000);
			nc.ClickTextName1("em", "8810");
			nc.sendKeys(nc.AnnualPayroll, "50000");
			nc.click(nc.SaveAndAddAnotherButton);
			TestListener.test.log(Status.PASS, "Under Annual Payroll:for Ist Unit-NC. Added Classification Code. Entered Annual Payroll field. Clicked on Save & Another button.");
			
			nc.click(nc.UnitDD1);
			Thread.sleep(2000);
			nc.ClickTextName1("li", "2 - Test VA - Virginia");
			nc.sendKeys(nc.ClassificationCode, "2286");
			Thread.sleep(2000);
			nc.ClickTextName1("em", "2286");
			nc.sendKeys(nc.AnnualPayroll, "50000");
			nc.click(nc.SavePayroll);
			TestListener.test.log(Status.PASS, "Entered another payroll for 2nd Unit and clicked on Save ");
			Thread.sleep(1500);
			

			List <WebElement> rows_1 = nc.PayrollTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbPayroll_i0_m_ucPayrollList_m_rgMain_ctl00')]"));
	    	int size1 = rows_1.size();
	    	Assert.assertTrue(size1==1);
			for(WebElement item : rows_1.subList(0,1))
			{				
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size11 = columns.size();
				String ClassificationCode = columns.get(5).getText();
				Assert.assertTrue(ClassificationCode.contains("2286"));
				po.screenShotPass("Verified that both the payrolls have been added with correct details displayed in the grid");
				
			}
			
			
			nc.click(nc.FinishPayroll);			
			Thread.sleep(1000);
			String AppName = nc.ApplicationName.getText();
			String ID = AppName.substring(AppName.length() - 6);
			String AppID = ID.substring(0, 5);
			Assert.assertTrue(AppName.contains("Test NC"));
			po.screenShotPass("Verified that new application created with new application Number,");
			nc.waitForElementToBeClickable(nc.GeneralInformation);
			nc.waitForElementToBeClickable(nc.Units);
			nc.waitForElementToBeClickable(nc.Officers);
			nc.waitForElementToBeClickable(nc.LossHistory);
			nc.waitForElementToBeClickable(nc.OptionalPolicyForms);
			nc.waitForElementToBeClickable(nc.ApplicationInfo);
			nc.waitForElementToBeClickable(nc.OtherEntities);
			nc.waitForElementToBeClickable(nc.Quotes);
			po.screenShotPass("Verified that on the left handside, there are different tabs- General Information, Units-Workplaces, Payroll, Additional Exposures, Officers, Loss History, Alternate Employer, Other Names Insureds, Amended Cancellation, Questions, Additional Information, Application History, UW WorkBench, Quotes");
			
			nc.click(nc.GeneralInformation);
			Thread.sleep(1000);
			Assert.assertTrue(nc.GetValue(nc.Name).equals("Test NC"));
			Assert.assertTrue(nc.GetValue(nc.ApplicationSource).equals("Email"));
			Assert.assertTrue(nc.GetValue(nc.NameType).equals("Commercial"));
			Assert.assertTrue(nc.GetValue(nc.Agent).contains("Ruth Heffner"));
			po.screenShotPass("Clicked on General Information tab.Verified that all the information entered are displayed correctly for this tab");
			
			// Add Officers
			nc.click(nc.Officers);
			nc.click(nc.AddOfficers);
			nc.sendKeys(nc.OfficersName, "FirstName");
			po.screenShotPass("Clicked on Officers tab");
			nc.sendKeys(nc.OfficersLast, "LastName");
			nc.click(nc.OfficersTitle);
			Thread.sleep(2000);
			nc.ClickTextName1("li", "Owner");
			nc.click(nc.SaveOfficers);
			TestListener.test.log(Status.PASS,"Added Officers by clicking on +icon. Entered all the mandatory fields and clicked on Save");
			List <WebElement> rows_11 = nc.OfficersTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_ucOfficers_m_pbOfficers_i0_m_rgOfficers_ctl00')]"));
	    	int size11 = rows_11.size();
	    	Assert.assertTrue(size11==1);
			for(WebElement item : rows_11.subList(0,1))
			{				
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size111 = columns.size();
				String Name = columns.get(3).getText();
				Assert.assertTrue(Name.contains("FirstName"));
				po.screenShotPass("Verified that officers is saved successfully and displayed in the grid");
				
			}
			
			// Add Loss History
			nc.click(nc.LossHistory);
			nc.click(nc.AddLossHistory);
			nc.sendKeys(nc.PolicyYear, "2018");
			po.screenShotPass("Clicked on Loss History tab");
			nc.sendKeys(nc.NCCCarrierCode, "property");
			Thread.sleep(2000);
			nc.ClickTextName1("em", "PROPERTY");
			nc.click(nc.SaveLoss);
			Thread.sleep(2000);
			TestListener.test.log(Status.PASS,"Added Loss History by clicking on +icon. Entered all the mandatory fields and clicked on Save");
			List <WebElement> rows_111 = nc.LossHistoryTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_ucLossHistory_m_pbLossHistory_i0_m_rgLossHistory_ctl00')]"));
	    	int size111 = rows_111.size();
	    	Assert.assertTrue(size111==1);
			for(WebElement item : rows_111.subList(0,1))
			{				
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size1111 = columns.size();
				String PolicyYear = columns.get(2).getText();
				Assert.assertTrue(PolicyYear.contains("2018"));
				po.screenShotPass("Verified that Loss History record is saved successfully and displayed in the grid");
				
			}
			
			// Add Quotes
			//nc.click(nc.Quotes);
			nc.click(nc.AddQuotes);
			nc.click(nc.Carrier);
			Thread.sleep(2000);
			nc.ClickTextName1("li", "Stonewood Insurance Company");
			po.screenShotPass("Clicked on Quote tab from Left hand Menu section");
			nc.click(nc.NextQuote);
			TestListener.test.log(Status.PASS,"Under Quote Information. Entered Carrier and clicked on Next button");
			Thread.sleep(2500);
			String AlertText = nc.QuoteNotification.getText().trim();
	    	Assert.assertTrue(nc.QuoteNotification.isDisplayed() && AlertText.contains("Quote")  && AlertText.contains("has been created"));
	    	po.screenShotPass("Quote <Quote Number> has been created message appears at bottom of screen on clicking 'Next' button");
			Thread.sleep(1000);
			
			// Add Employer Liability
			nc.click(nc.AddLimit);
			nc.click(nc.InsertLimit);
			Thread.sleep(2000);
			TestListener.test.log(Status.PASS,"Added Employeers Liability limits. Clicked on +Add Limit. Selected All Units from Unit dropdown. Selected Liabilty Limits from dropdown. Entered Rate. And clicked on save icon");
			List <WebElement> rows_1111 = nc.LimitTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbEmployersLiabilityLimits_i0_m_ucEel_m_rgMain_ctl00')]"));
	    	int size1111 = rows_1111.size();
	    	Assert.assertTrue(size1111==2);
			for(WebElement item : rows_1111.subList(1,2))
			{				
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size11111 = columns.size();
				String State = columns.get(2).getText();
				Assert.assertTrue(State.contains("VA"));
				po.screenShotPass("Verified that Limits being added for both the units");
				
			}
		
			// Add Credit/Debit
			nc.click(nc.AddCreditDebit);
			nc.click(nc.SaveCredit);
			Thread.sleep(2000);
			nc.click(nc.AddCreditDebit);
			nc.click(nc.CreditDebitUnit);
			nc.ClickTextName1("li", "Virginia - 2 - Test VA");
			nc.click(nc.SaveCredit);
			TestListener.test.log(Status.PASS,"Add Credits/Debits: Clicked on +Add Credit/Debit. Selected 1st unit. Selected Description and clicked on Save. Now added credit/debit for another unit and clicked on save");
			List <WebElement> rows_11111 = nc.CreditDebitTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbCreditsDebits_i0_m_ucCredits_m_rgCreditsDebits_ctl00')]"));
	    	int size11111 = rows_11111.size();
	    	Assert.assertTrue(size11111==2);
			for(WebElement item : rows_11111.subList(1,2))
			{				
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size111111 = columns.size();
				String State = columns.get(2).getText();
				Assert.assertTrue(State.contains("Test VA"));
				po.screenShotPass("Verified that Credit/Debits is added for both the units successfully");
				
			}

			nc.click(nc.NextQuote);
			TestListener.test.log(Status.PASS,"Clicked on Next button");
			
			// Save Billing
			nc.click(nc.SaveBilling);
			Thread.sleep(1000);
			nc.click(nc.SaveBilling);
			TestListener.test.log(Status.PASS,"Billing Plan: Selected Billing plan for first Unit and clicked on save. Added billing plan for another unit and click on save");
			Thread.sleep(2000);
			List <WebElement> rows_111111 = nc.BillingTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbBillingPlans_i0_m_rgBillingPlan_ctl00')]"));
	    	int size111111 = rows_111111.size();
	    	Assert.assertTrue(size111111==2);
			for(WebElement item : rows_111111.subList(1,2))
			{				
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size1111111 = columns.size();
				String State = columns.get(1).getText();
				Assert.assertTrue(State.contains("Test VA"));
				po.screenShotPass("Verified that user is able to add billing plan for both the units and displyed correctly in the billing plan");
				
			}
			
			nc.click(nc.FinishQuote);
			nc.waitForElementToBeClickable(nc.AddQuotes);
			List <WebElement> rows_1111111 = nc.QuoteTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbQuotes_i0_m_rgExistingQuotes_ctl00')]"));
	    	int size1111111 = rows_1111111.size();
	    	Assert.assertTrue(size1111111==1);
			for(WebElement item : rows_1111111.subList(0,1))
			{				
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size11111111 = columns.size();
				String QuoteNumber = columns.get(6).getText();
				po.screenShotPass("Verified that Quote is created with Quote Number: "+QuoteNumber);
				
			}
			
			//Change Quote Status to Released
			nc.click(nc.QuoteAction);
			nc.ClickTextName1("span", "Release Quote");
			TestListener.test.log(Status.PASS,"go to Actions * icon on Quote page- clicked on Release Quote and changed the quote status to Released");
			Thread.sleep(1000);
			List <WebElement> rows_11111111 = nc.QuoteTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbQuotes_i0_m_rgExistingQuotes_ctl00')]"));
	    	int size11111111 = rows_11111111.size();
	    	Assert.assertTrue(size11111111==1);
			for(WebElement item : rows_11111111.subList(0,1))
			{				
				List <WebElement> columns = item.findElements(By.tagName("td"));
				String Status = columns.get(13).getText();
				Assert.assertTrue(Status.equals("Released"));
				po.screenShotPass("Verified that Quote status is changed to 'Released'");
				
			}
			

			//Change Quote Status to Bind Quote
			nc.click(nc.QuoteAction);
			nc.ClickTextName1("span", "Bind Quote");
			TestListener.test.log(Status.PASS,"go to Actions * icon on Quote page- clicked on Bind Quote and changed the quote status to Bind");
			
			Thread.sleep(2500);
			String AlertText1 = nc.QuoteNotification.getText().trim();
	    	Assert.assertTrue(nc.QuoteNotification.isDisplayed() && AlertText1.contains("Application status updated to Ready to Issue."));
	    	po.screenShotPass("'Application status updated to Ready to Issue.' message appears at bottom of screen on changing to Bind Quote");
			Thread.sleep(1000);
			List <WebElement> rows_111111111 = nc.QuoteTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbQuotes_i0_m_rgExistingQuotes_ctl00')]"));
	    	int size111111111 = rows_111111111.size();
	    	Assert.assertTrue(size111111111==1);
			for(WebElement item : rows_111111111.subList(0,1))
			{				
				List <WebElement> columns = item.findElements(By.tagName("td"));
				String Status = columns.get(13).getText();
				Assert.assertTrue(Status.equals("Bound"));
				po.screenShotPass("Verified that Quote status is changed to 'Bound'");
				
			}
			
	    }
	    catch (Exception e) 
	    {	
	        po.TakeSnapshot(driver, screenShotPath);    	  
	        try {
	    		TestListener.test.addScreenCaptureFromPath(screenShotPath+".png");
	    	} catch (IOException e1) {
	    		e1.printStackTrace();
	    	}       
	    	TestListener.test.log(Status.FAIL, e.getMessage());
	    }
	    catch (AssertionError e) 
	    {
	    	po.TakeSnapshot(driver, screenShotPath);    	  
	        try {
	    		TestListener.test.addScreenCaptureFromPath(screenShotPath+".png");
	    	} catch (IOException e1) {
	    		// TODO Auto-generated catch block
	    		e1.printStackTrace();
	    	}       
	    	TestListener.test.log(Status.FAIL, e.getMessage());
	    }
     }

}