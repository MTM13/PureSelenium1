package Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TakeScreenShot {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice");

		// maximize the web page
		driver.manage().window().maximize();
		// to delete a web page cookies driver.manage().deleteAllCookies();
		// to delete a cooky name driver.manage().deleteCookieNamed("theCookieNameWillBeHere");
		// ------------------------------------------------
		
		
		// SCREENSHOT
		// in order to take a screenshot we have to convert the web driver object (driver) to screenshot object
		// by casting the driver  File screen = ((TakesScreenshot)driver).getScreenshotas(OutputType.FILE);

		// https://commons.apache.org/proper/commons-io/download_io.cgi to download the import class
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("/Users/mohammedalzuhairi/eclipse-workspace/PureSelenium/Screenshot.png") );
		
		
		Thread.sleep(1000);
		driver.close();
		
	}

}
