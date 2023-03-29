package testngdemo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day1 {
	
	@Test
	public void printt()
	{
		System.out.println("personal loan 1");
	}
	@Test(groups= {"smokee"})
	public void asdf()
	{
		System.out.println("grouping");
	}
	
	@Parameters({"URL"})
	@Test
	public void printpara(String urlname)
	{
		System.out.println(urlname);
	}
	@Parameters({"URL"}) //each time U have to define parameter for each method
	@Test
	public void printother(String urlname)
	{
		System.out.println(urlname);
	}
	
	
	

}
