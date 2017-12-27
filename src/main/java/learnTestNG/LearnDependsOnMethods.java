package learnTestNG;

import org.testng.annotations.Test;

public class LearnDependsOnMethods {
	
	
	//Scenario 1:: editLead dependsOn createLead
	//Scenario 2:: editLead and deleteLead dependsOn createLead
	//Scenario 3:: deleteLead dependsOn editLead and editLead dependsOn createLead
	//Scenario 4:: editLead dependsOn both createLead and deleteLead
	
	@Test
	public void createLead(){
		System.out.println("CreateLead");
	}
	
	@Test
	public void deleteLead(){
		System.out.println("DeleteLead");
	}
	
	@Test
	public void mergeLead(){
		System.out.println("MergeLead");
	}
	
	@Test(dependsOnMethods = {"createLead","deleteLead"})
	public void editLead(){
		System.out.println("EditLead");
	}

}
