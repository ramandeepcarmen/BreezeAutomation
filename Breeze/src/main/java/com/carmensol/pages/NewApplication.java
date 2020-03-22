package com.carmensol.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.carmensol.utilities.utility1;

public class NewApplication extends utility1

{

	
	public static ExtentReports report;
	public ExtentTest test;
	public Properties prop;
	
	public NewApplication(WebDriver driver, ExtentTest test) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.test = test;

	}

	//General Information
	
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbGeneralInfo_i0_m_ucInsuredName_m_tbName") public WebElement Name;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbGeneralInfo_i0_m_ucInsuredName_m_ddlNameTypeCode_Input") public WebElement NameType;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbGeneralInfo_i0_m_ddlApplicationSource_Input") public WebElement ApplicationSource;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbGeneralInfo_i0_m_ddlAgent_Input") public WebElement Agent;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbContactInfo_i0_m_ucMailingAddress_m_tbAddress1") public WebElement Address1;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbContactInfo_i0_m_ucMailingAddress_m_ddlCityStateZip_Input") public WebElement CityStateCountry;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbContactInfo_i0_m_ucCorporateContact_m_tbFirstName") public WebElement FirstName;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbContactInfo_i0_m_ucCorporateContact_m_tbLastName") public WebElement LastName;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbApplicantInfo_i0_m_ddlBusinessType_Input") public WebElement BusinessType;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbApplicantInfo_i0_m_tbOtherBusinessType") public WebElement OtherBusinessType;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbApplicantInfo_i0_m_ddlIndustryCode_Input") public WebElement NAIC;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbPolicyInfo_i0_m_dpPolicyEffectiveDate_dateInput") public WebElement EffectiveDate;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbPolicyInfo_i0_m_dpPolicyAnniversaryDate_dateInput") public WebElement AnniversaryDate;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbPolicyInfo_i0_m_ddlEmployeeLeasingType_Input") public WebElement EmployeeLeasingType;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbPolicyInfo_i0_m_dpPolicyExpirationDate_dateInput") public WebElement ExpirationDate;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbApplicantInfo_i0_m_tbYearsInBusiness") public WebElement YearsInBusiness;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbApplicantInfo_i0_m_tbFEIN") public WebElement FEIN;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction2") public WebElement Next;
	
	//Units Screen
	@FindBy(how=How.CSS, using="a#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbUnitInformation_i0_m_ucInsuredUnitExpModControl_m_rgMain_ctl00_ctl02_ctl00_InitInsertButton") public WebElement AddExperienceMod;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbUnitInformation_i0_m_ucInsuredUnitExpModControl_m_rgMain_ctl00_ctl02_ctl03_m_tbModifier") public WebElement Modifier;	
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbUnitInformation_i0_m_ucInsuredUnitExpModControl_m_rgMain_ctl00_ctl02_ctl03_m_ddlRatingType_Input") public WebElement RatingType;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbUnitInformation_i0_m_ucInsuredUnitExpModControl_m_rgMain_ctl00_ctl02_ctl03_m_btnInsertExperienceModifier") public WebElement SaveButton;
	@FindBy(how=How.XPATH, using="//span[text()='Add Unit']") public WebElement AddUnit;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbUnitInformation_i0_m_ddlGoverningState_Input") public WebElement GoverningState;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbUnitInformation_i0_m_tbUnitName") public WebElement UnitName;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbUnitContacts_i0_m_ucUnitContact_m_tbFirstName") public WebElement FirstName1;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbUnitContacts_i0_m_ucUnitContact_m_tbLastName") public WebElement LastName1;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbUnitContacts_i0_m_ucMailAddress_m_tbAddress1") public WebElement Address1_;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbUnitContacts_i0_m_ucMailAddress_m_ddlCityStateZip_Input") public WebElement CityStateZip;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbUnitContacts_i0_m_ucBillingContact_m_tbBusinessName") public WebElement Business;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbUnitContacts_i0_m_ucBillingContact_m_ucMailingAddress_m_tbAddress1") public WebElement MailingAddress1_;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbUnitContacts_i0_m_ucBillingContact_m_ucMailingAddress_m_ddlCityStateZip_Input") public WebElement MailingCityStateZip;
	
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbUnitContacts_i0_m_ucLocationOfRecordContact_m_tbBusinessName") public WebElement BusinessRecord;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbUnitContacts_i0_m_ucLocationOfRecordContact_m_ucPhysicalAddress_m_tbAddress1") public WebElement PhysicalAddress1_;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbUnitContacts_i0_m_ucLocationOfRecordContact_m_ucPhysicalAddress_m_ddlCityStateZip_Input") public WebElement PhysicalCityStateZip;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction1") public WebElement SaveButton1;
	@FindBy(how=How.CSS, using="table#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbCurrentUnits_i0_m_rgCurrentUnits_ctl00") public WebElement CurrentUnitTable;
	
	//Workplace Wizard
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbCurrentWorkplaces_i0_m_ucUnitSelectorControl_m_ddlUnits_Input") public WebElement UnitDD;
	
	//Payroll Screen
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbPayroll_i0_m_ucUnitSelector_m_ddlUnits_Input") public WebElement UnitDD1;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbPayroll_i0_m_ucPayrollList_m_rgMain_ctl00_ctl02_ctl03_m_ddlClassCodeDescription_Input") public WebElement ClassificationCode;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbPayroll_i0_m_ucPayrollList_m_rgMain_ctl00_ctl02_ctl03_m_tbAnnualPayroll") public WebElement AnnualPayroll;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbPayroll_i0_m_ucPayrollList_m_rgMain_ctl00_ctl02_ctl03_m_btnInsertAndAddAnother") public WebElement SaveAndAddAnotherButton;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbPayroll_i0_m_ucPayrollList_m_rgMain_ctl00_ctl02_ctl03_m_btnInsert") public WebElement SavePayroll;
	@FindBy(how=How.CSS, using="table#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbPayroll_i0_m_ucPayrollList_m_rgMain_ctl00") public WebElement PayrollTable;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction2") public WebElement FinishPayroll;
	
	//Application header
	@FindBy(how=How.CSS, using="span#ctl00_ctl00_ContentPlaceHolder1_m_ucApplicationFormHeaderControl_m_dblBusinessName") public WebElement ApplicationName;
	@FindBy(how=How.XPATH, using="//span[text()='General Information']") public WebElement GeneralInformation;
	@FindBy(how=How.XPATH, using="//span[text()='Units']") public WebElement Units;
	@FindBy(how=How.XPATH, using="//span[text()='Units']") public WebElement WorkPlaces;
	@FindBy(how=How.XPATH, using="//span[text()='Officers']") public WebElement Officers;
	@FindBy(how=How.XPATH, using="//span[text()='Loss History']") public WebElement LossHistory;
	@FindBy(how=How.XPATH, using="//span[text()='Other Entities']") public WebElement OtherEntities;
	@FindBy(how=How.XPATH, using="a[href='appQuotes.aspx?qs=10PoDrnKChQGPY27Xcg0j7JGprZvSG3tOwHm2heyCZuyr1k0AQSZ3Y%2fVBXe74m4tevuFJ%2f156fOoIxYZShSTHFraoEO%2b%2fvRrhhVLZBv3ziJ1CzgrIeiUKBAgTxKkCqGFYwFYCs66djzmlhrKwm2MMmZO%2bKxz4Vae3p5eWq%2fTXeM%3d']") public WebElement Quotes;
	@FindBy(how=How.XPATH, using="//span[text()='Optional Policy Forms']") public WebElement OptionalPolicyForms;
	@FindBy(how=How.XPATH, using="//span[text()='Application Info']") public WebElement ApplicationInfo;
	@FindBy(how=How.CSS, using="a#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_ucOfficers_m_pbOfficers_i0_m_rgOfficers_ctl00_ctl02_ctl00_InitInsertButton") public WebElement AddOfficers;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_ucOfficers_m_pbNewOfficer_i0_m_tbFirstName") public WebElement OfficersName;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_ucOfficers_m_pbNewOfficer_i0_m_tbLastName") public WebElement OfficersLast;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_ucOfficers_m_pbNewOfficer_i0_m_ddlTitle_Input") public WebElement OfficersTitle;
	@FindBy(how=How.CSS, using="input[name='ctl00$ctl00$ContentPlaceHolder1$ApplicationContent$m_ucOfficers$m_btnAction1']") public WebElement SaveOfficers;
	@FindBy(how=How.CSS, using="table#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_ucOfficers_m_pbOfficers_i0_m_rgOfficers_ctl00") public WebElement OfficersTable;
	
	@FindBy(how=How.CSS, using="a#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_ucLossHistory_m_pbLossHistory_i0_m_rgLossHistory_ctl00_ctl02_ctl00_InitInsertButton") public WebElement AddLossHistory;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_ucLossHistory_m_pbLossHistory_i0_m_rgLossHistory_ctl00_ctl02_ctl04_m_tbPolicyYear") public WebElement PolicyYear;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_ucLossHistory_m_pbLossHistory_i0_m_rgLossHistory_ctl00_ctl02_ctl04_m_ddlNCCICarrierCode_Input") public WebElement NCCCarrierCode;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_ucLossHistory_m_pbLossHistory_i0_m_rgLossHistory_ctl00_ctl02_ctl04_m_btnInsert") public WebElement SaveLoss;
	@FindBy(how=How.CSS, using="table#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_ucLossHistory_m_pbLossHistory_i0_m_rgLossHistory_ctl00") public WebElement LossHistoryTable;
	
	@FindBy(how=How.CSS, using="a#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbQuotes_i0_m_rgExistingQuotes_ctl00_ctl02_ctl00_InitInsertButton") public WebElement AddQuotes;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbQuoteInfo_i0_m_ddlCarrier_Input") public WebElement Carrier;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbQuoteInfo_i0_m_ddlProgram_Input") public WebElement Program;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbQuoteInfo_i0_m_ddlProductId_Input") public WebElement Product;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction3") public WebElement NextQuote;
	@FindBy(how=How.CSS, using="div#ctl00_ctl00_m_NotificationBox_simpleContentDiv") public WebElement QuoteNotification;
	
	//Quotes Employers Liability
	@FindBy(how=How.CSS, using="a#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbEmployersLiabilityLimits_i0_m_ucEel_m_rgMain_ctl00_ctl02_ctl00_InitInsertButton") public WebElement AddLimit;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbEmployersLiabilityLimits_i0_m_ucEel_m_rgMain_ctl00_ctl02_ctl03_PerformInsertButton") public WebElement InsertLimit;
	@FindBy(how=How.CSS, using="table#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbEmployersLiabilityLimits_i0_m_ucEel_m_rgMain_ctl00") public WebElement LimitTable;
	
	//Quotes Credit/Debit
	@FindBy(how=How.CSS, using="a#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbCreditsDebits_i0_m_ucCredits_m_rgCreditsDebits_ctl00_ctl02_ctl00_InitInsertButton") public WebElement AddCreditDebit;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbCreditsDebits_i0_m_ucCredits_m_rgCreditsDebits_ctl00_ctl02_ctl03_m_btnUpdateCredits") public WebElement SaveCredit;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbCreditsDebits_i0_m_ucCredits_m_rgCreditsDebits_ctl00_ctl02_ctl03_m_ddlCreditUnit_Input") public WebElement CreditDebitUnit;
	@FindBy(how=How.CSS, using="table#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbCreditsDebits_i0_m_ucCredits_m_rgCreditsDebits_ctl00") public WebElement CreditDebitTable;
	
	//Quotes Surcharges
	@FindBy(how=How.CSS, using="a#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbStateSurcharges_i0_m_rgStateSurcharges_ctl00_ctl02_ctl00_InitInsertButton") public WebElement AddSurcharges;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbStateSurcharges_i0_m_rgStateSurcharges_ctl00_ctl02_ctl03_m_ddlSurchargeUnit_Input") public WebElement SurchargesUnit;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbStateSurcharges_i0_m_rgStateSurcharges_ctl00_ctl02_ctl03_m_dpSurchargeFromDate_dateInput") public WebElement SurchargesEffectiveDate;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbStateSurcharges_i0_m_rgStateSurcharges_ctl00_ctl02_ctl03_m_dpSurchargeToDate_dateInput") public WebElement SurchargesExpirationDate;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbStateSurcharges_i0_m_rgStateSurcharges_ctl00_ctl02_ctl03_m_btnUpdateSurcharges") public WebElement SaveSurcharges;
	
	
	//Quotes Billing
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbBillingPlans_i0_m_rgBillingPlan_ctl00_ctl05_m_btnUpdateBillingPlans") public WebElement SaveBilling;
	@FindBy(how=How.CSS, using="table#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbBillingPlans_i0_m_rgBillingPlan_ctl00") public WebElement BillingTable;
	
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction2") public WebElement FinishQuote;	
	
	
	//Quote
	@FindBy(how=How.CSS, using="table#ctl00_ctl00_ContentPlaceHolder1_ApplicationContent_m_pbQuotes_i0_m_rgExistingQuotes_ctl00") public WebElement QuoteTable;
	@FindBy(how=How.CSS, using="a#m_piBillingPlans") public WebElement OpenBillingPlans;	
	@FindBy(how=How.CSS, using="a.fa.fa-cog.fa-no-link") public WebElement QuoteAction;	
	
	
	
	
	
}
