package com.carmensol.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;  
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import com.aventstack.extentreports.Status;



public abstract class utility1 {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;
    public Properties prop;    


    public void waitForElementToBeClickable(WebElement element)
    {
    	
    try {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
			TestListener.test.log(Status.FAIL, e.getMessage());
		}
    }
    
    public boolean isClickable(WebElement webe)      
    {
    try
    {
       WebDriverWait wait = new WebDriverWait(driver, 5);
       wait.until(ExpectedConditions.elementToBeClickable(webe));
       return true;
    }
    catch (Exception e)
    {
      return false;
    }
    }
    
    
    public void ImplicitWait() 
    {
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
    
    public void waitForPresenceOfElement(WebElement element)
    {
    	
    try {
		wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
		// TODO Auto-generated catch block
		throw e;
		}
    }
    
    public  void SwitchToNewWindow(){
    	try {
		
			String currentwindow = driver.getWindowHandle();
			Set<String> windIDs= driver.getWindowHandles();
			System.out.println("Total browsers are " +windIDs.size());
			for(String item : windIDs)
			
			if (!item.equals(currentwindow))
				{
				driver.switchTo().window(item);	
				}			
		
    		}
    	
    	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(driver.getWindowHandles());
    }    
    
    public  void SwitchfromThree(String handle){
    	try {
		
			String currentwindow = driver.getWindowHandle();
			Set<String> windIDs= driver.getWindowHandles();
			System.out.println("Total browsers are " +windIDs.size());
			for(String item : windIDs)
			
			if (!item.equals(currentwindow) && !item.equals(handle))
				{
				driver.switchTo().window(item);	
				}			
		
    		}
    	
    	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(driver.getWindowHandles());
    } 
    
	public void NewTab(String url)
	{
		((JavascriptExecutor)driver).executeScript("window.open()");
		SwitchToNewWindow();
		driver.navigate().to(url);
	}
	
	public void CloseTab()
	{
		driver.close();
	}
	
	public static void getLatestWindowFocused(WebDriver driver) 
	{
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.focus();");
	    js = null;
	}
	
	
	
	public Boolean isElementPresent(WebElement element) {
		
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			element.isDisplayed();
			//element.isEnabled();
			
			
			return true;
		} catch (Exception ex) 
		{
			return false;
		}
		
	}
    
    public void TakeSnapshot(WebDriver driver, String DestFilePath){
    	try {
    	TakesScreenshot screenshotFile = (TakesScreenshot)driver;
    	File ss = screenshotFile.getScreenshotAs(OutputType.FILE);
    	File DestFileObj=new File(DestFilePath +".png");  	
    	
    	
			FileUtils.copyFile(ss, DestFileObj);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			TestListener.test.log(Status.FAIL, e.getMessage());
		}
    	
    	}
    
   
    public String GetValue(WebElement element) throws InterruptedException
    	{
    	Thread.sleep(500);
    	String value = element.getAttribute("value");
    	return value;
    	}
    
    public String AttributeValue(WebElement element, String attribute) throws InterruptedException
	{
    Thread.sleep(500);
	String value = element.getAttribute(attribute);
	return value;
	}
    
    public void CheckYesButton(WebElement element) throws InterruptedException
    {
    	if (CheckExistence("button[ng-click='confirm(confirmValue)']") > 0)
		    click(element);
			Thread.sleep(1000);
    }
    
    
    public void MouseOver(WebElement element)
    	{
    	waitForElementToBeClickable(element);
    	Actions action=new Actions(driver);
    	action.moveToElement(element).build().perform();
    	}
    
    public void ControlClick(WebElement element)
	{
	waitForElementToBeClickable(element);
	Actions action=new Actions(driver);
	action.keyDown(Keys.CONTROL).build().perform();
	element.click();
	action.keyUp(Keys.CONTROL).build().perform();
	}


    public void RightClick(WebElement element)
	{
    	waitForElementToBeClickable(element);
    	Actions action=new Actions(driver);
    	action.contextClick(element).perform();
	}

    public void DoubleClick(WebElement element)
   	{
    	waitForElementToBeClickable(element);
    	Actions actions = new Actions(driver);
    	actions.doubleClick(element).perform();
   	}

