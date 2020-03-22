package com.carmensol.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.carmensol.pages.LogIn;



public class TestListener extends utility1 implements ITestListener {
	 
    //Extent Report Declarations
    private static ExtentReports extent = ExtentManager.createInstance();
    public static ExtentTest test;
    LogIn po = new LogIn(driver, TestListener.test);
    String screenShotPath = "C:\\Users\\rsingh3\\Desktop\\Selenium\\carmensol\\Screenshot\\screen " +po.GetCurrentTimeStamp().replace(":","_").replace(".","_");

 
    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Extent Reports Version 3 Test Suite started!");
    }
 
    @Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
        extent.flush();
    }
 
    @Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started!"));
        test = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        //test.set(extentTest);
    }
 
    @Override
    public synchronized void onTestSuccess(ITestResult result) {
    	      
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        //test.get().pass("Test passed");
        test.pass("All test steps of Test case '"+result.getMethod().getMethodName()+"'  are verified");
    }
 
    @Override
    public synchronized void onTestFailure(ITestResult result) {
    	 po.TakeSnapshot(driver, screenShotPath);    	  
         try {
     		TestListener.test.addScreenCaptureFromPath(screenShotPath+".png");
     	} catch (IOException e1) {
     		// TODO Auto-generated catch block
     		e1.printStackTrace();
     	}  
        System.out.println((result.getMethod().getMethodName() + " failed!"));
        //test.get().fail(result.getThrowable());
       
        test.fail("All test steps of Test case '"+result.getMethod().getMethodName()+"'  are not verified");
        
    }
 
    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        //test.get().skip(result.getThrowable());
    }
 
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }
}