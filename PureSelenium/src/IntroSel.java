
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class IntroSel {

	public static void main(String[] args) {


		
		// Invoking Browser
		//WebDriver -> Is a group of related methods with empty bodies.
		// 
		
		//ChromeDriver driver = new ChromeDriver();
		// driver here has access to all the methods of chrome driver
		
		//WebDriver driver = new ChromeDriver();
		//driver object here has access to the methods of chrome driver 
		//which are defined in WebDriver interface 
		
		
		// Now to be able to invoke the browser (chrome)
		// Chromedriver.exe is third party middle man which is help to invoke the browser
		// There are two ways to do that 
		// 1- Step to invoke chrome driver
		// System.setProperty("webdriver.chrome.driver", "path/of/your/chromedriver");
		// 2- selenium manager this will help us by find the way to the chrome driver
		// if the company has some restrictions then we go with setp 1 as of now i'm going \
		// with WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
	//	driver.close();// close the current page
		// driver.quit() close all associated pages with driver
		
	}

}
