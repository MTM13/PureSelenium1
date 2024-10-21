import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class CalendarRadioButtonCheckbox{

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.manage().window().maximize();
		
	    // input[type='radio']
	//	driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	//	System.out.println("Is the return the return date: " + driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
	//	// sometimes the method of isEnable is not working properly so as work around we can simply 
	// inspect the locator while clicking the return & one trip and then we can but if() statement to check
		// Whether the new value is contain or not like below:
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
			System.out.println("It's Enable! " );
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		// the locator for the current date
		//.ui-state-default.ui-state-highlight
		driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		
		
		
		// Checking the check box if it selected or not
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
	    Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	    
	    
		
			
		
		
		

	}

}
