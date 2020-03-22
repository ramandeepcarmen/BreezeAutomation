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

public class NewClaimScreen  extends utility1

{

	
	public static ExtentReports report;
	public ExtentTest test;
	public Properties prop;
	
	public NewClaimScreen(WebDriver driver, ExtentTest test) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.test = test;

	}

	@FindBy(how = How.CSS, using = "input[name='ctl00$ctl00$ContentPlaceHolder1$ClaimsContent$m_ddlJurisdiction']") public WebElement Jurisdiction;
	@FindBy(how = How.CSS, using = "input[name='ctl00$ctl00$ContentPlaceHolder1$ClaimsContent$m_dpDateOfInjury$dateInput']") public WebElement InjuryDate;
	@FindBy(how = How.CSS, using = "input[name='ctl00$ctl00$ContentPlaceHolder1$ClaimsContent$m_ucSearch$m_rgQuery$ctl00$ctl04$ddlFields']") public WebElement InsuredCriteriaDD;
	@FindBy(how = How.CSS, using = "input[name='ctl00$ctl00$ContentPlaceHolder1$ClaimsContent$m_ucSearch$m_rgQuery$ctl00$ctl04$tbValue']") public WebElement SearchField;
	@FindBy(how = How.CSS, using = "input[name='ctl00$ctl00$ContentPlaceHolder1$ClaimsContent$m_btnSearch']") public WebElement SearchButton;
	@FindBy(how = How.CSS, using = "table#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_rgResults_ctl00") public WebElement SearchTable;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_rgResults_ctl00_ctl04_columnSelectCheckBox") public WebElement RowCheckBox;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction1") public WebElement NextButton;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucSearch_m_rgQuery_ctl00_ctl04_tbValue") public WebElement LastName;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucSearch_m_rgQuery_ctl00_ctl05_tbValue") public WebElement FirstName;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucSearch_m_rgQuery_ctl00_ctl06_tbValue") public WebElement Address;
	@FindBy(how = How.CSS, using = "a#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucSearch_m_rgQuery_ctl00_ctl03_ctl01_btnAddCriteria") public WebElement Plus;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_btnSearch") public WebElement SearchButton1;
	@FindBy(how = How.CSS, using = "table#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_rgResults_ctl00") public WebElement EmployeeContactTable;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction2") public WebElement NextButton1;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_m_MessageBox_m_rwMessageBox_C_m_btnYes") public WebElement YesButton;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbGeneralInfo_i0_m_ddlClaimAdministrator_Input") public WebElement ClaimAdministrator;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbGeneralInfo_i0_m_ddlClaimStatus_Input") public WebElement ClaimStatus;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbGeneralInfo_i0_m_ddlClaimType_Input") public WebElement ClaimType;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbNotice_i0_m_dpDateEmployerHadKnowledgeOfInjury_dateInput") public WebElement DateEmployerHadKnowledgeofInjury;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbNotice_i0_m_dpDateEmployerHadKnowledgeOfDateOfDisability_dateInput") public WebElement DateEmployerHadKnowledgeofDisability;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbNotice_i0_m_dpDateClaimAdministratorHadKnowledgeOfInjury_dateInput") public WebElement DateClaimAdministratorHadKnowledgeofInjury;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbNotice_i0_m_ddlOrigination_Input") public WebElement Organization;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbNotice_i0_m_dpDateClaimAdministratorNotifiedOfEmployeeRepresentation_dateInput") public WebElement DateClaimAdministratorNotifiedOfEmployeeRepresentation;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbDisabilityDates_i0_m_dpInitialDateLastDayWorked_dateInput") public WebElement InitialDateLastDayWorked;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbDisabilityDates_i0_m_dpInitialReturnToWorkDate_dateInput") public WebElement InitialReturnToWorkDate;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction3") public WebElement NextButton2;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbMedicalProfile_i0_m_tbHeight") public WebElement Height;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbMedicalProfile_i0_m_tbWeight") public WebElement Weight;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbMedicalProfile_i0_m_ddlSmoker_Input") public WebElement Smoker;
	
	//Accident Details
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbAccidentDetails_i0_m_dpDateOfInjury_dateInput") public WebElement DateOfInjury;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbAccidentDetails_i0_m_tpTimeOfInjury_dateInput") public WebElement TimeOfInjury;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbAccidentDetails_i0_m_tpWorkStartTime_dateInput") public WebElement WorkStartTime;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbAccidentDetails_i0_m_ddlUnitStatLossType_Input") public WebElement LossType;
	@FindBy(how = How.CSS, using = "textarea#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbAccidentDetails_i0_m_tbInjuryDescription") public WebElement AccidentInjuryDescriptionNarrative;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbAccidentDetails_i0_m_ddlPartOfBodyInjuredInput") public WebElement PartOfBodyInjured;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbAccidentDetails_i0_m_ddlCauseOfInjury_Input") public WebElement CauseOfInjury;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbAccidentDetails_i0_m_ddlNatureOfInjury_Input") public WebElement NatureOfInjury;
	
	//Employment Detail
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbWageInfo_i0_m_tbWage") public WebElement Wage;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbWageInfo_i0_m_ddlWagePeriodCode_Input") public WebElement WagePeriodCode;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbWageInfo_i0_m_dpWageEffectiveDate_dateInput") public WebElement WageEffectiveDate;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbWageInfo_i0_m_ddlFullWagesPaid_Input") public WebElement FullWagesPaidForDateOfInjury;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction4") public WebElement FinishButton;
	
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbEmployer_i0_m_tbInsuredName") public WebElement InsuredName;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbEmployer_i0_m_ucInsuredMailing_m_tbAddress1") public WebElement InsuredAddress;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbEmployer_i0_m_tbInsuredUnitName") public WebElement InsuredUnit;
	@FindBy(how = How.CSS, using = "input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbEmployer_i0_m_ddlWorkplace_Input") public WebElement InsuredWorkPlace;
	
	//Claim screen
	@FindBy(how = How.CSS, using = "span#ctl00_ctl00_ContentPlaceHolder1_m_dblClaimNo") public WebElement ClaimNumber;
	
	//Left Hand Side menu
	@FindBy(how=How.XPATH, using="//span[text()='Actions']") public WebElement Actions;
	@FindBy(how=How.XPATH, using="//span[text()='Generate FROI Form']") public WebElement GenerateFROIForm;
	@FindBy(how=How.CSS, using="div#ctl00_ctl00_m_NotificationBox_simpleContentDiv") public WebElement SuccessMessage;
	@FindBy(how=How.XPATH, using="//span[text()='Financials']") public WebElement Financials;
	@FindBy(how=How.XPATH, using="//span[text()='Reserves']") public WebElement Reserves;
	@FindBy(how=How.XPATH, using="//span[text()='Claim']") public WebElement ClaimMenu;
	
	//Right side icons
	@FindBy(how=How.CSS, using="li#ctl00_ctl00_ContentPlaceHolder1_m_ucActivityCenter_m_liDocuments") public WebElement DocumentsIcon;
	
	//Documents
	@FindBy(how=How.CSS, using="table#ctl00_ctl00_ContentPlaceHolder1_PrivateContent_m_rgDocuments_ctl00") public WebElement DocumentsTable;
	@FindBy(how=How.CSS, using="a.fa.fa-camera.fa-no-link") public WebElement ViewDocument;
	
	//Financials
	@FindBy(how=How.CSS, using="a#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserves_i0_m_rgReserves_ctl00_ctl02_ctl00_m_lnkAddReserve") public WebElement AddReserve;
	@FindBy(how=How.CSS, using="table#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00") public WebElement FinancialTable;
	@FindBy(how=How.XPATH, using="//span[text()='Medical']") public WebElement MedicalTab;
	@FindBy(how=How.XPATH, using="//span[text()='Expense']") public WebElement ExpenseTab;
	@FindBy(how=How.XPATH, using="//span[text()='Legal']") public WebElement LegalTab;
	@FindBy(how=How.XPATH, using="//span[text()='Other']") public WebElement OtherTab;
	
	//Financial Indemnity Tab
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgIndemnity_m_rgGrid_ctl00_ctl08_EditButton") public WebElement OtherIndemnityPencil;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgIndemnity_m_rgGrid_ctl00_ctl08_m_tbQuantity") public WebElement OtherIndemnityQuatity;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgIndemnity_m_rgGrid_ctl00_ctl08_m_tbRate") public WebElement OtherIndemnityRate;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgIndemnity_m_rgGrid_ctl00_ctl08_m_ddlUnitOfMeasure_Input") public WebElement OtherIndemnityUnitMeasure;
	@FindBy(how=How.CSS, using="span#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgIndemnity_m_rgGrid_ctl00_ctl08_m_lblAmount") public WebElement OtherIndemnityAvailableMeasure;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgIndemnity_m_rgGrid_ctl00_ctl08_UpdateButton") public WebElement OtherIndemnityUpdate;
	
	//Financial Medical Tab
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl04_EditButton") public WebElement PhysicialPencil;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl04_m_tbQuantity") public WebElement PhysianQuatity;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl04_m_tbRate") public WebElement PhysicianRate;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl04_m_ddlUnitOfMeasure_Input") public WebElement PhysicianUnitMeasure;
	@FindBy(how=How.CSS, using="span#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl04_m_lblAmount") public WebElement PhysicianAvailableMeasure;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl04_UpdateButton") public WebElement PhysicianUpdate;
	
	
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl06_EditButton") public WebElement PharmacyPencil;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl06_m_tbQuantity") public WebElement PharmacyQuatity;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl06_m_tbRate") public WebElement PharmacyRate;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl06_m_ddlUnitOfMeasure_Input") public WebElement PharmacyUnitMeasure;
	@FindBy(how=How.CSS, using="span#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl06_m_lblAmount") public WebElement PharmacyAvailableMeasure;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl06_UpdateButton") public WebElement PharmacyUpdate;
	
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl08_EditButton") public WebElement MedicalPencil;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl08_m_tbQuantity") public WebElement MedicalQuatity;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl08_m_tbRate") public WebElement MedicalRate;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl08_m_ddlUnitOfMeasure_Input") public WebElement MedicalUnitMeasure;
	@FindBy(how=How.CSS, using="span#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl08_m_lblAmount") public WebElement MedicalAvailableMeasure;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl08_UpdateButton") public WebElement MedicalUpdate;
	
	
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl09_EditButton") public WebElement OtherMedicalPencil;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl09_m_tbQuantity") public WebElement OtherMedicalQuatity;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl09_m_tbRate") public WebElement OtherMedicalRate;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl09_m_ddlUnitOfMeasure_Input") public WebElement OtherMedicalUnitMeasure;
	@FindBy(how=How.CSS, using="span#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl09_m_lblAmount") public WebElement OtherMedicalAvailableMeasure;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_rgGrid_ctl00_ctl09_UpdateButton") public WebElement OtherMedicalUpdate;
	
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgMedical_m_tbAdjustment") public WebElement TotalMedicalAdjustment;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_tbTotal") public WebElement TotalReservedAmount;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_tbTotalAdjustment") public WebElement TotalReservedAdjustment;
	
	//Financial Expense Tab
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgExpense_m_rgGrid_ctl00_ctl08_EditButton") public WebElement OtherExpensePencil;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgExpense_m_rgGrid_ctl00_ctl08_m_tbQuantity") public WebElement OtherExpenseQuatity;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgExpense_m_rgGrid_ctl00_ctl08_m_tbRate") public WebElement OtherExpenseRate;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgExpense_m_rgGrid_ctl00_ctl08_m_ddlUnitOfMeasure_Input") public WebElement OtherExpenseUnitMeasure;
	@FindBy(how=How.CSS, using="span#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgExpense_m_rgGrid_ctl00_ctl08_m_lblAmount") public WebElement OtherExpenseAvailableMeasure;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgExpense_m_rgGrid_ctl00_ctl08_UpdateButton") public WebElement OtherExpenseUpdate;
	
	
	//Financial Other Tab
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgOther_m_rgGrid_ctl00_ctl08_EditButton") public WebElement MiscOtherPencil;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgOther_m_rgGrid_ctl00_ctl08_m_tbQuantity") public WebElement MiscOtherQuatity;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgOther_m_rgGrid_ctl00_ctl08_m_tbRate") public WebElement MiscOtherRate;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgOther_m_rgGrid_ctl00_ctl08_m_ddlUnitOfMeasure_Input") public WebElement MiscOtherUnitMeasure;
	@FindBy(how=How.CSS, using="span#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgOther_m_rgGrid_ctl00_ctl08_m_lblAmount") public WebElement MiscOtherAvailableMeasure;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbReserveWorksheet_i0_m_rgOther_m_rgGrid_ctl00_ctl08_UpdateButton") public WebElement MiscOtherUpdate;
		
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction1") public WebElement SaveAndApprove;
	
	//Financials Payables
	@FindBy(how=How.XPATH, using="//span[text()='Payables']") public WebElement Payables;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbPayables_i0_m_rgPayables_ctl00_ctl02_ctl00_m_rtbCommands_i0_m_ddlPayableFormType_Input") public WebElement DropDown;
	@FindBy(how=How.XPATH, using="//span[text()='Add Payable']") public WebElement AddPayable;
	@FindBy(how=How.CSS, using="table#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbPayables_i0_m_rgPayables_ctl00") public WebElement PayableTable;
	@FindBy(how=How.CSS, using="a.fa.fa-cog.fa-no-link") public WebElement IconInTable;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction2") public WebElement DisbursementNext;
	@FindBy(how=How.CSS, using="table#ctl00_ctl00_ContentPlaceHolder1_FinancialsContent_m_pbSearchResults_i0_m_rgSearchResults_ctl00") public WebElement DisbursemenTable;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction1") public WebElement GenerateBatch;
	@FindBy(how=How.CSS, using="div#ctl00_ctl00_m_NotificationBox_simpleContentDiv") public WebElement BatchCreatedNotification;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction1") public WebElement PrintChecks;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_FinancialsContent_m_pbPrinters_i0_m_ddlCheckPrinterProfileId_Input") public WebElement CheckPrinterProfile;
	@FindBy(how=How.CSS, using="div#ctl00_ctl00_m_NotificationBox_simpleContentDiv") public WebElement CheckPrintSuccessMessage;
	//@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction1") public WebElement PrintChecks;
	
	//Physician Payable Entry
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucBillEntry_m_pbPayableEntry_i0_m_ucProviderId_m_qsProviderId_m_ddlResults_Input") public WebElement Provider;
	
	@FindBy(how=How.CSS, using="a#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucBillEntry_m_pbDetailsAndAdjustments_i0_m_ucServiceProviderTaxId_m_ibProviderLookup") public WebElement ServiceProviderLookUp;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucBillEntry_m_pbDetailsAndAdjustments_i0_m_ucServiceProviderTaxId_m_qsProviderId_m_ddlResults_Input") public WebElement ServiceProviderField;
	@FindBy(how=How.XPATH, using="//*[@id=\"ctl00_ContentPlaceHolder1_m_ucSearch_m_rgQuery_ctl00_ctl04_ddlFields_Input\"]") public WebElement DropDown1;	
	@FindBy(how=How.CSS, using="input#ctl00_ContentPlaceHolder1_m_ucSearch_m_rgQuery_ctl00_ctl04_tbValue") public WebElement SearchBox;	
	@FindBy(how=How.CSS, using="input#ctl00_ContentPlaceHolder1_m_btnStartSearch") public WebElement SearchBtn;	
	@FindBy(how=How.CSS, using="tr#ctl00_ContentPlaceHolder1_m_rgResults_ctl00__0") public WebElement SearchedRow1st;	
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucBillEntry_m_pbPayableEntry_i0_m_dpServiceFromDate_dateInput") public WebElement SeriveFromDate;	
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucBillEntry_m_pbPayableEntry_i0_m_dpServiceToDate_dateInput") public WebElement ServiceToDate;	
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucBillEntry_m_pbPayableEntry_i0_m_ddlPayCode_Input") public WebElement PayCode;	
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucBillEntry_m_pbPayableEntry_i0_m_ddlPayableStatus_Input") public WebElement PayableStatus;	
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucBillEntry_m_pbPayableEntry_i0_m_dpScheduledPayDate_dateInput") public WebElement SchedulePayDate;	
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucBillEntry_m_pbPayableEntry_i0_m_tbAvailableReserves") public WebElement AvailableReserves;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucBillEntry_m_pbDetailsAndAdjustments_i0_m_rgDetails_ctl00_ctl02_ctl00_AddNewRecordButton") public WebElement AddDetail;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucBillEntry_m_pbDetailsAndAdjustments_i0_m_rgDetails_ctl00_ctl02_ctl03_m_tbRequestedAmount") public WebElement RequestedAmount;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucBillEntry_m_pbDetailsAndAdjustments_i0_m_rgDetails_ctl00_ctl02_ctl03_m_btnInsertClaimPayableDetail") public WebElement Save;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction1") public WebElement Save1;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_m_MessageBox_m_rwMessageBox_C_m_btnYes") public WebElement YesButton1;
	
	
	//General Information
	@FindBy(how=How.XPATH, using="//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_m_rpbClaims_i0_i0_m_rmClaimsMaster\"]/ul/li[1]/div/ul/li[9]/a/span") public WebElement GeneralInfo;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction1") public WebElement EditGeneralInfo;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction1") public WebElement SaveGeneralInfo;
	//Other payable Enter
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucBillEntry_m_pbDetailsAndAdjustments_i0_m_rgDetails_ctl00_ctl02_ctl03_m_tbOtherRequestedAmount") public WebElement OtherRequestedAmount;
	
	//Financial Summary
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Summary')]") public WebElement Summary;
	@FindBy(how=How.CSS, using="table#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbFinancialSummary_i0_m_ucSummary_m_rgFinancialSummary_ctl00") public WebElement SummaryTable;
	
	//Search Claims
	@FindBy(how=How.XPATH, using="//*[@id=\"ctl00_ctl00_mstr_megaMenu_m_menu_i1_i0_ctl01\"]/ul/li[1]/ul/li[6]/a") public WebElement Claims_Cases;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucSearch_m_rgQuery_ctl00_ctl04_ddlFields_Input") public WebElement SearchDD;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_ucSearch_m_rgQuery_ctl00_ctl04_tbValue") public WebElement SearchTextField;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_btnStartSearch") public WebElement SearchClaimButton;
	@FindBy(how = How.CSS, using = "table#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_rgSearchResults_ctl00") public WebElement SearchClaimTable;
	@FindBy(how=How.CSS, using="a.fa.fa-folder-open.fa-no-link") public WebElement SearchedClaim;
	
	//Indemnity Payable
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbIndemnityPayableEntry_i0_m_ddlPayCode_Input") public WebElement IndemnityPayCode;	
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbIndemnityPayableEntry_i0_m_ddlPayableStatus_Input") public WebElement IndemnityPayableStatus;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbIndemnityPayableEntry_i0_m_dpPayPeriodFromDate_dateInput") public WebElement PayPeriodFromDate;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbIndemnityPayableEntry_i0_m_dpPayPeriodToDate_dateInput") public WebElement PayPeriodToDate;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbIndemnityPayableEntry_i0_m_tbPayPeriodDays") public WebElement PayPeriodDays;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbIndemnityPayableEntry_i0_m_tbAmount") public WebElement IndemnityRequestedAmount;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbIndemnityPayableEntry_i0_m_dpScheduledPayDate_dateInput") public WebElement IndemnitySchedulePayDate;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_ClaimsContent_m_pbIndemnityPayableEntry_i0_m_tbAvailableReserves") public WebElement IndemnityAvailableReserves;
	//Bank Account Settings
	@FindBy(how=How.XPATH, using="//*[@id=\"ctl00_ctl00_m_tstUserActions_m_rmActions\"]/ul/li/a/span") public WebElement SettingsIcon;
	@FindBy(how=How.XPATH, using="//span[text()='System Configuration']") public WebElement SystemConfiguration;
	@FindBy(how=How.XPATH, using="//a[text()='Bank Accounts']") public WebElement BankAccounts;
	@FindBy(how=How.XPATH, using="//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_FinancialsContent_m_pbBankAccounts_i0_m_rgBankAccounts_ctl00__0\"]/td[2]/a") public WebElement EditIcon;
	@FindBy(how=How.XPATH, using="//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_FinancialsContent_m_pbBankAccounts_i0_m_rgBankAccounts_ctl00__2\"]/td[2]/a") public WebElement EditIconNJ;
	
	
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_FinancialsContent_m_pbAccountInformation_i0_m_chkLockedByUser") public WebElement LockedCheckBox;
	@FindBy(how=How.CSS, using="input#ctl00_ctl00_ContentPlaceHolder1_m_btnAction1") public WebElement SaveSetting;	
	
	
	
	public void UnlockFromUser() throws InterruptedException
	{
		click(SettingsIcon);
		Thread.sleep(1000);
		click(SystemConfiguration);
		Thread.sleep(3000);
		click(BankAccounts);
		click(EditIcon);
		Thread.sleep(1000);
		click(LockedCheckBox);
		Thread.sleep(1000);
		click(SaveSetting);
		
	}
	public void UnlockFromUserNJ() throws InterruptedException
	{
		click(SettingsIcon);
		click(SystemConfiguration);
		Thread.sleep(3000);
		click(BankAccounts);
		click(EditIconNJ);
		Thread.sleep(1000);
		click(LockedCheckBox);
		Thread.sleep(1000);
		click(SaveSetting);
		
	}
}
