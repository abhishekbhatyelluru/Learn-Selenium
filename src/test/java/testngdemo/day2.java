package testngdemo;

import org.junit.Assert;
import org.testng.annotations.Test;

public class day2 {
	
	@Test(dependsOnMethods="printt")  //Before this execution, it will execute
	public void javaa()
	{
		System.out.println("javaa print");
	}
	
	@Test(enabled=false)   //It will skip this test
	public void pythonn() 
	{
		System.out.println("pythonn 2");
	}
	
	@Test
	public void printt()
	{
		System.out.println("personal loan 2");
	}
	@Test
	public void printtestfail()
	{
		Assert.assertTrue(false);
		System.out.println("personal loan 2");
	}
	
	
	

}
