import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locate2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// First we have to add some timeout 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		// TODO Auto-generated method stub
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("submit")).click();
		// now we will get the error message 
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Mohammed");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Mohammedalzuhairi3@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("5714893209");
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		// rahulshettyacademy
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		//	driver.close();
		driver.findElement(By.cssSelector("button[class='go-to-login-btn']")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		// using partial text xpath & css selectors 
		// css input[type*='pass'] 
		// * mean any for this example we assumed that the pass is stable value but 
		
		// the rest will every time get change so we use that start with partial css
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.className("submit")).click();
		
	}

}
