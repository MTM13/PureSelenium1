package Actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {

		// give the count of links in this pages
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://qaclickacademy.com/practice.php");

		driver.manage().window().maximize();

		// here we get the count of links in entire page
		System.out.println("The links in whole page are: " + driver.findElements(By.tagName("a")).size());
		
		// Now we are looking for links count on footer only 
		WebElement footerDriver = driver.findElement(By.id("gf-BIG")); // here we are limiting the scope
		System.out.println("The links in footer section are: " + footerDriver.findElements(By.tagName("a")).size());
		
		
		// now we are looking the count of links in one column 
		
		WebElement column = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println("The links in one column section are: " + column.findElements(By.tagName("a")).size());
		
		// click on each links in that column and check if the links is working 
		// the idea to get dynamic locator so that we can use it and doesn't matter how many links are there
		// start from 1 because the first links is not working 
		for(int i = 1 ; i < column.findElements(By.tagName("a")).size() ; i++ ) {
			//column.findElements(By.tagName("a")).get(i).click();
			// if we are keep it as this the code will fail due to the driver will go into another page and lose the other links
//			Thread.sleep(1000);
			// this line will identify the control action but there is another issue
			// which is we have to keep it in one single line and to do that we assign it to String variable
			
			// this line for windows users 
//			String ClickAndHold = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			// this line for mac users only
			String ClickAndHold = Keys.chord(Keys.COMMAND,Keys.ENTER);
			// now we pass the variable in single line like below
			
			column.findElements(By.tagName("a")).get(i).sendKeys(ClickAndHold);
			Thread.sleep(5000);
			// now we are looking to jump into each tab and get the title 
			
			
			
		}
		// here we are trying to jump into each tab and print the title and this one should be good with each links 
		Set <String> abc = driver.getWindowHandles();
		
		// help us to jump into new tabs
		Iterator <String> it = abc.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		
		
		
		driver.close();

		
	}

}
