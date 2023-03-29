package basics;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.util.Strings;

public class ChildWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();
		//now switching to child window to extract email id
		Set<String> windowss =driver.getWindowHandles(); 	//windowss = [parent,child,subchild,...]
		Iterator<String>itt=windowss.iterator();
		String parentid=itt.next();
		String childid=itt.next();
		driver.switchTo().window(childid);
		System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
		driver.findElement(By.cssSelector("p.im-para.red")).getText();
		String emailid=driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];
	    //now switch back to parent window
		driver.switchTo().window(parentid);
		driver.findElement(By.id("username")).sendKeys(emailid);
	     

	}

}
