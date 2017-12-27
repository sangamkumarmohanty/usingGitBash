package learnTestNG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAttributes {

	public static void main(String[] args) throws InterruptedException {
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
