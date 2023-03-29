package basics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions optionss=new ChromeOptions();
		optionss.setAcceptInsecureCerts(true);       //It will accept insecure HTTP page
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver(optionss); //calling the chromeoptions
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());
		
		
		// Add the WebDriver proxy capability using Chromeoptions
//		Proxy proxy = new Proxy();
//		proxy.setHttpProxy("myhttpproxy:3337");   //sample example
//		options.setCapability("proxy", proxy);
		
		
		//Block pop-up windows
		//By default, ChromeDriver configures Chrome to allow pop-up windows. If you want to block pop-ups, do the following:
//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("excludeSwitches",
//	    Arrays.asList("disable-popup-blocking"));
		
		
	//	Set download directory
	//	The following code can be used to configure Chrome to download files to a specific directory
//		ChromeOptions options = new ChromeOptions();
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		prefs.put("download.default_directory", "/directory/path");
//		options.setExperimentalOption("prefs", prefs);

	}

}
