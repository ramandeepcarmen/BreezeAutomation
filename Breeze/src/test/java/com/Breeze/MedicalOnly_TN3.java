package com.Breeze;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
public class MedicalOnly_TN3 extends BaseTest{
	
	@Test(priority=0)
    public void MedicalOnly_TN3_Claim() 
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
			
			dm.ClickClaims();
	    	TestListener.test.log(Status.PASS, "Breeze dashboard is displayed");
	    	dm.click(dm.NewClaim);
	    	dm.waitForElementToBeClickable(ncs.Jurisdiction);
	    	po.screenShotPass("User clicked on Claims tab and selected 'New Claim' option. Verified that New claim wizard is displayed.");
	    	ncs.click(ncs.Jurisdiction);
	    	ncs.ClickTextName1("li", "Tennessee");
	    	TestListener.test.log(Status.PASS, "Verified that Jurisdiction dropdown is available and user selected the value 'Tennessee' from dropdown");
	    	ncs.sendKeys(ncs.InjuryDate, todayDate+"2020");
	    	TestListener.test.log(Status.PASS, "Verified that Date of injury field is available and user entered the valid date");
	    	ncs.click(ncs.InsuredCriteriaDD);
	    	ncs.ClickTextName1("li", "Policy Number");
	    	TestListener.test.log(Status.PASS, "User selected 'Policy Number' dropdown value");
	    	ncs.sendKeys(ncs.SearchField, "WC100-0074620-2019A");
	    	po.screenShotPass("User entereded the Policy Number 'WC100-0074620-2019A' in a search text field");
	    	ncs.click(ncs.SearchButton);
	    	
	    	Thread.sleep(1000);
	    	
	    	List <WebElement> rows1 = ncs.SearchTable.findElements(By.tagName("tr"));
			int size = rows1.size();
			Assert.assertTrue(size==5);
			String InsuredName= "";
			String WorkPlaceName="";
			String Address="";
			for(WebElement item : rows1.subList(size-1,size))
			{				
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size1 = columns.size();
				String PolicyNumber = columns.get(1).getText();
				InsuredName = columns.get(4).getText();				
				WorkPlaceName = columns.get(6).getText();
				Address = columns.get(8).getText();
				Assert.assertTrue(PolicyNumber.contains("WC100-0074620-2019A"));
				po.screenShotPass("Verified that relevant record is displayed in the search grid after clicking on Search button");
				
			}
			ncs.click(ncs.RowCheckBox);
			ncs.click(ncs.NextButton);
			TestListener.test.log(Status.PASS, "User selected the record from Search grid and clicked on Next button");
			Thread.sleep(1000);
			
			//Employee Contact Selection screen
			ncs.sendKeys(ncs.LastName, "Abram");
			TestListener.test.log(Status.PASS, "System navigates to 'Employee Contact Selection' wizard");
			ncs.sendKeys(ncs.FirstName, "Adam");
			ncs.click(ncs.Plus);
			ncs.sendKeys(ncs.Address, "6131");
			ncs.click(ncs.SearchButton1);
			TestListener.test.log(Status.PASS, "Enter LastName and First Name. Click on +icon New Criteria. Verified that after clicking on +icon ,one another dropdown is displayed for search criteria where 'Address' is selected by default. Entered Address and clicked on Search button");
			
			Thread.sleep(1000);
	    	//WebElement Body = ncs.SearchTable.findElement(By.tagName("tbody"));
	    	List <WebElement> rows = ncs.SearchTable.findElements(By.tagName("tr"));
			int size_ = rows.size();
			//Assert.assertTrue(size_==5);
			for(WebElement item : rows.subList(size_-1,size_))
			{				
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size1 = columns.size();
				for(WebElement item1 : columns.subList(0, 2))
				{
					int col = columns.indexOf(item1);			
					String data = item1.getText();

					if(col==1){
						Assert.assertTrue(data.contains("Adam"));
						po.screenShotPass("Verified that relevant record is displayed in the 'Employee Contact' search grid ");
						break;
					}
					
				 }
			}
			
			ncs.click(ncs.RowCheckBox);
			ncs.click(ncs.NextButton1);
			TestListener.test.log(Status.PASS, "Selected the record from Search grid by checking the checkbox corresponding to that record. Click on Next button");
			Thread.sleep(1000);
			if(ncs.CheckExistence("input#ctl00_ctl00_m_MessageBox_m_rwMessageBox_C_m_btnYes")>0)
				ncs.click(ncs.YesButton);
			
			//General Information Wizard
			ncs.waitForElementToBeClickable(ncs.ClaimStatus);
			po.screenShotPass("Verified that system is navigated to 'General Information' wizard on clicking 'Next' button");
			ncs.click(ncs.ClaimStatus);
			ncs.ClickTextName1("li", "Open");
			ncs.sendKeys(ncs.DateEmployerHadKnowledgeofInjury, todayDate+"2020");
			ncs.sendKeys(ncs.DateClaimAdministratorHadKnowledgeofInjury, todayDate+"2020");
			ncs.sendKeys(ncs.DateClaimAdministratorNotifiedOfEmployeeRepresentation, todayDate+"2020");
		
			ncs.click(ncs.Organization);
			ncs.ClickTextName1("li", "Email");
			ncs.sendKeys(ncs.InitialDateLastDayWorked,  todayDate+"2020");
			ncs.sendKeys(ncs.InitialReturnToWorkDate, todayDate+"2020");
			TestListener.test.log(Status.PASS, "User entered all the  mentioned details under 'General Information', 'Notice', 'Disablitiy Dates' sections");
			ncs.click(ncs.NextButton2);
			po.screenShotPass("Clicked on Next button");
			
