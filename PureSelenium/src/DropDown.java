import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//https://rahulshettyacademy.com/dropdownsPractise/
		driver.manage().window().maximize();
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		for(int i = 0 ; i < 4 ; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		Thread.sleep(2000);
		driver.findElement(By.id("btnclosepaxoption")).click();
		driver.close();
		
	

	}

}
