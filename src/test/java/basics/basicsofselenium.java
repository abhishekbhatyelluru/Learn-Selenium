package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class basicsofselenium {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","C:\\Abhishek\\geckodriver.exe");
		System.setProperty("webdriver.edge.driver","C:\\Abhishek\\msedgedriver.exe");
		WebDriver driver=new ChromeDriver();
	//	WebDriver driver=new FirefoxDriver();
	//	WebDriver driver=new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());	
	}

}
