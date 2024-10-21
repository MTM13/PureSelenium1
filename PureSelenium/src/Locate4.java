import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locate4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// First we have to add some timeout 
		String name="Mohammed";
		// Thread.sleep(3000);
		String password = getPassword(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		
		// TODO Auto-generated method stub
		
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		// now we will get the error message 
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
		
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
	//	driver.close();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String PasswordText = driver.findElement(By.cssSelector("form p")).getText();
		// here we are going to extract the password from dynamic text
		// first we create a string array and provide to split by space or ' or , 
		// then create another string to store the new value so that we can use it
		// this is first array and split it by ' 
		String [] StrArray = PasswordText.split("'");
		// here we store the value into string so we can use it
		String password = StrArray[1].split("'")[0];
		return password;
		
		
	}
	

}
