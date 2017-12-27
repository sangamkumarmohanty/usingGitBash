package leaf.Lead;

import org.testng.annotations.Test;

import wrappers.LeafTapsWrapper;


public class MergeLead extends LeafTapsWrapper {
	
	@Test
	public void mergeLead() throws Exception{
		clickByLink("Leads");
		clickByLink("Merge Leads");
		clickByXpath("(//img[@alt='Lookup'])[1]");
		switchToWindow(1);
		enterByName("firstName", "Gopinath");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(2000);
		String sText = getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		System.out.println(sText);
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		switchToWindow(0);
		clickByXpath("(//img[@alt='Lookup'])[2]");
		switchToWindow(1);
		enterByName("firstName", "Babu");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(2000);
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		switchToWindow(0);
		clickByLinkNoSnap("Merge");
		alertAccept();
		clickByLink("Find Leads");
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input", sText);
		clickByXpath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(2000);
		verifyTextContainsByXpath("//div[@class='x-paging-info']", "No records to display");
			
	}

}