			//Employee Details Wizard
			ncs.waitForElementToBeClickable(ncs.Height);
			po.screenShotPass("Ensure that system is navigated to 'Employee Details'");
			ncs.sendKeys(ncs.Height, "6");
			ncs.sendKeys(ncs.Weight, "88");
			ncs.click(ncs.Smoker);
			ncs.ClickTextName1("li", "No");
			TestListener.test.log(Status.PASS, "User add the information correctly for Height, Weight, Smoker and Hand Dominance");
			ncs.click(ncs.NextButton2);
			po.screenShotPass("Clicked on Next button");
			
			//Accident Wizard
			ncs.sendKeys(ncs.TimeOfInjury, "1");
			po.screenShotPass("Verified that system is navigate to 'Accident details' wizard");
			ncs.sendKeys(ncs.WorkStartTime, "7");
		
			ncs.click(ncs.CauseOfInjury);
			ncs.ClickTextName1("li", "BROKEN GLASS");
			ncs.click(ncs.NatureOfInjury);
			ncs.ClickTextName1("li", "AIDS");
			
			
			ncs.click(ncs.LossType);
			ncs.ClickTextName1("li", "Cumulative Injury");
			ncs.sendKeys(ncs.AccidentInjuryDescriptionNarrative, "Description");
			ncs.click(ncs.DateOfInjury);
			TestListener.test.log(Status.PASS, "Entered 'Time of Injury' field. Entered 'Work Start Time' field. Entered LossType. Entered 'Accident/Injury DescriptionNarrative' field. Entered 'Accident Premises' field");
			ncs.click(ncs.NextButton2);
			po.screenShotPass("Clicked on Next button");
			
			//Employment Details
			ncs.sendKeys(ncs.Wage, "10");
			po.screenShotPass("Verified that system is navigated to 'Employment' wizard");
			Thread.sleep(1000);
			ncs.sendKeys(ncs.WageEffectiveDate,  todayDate+"2020");
			Thread.sleep(1000);
			ncs.sendKeys(ncs.WageEffectiveDate,  todayDate+"2020");
			ncs.click(ncs.WagePeriodCode);
			ncs.ClickTextName1("li", "Hourly");
			//ncs.click(ncs.FullWagesPaidForDateOfInjury);
			//Thread.sleep(1000);
			//ncs.ElemenyByX("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbWageInfo_i0_m_ddlFullWagesPaid_DropDown\"]/div/ul/li[2]").click();
			//Thread.sleep(1000);
			//ncs.click(ncs.FullWagesPaidForDateOfInjury);
			//Thread.sleep(1000);
			//ncs.ElemenyByX("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbWageInfo_i0_m_ddlFullWagesPaid_DropDown\"]/div/ul/li[2]").click();
			TestListener.test.log(Status.PASS, "Entered all the required information on Employment screen");
			Thread.sleep(1000);
			Assert.assertTrue(InsuredName.contains(ncs.GetValue(ncs.InsuredName).trim()));
			Assert.assertTrue(InsuredName.contains(ncs.GetValue(ncs.InsuredUnit).trim()));
			//Assert.assertTrue(Address.contains(ncs.GetValue(ncs.InsuredAddress).trim()));
			//Assert.assertTrue(ncs.GetValue(ncs.InsuredWorkPlace).trim().contains(WorkPlaceName));
			po.screenShotPass("Verifed that Employer information : Insured Name, Insured unit, Address, Workplace address  are displayed correctly on Employment screen");
			ncs.click(ncs.FinishButton);
			po.screenShotPass("Clicked on Finish button");
			Thread.sleep(2000);
			Assert.assertTrue(ncs.ClaimNumber.isDisplayed());
			String ClaimNo= ncs.ClaimNumber.getText().trim();
			String ClaimNo1= ClaimNo.substring(5,14);
			po.screenShotPass("Verified that Claim number is displayed on next screen after clicking on Finish button. Claim number displayed as: "+ClaimNo1);
			
			//Left Menu section
			ncs.click(ncs.Actions);
			ncs.click(ncs.GenerateFROIForm);
			TestListener.test.log(Status.PASS, "Clicked on GenerateFROIForm link under Actions from left menu");
			Thread.sleep(4500);
			String AlertText = ncs.SuccessMessage.getText().trim();
	    	Assert.assertTrue(ncs.SuccessMessage.isDisplayed() && AlertText.contains("Document Created Successfully"));
	    	po.screenShotPass("'Document Created Successfully.' message appears at bottom of screen on clicking 'GenerateFROIForm' link");
	    	String PrimaryWindow= ncs.getWindowHandle();
	    	ncs.click(ncs.DocumentsIcon);
	    	Thread.sleep(3000);
	    	ncs.SwitchToNewWindow();
	    	
	    	WebElement Body = ncs.DocumentsTable.findElement(By.tagName("tbody"));
	    	String SecondaryWindow= ncs.getWindowHandle();
	    	List <WebElement> rows_= Body.findElements(By.tagName("tr"));
			
			for(WebElement item : rows_.subList(0,1))
			{				
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size1 = columns.size();
				String FirstReportOfInjury = columns.get(1).getText();
				Assert.assertTrue(FirstReportOfInjury.contains("First Report of Injury"));
				po.screenShotPass("Verified that First Report of Injury form is displayed in new window.");
				
			}
			ncs.click(ncs.ViewDocument);
			Thread.sleep(3000);
			//ncs.SwitchfromThree(PrimaryWindow);
			//Assert.assertTrue(ncs.GetURL().contains("Breeze/ViewDocument"));
			//ncs.BrowserClose();
			//ncs.switchToDefaultWindow(SecondaryWindow);
			ncs.BrowserClose();
			ncs.switchToDefaultWindow(PrimaryWindow);
			ncs.MouseOver(ncs.Financials);
			ncs.click(ncs.Reserves);
			TestListener.test.log(Status.PASS, "Clicked on Financials. selected Reserve option'");
			Thread.sleep(1000);
			
