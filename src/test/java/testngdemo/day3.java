package testngdemo;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day3 {
	
	@Test
	public void webcarloan()
	{
		System.out.println("webcarloanprint");
	}
    @AfterSuite
    public void aftersuite()
    {
    	System.out.println("after suite");
    }
	@Test
	public void mobilecarloan()
	{
		System.out.println("mobilecarloanprint");
	}
    @BeforeSuite
    public void beforesuit()
    {
    	System.out.println("before suit");
    }
	@Test
	public void mobilelogincarloan()
	{
		System.out.println("mobilelogincarloanprint");
	}
	@Test
	public void mobilesigncarloan()
	{
		System.out.println("mobilesigncarloanprint");
	}
	
	@Test(groups= {"smokee"})
	public void mobileappscarloan()
	{
		System.out.println("mobileappscarloanprint");
	}
	@Test
	public void apicarloan()
	{
		System.out.println("apicarloanprint");
	}

}
