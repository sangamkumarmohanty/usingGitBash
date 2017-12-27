package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericWrappers{

	public RemoteWebDriver driver;
	int i=1;

	public boolean invokeApp(String browser, String Url) {
		boolean bReturn = false;
		try {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else			{
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(Url);
			System.out.println("The browser:" + browser + " launched successfully");
			bReturn = true;
		} catch (Exception e) {
			System.out.println("The browser:" + browser + " could not be launched");
		}
		finally{
			takeSnap();
		}
		return bReturn;
	}

	public boolean enterById(String idValue, String data) throws Exception{
		boolean bReturn = false;
		try {
			driver.findElementById(idValue).clear();
			driver.findElementById(idValue).sendKeys(data);	
			System.out.println("The data: "+data+" entered successfully in field :"+idValue);
			bReturn = true;
		} catch (NoSuchElementException e) {
			System.out.println("The data: "+data+" could not be entered in the field :"+idValue);
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while entering "+data+" in the field :"+idValue);
		} 
		finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean enterByName(String nameValue, String data) {
		boolean bReturn = false;
		try {
			driver.findElementByName(nameValue).clear();
			driver.findElementByName(nameValue).sendKeys(data);	
			System.out.println("The data: "+data+" entered successfully in field :");
			bReturn = true;
		} catch (NoSuchElementException e) {
			System.out.println("The data: "+data+" could not be entered in the field :");
		}  catch (WebDriverException e) {
			System.out.println("Unknown exception occured while entering "+data+" in the field :"+nameValue);
		} 
		finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean enterByXpath(String XpathValue, String data) {
		boolean bReturn = false;
		try {
			driver.findElementByXPath(XpathValue).clear();
			driver.findElementByXPath(XpathValue).sendKeys(data);	
			System.out.println("The data: "+data+" entered successfully in field :"+XpathValue);
			bReturn = true;
		} catch (NoSuchElementException e) {
			System.out.println("The data: "+data+" could not be entered in the field :"+XpathValue);
		}  catch (WebDriverException e) {
			System.out.println("Unknown exception occured while entering "+data+" in the field :"+XpathValue);
		} 
		finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean verifyTitle(String title){
		boolean bReturn = false;
		try{
			if (driver.getTitle().equalsIgnoreCase(title)){
				System.out.println("The title of the page matches with the value :"+title);
				bReturn = true;
			}else
				System.out.println("The title of the page:"+driver.getTitle()+" did not match with the value :"+title);
		}catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the title");
		}
		finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean verifyTextById(String id, String text) {
		boolean bReturn = false;
		try {
			String sText = driver.findElementById(id).getText();
			if (sText.equals(text)){
				System.out.println("The text: "+sText+" matches with the value :"+text);
			}else{
				System.out.println("The text: "+sText+" did not match with the value :"+text);
			}
			bReturn = true;
		} catch (NoSuchElementException e) {
			System.out.println("The Element with Xpath: "+id+" could not be found");
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while founding Xpath: "+id);
		} 
		return bReturn;
	}

	public boolean verifyTextByXpath(String xpath, String text){
		boolean bReturn = false;
		try {
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.equals(text)){
				System.out.println("The text: "+sText+" matches with the value :"+text);
				bReturn = true;
			}else{
				System.out.println("The text: "+sText+" did not match with the value :"+text);
			}
			bReturn = true;
		} catch (NoSuchElementException e) {
			System.out.println("The Element with Xpath: "+xpath+" could not be found");
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while founding Xpath: "+xpath);
		} 
		return bReturn;
	}

	public boolean verifyTextContainsById(String idValue, String text){
		boolean bReturn = false;
		try {
			String sText = driver.findElementById(idValue).getText();
			if (sText.contains(text)){
				System.out.println("The text: "+sText+" matches with the value :"+text);
				bReturn = true;
			}else{
				System.out.println("The text: "+sText+" did not match with the value :"+text);
			}
			bReturn = true;
		}catch (NoSuchElementException e) {
			System.out.println("The Element with Id: "+idValue+" could not be found");
		}  catch (WebDriverException e) {
			System.out.println("Unknown exception occured while founding Id: "+idValue);
		} 
		return bReturn;
	}

	public boolean verifyTextContainsByXpath(String xpath, String text){
		boolean bReturn = false;
		try {
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.contains(text)){
				System.out.println("The text: "+sText+" matches with the value :"+text);
				bReturn = true;
			}else{
				System.out.println("The text: "+sText+" did not match with the value :"+text);
			}
			bReturn = true;
		}catch (NoSuchElementException e) {
			System.out.println("The Element with Xpath: "+xpath+" could not be found");
		}  catch (WebDriverException e) {
			System.out.println("Unknown exception occured while founding Xpath: "+xpath);
		} 
		return bReturn;
	}	

	public boolean verifyAttributeTextById(String id, String value, String text) {
		boolean bReturn = false;
		try {
			String sText = driver.findElementById(id).getAttribute(value);
			if (sText.equals(text)){
				System.out.println("The text: "+sText+" matches with the A_value :"+text);
			}else{
				System.out.println("The text: "+sText+" did not match with the A_value :"+text);
			}
			bReturn = true;
		} catch (NoSuchElementException e) {
			System.out.println("The Element with Xpath: "+id+" could not be found");
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while founding Xpath: "+id);
		} 
		return bReturn;
	}

	public boolean clickById(String id) {
		boolean bReturn = false;
		try{
			driver.findElementById(id).click();
			System.out.println("The element with id: "+id+" is clicked.");
			bReturn = true;
		} catch (NoSuchElementException e) {
			System.out.println("The element with id: "+id+" could not be clicked.");
		}catch (WebDriverException e) {
			System.out.println("Unknow Exceptions occured while intracting with Id:"+id);
		}finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean clickByName(String name) {
		boolean bReturn = false;
		try{
			driver.findElementByName(name).click();
			System.out.println("The element with Name: "+name+" is clicked.");
			bReturn = true;
		} catch (NoSuchElementException e) {
			System.out.println("The element with Name: "+name+" could not be clicked.");
		}catch (WebDriverException e) {
			System.out.println("Unknow Exceptions occured while intracting with Name:"+name);
		}finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean clickByClassName(String classVal) {
		boolean bReturn = false;
		try{
			driver.findElementByClassName(classVal).click();
			System.out.println("The element with ClassName: "+classVal+" is clicked.");
			bReturn = true;
		} catch (NoSuchElementException e) {
			System.out.println("The element with ClassName: "+classVal+" could not be clicked.");
		}catch (WebDriverException e) {
			System.out.println("Unknow Exceptions occured while intracting with ClassName:"+classVal);
		}finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean clickByLink(String name){
		boolean bReturn = false;
		try{
			driver.findElementByLinkText(name).click();
			System.out.println("The element with LinkText: "+name+" is clicked.");
			bReturn = true;
		} catch (NoSuchElementException e) {
			System.out.println("The element with LinkText: "+name+" could not be clicked.");
		}catch (WebDriverException e) {
			System.out.println("Unknow Exceptions occured while intracting with LinkText:"+name);
		}finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean clickByLinkNoSnap(String name){
		boolean bReturn = false;
		try{
			driver.findElementByLinkText(name).click();
			System.out.println("The element with LinkText: "+name+" is clicked.");
			bReturn = true;
		} catch (NoSuchElementException e) {
			System.out.println("The element with LinkText: "+name+" could not be clicked.");
		}catch (WebDriverException e) {
			System.out.println("Unknow Exceptions occured while intracting with LinkText:"+name);
		}
		return bReturn;
	}

	public boolean clickByPartialLink(String name) throws Exception{
		boolean bReturn = false;
		try{
			driver.findElementByPartialLinkText(name).click();
			System.out.println("The element with P_LinkText: "+name+" is clicked.");
			bReturn = true;
		} catch (NoSuchElementException e) {
			System.out.println("The element with P_LinkText: "+name+" could not be clicked.");
		}catch (WebDriverException e) {
			System.out.println("Unknow Exceptions occured while intracting with P_LinkText:"+name);
		}finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean clickByXpath(String xpathVal) {
		boolean bReturn = false;
		try{
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The element with XPath: "+xpathVal+" is clicked.");
			bReturn = true;
		} catch (NoSuchElementException e) {
			System.out.println("The element with XPath: "+xpathVal+" could not be clicked.");
		}catch (WebDriverException e) {
			System.out.println("Unknow Exceptions occured while intracting with XPath:"+xpathVal);
		}finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean clickByXpathNoSnap(String xpathVal) {
		boolean bReturn = false;
		try{
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The element with XPath: "+xpathVal+" is clicked.");
			bReturn = true;
		} catch (NoSuchElementException e) {
			System.out.println("The element with XPath: "+xpathVal+" could not be clicked.");
		}catch (WebDriverException e) {
			System.out.println("Unknow Exceptions occured while intracting with XPath:"+xpathVal);
		}
		return bReturn;
	}

	public boolean mouseOverByXpath(String xpathVal) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			System.out.println("The mouse over by xpath : "+xpathVal+" is performed.");
			bReturn = true;
		} catch (Exception e) {
			System.out.println("The mouse over by xpath : "+xpathVal+" could not be performed.");
		}finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean mouseOverByLinkText(String linkName) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			System.out.println("The mouse over by link : "+linkName+" is performed.");
			bReturn = true;
		} catch (Exception e) {
			System.out.println("The mouse over by link : "+linkName+" could not be performed.");
		}finally {
			takeSnap();
		}
		return bReturn;
	}

	public String getTextById(String idVal) {
		String bReturn = "";
		try{
			bReturn = driver.findElementById(idVal).getText();
		} catch (NoSuchElementException e) {
			System.out.println("The element with Id: "+idVal+" could not be found.");
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while founding Id: "+idVal);
		}finally {
			takeSnap();
		}
		return bReturn; 
	}

	public String getTextByXpath(String xpathVal){
		String bReturn = "";
		try{
			bReturn = driver.findElementByXPath(xpathVal).getText();
		} catch (NoSuchElementException e) {
			System.out.println("The element with xpath: "+xpathVal+" could not be found.");
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while founding Xpath: "+xpathVal);
		}finally {
			takeSnap();
		}
		return bReturn; 
	}

	public String getAttributeById(String idValue, String value){
		String bReturn = "";
		try{
			bReturn = driver.findElementByXPath(idValue).getAttribute(value);
		} catch (NoSuchElementException e) {
			System.out.println("The element with Id: "+idValue+" could not be found.");
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while founding Id: "+idValue);
		}finally {
			takeSnap();
		}
		return bReturn; 
	}

	public boolean switchToFrame(String nameOrId) {
		boolean bReturn = false;
		try {
			driver.switchTo().frame(nameOrId);
			bReturn = true;
		} catch (NoSuchFrameException e){
			System.out.println("The Expected Frame: "+nameOrId+" could not be found");
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while Switch Frame with Id/Name: "+nameOrId);
		}finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean switchToDefault() {
		boolean bReturn = false;
		try {
			driver.switchTo().defaultContent();
			bReturn = true;
		} catch (NoAlertPresentException e){
			System.out.println("No Alert - Present");
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while Switch back to WebApplication");
		} finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean alertAccept(){
		boolean bReturn = false;
		try {
			driver.switchTo().alert().accept();
			bReturn = true;
		} catch (NoAlertPresentException e){
			System.out.println("No Alert - Present");
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while Switch to Alert");
		}
		return bReturn;
	}

	public boolean alertDismiss(){
		boolean bReturn = false;
		try {
			driver.switchTo().alert().dismiss();
			bReturn = true;
		} catch (NoAlertPresentException e){
			System.out.println("No Alert - Present");
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while Switch to Alert");
		}		
		return bReturn;
	}

	public String getTextAndAcceptAlert(){
		String sText = "";
		try{
			sText = driver.switchTo().alert().getText();
			alertAccept();
		} catch (NoAlertPresentException e){
			System.out.println("No Alert - Present");
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while Switch to Alert");
		}
		return sText;
	}

	public boolean switchToWindow(int index) {
		boolean bReturn = false;
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			List<String> allHandles = new ArrayList<>();
			allHandles.addAll(allWindowHandles);
			driver.switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			System.out.println("The driver could not move to the given window by index "+index);
		} catch (WebDriverException e) {
			System.out.println("Unknown Exception occurred while switch to another Window by index"+index);
		}
		return bReturn;
	}


	public boolean selectByIndexById(String id, int value) {
		boolean bReturn = false;
		try{
			new Select(driver.findElementById(id)).selectByIndex(value);;
			System.out.println("The element with id: "+id+" is selected with value :"+value);
			bReturn = true;
		} catch (NoSuchElementException e) {
			System.out.println("The value: "+value+" could not be selected in the Dropdown");
		} catch (WebDriverException e) {
			System.out.println("UnExpected error occurred which intracting with Dropdown with: "+id);
		}
		finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean selectByValueById(String id, String value) {
		boolean bReturn = false;
		try{
			new Select(driver.findElementById(id)).selectByValue(value);
			System.out.println("The element with id: "+id+" is selected with value :"+value);
			bReturn = true;
		} catch (NoSuchElementException e) {
			System.out.println("The value: "+value+" could not be selected in the Dropdown");
		} catch (WebDriverException e) {
			System.out.println("UnExpected error occurred which intracting with Dropdown with: "+id);
		}
		finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean selectVisibileTextById(String id, String value) {
		boolean bReturn = false;
		try{
			new Select(driver.findElementById(id)).selectByVisibleText(value);
			System.out.println("The element with id: "+id+" is selected with value :"+value);
			bReturn = true;
		} catch (NoSuchElementException e) {
			System.out.println("The value: "+value+" could not be selected in the Dropdown");
		} catch (WebDriverException e) {
			System.out.println("UnExpected error occurred which intracting with Dropdown with: "+id);
		}
		finally {
			takeSnap();
		}
		return bReturn;
	}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/snap"+i+".jpeg");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			System.out.println("There was IO Exception while taking the SnapShot");
		}
		i++;
	}

	public void closeBrowser() {
		try {
			driver.close();
			System.out.println("Browser Closed");
		} catch (Exception e) {
			System.out.println("The browser:"+driver.getCapabilities().getBrowserName()+" could not be closed.");
		}
	}

	public void closeAllBrowser() {
		try {
			driver.quit();
			System.out.println("Browser Closed");
		} catch (Exception e) {
			System.out.println("The browser:"+driver.getCapabilities().getBrowserName()+" could not be closed.");
		}
	}

}