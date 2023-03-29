package basics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteCookieTakescreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		//Deleting the cookies
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("abhi"); //deleting a specific cookies
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile,new File("C:\\Users\\ei13065\\OneDrive - Tietoevry\\Pictures\\Screenshots//selenium.png"));

	}

}
