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
import com.carmensol.pages.NewClaimScreen;
import com.carmensol.utilities.TestListener;
import com.carmensol.utilities.utility1;

@Listeners(com.carmensol.utilities.TestListener.class)
public class ReOpenClaim_NJ7 extends BaseTest{
	
	@Test(priority=0)
    public void ReOpenClaim_NJ7_Claim() 
    {   
		LogIn po = new LogIn(driver, TestListener.test);
		DashboardMenu dm = new DashboardMenu(driver, TestListener.test);
		NewClaimScreen ncs = new NewClaimScreen(driver, TestListener.test);
	    String screenShotPath =  System.getProperty("user.dir")+"\\Screenshot\\screen " +utility1.GetCurrentTimeStamp().replace(":","_").replace(".","_");
	    try 
	    {
	    	
	    	DateFormat dateFormat = new SimpleDateFormat("M/d/");
			Date date = new Date();
			String todayDate = dateFormat.format(date).toString();
			Thread.sleep(1000);
			dm.PopUp("Yes");
			
			dm.click(dm.Claims);
	    	TestListener.test.log(Status.PASS, "Breeze dashboard is displayed");
	    	dm.click(dm.SearchClaim);
	    	dm.waitForElementToBeClickable(ncs.SearchClaimButton);
	    	po.screenShotPass("User clicked on Claims tab and selected 'Search Claim/Case' option. Verified that 'Search Claim' wizard is displayed.");
	    	
	    	ncs.click(ncs.SearchDD);
	    	ncs.ClickTextName1("li", "Claim Number");
	    	TestListener.test.log(Status.PASS, "User selected 'Claim Number' dropdown value");
	    	ncs.sendKeys(ncs.SearchTextField, "AEI020782");
	    	po.screenShotPass("User entereded the Claim Number 'AEI020782' in a search text field");
	    	ncs.click(ncs.SearchClaimButton);
	    	
	    	Thread.sleep(1000);
	    	
	    	List <WebElement> rows1 = ncs.SearchClaimTable.findElements(By.tagName("tr"));
			int size = rows1.size();
			Assert.assertTrue(size==4);
			for(WebElement item : rows1.subList(size-1,size))
			{				
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size1 = columns.size();
				String ClaimNumber = columns.get(1).getText();
				Assert.assertTrue(ClaimNumber.contains("AEI020782"));
				po.screenShotPass("Verified that relevant record is displayed in the search grid after clicking on Search button");
				
			}
			
			ncs.click(ncs.SearchedClaim);
			TestListener.test.log(Status.PASS, "User opened the claim from searched grid");
			
			
			//Go to General Information
			ncs.MouseOver(ncs.ClaimMenu);
			Thread.sleep(1000);
			ncs.click(ncs.GeneralInfo);
			ncs.waitForElementToBeClickable(ncs.EditGeneralInfo);
			ncs.click(ncs.EditGeneralInfo);
			po.screenShotPass("Verified that system is navigated to 'General Information' wizard on clicking 'General Information' sub-menu under Claim Menu. Clicked on Edit button");
			ncs.click(ncs.ClaimStatus);
			ncs.ClickTextName1("li", "Re-open");
			ncs.click(ncs.SaveGeneralInfo);
			po.screenShotPass("Reopened the Claim from General information screen and clicked on Save button. User remains on General information screen");
			Thread.sleep(3000);
			
			//Go to Financial Summary
	    	ncs.MouseOver(ncs.Financials);
			ncs.click(ncs.Summary);
			Thread.sleep(1000);
			TestListener.test.log(Status.PASS, "Clicked on Financials. selected Summary option'");
			String MedicalPaid = ncs.ElemenyByX("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00__1\"]/td[3]").getText();
			String IndemnityPaid = ncs.ElemenyByX("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00__0\"]/td[3]").getText();
			
			po.screenShotPass("Verified that Financial Summary page is opened up.And there is already amount for Medical and expense reserves i.e. "+MedicalPaid +", "+IndemnityPaid +" respectively" );
			
			String MedicalPaid1 = MedicalPaid.replace(",", "");
			String IndemnityPaid1 = IndemnityPaid.replace(",", "");
			Double MedicalPaidAmt = Double.parseDouble(MedicalPaid1.substring(1));         
			Double IndemnityPaidAmt = Double.parseDouble(IndemnityPaid1.substring(1)); 
			
			
			
			Thread.sleep(1000);
			ncs.MouseOver(ncs.Financials);
			ncs.click(ncs.Reserves);
			TestListener.test.log(Status.PASS, "Clicked on Financials. selected Reserve option'");
			ncs.click(ncs.AddReserve);
	    	Thread.sleep(1000);
	    	ncs.waitForElementToBeClickable(ncs.MedicalTab);
	    	ncs.waitForElementToBeClickable(ncs.ExpenseTab);
	    	ncs.waitForElementToBeClickable(ncs.LegalTab);
	    	ncs.waitForElementToBeClickable(ncs.OtherTab);
	    	po.screenShotPass("Clicked on 'Add Reserves. Verified that Reserve Worksheet opens with  four tabs-Medical,Expense,Legal and Other");
	    	
	    	ncs.click(ncs.OtherIndemnityPencil);
	    	ncs.sendKeys(ncs.OtherIndemnityQuatity, "2");
	    	ncs.click(ncs.OtherIndemnityUnitMeasure);
	    	ncs.ClickTextName2("li", "Hour");
	    	ncs.sendKeys(ncs.OtherIndemnityRate, "50.00");
	    	ncs.click(ncs.OtherIndemnityQuatity);
	    	po.screenShotPass("Clicked on Pencil icon to edit Other Indemnity. Entered Quanity as '2', Unit of Measure as 'Hour' and Rate as '50.00' ");
	    	ncs.click(ncs.OtherIndemnityUpdate);
	    	TestListener.test.log(Status.PASS, "Clicked on update icon corresponding to Other Indemnity row");
	    	Thread.sleep(3000);
	    	String value = ncs.OtherIndemnityAvailableMeasure.getText();
	    	Assert.assertTrue(value.equals("$100.00"));
	    	//String value1_ = ncs.TotalReservedAdjustment.getText();
	    	//Assert.assertTrue(value1_.equals("$100.00"));
	    	po.screenShotPass("Verified that 'Target -Available Reserves' is calculated based on the qty., unit of measure and rate entered i.e. Other Indemnity: 2 x 50 =100$");
	    	
	    	ncs.click(ncs.MedicalTab);
	    	TestListener.test.log(Status.PASS, "Click on Medical Tab");
	    	
	    	ncs.click(ncs.PhysicialPencil);
	    	ncs.sendKeys(ncs.PhysianQuatity, "2");
	    	ncs.click(ncs.PhysicianUnitMeasure);
	    	ncs.ClickTextName2("li", "Hour");
	    	ncs.sendKeys(ncs.PhysicianRate, "5.00");
	    	ncs.click(ncs.PhysianQuatity);
	    	po.screenShotPass("Clicked on Pencil icon to edit Physician. Entered Quanity as '2', Unit of Measure as 'Hour' and Rate as '5.00' ");
	    	ncs.click(ncs.PhysicianUpdate);
	    	TestListener.test.log(Status.PASS, "Clicked on update icon corresponding to Physician row");
	    	Thread.sleep(3000);
	    	String value_ = ncs.PhysicianAvailableMeasure.getText();
	    	Assert.assertTrue(value_.equals("$10.00"));
	    	po.screenShotPass("Verified that 'Target -Available Reserves' is calculated based on the qty., unit of measure and rate entered i.e. Physician: 2 x 5 =10$");
	    	
	    	ncs.click(ncs.PharmacyPencil);
	    	ncs.sendKeys(ncs.PharmacyQuatity, "2");
	    	ncs.click(ncs.PharmacyUnitMeasure);
	    	ncs.ClickTextName2("li", "Hour");
	    	ncs.sendKeys(ncs.PharmacyRate, "500.00");
	    	ncs.click(ncs.PharmacyQuatity);
	    	po.screenShotPass("Clicked on Pencil icon to edit Pharmacy. Entered Quanity as '2', Unit of Measure as 'Hour' and Rate as '500.00' ");
	    	ncs.click(ncs.PharmacyUpdate);
	    	TestListener.test.log(Status.PASS, "Clicked on update icon corresponding to Pharmacy row");
	    	Thread.sleep(3000);
	    	String value1 = ncs.PharmacyAvailableMeasure.getText();
	    	Assert.assertTrue(value1.equals("$1,000.00"));
	    	po.screenShotPass("Verified that 'Target -Available Reserves' is calculated based on the qty., unit of measure and rate entered i.e. Pharmacy: 2 x 500 =1,000$");
	    	
	    	ncs.click(ncs.MedicalPencil);
	    	ncs.sendKeys(ncs.MedicalQuatity, "2");
	    	ncs.click(ncs.MedicalUnitMeasure);
	    	ncs.ClickTextName2("li", "Hour");
	    	ncs.sendKeys(ncs.MedicalRate, "300.00");
	    	ncs.click(ncs.MedicalQuatity);
	    	po.screenShotPass("Clicked on Pencil icon to edit Medical. Entered Quanity as '2', Unit of Measure as 'Hour' and Rate as '300.00' ");
	    	ncs.click(ncs.MedicalUpdate);
	    	TestListener.test.log(Status.PASS, "Clicked on update icon corresponding to Medical row");
	    	Thread.sleep(3000);
	    	String value2 = ncs.MedicalAvailableMeasure.getText();
	    	Assert.assertTrue(value2.equals("$600.00"));
	    	po.screenShotPass("Verified that 'Target -Available Reserves' is calculated based on the qty., unit of measure and rate entered i.e. Medical: 2 x 300 =600$");
	    	
	    	String TotalAdjustment = ncs.GetValue(ncs.TotalMedicalAdjustment);
	    	//Assert.assertTrue(TotalAdjustment.equals("$1,610.00"));
	    	po.screenShotPass("Verified that Total Medical Adjustment amount becomes $1,610.00");
	    	
	    	
	    	
	    	ncs.click(ncs.SaveAndApprove);
	    	Thread.sleep(1500);
	    	
	    	
	    	List <WebElement> rows2_ = ncs.FinancialTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00')]"));
	    	int size2_ = rows2_.size();
	    	for(WebElement item : rows2_.subList( 0,1))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size1 = columns.size();
				String incurredIndemnity = columns.get(1).getText();
				String incurredIndemnity1 = incurredIndemnity.replace(",", "");
				
				Double incurredIndemnityAmt = Double.parseDouble(incurredIndemnity1.substring(1));
				String ReserveBalanceIndemnity = columns.get(3).getText();
				String ReserveBalanceIndemnity1 = ReserveBalanceIndemnity.replace(",", "");
				Double ReserveBalanceIndemnityAmt = Double.parseDouble(ReserveBalanceIndemnity1.substring(1));
				Assert.assertTrue(incurredIndemnityAmt == ReserveBalanceIndemnityAmt + IndemnityPaidAmt);
				Assert.assertTrue(ReserveBalanceIndemnity.equals("$100.00"));
				po.screenShotPass("Verified that Indemnity corresponding to Incurred column ,amount is '"+incurredIndemnityAmt+"' and Indemnity corresponding to Reserve Balance column ,amount is '$100.00'");
			}
	
	    	Thread.sleep(1000);
			ncs.MouseOver(ncs.Financials);
			ncs.click(ncs.Payables);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Payables");
			Thread.sleep(1000);
			ncs.waitForElementToBeClickable(ncs.DropDown);
			po.screenShotPass("Verified that Payables screen opens up");
			
			ncs.click(ncs.DropDown);
			ncs.ClickTextName2("li", "Indemnity");
			Thread.sleep(1000);
			ncs.click(ncs.AddPayable);
			
			//Indemnity Payable
			TestListener.test.log(Status.PASS, "Selected the dropdown value as Indemnity and clicked on +Add payable ");
			ncs.waitForElementToBeClickable(ncs.IndemnityPayCode);
			po.screenShotPass("Verified that  Physician payable Entry screen opens upon clicking  +Add payable");
			Assert.assertTrue(ncs.GetValue(ncs.IndemnityPayableStatus).equals("Hold"));
			ncs.click(ncs.IndemnityPayCode);
			ncs.ClickTextName2("li", "Employers Liability Settlement");
			po.screenShotPass("Selected Paycode as 'Employers Liability Settlement'.");
			Assert.assertTrue(ncs.GetValue(ncs.IndemnityAvailableReserves).equals("$100.00"));
			po.screenShotPass("Verified that Payable status is 'Hold'. And after selecting paycode, under Reserves section Available Reserves is same as Indemnity Reserves i.e $100");
			ncs.sendKeys(ncs.PayPeriodFromDate, todayDate+"2019");
			ncs.click(ncs.IndemnitySchedulePayDate);
			Thread.sleep(1000);
			ncs.sendKeys(ncs.PayPeriodToDate, todayDate+"2019");
			ncs.click(ncs.IndemnitySchedulePayDate);
			Thread.sleep(1000);
			ncs.sendKeys(ncs.PayPeriodDays, "3");
			ncs.sendKeys(ncs.IndemnityRequestedAmount, "60");
			ncs.click(ncs.IndemnitySchedulePayDate);
			Thread.sleep(1000);
			ncs.sendKeys(ncs.IndemnitySchedulePayDate, todayDate+"2019");
			po.screenShotPass("Selected Pay Period From Date,Pay Period Through Date,Pay Period Days and Scheduled Pay Date. Entered Requested Amount as '$60'");
		
	       	ncs.click(ncs.Save1);
	       	TestListener.test.log(Status.PASS, "Clicked on Save button of payable screen");
	       	Thread.sleep(1000);
	       	if(ncs.CheckExistence("input#ctl00_ctl00_m_MessageBox_m_rwMessageBox_C_m_btnYes")>0)
	       	{
	       		ncs.click(ncs.ElemenyByCSS("input#ctl00_ctl00_m_MessageBox_m_rwMessageBox_C_m_btnYes"));
	       	}
	       	
	       	
	    	Thread.sleep(1000);
	       	
	       	List <WebElement> rowss = ncs.PayableTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbPayables_i0_m_rgPayables_ctl00')]"));
	       	
	    	int sizes = rowss.size();
	    	//Assert.assertTrue(sizes==1);
	    	for(WebElement item : rowss.subList( 0,1))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size1 = columns.size();
				String Status = columns.get(4).getText();
				String PayCode = columns.get(8).getText();
				String ReserveType = columns.get(9).getText();
				String Amount = columns.get(13).getText();
				
				Assert.assertTrue(Status.equals("Hold") && PayCode.equals("Employers Liability Settlement") && ReserveType.equals("Indemnity") && Amount.equals("$60.00"));
				po.screenShotPass("Verified that on Payables screen , there is entry for that payable enterd i.e. '$60' in prevoius step and status is 'Hold'. Also verified that Pay Code and Reserve Type are displayed correctly in a grid");
			}
	    	
