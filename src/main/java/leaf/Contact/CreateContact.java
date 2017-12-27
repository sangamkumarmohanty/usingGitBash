package leaf.Contact;

import org.testng.annotations.Test;

import wrappers.LeafTapsWrapper;

public class CreateContact extends LeafTapsWrapper {

	@Test
	public void  createContact() throws Exception {
		invokeApp("chrome", "http://leaftaps.com/opentaps");
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByLink("CRM/SFA");
		clickByLink("Contacts");
		clickByLink("Create Contact");
		enterById("firstNameField", "Gopinath");
		enterById("lastNameField", "Jayakumar");
		clickByName("submitButton");
	}	
}
