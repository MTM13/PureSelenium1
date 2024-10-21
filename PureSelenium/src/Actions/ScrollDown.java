package Actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollDown {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice");

		driver.manage().window().maximize();
		// We are going to use javaScript to scroll down and we have to create the object first
		JavascriptExecutor js = (JavascriptExecutor)driver;
		// Here we are going to scroll down the whole page
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(2000);
		// Here we are going to scroll down one table inside the main page
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		// Now we are going to find an element that can handle the whole rows for that table
		// So we can find that elements based on xpath or css
		//   xpath  //td(4)      |   css   td:nth-child(4)
		// But if we have multiple tables then to a specify that table we have to use the class name then locator
		// we are going to store those values inside a list
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		// now we are iterate through them
		int sum = 0 ; 
		for (int i = 0 ; i < values.size() ; i++) {
		//	System.out.println(values.get(i).getText());
			// in this way we will get the values as String then we have to convert them into integer 
			System.out.println(Integer.parseInt(values.get(i).getText()));
			// we are getting the sum of that colmun 
			sum = sum + Integer.parseInt(values.get(i).getText());
		}
		
		
		System.out.println("The sum is: " + sum);
		
		// now the logic is to get the sum text from the web and compare it with our sum
		// we are going to get the get the text first then trim it and get the number and compare it
		
	int expected = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
	
	 Assert.assertEquals(sum, expected);
	
	
		
		
		
		
		
		
		
		
		Thread.sleep(5000);
		driver.close();
		
	}

}
