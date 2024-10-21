import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginToMySalesforce {

	public static void main(String[] args) throws InterruptedException {
		
		// by these two lines we can disable notifications 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
		
		driver.get("https://login.salesforce.com/");

		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("mmalzuhahiri@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Ronnie1986$$");
		driver.findElement(By.id("Login")).click();
		
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		//options.addArguments("--disable-notifications");
		//driver.switchTo().alert().accept();
		// div[class^='appLauncher']           .slds-button.slds-context-bar__button.slds-icon-waffle_container.slds-show
		
		driver.findElement(By.cssSelector("div[class^='appLauncher']")).click();
		Thread.sleep(5000);
		// slds-input
		
		//driver.findElement(By.className("input[type='search']")).sendKeys("sal");
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("sales");
		
		//driver.findElement(By.xpath("//span[@class='label' and text()='Sales']")).click();
		
		
		// these two are working as individual options to get the sales option
//		driver.findElement(By.xpath("//div[2]/one-app-launcher-menu/div/div[1]/one-app-launcher-menu-item[3]/a/div/lightning-formatted-rich-text/span/p/b")).click();
//		driver.findElement(By.xpath("//*[@id='07pHn000000L8iJIAS']/div/lightning-formatted-rich-text/span/p/b")).click();
		
		
		
		// need to figure out why this is not working      p[class='slds-truncate'] b    or    div[class='slds-size_small'] p 
		//List <WebElement> opt = driver.findElements(By.cssSelector("div[class='slds-size_small'] p[class='slds-truncate']"));
		
		// let try with xpath //div[@class='slds-size_small'] //p
		List <WebElement> opt = driver.findElements(By.xpath("//div[@class='slds-size_small'] //p"));
		
		Thread.sleep(3000);
		for(WebElement o : opt) {
			if(o.getText().equalsIgnoreCase("sales")) {
				o.click();
				break;
			}
			
			System.out.println(o.getText());
		
		}
	}

}
