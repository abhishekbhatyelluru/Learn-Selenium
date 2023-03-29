package testngdemo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class day5 {
	
	@Test
	public void extracarloan()
	{
		System.out.println("extracarloanprint");
	}
	@Test
	public void newcarloan()
	{
		System.out.println("newcarloanprint");
	}
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("car car car car car car");
	}
	@Test(groups= {"smokee"})
	public void newcarloanbmw()
	{
		System.out.println("newcarloanBMWprint");
	}

}
