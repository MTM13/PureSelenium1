import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locate {

	public static void main(String[] args) {
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
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn'] ")).click();
		// rahulshettyacademy
		driver.findElement(By.cssSelector("button[class='go-to-login-btn']")).click();
		//	driver.close();
		
		
	}

}