   public void PopUp(String command)
   {
	   Alert alert = driver.switchTo().alert();
	   if(command == "No")
	   {
	   alert.dismiss();
	   }
	   else
	   {
		   alert.accept();
	   }

   }
   
    public  void switchToFrame_byID(String frameID) {
		   driver.switchTo().frame(frameID);
		  
		   }
    
    
    public  void switchToDefaultWindow(String handle) {
    	driver.switchTo().window(handle);
		  
		   }
    
    public  String getWindowHandle() {
    	String handle = driver.getWindowHandle();
    	return handle;
		  
		   }
    
    public  Set<String> WindowHandles() {
    	Set<String> handle = driver.getWindowHandles();
    	return handle;
		  
		   }
    
    public void switchToDefault() {
    	driver.switchTo().defaultContent();
    }
    
    public void  WaitForElementClickable(WebElement element, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(element)) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
    
    
    
    
    public void  WaitForElementPresent(WebElement element, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(element)) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
   

    
    public String GetURL() {
        try {
            String URL = driver.getCurrentUrl();
            return URL;
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public void navigateToURL(String URL) {
        System.out.println("Navigating to: " + URL);
        System.out.println("Thread id = " + Thread.currentThread().getId());

        try {
            driver.navigate().to(URL);
        } catch (Exception e) {
            System.out.println("URL did not load: " + URL);
            throw new TestException("URL did not load");
        }
    }

    
    public static String GetCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss.SSS");// dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
    

    public int randomNumber()
    {
    	Random rand = new Random();
        int ClaimNum = rand.nextInt(90000000) + 10000000;
        return ClaimNum;
    }
    
    private String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String randomString(int count) {

    StringBuilder builder = new StringBuilder();

    while (count-- != 0) {

    int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());

    builder.append(ALPHA_NUMERIC_STRING.charAt(character));

    }

    return builder.toString();

    }
    
    
    
    public String getPageTitle() {
        try {
            System.out.print(String.format("The title of the page is: %s\n\n", driver.getTitle()));
            return driver.getTitle();
        } catch (Exception e) {
            throw new TestException(String.format("Current page title is: %s", driver.getTitle()));
        }
    }

    public void JavaExecutorSendKeys(WebElement element, String value)
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver; 
    	js.executeScript("arguments[0].value ='';", element);
		js.executeScript("arguments[0].value="+ value +";", element);
    }
    
    public void JavaExecutorClick(WebElement element)
    {
    	waitForElementToBeClickable(element);
    	JavascriptExecutor js = (JavascriptExecutor) driver;  		
		js.executeScript("arguments[0].click();", element);
    }
    
    public void JavaExecutorClearField(WebElement element)
    {
    	((JavascriptExecutor) driver).executeScript("arguments[0].value ='';", element);
    }
    
    public void sendKeys(WebElement element, String value) {
    	try
    	{
    	waitForElementToBeClickable(element);
    	clearField(element);
        element.sendKeys(value);
    	}
    	catch(Exception e)
    	{
    		throw new Error("Webelemnt is not accepting key values");
    	}
        
    }
 
    
    public void SpecialsendKeys(WebElement element, String value) {
    	
    	try
    	{
    	waitForElementToBeClickable(element);
    	Actions actionObj = new Actions(driver);
    	actionObj.keyDown(Keys.CONTROL)
    	         .sendKeys(Keys.chord("A"))
    	         .keyUp(Keys.CONTROL).build()
    	         .perform();
        element.sendKeys(value);
    	}
    	catch(Exception e)
    	{
    		throw new Error("Webelemnt is not accepting key values");
    	}
        
    }
    
    
    public int CheckExistence(String selector)
    {
    	int Size_ = driver.findElements(By.cssSelector(selector)).size();
    	return Size_;
    }
    
    public int CheckExistenceX(String selector)
    {
    	int Size_ = driver.findElements(By.xpath(selector)).size();
    	return Size_;
    }
   

    public String GetSelectedValueDD(WebElement element)
    {
    	Select select = new Select(element);
    	WebElement option = select.getFirstSelectedOption();
    	String  selected = option.getText().trim();
    	return selected;
	}
    
