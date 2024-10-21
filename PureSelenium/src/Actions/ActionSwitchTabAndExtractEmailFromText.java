package Actions;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionSwitchTabAndExtractEmailFromText {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		/*
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.udemy.com/");

		driver.manage().window().maximize();

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//span[text()='Categories']"))).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//input[@name='q'] ")))
		.click().keyDown(Keys.SHIFT).sendKeys("cpq").doubleClick().build().perform();
	//	Thread.sleep(2000);
	//	driver.findElement(By.xpath("//input[@name='q'] ")).sendKeys("cpq"+Keys.ENTER);
		*/
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		Set <String> windows = driver.getWindowHandles();
		Iterator <String> it = windows.iterator();
		
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ");
		String Email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(Email);
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(Email);
		
		
		
		
		
		
		
		
	}

}
