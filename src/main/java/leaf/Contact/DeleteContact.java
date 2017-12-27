package leaf.Contact;

import org.testng.annotations.Test;

import wrappers.LeafTapsWrapper;


public class DeleteContact extends LeafTapsWrapper {

	
	@Test
	public void deleteContact() throws Exception{
		
		clickByLink("Contacts");
		clickByLink("Find Contacts");
		enterByXpath("(//input[@name='firstName'])[3]", "Gopinath");
		clickByXpath("//button[contains(text(),'Find Contacts')]");
		String sText = getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");		
		clickByLinkNoSnap("Deactivate Contact");
		alertAccept();
		clickByLink("Find Contacts");
		enterByXpath("//label[contains(text(),'Contact Id:')]/following::input[1]", sText);
		clickByXpath("//button[contains(text(),'Find Contacts')]");
		Thread.sleep(2000);
		verifyTextContainsByXpath("//div[@class='x-paging-info']", "No records to display");
	}
	

}
