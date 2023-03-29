package testngdemo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day4 {
	
	@Test
	public void webhomeloan()
	{
		System.out.println("webhomeloanprint");
	}
    @AfterTest
    public void aftertest()
    {
    	System.out.println("after test");
    }
	@Test
	public void mobilehomeloan()
	{
		System.out.println("mobilehomeloanprint");
	}
	@Parameters({"URL","username"})          //passing multiple parameter
	@Test
	public void mobilehomeloanlink(String uname,String userkey)
	{
		System.out.println(uname);
		System.out.println(userkey);
	}
    @BeforeTest
    public void beforetest()
    {
    	System.out.println("before test");
    }
	@Test
	public void apihomeloan()
	{
		System.out.println("apihomeloanprint");
	}

}
