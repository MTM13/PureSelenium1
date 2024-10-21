import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageWindow {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		// First we have to add some timeout 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//https://rahulshettyacademy.com/dropdownsPractise/
		driver.manage().window().maximize();
		driver.navigate().to("https://amazon.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.close();
		
	}

}
