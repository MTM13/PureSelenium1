import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUtils {

		public static void main(String[] args) throws IOException {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			getScreenshot(driver);
		}
		
		
	public static void getScreenshot(WebDriver driver) throws IOException{
		
		driver.get("https://www.google.com");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src,new File("/Users/mohammedalzuhairi/eclipse-workspace/PureSelenium/target/screenshot.png"));
		FileUtils.copyFile(src,new File("/PureSelenium/target/screenshot.png"));
	}


	private static void copyFile(File src, File file) {
		// TODO Auto-generated method stub
		
	}


}