			List <WebElement> rows1_ = ncs.FinancialTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00')]"));
	    	int size1_ = rows1_.size();
	    	for(WebElement item : rows1_.subList( 0,size1_))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size1 = columns.size();
				for(WebElement item1 : columns.subList(1, 8))
				{						
					int col = columns.indexOf(item1);					
					String actual = item1.getText();
					Assert.assertTrue(actual.equals("$0.00"));
				 }
			}
			po.screenShotPass("Verified that under financial summary ,reserve worksheet are all set to '$0.00'");
			
			ncs.click(ncs.AddReserve);
	    	Thread.sleep(1000);
	    	ncs.waitForElementToBeClickable(ncs.MedicalTab);
	    	ncs.waitForElementToBeClickable(ncs.ExpenseTab);
	    	ncs.waitForElementToBeClickable(ncs.LegalTab);
	    	ncs.waitForElementToBeClickable(ncs.OtherTab);
	    	po.screenShotPass("Clicked on 'Add Reserves. Verified that Reserve Worksheet opens with  four tabs-Medical,Expense,Legal and Other");
	    	
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
	    	String value = ncs.PhysicianAvailableMeasure.getText();
	    	Assert.assertTrue(value.equals("$10.00"));
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
	    	Assert.assertTrue(TotalAdjustment.equals("$1,610.00"));
	    	po.screenShotPass("Verified that Total Adjustment amount becomes $1,610.00");
	    	
	    	
	    	//Go to Expense Tab
	    	ncs.click(ncs.ExpenseTab);
	    	TestListener.test.log(Status.PASS, "Click on Expense Tab");
	    	ncs.click(ncs.OtherExpensePencil);
	    	ncs.sendKeys(ncs.OtherExpenseQuatity, "1");
	    	ncs.click(ncs.OtherExpenseUnitMeasure);
	    	ncs.ClickTextName2("li", "Hour");
	    	ncs.sendKeys(ncs.OtherExpenseRate, "125.00");
	    	ncs.click(ncs.OtherExpenseQuatity);
	    	po.screenShotPass("Clicked on Pencil icon to edit OtherExpense. Entered Quanity as '1', Unit of Measure as 'Hour' and Rate as '125.00' ");
	    	ncs.click(ncs.OtherExpenseUpdate);
	    	TestListener.test.log(Status.PASS, "Clicked on update icon corresponding to OtherExpense row");
	    	Thread.sleep(1000);
	    	String value3 = ncs.OtherExpenseAvailableMeasure.getText();
	    	Assert.assertTrue(value3.equals("$125.00"));
	    	po.screenShotPass("Verified that 'Target -Available Reserves' is calculated based on the qty., unit of measure and rate entered i.e. OtherExpense: 1 x 125 =$600");
	    	
	    	
	    	String TotalReserveAdjustment = ncs.GetValue(ncs.TotalReservedAdjustment);
	    	String TotalReservedAmount = ncs.GetValue(ncs.TotalReservedAmount);
	    	Assert.assertTrue(TotalReservedAmount.equals("$1,735.00") && TotalReserveAdjustment.equals("$1,735.00"));
	    	po.screenShotPass("Verified that after saving the record the Total Reserve amount and total reserve Adjustment amount becomes =1,735$");
	       	Thread.sleep(1000);
	       	
	       	
	       	//Go to Other Tab
	       	ncs.click(ncs.OtherTab);
	    	TestListener.test.log(Status.PASS, "Click on Other Tab");
	    	ncs.click(ncs.MiscOtherPencil);
	    	ncs.sendKeys(ncs.MiscOtherQuatity, "2");
	    	ncs.click(ncs.MiscOtherUnitMeasure);
	    	ncs.ClickTextName2("li", "Hour");
	    	ncs.sendKeys(ncs.MiscOtherRate, "3.00");
	    	ncs.click(ncs.MiscOtherQuatity);
	    	po.screenShotPass("Clicked on Pencil icon to edit Misc Other. Entered Quanity as '2', Unit of Measure as 'Hour' and Rate as '3.00' ");
	    	ncs.click(ncs.MiscOtherUpdate);
	    	TestListener.test.log(Status.PASS, "Clicked on update icon corresponding to 'Misc Other' row");
	    	Thread.sleep(1000);
	    	String value4 = ncs.MiscOtherAvailableMeasure.getText();
	    	Assert.assertTrue(value4.equals("$6.00"));
	    	po.screenShotPass("Verified that 'Target -Available Reserves' is calculated based on the qty., unit of measure and rate entered i.e. Misc Other: 2 x 3 =$6");
	    	
	    	
	    	String TotalReserveAdjustment1 = ncs.GetValue(ncs.TotalReservedAdjustment);
	    	String TotalReservedAmount1 = ncs.GetValue(ncs.TotalReservedAmount);
	    	Assert.assertTrue(TotalReservedAmount1.equals("$1,741.00") && TotalReserveAdjustment1.equals("$1,741.00"));
	    	po.screenShotPass("Verified that after saving the record the Total Reserve amount and total reserve Adjustment amount becomes =1,735$+6= $1,741");
	    	ncs.click(ncs.SaveAndApprove);
	    	Thread.sleep(1500);
	    	
	    	
	    	List <WebElement> rows2_ = ncs.FinancialTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00')]"));
	    	int size2_ = rows2_.size();
	    	for(WebElement item : rows2_.subList( 1,2))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size1 = columns.size();
				String incurredMedical = columns.get(1).getText();
				String ReserveBalance = columns.get(3).getText();
				Assert.assertTrue(incurredMedical.equals("$1,610.00") && ReserveBalance.equals("$1,610.00"));
				po.screenShotPass("Verified that Medical expense corresponding to Incurred column ,amount is '$1,610.00' and  Medical expense corresponding to Reserve Balance column ,amount is '$1,610.00'");
			}
	
			
			ncs.MouseOver(ncs.Financials);
			Thread.sleep(1000);
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
			
			ncs.click(ncs.ServiceProviderLookUp);
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
			po.screenShotPass("Verified that 'Provider TaxID ,Provider Bussiness Name filled automatically on 'Physician Payable Entry' screen ");
			ncs.sendKeys(ncs.Provider, "test");
			Thread.sleep(2000);
			ncs.ClickTextName1("span", "381 Deerfield Road");
			ncs.sendKeys(ncs.SeriveFromDate, todayDate+"2020");
			ncs.sendKeys(ncs.SchedulePayDate, todayDate+"2020");
			Thread.sleep(1000);
			Assert.assertTrue(ncs.GetValue(ncs.PayableStatus).equals("Hold"));
			ncs.click(ncs.PayCode);
			ncs.ClickTextName2("li", "Physical Therapy (Physician)");
			po.screenShotPass("Selected Paycode. Entered Service FromDate,Service To date, Scheduled Pay Date same as Date of Injury Date");
			Thread.sleep(1000);
			Assert.assertTrue(ncs.GetValue(ncs.AvailableReserves).equals("$1,610.00"));
			po.screenShotPass("Verified that Payable status is 'Hold'. And after selecting paycode, under Reserves section Available Reserves is same as Medical Reserves i.e 1,610");
			ncs.scrollIntoView(ncs.AddDetail);
			//ncs.click(ncs.AddDetail);
			TestListener.test.log(Status.PASS, "Under Details and Adjustments section:  Clicked on + Add detail");
			ncs.waitForElementToBeClickable(ncs.RequestedAmount);
			po.screenShotPass("Verified tthat Details and Adjustment section opens up");
			ncs.sendKeys(ncs.RequestedAmount, "100");
			ncs.click(ncs.Save);
			po.screenShotPass("Entered the Requested Amount and clicked on save button. Verified that Requested Amount is entered and value is save successfully");
	       	Thread.sleep(1000);
	       	ncs.click(ncs.Save1);
	       	TestListener.test.log(Status.PASS, "Clicked on Save button of entire screen");
	    	Thread.sleep(1000);
	       	
	       	List <WebElement> rowss = ncs.PayableTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbPayables_i0_m_rgPayables_ctl00')]"));
	       	
	    	int sizes = rowss.size();
	    	Assert.assertTrue(sizes==1);
	    	for(WebElement item : rowss.subList( 0,sizes))
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
	    	List <WebElement> rowss_ = ncs.PayableTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbPayables_i0_m_rgPayables_ctl00')]"));
	       	
	    	int sizes_ = rowss_.size();
	    	for(WebElement item : rowss_.subList( 0,sizes_))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				String Status = columns.get(4).getText();
				Assert.assertTrue(Status.equals("Released"));
				po.screenShotPass("Verified that Payable entry status is 'Released' now");
			}
	    	
	    	Thread.sleep(1000);	    	
	       	//Go to Financial Summary
	    	ncs.MouseOver(ncs.Financials);
			ncs.click(ncs.Summary);
			Thread.sleep(1000);
	    	List <WebElement> rowsss = ncs.FinancialTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00')]"));	       	
	    	int sizess = rowsss.size();
	    	for(WebElement item : rowsss.subList(1,2))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				String Pending = columns.get(5).getText();
				String AR = columns.get(4).getText();
				Assert.assertTrue(Pending.equals("$100.00") && AR.equals("$1,510.00"));
				po.screenShotPass("Verified that payable amount is reflected under Pending payment s column for 'Medical' & Available Reserves is Incurred - Pending Payment ");
			}
	    	
	    	// Go again to Financials Payables
	    	Thread.sleep(1000);
	    	ncs.MouseOver(ncs.Financials);
	    	Thread.sleep(1000);
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
				String Pending = columns.get(5).getText();
				Assert.assertTrue(Pending.equals("$100.00"));
				po.screenShotPass("one record in search grid is being selected with that much payable amount i.e. $100.00");
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
	    	Thread.sleep(3500);
			String AlertText2 = ncs.CheckPrintSuccessMessage.getText().trim();
	    	Assert.assertTrue(ncs.CheckPrintSuccessMessage.isDisplayed());
	    	Assert.assertTrue(AlertText2.contains("Checks printed and batch was automatically posted") || AlertText2.contains("Successfully submitted \"Print Checks\""));
	    	po.screenShotPass("'Checks printed and batch was automatically posted.' message appears at bottom of screen on clicking 'Check Print' button");
	    	
	    	if(AlertText2.contains("Successfully submitted \"Print Checks\""))
	    	{
	    		ncs.UnlockFromUser();
	    		Thread.sleep(30000);
	    	}
	    	
	    	//Search claim
	    	dm.click(dm.FindNew);
	    	dm.click(ncs.Claims_Cases);
	    	ncs.click(ncs.SearchDD);
	    	ncs.ElemenyByX("//*[text()='Claim Number']").click();
	    	ncs.sendKeys(ncs.SearchTextField, ClaimNo1);
	    	ncs.click(ncs.SearchClaimButton);
	    	Thread.sleep(1000);
	    	ncs.click(ncs.SearchedClaim);
	    	po.screenShotPass("Searched the Claim for which check is printed after generation of Batch");
	    	
	    	Thread.sleep(1000);
	    	ncs.MouseOver(ncs.Financials);
	    	Thread.sleep(1000);
			ncs.click(ncs.Payables);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Payables");			
			Thread.sleep(1000);
	       	
	       	List <WebElement> rowss1 = ncs.PayableTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbPayables_i0_m_rgPayables_ctl00')]"));
	       	
	    	int sizes1 = rowss1.size();
	    	Assert.assertTrue(sizes1==1);
	    	for(WebElement item : rowss1.subList( sizes1-1,sizes1))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size1 = columns.size();
				String Amount = columns.get(13).getText();
				String Status = columns.get(4).getText();
				Assert.assertTrue(Status.equals("Paid") || Status.equals("Released") );
				Assert.assertTrue(Amount.equals("$100.00"));
				po.screenShotPass("Verified that on Payables screen , there is entry for that payable enterd in prevoius step and status is 'Paid' now with Amount '$100.00'");
			}
	    	
	    	Thread.sleep(2000);
	    	ncs.MouseOver(ncs.Financials);
	    	Thread.sleep(1000);
			ncs.click(ncs.Summary);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Summary");
			Thread.sleep(2000);
			//ncs.waitForElementToBeClickable(ncs.FinancialTable);
			List <WebElement> rows2_2 = ncs.FinancialTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00')]"));
	    	for(WebElement item2 : rows2_2.subList( 1,2))
			{
	    		Thread.sleep(1000);
				List <WebElement> columns = item2.findElements(By.tagName("td"));
				String incurredMedical = columns.get(1).getText();
				String PendingPayments = columns.get(5).getText();
				String incurredMedical1 = columns.get(7).getText();
				
				Assert.assertTrue(incurredMedical.equals("$1,610.00") && PendingPayments.equals("$0.00") && incurredMedical1.equals("$1,610.00"));
				po.screenShotPass("Verified that under Financial summary section. Under GROSS and Net of Recoveries corresponding to Paid  column: Medical expense amount is $1,610.00. Pending payment for Medical is Zero");
			}
	
	    	Thread.sleep(1000);
	    	ncs.MouseOver(ncs.Financials);
	    	Thread.sleep(1000);
			ncs.click(ncs.Payables);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Payables");
			Thread.sleep(1000);
			ncs.waitForElementToBeClickable(ncs.DropDown);
			po.screenShotPass("Verified that Payables screen opens up");
			ncs.click(ncs.DropDown);
			ncs.ClickTextName2("li", "Other");
			ncs.click(ncs.AddPayable);
			TestListener.test.log(Status.PASS, "Selected the dropdown value as 'Other' and clicked on +Add payable ");
			ncs.waitForElementToBeClickable(ncs.Provider);
			po.screenShotPass("Verified that 'Other payable Entry' screen opens upon clicking  +Add payable");
			
			ncs.click(ncs.ServiceProviderLookUp);
			Thread.sleep(1500);
			
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
			po.screenShotPass("Verified that 'Provider TaxID ,Provider Bussiness Name filled automatically on 'Physician Payable Entry' screen ");
			ncs.sendKeys(ncs.Provider, "test");
			Thread.sleep(2000);
			ncs.ClickTextName1("span", "381 Deerfield Road");
			ncs.sendKeys(ncs.SeriveFromDate, todayDate+"2020");
			ncs.sendKeys(ncs.SchedulePayDate, todayDate+"2020");
			Thread.sleep(1000);
			Assert.assertTrue(ncs.GetValue(ncs.PayableStatus).equals("Hold"));
			ncs.click(ncs.PayCode);
			ncs.ClickTextName2("li", "Miscellaneous Expense");
			po.screenShotPass("Selected Paycode as 'Miscellaneous Expense'. Entered Service FromDate,Service To date, Scheduled Pay Date same as Date of Injury Date");
			Thread.sleep(1000);
			Assert.assertTrue(ncs.GetValue(ncs.AvailableReserves).equals("$125.00"));
			po.screenShotPass("Verified that Payable status is 'Hold'. And after selecting paycode, under Reserves section Available Reserves is same as Medical Reserves i.e 1,610");
			ncs.scrollIntoView(ncs.AddDetail);
			//ncs.click(ncs.AddDetail);
			TestListener.test.log(Status.PASS, "Under Details and Adjustments section:  Clicked on + Add detail");
			ncs.waitForElementToBeClickable(ncs.OtherRequestedAmount);
			po.screenShotPass("Verified tthat Details and Adjustment section opens up");
			ncs.sendKeys(ncs.OtherRequestedAmount, "50");
			ncs.click(ncs.Save);
			po.screenShotPass("Entered the Requested Amount and clicked on save button. Verified that Requested Amount is entered and value is save successfully");
	       	Thread.sleep(1000);
	       	ncs.click(ncs.Save1);
	       	Thread.sleep(1000);
	       	if(ncs.CheckExistence("input#ctl00_ctl00_m_MessageBox_m_rwMessageBox_C_m_btnYes")>0)
	       	{
	       		ncs.click(ncs.YesButton1);
	       	}
	       	
	       	
	       	
	       	
	       	
	       	
	       	TestListener.test.log(Status.PASS, "Clicked on Save button of entire screen");
	    	Thread.sleep(1000);
	       	
	       	List <WebElement> rowss5 = ncs.PayableTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbPayables_i0_m_rgPayables_ctl00')]"));
	       	
	    	int sizes5 = rowss5.size();
	    	Assert.assertTrue(sizes5==2);
	    	for(WebElement item : rowss5.subList( 0,1))
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
	    	List <WebElement> rowss_5 = ncs.PayableTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbPayables_i0_m_rgPayables_ctl00')]"));
	       	
	    	int sizes_5 = rowss_5.size();
	    	for(WebElement item : rowss_5.subList( 0,sizes_))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				String Status = columns.get(4).getText();
				Assert.assertTrue(Status.equals("Released"));
				po.screenShotPass("Verified that Payable entry status is 'Released' now");
			}
	    	Thread.sleep(1000);
	       	//Go to Financial Summary
	    	ncs.MouseOver(ncs.Financials);
			ncs.click(ncs.Summary);
			Thread.sleep(1000);
	    	List <WebElement> rowsss5 = ncs.FinancialTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00')]"));	       	
	    	int sizess5 = rowsss5.size();
	    	for(WebElement item : rowsss5.subList(2,3))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				String Pending = columns.get(5).getText();
				String AR = columns.get(4).getText();
				Assert.assertTrue(Pending.equals("$50.00") && AR.equals("$75.00"));
				po.screenShotPass("Verified that payable amount is reflected under Pending payment s column for 'Expense' & Available Reserves is Incurred - Pending Payment ");
			}
	    	Thread.sleep(1000);
	    	// Go again to Financials Payables
	    	ncs.MouseOver(ncs.Financials);
	    	Thread.sleep(1000);
			ncs.click(ncs.Payables);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Payables");
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
	    	
	    	Thread.sleep(1000);
	    	List <WebElement> rowsss15 = ncs.DisbursemenTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_FinancialsContent_m_pbSearchResults_i0_m_rgSearchResults_ctl00')]"));
	       	po.screenShotPass("Disbursement batch screen opens up");
	    	int sizesss5 = rowsss15.size();
	    	for(WebElement item : rowsss15.subList(0,sizesss))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				String Pending = columns.get(5).getText();
				Assert.assertTrue(Pending.equals("$50.00"));
				po.screenShotPass("one record in search grid is being selected with that much payable amount i.e. $50.00");
			}
	    	
	    	ncs.click(ncs.GenerateBatch);
	    	TestListener.test.log(Status.PASS, "Clicked on 'Generate Batch' button");
	    	Thread.sleep(4500);
			String AlertText11 = ncs.BatchCreatedNotification.getText().trim();
	    	Assert.assertTrue(ncs.BatchCreatedNotification.isDisplayed() && AlertText11.contains("was created successfully"));
	    	po.screenShotPass("'Batch <number> was created suucessfully' message appears at bottom of screen on clicking 'Generate Batch' button");
	    	Thread.sleep(1000);
	    	ncs.click(ncs.CheckPrinterProfile);
	    	Thread.sleep(1000);
	    	ncs.ElemenyByX("//*[text()='ClaimsPrinter2']").click();
	    	Thread.sleep(4000);
	    	TestListener.test.log(Status.PASS, "Selected Check Printer Profile");
	    	ncs.click(ncs.PrintChecks);
	    	TestListener.test.log(Status.PASS, "Clicked on 'Print Checks' button");
	    	Thread.sleep(3000);
			String AlertText21 = ncs.CheckPrintSuccessMessage.getText().trim();
	    	Assert.assertTrue(ncs.CheckPrintSuccessMessage.isDisplayed());
	    	Assert.assertTrue(AlertText21.contains("Checks printed and batch was automatically posted") || AlertText21.contains("Successfully submitted \"Print Checks\""));
	    	po.screenShotPass("'Checks printed and batch was automatically posted.' message appears at bottom of screen on clicking 'Check Print' button");
	    	
	     	if(AlertText21.contains("Successfully submitted \"Print Checks\""))
	    	{
	    		ncs.UnlockFromUser();
	    		Thread.sleep(30000);
	    	}
	    	
	    	
	    	//Search claim
	    	dm.click(dm.FindNew);
	    	dm.click(ncs.Claims_Cases);
	    	ncs.click(ncs.SearchDD);
	    	ncs.ElemenyByX("//*[text()='Claim Number']").click();
	    	ncs.sendKeys(ncs.SearchTextField, ClaimNo1);
	    	ncs.click(ncs.SearchClaimButton);
	    	Thread.sleep(1000);
	    	ncs.click(ncs.SearchedClaim);
	    	po.screenShotPass("Searched the Claim for which check is printed after generation of Batch");
	    	
	    	Thread.sleep(1000);
	    	ncs.MouseOver(ncs.Financials);
	    	Thread.sleep(1000);
			ncs.click(ncs.Payables);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Payables");
			
			Thread.sleep(1000);
	       	
	       	List <WebElement> rowss11 = ncs.PayableTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbPayables_i0_m_rgPayables_ctl00')]"));
	       	
	    	int sizes11 = rowss11.size();
	    	Assert.assertTrue(sizes11==2);
	    	for(WebElement item : rowss11.subList(0,1))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size1 = columns.size();
				String Status = columns.get(4).getText();
				Assert.assertTrue(Status.equals("Paid") || Status.equals("Released") );
				po.screenShotPass("Verified that on Payables screen , there is entry for that payable enterd in prevoius step and status is 'Paid' now. So, Expense amount is displayed as  $50");
			}
	    	   	
	    	Thread.sleep(1000);
	    	ncs.MouseOver(ncs.Financials);
	    	Thread.sleep(1000);
			ncs.click(ncs.Summary);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Summary");
			Thread.sleep(2000);
			//ncs.waitForElementToBeClickable(ncs.FinancialTable);
			List <WebElement> rows2_21 = ncs.FinancialTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00')]"));
	    	for(WebElement item2 : rows2_21.subList( 1,2))
			{
				List <WebElement> columns = item2.findElements(By.tagName("td"));
				String incurredMedical = columns.get(1).getText();
				String PendingPayments = columns.get(5).getText();
				String incurredMedical1 = columns.get(7).getText();
				
				Assert.assertTrue(incurredMedical.equals("$1,610.00") && PendingPayments.equals("$0.00") && incurredMedical1.equals("$1,610.00"));
				po.screenShotPass("Verified that under Financial summary section. Under GROSS and Net of Recoveries corresponding to Paid  column: Medical expense amount is $1,610.00. Pending payment for Medical is Zero");
			}
	
	    	Thread.sleep(1000);
	    	ncs.MouseOver(ncs.Financials);
	    	Thread.sleep(1000);
			ncs.click(ncs.Payables);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Payables");
			ncs.waitForElementToBeClickable(ncs.DropDown);
			po.screenShotPass("Verified that Payables screen opens up");
			ncs.click(ncs.DropDown);
			ncs.ClickTextName2("li", "Other");
			ncs.click(ncs.AddPayable);
			TestListener.test.log(Status.PASS, "Selected the dropdown value as 'Other' and clicked on +Add payable ");
			ncs.waitForElementToBeClickable(ncs.Provider);
			po.screenShotPass("Verified that 'Other payable Entry' screen opens upon clicking  +Add payable");
			
			ncs.click(ncs.ServiceProviderLookUp);
			Thread.sleep(1500);
			
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
			po.screenShotPass("Verified that 'Provider TaxID ,Provider Bussiness Name filled automatically on 'Physician Payable Entry' screen ");
			ncs.sendKeys(ncs.Provider, "test");
			Thread.sleep(2000);
			ncs.ClickTextName1("span", "381 Deerfield Road");
			ncs.sendKeys(ncs.SeriveFromDate, todayDate+"2020");
			ncs.sendKeys(ncs.SchedulePayDate, todayDate+"2020");
			Thread.sleep(1000);
			Assert.assertTrue(ncs.GetValue(ncs.PayableStatus).equals("Hold"));
			ncs.click(ncs.PayCode);
			ncs.ClickTextName2("li", "Penalties Paid");
			po.screenShotPass("Selected Paycode as 'Penalties Paid'. Entered Service FromDate,Service To date, Scheduled Pay Date same as Date of Injury Date");
			Assert.assertTrue(ncs.GetValue(ncs.AvailableReserves).equals("$6.00"));
			po.screenShotPass("Verified that Payable status is 'Hold'. And after selecting paycode, under Reserves section Available Reserves is same as Medical Reserves i.e 1,610");
			ncs.scrollIntoView(ncs.AddDetail);
			//ncs.click(ncs.AddDetail);
			TestListener.test.log(Status.PASS, "Under Details and Adjustments section:  Clicked on + Add detail");
			ncs.waitForElementToBeClickable(ncs.OtherRequestedAmount);
			po.screenShotPass("Verified that Details and Adjustment section opens up");
			ncs.sendKeys(ncs.OtherRequestedAmount, "5");
			ncs.click(ncs.Save);
			po.screenShotPass("Entered the Requested Amount and clicked on save button. Verified that Requested Amount is entered and value is save successfully");
	       	Thread.sleep(1000);
	       	ncs.click(ncs.Save1);
	       	Thread.sleep(1000);
	       	if(ncs.CheckExistence("input#ctl00_ctl00_m_MessageBox_m_rwMessageBox_C_m_btnYes")>0)
	       	{
	       		ncs.click(ncs.YesButton1);
	       	}
	       	
	       	
	
	       	TestListener.test.log(Status.PASS, "Clicked on Save button of entire screen");
	    	Thread.sleep(2000);
	       	
	       	List <WebElement> rowss51 = ncs.PayableTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbPayables_i0_m_rgPayables_ctl00')]"));
	       	
	    	int sizes51 = rowss51.size();
	    	Assert.assertTrue(sizes51==3);
	    	for(WebElement item : rowss51.subList( 0,1))
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
	    	List <WebElement> rowss_51 = ncs.PayableTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbPayables_i0_m_rgPayables_ctl00')]"));
	       	
	    	int sizes_51 = rowss_51.size();
	    	for(WebElement item : rowss_51.subList( 0,1))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				String Status = columns.get(4).getText();
				Assert.assertTrue(Status.equals("Released"));
				po.screenShotPass("Verified that Payable entry status is 'Released' now");
			}
	       	
	    	Thread.sleep(2000);
	       	//Go to Financial Summary
	    	ncs.MouseOver(ncs.Financials);
			ncs.click(ncs.Summary);
			Thread.sleep(1000);
	    	List <WebElement> rowsss51 = ncs.FinancialTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00')]"));	       	
	    	int sizess51 = rowsss51.size();
	    	for(WebElement item : rowsss51.subList(5,6))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				String Pending = columns.get(5).getText();
				String AR = columns.get(4).getText();
				Assert.assertTrue(Pending.equals("$5.00") && AR.equals("$1.00"));
				po.screenShotPass("Verified that payable amount is reflected under Pending payment s column for 'Other' & Available Reserves is Incurred - Pending Payment ");
			}
	    	
	    	Thread.sleep(1000);
	    	// Go again to Financials Payables
	    	ncs.MouseOver(ncs.Financials);
	    	Thread.sleep(1000);
			ncs.click(ncs.Payables);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Payables");
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
	    	
	    	Thread.sleep(1000);
	    	List <WebElement> rowsss151 = ncs.DisbursemenTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_FinancialsContent_m_pbSearchResults_i0_m_rgSearchResults_ctl00')]"));
	       	po.screenShotPass("Disbursement batch screen opens up");
	    	int sizesss51 = rowsss151.size();
	    	for(WebElement item : rowsss151.subList(0,sizesss51))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				String Payable = columns.get(5).getText();
				Assert.assertTrue(Payable.equals("$5.00"));
				po.screenShotPass("one record in search grid is being selected with that much payable amount i.e. $5.00");
			}
	    	
	    	ncs.click(ncs.GenerateBatch);
	    	TestListener.test.log(Status.PASS, "Clicked on 'Generate Batch' button");
	    	Thread.sleep(4500);
			String AlertText111 = ncs.BatchCreatedNotification.getText().trim();
	    	Assert.assertTrue(ncs.BatchCreatedNotification.isDisplayed() && AlertText111.contains("was created successfully"));
	    	po.screenShotPass("'Batch <number> was created suucessfully' message appears at bottom of screen on clicking 'Generate Batch' button");
	    	Thread.sleep(1000);
	    	ncs.click(ncs.CheckPrinterProfile);
	    	Thread.sleep(1000);
	    	ncs.ElemenyByX("//*[text()='ClaimsPrinter2']").click();
	    	Thread.sleep(4000);
	    	TestListener.test.log(Status.PASS, "Selected Check Printer Profile");
	    	ncs.click(ncs.PrintChecks);
	    	TestListener.test.log(Status.PASS, "Clicked on 'Print Checks' button");
	    	Thread.sleep(2000);
			String AlertText211 = ncs.CheckPrintSuccessMessage.getText().trim();
	    	Assert.assertTrue(ncs.CheckPrintSuccessMessage.isDisplayed());
	    	Assert.assertTrue(AlertText211.contains("Checks printed and batch was automatically posted") || AlertText211.contains("Successfully submitted \"Print Checks\""));
	    	po.screenShotPass("'Checks printed and batch was automatically posted.' message appears at bottom of screen on clicking 'Check Print' button");
	    	
	     	if(AlertText211.contains("Successfully submitted \"Print Checks\""))
	    	{
	    		ncs.UnlockFromUser();
	    		Thread.sleep(30000);
	    	}
	    	
	    	
	    	//Search claim
	    	dm.click(dm.FindNew);
	    	dm.click(ncs.Claims_Cases);
	    	ncs.click(ncs.SearchDD);
	    	ncs.ElemenyByX("//*[text()='Claim Number']").click();
	    	ncs.sendKeys(ncs.SearchTextField, ClaimNo1);
	    	ncs.click(ncs.SearchClaimButton);
	    	Thread.sleep(1000);
	    	ncs.click(ncs.SearchedClaim);
	    	po.screenShotPass("Searched the Claim for which check is printed after generation of Batch");
	    	
	    	Thread.sleep(1000);
	    	ncs.MouseOver(ncs.Financials);
	    	Thread.sleep(1000);
			ncs.click(ncs.Payables);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Payables");
			
			Thread.sleep(1000);
	       	
	       	List <WebElement> rowss111 = ncs.PayableTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbPayables_i0_m_rgPayables_ctl00')]"));
	       	
	    	int sizes111 = rowss111.size();
	    	Assert.assertTrue(sizes111==3);
	    	for(WebElement item : rowss111.subList(0,1))
			{
				List <WebElement> columns = item.findElements(By.tagName("td"));
				int size1 = columns.size();
				String Status = columns.get(4).getText();
				String Amount = columns.get(13).getText();
				Assert.assertTrue(Status.equals("Paid") || Status.equals("Released") );
				Assert.assertTrue(Amount.equals("$5.00") );
				po.screenShotPass("Verified that on Payables screen , there is entry for that payable enterd in prevoius step and status is 'Paid' now. So, 'Other' amount is displayed as $5");
			}
	    	
	    	Thread.sleep(1000);
	    	ncs.MouseOver(ncs.Financials);
	    	Thread.sleep(1000);
			ncs.click(ncs.Summary);
			TestListener.test.log(Status.PASS, "Mouse Over Financials menu- clicked on Summary");
			Thread.sleep(2000);
			//ncs.waitForElementToBeClickable(ncs.FinancialTable);
			List <WebElement> rows2_211 = ncs.FinancialTable.findElements(By.xpath("//tr[contains(@id, 'ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00')]"));
	    	for(WebElement item2 : rows2_211.subList( 5,6))
			{
				List <WebElement> columns = item2.findElements(By.tagName("td"));
				String incurredOther = columns.get(1).getText();
				String PendingPayments = columns.get(5).getText();
				String incurredOther1 = columns.get(7).getText();
				
				Assert.assertTrue(incurredOther.equals("$6.00") && PendingPayments.equals("$0.00") && incurredOther1.equals("$6.00"));
				po.screenShotPass("Verified that under Financial summary section. Under GROSS and Net of Recoveries corresponding to Paid  column: Other's amount is $6.00. Pending payment for Other is Zero");
			}
	    	
	    	String PaidMedical = ncs.ElemenyByX("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00__1\"]/td[9]").getText();
	    	String PaidExpense = ncs.ElemenyByX("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00__2\"]/td[9]").getText();
	    	String PaidOther = ncs.ElemenyByX("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00__5\"]/td[9]").getText();
	    	Assert.assertTrue(PaidMedical.equals("$100.00") && PaidExpense.equals("$50.00") && PaidOther.equals("$5.00"));
	    	
	    	po.screenShotPass("Also Verified that under Financial summary section: Under Net of Recoveries Corresponding to Paid  column: Medical expense amount is displayed as $100.00, Expense amound displayed as 50 $ and Other Amount is displayed as $5.00");
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
