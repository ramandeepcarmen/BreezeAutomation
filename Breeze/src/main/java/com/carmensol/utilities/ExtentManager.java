package com.carmensol.utilities;



import java.io.File;

import org.testng.ITestResult;
import org.testng.xml.internal.TestNamesMatcher;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sun.jna.Platform;

public class ExtentManager extends utility1 {
    private static ExtentReports extent;
    private static Platform platform;
    private static String reportFileName = "ExtentReports-Version3-Test-Automaton-Report.html";
    private static String macPath = System.getProperty("user.dir")+ "/TestReport";
    private static String windowsPath = System.getProperty("user.dir")+ "\\TestReport";
    private static String macReportFileLoc = macPath + "/" + reportFileName;
    private static String winReportFileLoc = windowsPath + "\\" + reportFileName;
 
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
 
    //Create an extent report instance
    public static ExtentReports createInstance() {
        
    	

    	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter( System.getProperty("user.dir")+"\\ExtentReports\\extentreport " +GetCurrentTimeStamp().replace(":","_").replace(".","_")+".html");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle( System.getProperty("user.dir")+"\\ExtentReports\\extentreport"+GetCurrentTimeStamp().replace(":","_").replace(".","_")+".html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName( System.getProperty("user.dir")+"\\ExtentReports\\extentreport"+GetCurrentTimeStamp().replace(":","_").replace(".","_")+".html");
 
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
 
        return extent;
    }
 

    //Create the report path if it does not exist
    private static void createReportPath (String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
            } else {
                System.out.println("Failed to create directory: " + path);
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
    }
}
 
   
