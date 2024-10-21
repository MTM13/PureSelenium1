import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToParentsLocators {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		// First we have to add some timeout 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div")).getText());
	}

}