    public void Selectvalue(WebElement element, String data)
    {
    	waitForElementToBeClickable(element);
		Select select = new Select(element);
		select.selectByVisibleText(data);
	}
    
    public void Selectvalue1(WebElement element, String data)
    {
    	//waitForElementToBeClickable(element);
		Select select = new Select(element);
		select.selectByVisibleText(data);
	}
    
    public void SelectIndex(WebElement element, int data)
    {
		Select select = new Select(element);
		select.selectByIndex(data);
	}
    
    public  List<String> DropDownOptions(WebElement element)
    {
        List<String> options = new ArrayList<String>();
        for (WebElement option : new Select(element).getOptions()) {
            String txt = option.getText();
            if (option.getAttribute("value") != "") options.add(option.getText());
        }
        return options;
    }
    
 public void ClickTextName1(String TagName, String Text) {
    	
    	waitForElementToBeClickable(driver.findElement(By.xpath("//"+TagName+"[contains(text(),\""+Text+"\")]")));    	
    	//driver.findElement(By.xpath("//"+TagName+"[contains(text(),'"+Text+"')]")).click();
    	driver.findElement(By.xpath("//"+TagName+"[contains(text(),\""+Text+"\")]")).click();
    }
    
 public void ClickTextName2(String TagName, String Text) {
 	
 	waitForElementToBeClickable(driver.findElement(By.xpath("//"+TagName+"[contains(text(),\""+Text+"\")]")));    	
 	//driver.findElement(By.xpath("//"+TagName+"[contains(text(),'"+Text+"')]")).click();
 	driver.findElement(By.xpath("//"+TagName+"[text()='"+Text+"']")).click();
 }
    public void ClickTextName(String TagName, String Text) {
    	
    	waitForElementToBeClickable(driver.findElement(By.xpath("//"+TagName+"[contains(text(),\""+Text+"\")]")));    	
    	//driver.findElement(By.xpath("//"+TagName+"[contains(text(),'"+Text+"')]")).click();
    	driver.findElement(By.cssSelector("mat-option#mat-option-0")).click();
    }
    
   
    public void clearField(WebElement element) {
    	waitForElementToBeClickable(element);
        try {
            element.clear();
        } catch (Exception e) {
            System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
        }
    }

    
    public int AmttoInt(WebElement AmountField)
    {
    int LastAmt;
    waitForElementToBeClickable(AmountField);
    String StringAmt = AmountField.getText().trim();
	String Amount1 = StringAmt.replace("$","").replaceAll(",", "");
	if(Amount1.contains("."))
	{
	String FinalAmt = Amount1.substring(0, Amount1.indexOf("."));
	LastAmt = Integer.parseInt(FinalAmt);
	}
	else
	{
	LastAmt = Integer.parseInt(Amount1);
	}
    return LastAmt;
    }
    
    
    public  static Connection oracleconnectivity() throws ClassNotFoundException, SQLException{
		   
		   Class.forName("oracle.jdbc.driver.OracleDriver"); 
		   
		   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@JRGI-ORAUAT-01.jrgi.com:1521/UAT.ORACLE","uat","uatjr");
		   return con;		   
	   }    
    
    public  void scrollIntoView(WebElement element) {
		   
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    	   
	   }    
    
    public  void scrollToBottom() {
		   
    	((JavascriptExecutor) driver)
        .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    	   
	   }
    
    
    public  void scrollUp(String number) {
    	((JavascriptExecutor) driver).executeScript("window.scrollBy(0, arguments[0])", number);
	   }
    

    public  WebElement ParentElement(WebElement element) {
    	WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;", element);
    	return parent;
	   }
    
    public WebElement ElemenyByX(String value)
    {
    	WebElement x = driver.findElement(By.xpath(value));
    	return x;
    }
    public WebElement ElemenyByCSS(String value)
    {
    	WebElement x = driver.findElement(By.cssSelector(value));
    	return x;
    }
    
    
    public void click(WebElement element) 
      {
    	waitForElementToBeClickable(element);
        try {
            element.click();
        } catch (Exception e){
            throw new Error(String.format("The following element is not clickable: [%s]", element.toString()));
        }
	  }
    
