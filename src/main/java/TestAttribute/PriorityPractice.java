package TestAttribute;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PriorityPractice {
	@BeforeSuite
	public void BS() {
		System.out.println("Before Suite");	
	}
	@BeforeTest
	public void BT() {
		System.out.println("Before Test");
	}
	@BeforeClass
	public void BC() {
		System.out.println("Before Class");
	}
	@BeforeMethod
	public void BM() {
		System.out.println("Before Method");
	}
	@Test(priority=5,enabled=true,groups={"group1","group2"},retryAnalyzer=TestAttribute.RetryAnalyzer.class)
	public void T1() {
		System.out.println("Test 1");
		Assert.assertEquals(true, false);
		
	}
	@Test(priority=4,groups={"group1"})
	public void T2() {
		System.out.println("Test 2");
	}
	@Test(priority=3,groups={"group1"})
	public void T3() {
		System.out.println("Test 3");
	}
	@Test(priority=2,groups={"group2"})
	public void T4() {
		System.out.println("Test 4");
	}
	@Test(priority=1,groups={"group2"})
	public void T5() {
		System.out.println("Test 5");
	}
	@AfterMethod
	public void AM() {
		System.out.println("After Method");
	}
	@AfterClass
	public void AC() {
		System.out.println("After Class");
	}
	@AfterTest
	public void AT() {
		System.out.println("After Test");
	}
	@AfterSuite
	public void AS() {
		System.out.println("After Suite");
	}
}
