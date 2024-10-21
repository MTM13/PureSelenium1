import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assign2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys("Mohammed");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("m.alzuhahiri@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("123456789");
		
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement down = driver.findElement(By.id("exampleFormControlSelect1"));
		Select list = new Select(down);
		list.selectByIndex(0);
		driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys("01/29/1986");
		driver.findElement(By.id("inlineRadio1")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println(driver.findElement(By.cssSelector("div[class$='alert-dismissible']")).getText());

	}

}
