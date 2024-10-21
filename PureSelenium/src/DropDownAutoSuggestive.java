import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownAutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.manage().window().maximize();
		
		//  //a[@value='MAA']  

		//  //a[@value='BLR']

		driver.findElement(By.id("autosuggest")).sendKeys("It");
		Thread.sleep(3000);
		//driver.findElement(By.id("//ul[@id='ui-id-1'] //*[@id='ui-id-121']")).click();
		// this is how to handle auto suggested drop down without any options
		// first goal is to provide input 
		// then figure out a generic locator which extract all suggested options 
		// then stored in list then go throu them with loop and use the condition if() 
		// so if the condition is met then will go inside it and click it 
		
		List <WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("Italy")) {
				option.click();
				break;
			}
		}

	
		
		
	}

}
