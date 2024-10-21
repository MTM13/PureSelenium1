package Actions;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleSSLCertificate {

	public static void main(String[] args) throws InterruptedException {
		// chromOption class help us to set the behavior of chrome browser 
		ChromeOptions options  = new ChromeOptions();
		// this object of options we can enter the methods inside ChromeOptions class
		// to handle that certificate we don't have to automate it we can simply used the object like below
		options.setAcceptInsecureCerts(true);
		// Also, there is another object for fire fox browser |  FirefoxOptions for firefox|  EdgeOptions for Edge
		// lecture 105 for HTTP proxy and need to watch it 
		
		
		// then we have to pass that object as an argument to the webDriver to tell how to behave 
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://expired.badssl.com");

		driver.manage().window().maximize();
		
		
		System.out.println(driver.getTitle());
		
		// to disable the pop up notifications on web page we can use this
		// options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		
		// to change the directory of download file then we can use this
		// Map <String , Object> prefs = new HashMap <String , Object>();
		// prefs.put("download.default_directory", "/directory/path");
		// options.setExperimentalOption("prefs", prefs);
		
		

		Thread.sleep(5000);
		driver.close();

	}

}
