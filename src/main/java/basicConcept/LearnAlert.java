package basicConcept;

import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlert {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//ClassName objectName = new ClassName();
		ChromeDriver driver = new ChromeDriver();
		//Load the url
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		//maximize the Browser
		driver.manage().window().maximize();
		
		driver.findElementById("userRegistrationForm:checkavail").click();
		Thread.sleep(2000);
	//	String txt = driver.switchTo().alert().getText();
		driver.findElementById("userRegistrationForm:userName").sendKeys("123456");
	//	System.out.println(txt);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

	}

}
