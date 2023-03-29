package testngdemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day6 {
	
	//Parameterizing in testng
	//Two way- 1)Data provider
	//         2)parameter in testngxml file
	
	
	
	@Test(dataProvider="getdata")
	public void bank(String username,String password)
	{
		System.out.println(username);
		System.out.println(password);
	}
	
	
	@DataProvider()
	public Object[][] getdata()
	{
	      //1st combiantion - username password - good credit history= row
		  //2nd - username password  - no crdit history
		  // 3rd - fraudelent credit history
		
		Object[][] dataa=new Object[3][2]; //3-means three combination & 2-means username & password
		  
				
				//1st set 
				dataa[0][0]="firstsetusername";
				dataa[0][1]="firstpassword";
				//couloumns in the row are nothing but values for that particualar combination(row)
				
				//2nd set
				dataa[1][0]= "secondsetusername";
				dataa[1][1]= "secondpassword";
				
				//3rd set
				dataa[2][0]="thirdsetusername";
				dataa[2][1]="thirdpassword";
				
				return dataa;
	}

}
