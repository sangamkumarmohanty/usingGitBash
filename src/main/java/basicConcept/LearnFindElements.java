package basicConcept;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFindElements {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//ClassName objectName = new ClassName();
		ChromeDriver driver = new ChromeDriver();
		//Load the url
		driver.get("http://legacy.crystalcruises.com/Calendar.aspx");
		driver.manage().window().maximize();
		List<WebElement> allElement = driver.findElementsByLinkText("Get-a-Quote");
		System.out.println(allElement.size());
		allElement.get(2).click();
		System.out.println(driver.getTitle());
		
		
		
		
		
		
		

	}

}