    public WebElement FocusedElement()
    {    
		WebElement element = driver.switchTo().activeElement();
		return element;    	
    }
    
    static String JS_DROP_FILE = "for(var b=arguments[0],k=arguments[1],l=arguments[2],c=b.ownerDocument,m=0;;){var e=b.getBoundingClientRect(),g=e.left+(k||e.width/2),h=e.top+(l||e.height/2),f=c.elementFromPoint(g,h);if(f&&b.contains(f))break;if(1<++m)throw b=Error('Element not interractable'),b.code=15,b;b.scrollIntoView({behavior:'instant',block:'center',inline:'center'})}var a=c.createElement('INPUT');a.setAttribute('type','file');a.setAttribute('style','position:fixed;z-index:2147483647;left:0;top:0;');a.onchange=function(){var b={effectAllowed:'all',dropEffect:'none',types:['Files'],files:this.files,setData:function(){},getData:function(){},clearData:function(){},setDragImage:function(){}};window.DataTransferItemList&&(b.items=Object.setPrototypeOf([Object.setPrototypeOf({kind:'file',type:this.files[0].type,file:this.files[0],getAsFile:function(){return this.file},getAsString:function(b){var a=new FileReader;a.onload=function(a){b(a.target.result)};a.readAsText(this.file)}},DataTransferItem.prototype)],DataTransferItemList.prototype));Object.setPrototypeOf(b,DataTransfer.prototype);['dragenter','dragover','drop'].forEach(function(a){var d=c.createEvent('DragEvent');d.initMouseEvent(a,!0,!0,c.defaultView,0,0,0,g,h,!1,!1,!1,!1,0,null);Object.setPrototypeOf(d,null);d.dataTransfer=b;Object.setPrototypeOf(d,DragEvent.prototype);f.dispatchEvent(d)});a.parentElement.removeChild(a)};c.documentElement.appendChild(a);a.getBoundingClientRect();return a;";

    public void DropFile(File filePath, WebElement target, int offsetX, int offsetY) {
        if(!filePath.exists())
            throw new WebDriverException("File not found: " + filePath.toString());
    	  
    	
    	  
    	  WebDriver driver = ((WrapsDriver)((WrapsElement)target).getWrappedElement()).getWrappedDriver();
       // WebDriver driver = ((WebElement)target).findElement(By.id("aa")).get;
    	  JavascriptExecutor jse = (JavascriptExecutor)driver;
    	    WebDriverWait wait = new WebDriverWait(driver, 3000);

    	    String JS_DROP_FILE =
    	        "var target = arguments[0]," +
    	        "    offsetX = arguments[1]," +
    	        "    offsetY = arguments[2]," +
    	        "    document = target.ownerDocument || document," +
    	        "    window = document.defaultView || window;" +
    	        "" +
    	        "var input = document.createElement('INPUT');" +
    	        "input.type = 'file';" +
    	        "input.style.display = 'none';" +
    	        "input.onchange = function () {" +
    	        "  var rect = target.getBoundingClientRect()," +
    	        "      x = rect.left + (offsetX || (rect.width >> 1))," +
    	        "      y = rect.top + (offsetY || (rect.height >> 1))," +
    	        "      dataTransfer = { files: this.files };" +
    	        "" +
    	        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
    	        "    var evt = document.createEvent('MouseEvent');" +
    	        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
    	        "    evt.dataTransfer = dataTransfer;" +
    	        "    target.dispatchEvent(evt);" +
    	        "  });" +
    	        "" +
    	        "  setTimeout(function () { document.body.removeChild(input); }, 25000);" +
    	        "};" +
    	        "document.body.appendChild(input);" +
    	        "return input;";

    	    WebElement input =  (WebElement)jse.executeScript(JS_DROP_FILE, target, offsetX+5, offsetY+5);
    	    input.sendKeys(filePath.getAbsoluteFile().toString());
    	    wait.until(ExpectedConditions.stalenessOf(input));
    	    System.out.println("hello"); 
    	    
    	}
    public void BrowserClose()
    {
    	driver.close();
    }
    
    public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
    
    public boolean isAlpha(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }
    
   }