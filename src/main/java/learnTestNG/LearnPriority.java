package learnTestNG;

import org.testng.annotations.Test;

public class LearnPriority {
	
	
	/*Note:: Priority execute lowest value first(negative value).  The default value will be 0 for priority. If you don't  mention 
	         the priority, it will take all the test cases as "priority=0" and execute.*/
	
	@Test(priority = 3)
	public void test1(){
		System.out.println("Test1");
	}
	
	@Test(priority = 4)
	public void test2(){
		System.out.println("Test2");
	}
	
	@Test(priority = 1)
	public void test3(){
		System.out.println("Test3");
	}
	
	@Test(priority = 2)
	public void test4(){
		System.out.println("Test4");
	}

}
