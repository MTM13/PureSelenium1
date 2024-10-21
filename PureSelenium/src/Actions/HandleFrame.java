package Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleFrame {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://jqueryui.com/droppable/");

		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		driver.findElement(By.id("draggable")).click();
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
		
		
		
		
	}

}