	    	ncs.click(ncs.IconInTable);
	    	ncs.ClickTextName2("span", "Release");
	       	Thread.sleep(1000);
	    	TestListener.test.log(Status.PASS, "Clicked on icon beside Hold status and clicked on Release");
	    	List <WebElement> rowss_ = ncs.PayableTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbPayables_i0_m_rgPayables_ctl00')]"));
	       	
	    	//int sizes_ = rowss_.size();
	    	for(WebElement item : rowss_.subList( 0,1))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				String Status = columns.get(4).getText();
				Assert.assertTrue(Status.equals("Released"));
				po.screenShotPass("Verified that Payable entry status is 'Released' now");
			}
	       	
	       	//Go to Financial Summary
	    	Thread.sleep(1000);
	    	ncs.MouseOver(ncs.Financials);
			ncs.click(ncs.Summary);
			Thread.sleep(1000);
	    	List <WebElement> rowsss = ncs.FinancialTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00')]"));	       	
	    	//int sizess = rowsss.size();
	    	for(WebElement item : rowsss.subList(0,1))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				String Pending = columns.get(5).getText();
				String AR = columns.get(4).getText();
				Assert.assertTrue(Pending.equals("$60.00") && AR.equals("$40.00"));
				po.screenShotPass("Verified that under Financial table, payable amount is reflected under Pending payment's column for 'Indemnity' & Available Reserves is Incurred - Pending Payment ");
			}
	    	
	    	// Go again to Financials Payables
	    	Thread.sleep(1000);
	    	ncs.MouseOver(ncs.Financials);
			ncs.click(ncs.Payables);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Payables");
			Thread.sleep(1000);
			ncs.waitForElementToBeClickable(ncs.DropDown);
			po.screenShotPass("Verified that Payables screen opens up");
			ncs.click(ncs.IconInTable);
	    	ncs.ClickTextName2("span", "Create Check");
	       	Thread.sleep(1000);
	    	TestListener.test.log(Status.PASS, "Clicked on icon beside Release status and clicked on 'Create Check'");
	    	ncs.waitForElementToBeClickable(ncs.DisbursementNext);
	    	po.screenShotPass("Disbursements - Create Claim Disbursements screen opens up");
	    	ncs.click(ncs.DisbursementNext);
	    	TestListener.test.log(Status.PASS, "Clicked on 'Next' button");
	    	
	    	Thread.sleep(1500);
	    	List <WebElement> rowsss1 = ncs.DisbursemenTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_FinancialsContent_m_pbSearchResults_i0_m_rgSearchResults_ctl00')]"));
	       	po.screenShotPass("Disbursement batch screen opens up");
	    	int sizesss = rowsss1.size();
	    	for(WebElement item : rowsss1.subList(0,sizesss))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				String Amount = columns.get(5).getText();
				Assert.assertTrue(Amount.equals("$60.00"));
				po.screenShotPass("One record in searched grid is being selected with that much payable amount i.e. $60.00");
			}
	    	
	    	ncs.click(ncs.GenerateBatch);
	    	TestListener.test.log(Status.PASS, "Clicked on 'Generate Batch' button");
	    	Thread.sleep(4500);
			String AlertText1 = ncs.BatchCreatedNotification.getText().trim();
	    	Assert.assertTrue(ncs.BatchCreatedNotification.isDisplayed() && AlertText1.contains("was created successfully"));
	    	po.screenShotPass("'Batch <number> was created suucessfully' message appears at bottom of screen on clicking 'Generate Batch' button");
	    	Thread.sleep(1000);
	    	ncs.click(ncs.CheckPrinterProfile);
	    	Thread.sleep(1000);
	    	ncs.ElemenyByX("//*[text()='ClaimsPrinter2']").click();
	    	Thread.sleep(4000);
	    	TestListener.test.log(Status.PASS, "Selected Check Printer Profile");
	    	ncs.click(ncs.PrintChecks);
	    	TestListener.test.log(Status.PASS, "Clicked on 'Print Checks' button");
	    	Thread.sleep(4000);
			String AlertText2 = ncs.CheckPrintSuccessMessage.getText().trim();
	    	Assert.assertTrue(ncs.CheckPrintSuccessMessage.isDisplayed());
	    	Assert.assertTrue(AlertText2.contains("Checks printed and batch was automatically posted") || AlertText2.contains("Successfully submitted \"Print Checks\""));
	    	po.screenShotPass("'Checks printed and batch was automatically posted.' message appears at bottom of screen on clicking 'Check Print' button");
	    	
	    	if(AlertText2.contains("Successfully submitted \"Print Checks\""))
	    	{
	    		ncs.UnlockFromUserNJ();
	    		Thread.sleep(40000);
	    	}
	    	
	    	//Search claim
	    	dm.click(dm.FindNew);
	    	dm.click(ncs.Claims_Cases);
	    	ncs.click(ncs.SearchDD);
	    	ncs.ElemenyByX("//*[text()='Claim Number']").click();
	    	//ncs.sendKeys(ncs.SearchTextField, "AEI020308");
	    	//Thread.sleep(3000);
	    	//ncs.click(ncs.SearchClaimButton);
	    	ncs.click(ncs.SearchedClaim);
	    	po.screenShotPass("Searched the Claim for which check is printed after generation of Batch");
	    	
	    	Thread.sleep(1000);
	    	ncs.MouseOver(ncs.Financials);
			ncs.click(ncs.Payables);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Payables");			
			Thread.sleep(1000);
	       	
	       	List <WebElement> rowss1 = ncs.PayableTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbPayables_i0_m_rgPayables_ctl00')]"));
	       	
	    	int sizes1 = rowss1.size();
	    	//Assert.assertTrue(sizes1==1);
	    	for(WebElement item : rowss1.subList(0,1))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size1 = columns.size();
				String Amount = columns.get(13).getText();
				String Status = columns.get(4).getText();
				Assert.assertTrue(Status.equals("Paid") || Status.equals("Released"));
				Assert.assertTrue(Amount.equals("$60.00"));				
				po.screenShotPass("Verified that on Payables screen, there is entry for that payable enterd in prevoius step and status is 'Paid' now with Amount '$60.00'");
			}
	    	
	    	// Medical payment
	    	Thread.sleep(1000);
	    	ncs.MouseOver(ncs.Financials);
			ncs.click(ncs.Summary);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Summary");
			Thread.sleep(2000);
			//ncs.waitForElementToBeClickable(ncs.FinancialTable);
			List <WebElement> rows2_2 = ncs.FinancialTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00')]"));
	    	for(WebElement item2 : rows2_2.subList( 1,2))
			{
				List <WebElement> columns = item2.findElements(By.tagName("td"));

				String PendingPayments = columns.get(5).getText();
				String ReserveBalanceMedical = columns.get(3).getText();
				Assert.assertTrue(PendingPayments.equals("$0.00") && ReserveBalanceMedical.equals("$1,610.00") );
				po.screenShotPass("Verified that under Financial summary section. Under GROSS and Net of Recoveries corresponding to Paid  column: Medical Reserve amount is $1,610.00. Pending payment for Medical is Zero");
			
			
			}
	
	    	Thread.sleep(1000);
	    	ncs.MouseOver(ncs.Financials);
			ncs.click(ncs.Payables);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Payables");
			Thread.sleep(1000);
			ncs.waitForElementToBeClickable(ncs.DropDown);
			po.screenShotPass("Verified that Payables screen opens up");
			ncs.click(ncs.DropDown);
			ncs.ClickTextName2("li", "Physician");
			ncs.click(ncs.AddPayable);
			TestListener.test.log(Status.PASS, "Selected the dropdown value as Physician and clicked on +Add payable ");
			ncs.waitForElementToBeClickable(ncs.Provider);
			po.screenShotPass("Verified that  Physician payable Entry screen opens upon clicking  +Add payable");
			
			/*ncs.click(ncs.ServiceProviderLookUp);
			Thread.sleep(1500);
			//Switch to Frame
			ncs.switchToFrame_byID("m_rwProviderLookup");
			ncs.click(ncs.DropDown1);
			TestListener.test.log(Status.PASS, "Click on 'Provider look up' search");
			ncs.ClickTextName2("li", "State/Province");			
			
			ncs.sendKeys(ncs.SearchBox, "NC");
			ncs.click(ncs.SearchBtn);
			TestListener.test.log(Status.PASS, "Selected State/Province from drop down . Entered NC in search box and clicked on search button ");
			ncs.DoubleClick(ncs.SearchedRow1st);
			
			po.screenShotPass("Verified that search results comes up in a grid and now selected any one record by double clicking on it");
			Thread.sleep(1000);
			ncs.switchToDefault();
			Assert.assertTrue(!ncs.GetValue(ncs.ServiceProviderField).equals(""));
			po.screenShotPass("Verified that 'Provider TaxID ,Provider Bussiness Name filled automatically on 'Physician Payable Entry' screen ");*/
			ncs.sendKeys(ncs.Provider, "test");
			Thread.sleep(3000);
			ncs.ClickTextName1("span", "381 Deerfield Road");
			ncs.sendKeys(ncs.SeriveFromDate, todayDate+"2019");
			ncs.sendKeys(ncs.SchedulePayDate, todayDate+"2019");
			Thread.sleep(1000);
			Assert.assertTrue(ncs.GetValue(ncs.PayableStatus).equals("Hold"));
			ncs.click(ncs.PayCode);
			ncs.ClickTextName2("li", "Physical Therapy (Physician)");
			po.screenShotPass("Selected Provider, Paycode. Entered Service FromDate,Service To date, Scheduled Pay Date same as Date of Injury Date");
			Thread.sleep(1000);
			Assert.assertTrue(ncs.GetValue(ncs.AvailableReserves).equals("$1,610.00"));
			po.screenShotPass("Verified that Payable status is 'Hold'. And after selecting paycode, under Reserves section Available Reserves is same as Medical Reserves i.e 1,610");
			ncs.scrollIntoView(ncs.AddDetail);
			//ncs.click(ncs.AddDetail);
			TestListener.test.log(Status.PASS, "Under Details and Adjustments section:  Clicked on + Add detail");
			ncs.waitForElementToBeClickable(ncs.RequestedAmount);
			po.screenShotPass("Verified that Details and Adjustment section opens up");
			ncs.sendKeys(ncs.RequestedAmount, "100");
			ncs.click(ncs.Save);
			po.screenShotPass("Entered the Requested Amount and clicked on save button. Verified that Requested Amount is entered and value is save successfully");
	       	Thread.sleep(1000);
	       	ncs.click(ncs.Save1);
	       	TestListener.test.log(Status.PASS, "Clicked on Save button of entire screen");
	      	Thread.sleep(1000);
	       	if(ncs.CheckExistence("input#ctl00_ctl00_m_MessageBox_m_rwMessageBox_C_m_btnYes")>0)
	       	{
	       		ncs.click(ncs.YesButton1);
	       	}
	    	Thread.sleep(1000);
	       	
	       	List <WebElement> rowss0 = ncs.PayableTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbPayables_i0_m_rgPayables_ctl00')]"));
	       	
	    	int sizes0 = rowss0.size();
	    	//Assert.assertTrue(sizes0==2);
	    	for(WebElement item : rowss0.subList( 0,1))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size1 = columns.size();
				String Status = columns.get(4).getText();
				Assert.assertTrue(Status.equals("Hold"));
				po.screenShotPass("Verified that on Payables screen , there is entry for that payable enterd in prevoius step and status is 'Hold'");
			}
	    	
	    	ncs.click(ncs.IconInTable);
	    	ncs.ClickTextName2("span", "Release");
	       	Thread.sleep(1000);
	    	TestListener.test.log(Status.PASS, "Clicked on icon beside Hold status and clicked on Release");
	    	List <WebElement> rowss_0 = ncs.PayableTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbPayables_i0_m_rgPayables_ctl00')]"));
	       	
	    	int sizes_0 = rowss_0.size();
	    	for(WebElement item : rowss_0.subList( 0,1))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				String Status = columns.get(4).getText();
				Assert.assertTrue(Status.equals("Released"));
				po.screenShotPass("Verified that Payable entry status is 'Released' now");
			}
	       	
	       	//Go to Financial Summary
	    	Thread.sleep(1000);
	    	ncs.MouseOver(ncs.Financials);
			ncs.click(ncs.Summary);
			Thread.sleep(1000);
	    	List <WebElement> rowsss0 = ncs.FinancialTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00')]"));	       	
	    	int sizess0 = rowsss0.size();
	    	for(WebElement item : rowsss0.subList(1,2))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				String Pending = columns.get(5).getText();
				String AR = columns.get(4).getText();
				Assert.assertTrue(Pending.equals("$100.00") && AR.equals("$1,510.00"));
				po.screenShotPass("Verified that payable amount is reflected under Pending payment s column for 'Medical' & Available Reserves is Incurred - Pending Payment ");
			}
	    	
	    	// Go again to Financials Payables
	    	Thread.sleep(2000);
	    	ncs.MouseOver(ncs.Financials);
			ncs.click(ncs.Payables);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Payables");
			Thread.sleep(1000);
			ncs.waitForElementToBeClickable(ncs.DropDown);
			po.screenShotPass("Verified that Payables screen opens up");
			Thread.sleep(1000);
			ncs.click(ncs.IconInTable);
	    	ncs.ClickTextName2("span", "Create Check");
	       	Thread.sleep(1000);
	    	TestListener.test.log(Status.PASS, "Clicked on icon beside Release status and clicked on 'Create Check'");
	    	ncs.waitForElementToBeClickable(ncs.DisbursementNext);
	    	po.screenShotPass("Disbursements - Create Claim Disbursements screen opens up");
	    	ncs.click(ncs.DisbursementNext);
	    	TestListener.test.log(Status.PASS, "Clicked on 'Next' button");
	    	
	    	Thread.sleep(1500);
	    	List <WebElement> rowsss10 = ncs.DisbursemenTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_FinancialsContent_m_pbSearchResults_i0_m_rgSearchResults_ctl00')]"));
	       	po.screenShotPass("Disbursement batch screen opens up");
	    	int sizesss0 = rowsss10.size();
	    	for(WebElement item : rowsss10.subList(0,sizesss0))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				String Pending = columns.get(5).getText();
				Assert.assertTrue(Pending.equals("$100.00"));
				po.screenShotPass("one record in search grid is being selected with that much payable amount i.e. $100.00");
			}
	    	
	    	ncs.click(ncs.GenerateBatch);
	    	TestListener.test.log(Status.PASS, "Clicked on 'Generate Batch' button");
	    	Thread.sleep(4500);
			String AlertText10 = ncs.BatchCreatedNotification.getText().trim();
	    	Assert.assertTrue(ncs.BatchCreatedNotification.isDisplayed() && AlertText10.contains("was created successfully"));
	    	po.screenShotPass("'Batch <number> was created suucessfully' message appears at bottom of screen on clicking 'Generate Batch' button");
	    	Thread.sleep(1000);
	    	ncs.click(ncs.CheckPrinterProfile);
	    	Thread.sleep(1000);
	    	ncs.ElemenyByX("//*[text()='ClaimsPrinter2']").click();
	    	Thread.sleep(4000);
	    	TestListener.test.log(Status.PASS, "Selected Check Printer Profile");
	    	ncs.click(ncs.PrintChecks);
	    	TestListener.test.log(Status.PASS, "Clicked on 'Print Checks' button");
	    	Thread.sleep(4000);
			String AlertText20 = ncs.CheckPrintSuccessMessage.getText().trim();
	    	Assert.assertTrue(ncs.CheckPrintSuccessMessage.isDisplayed());
	    	Assert.assertTrue(AlertText20.contains("Checks printed and batch was automatically posted") || AlertText20.contains("Successfully submitted \"Print Checks\""));
	    	po.screenShotPass("'Checks printed and batch was automatically posted.' message appears at bottom of screen on clicking 'Check Print' button");
	    	
	    	if(AlertText20.contains("Successfully submitted \"Print Checks\""))
	    	{
	    		ncs.UnlockFromUserNJ();
	    		Thread.sleep(40000);
	    	}
	    	
	    	//Search claim
	    	dm.click(dm.FindNew);
	    	dm.click(ncs.Claims_Cases);
	    	ncs.click(ncs.SearchDD);
	    	ncs.ElemenyByX("//*[text()='Claim Number']").click();
	    	//ncs.sendKeys(ncs.SearchTextField, "AEI020308");
	    	//ncs.click(ncs.SearchClaimButton);
	    	Thread.sleep(1000);
	    	ncs.click(ncs.SearchedClaim);
	    	po.screenShotPass("Searched the Claim for which check is printed after generation of Batch");
	    	
	    	ncs.MouseOver(ncs.Financials);
			ncs.click(ncs.Payables);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Payables");			
			Thread.sleep(1000);
	       	
	       	List <WebElement> rowss11 = ncs.PayableTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbPayables_i0_m_rgPayables_ctl00')]"));
	       	
	    	int sizes11 = rowss11.size();
	    	//Assert.assertTrue(sizes11==2);
	    	for(WebElement item : rowss11.subList(0,1))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size1 = columns.size();
				String Amount = columns.get(13).getText();
				String Status = columns.get(4).getText();
				Assert.assertTrue(Status.equals("Paid") || Status.equals("Released"));
				Assert.assertTrue(Amount.equals("$100.00"));
				po.screenShotPass("Verified that on Payables screen , there is entry for that payable enterd in prevoius step and status is 'Paid' now with Amount '$100.00'");
			}
	    	
	    	Thread.sleep(1000);
	    	ncs.MouseOver(ncs.Financials);
			ncs.click(ncs.Summary);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Summary");
			Thread.sleep(2000);
			//ncs.waitForElementToBeClickable(ncs.FinancialTable);
			List <WebElement> rows2_21 = ncs.FinancialTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00')]"));
	    	for(WebElement item2 : rows2_21.subList(1,2))
			{
	    		
	    		List <WebElement> columns = item2.findElements(By.tagName("td"));
				int size1 = columns.size();
				String incurredMedical = columns.get(1).getText();
				String incurredMedical1 = incurredMedical.replace("$", "").replace(",", "");
				
				Double incurredMedicalAmt = Double.parseDouble(incurredMedical1);
				
					
				
				String ReserveBalanceMedical = columns.get(3).getText();
				String ReserveBalanceMedical1 = ReserveBalanceMedical.replace("$", "").replace(",", "");
				Double ReserveBalanceMedicalAmt = Double.parseDouble(ReserveBalanceMedical1);
				Assert.assertTrue(incurredMedicalAmt == ReserveBalanceMedicalAmt + MedicalPaidAmt + 100.0);
				//Assert.assertTrue(ReserveBalanceMedical.equals("$100.00"));
				po.screenShotPass("Verified that Medical corresponding to Incurred column ,amount is '"+incurredMedicalAmt+"'");
				
				
				
				
			}
	    	
			
	    }
	    catch (Exception e) 
	    {	
	    	String Message = e.getMessage();
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
	    	String Message = e.getMessage();
	    	String Message1 = e.toString();
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