package basicConcept;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LearnFrames {
	
	
	//(invocationCount = 2)
	//(invocationCount = 2, threadPoolSize =2)
	//(invocationCount = 2, invocationTimeOut = 20000)
	//(invocationCount = 2, threadPoolSize = 2, invocationTimeOut = 20000)
	//(invocationCount = 2, timeOut = 20000)
	
	@Test(invocationCount = 2, timeOut = 20000)
	public void learnFrames(){		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();		
		WebElement element = driver.findElementByClassName("demo-frame");		
		driver.switchTo().frame(element);
		driver.findElementByXPath("//li[text()='Item 3']").click();	
		driver.switchTo().defaultContent();
		driver.findElementByLinkText("Download").click();	
	}
}
