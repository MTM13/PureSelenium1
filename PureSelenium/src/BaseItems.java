import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseItems {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		driver.manage().window().maximize();
		String[] items = { "Cucumber", "Apple", "Corn", "Mango", "Brinjal","Tomato" };
		
		BaseItems B = new BaseItems();
		B.AddItems(driver, items);
		//driver.close();
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		//Thread.sleep(2000);
		driver.findElement(By.className("promoBtn")).click();
		
		
		 w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		driver.close();
		
		
		
		
		
		

		}
		
		
		public static void AddItems(WebDriver driver, String[] items) throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// in this scenario we handle one item by name to add into cart since we don't
			// have actual xpath
			// so we create a list and store them inside and iterate with loop and search by
			// text
			// once we find the text with IF() statement then safely click it
			List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));

			

			// But if we want to select multiple items in this case we can declare an array
			// and
			// convert that array to array list for easy search and so that we can use the
			// contains method to check
			// while doing iteration inside it

			int j = 0 ; 
			for (int i = 0; i < product.size(); i++) {

				String[] name = product.get(i).getText().split("-");
				String format = name[0].trim();

				List all = Arrays.asList(items);

				// Thread.sleep(2000);
				if (all.contains(format)) {

					j++;
					// driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
	                //with this xpath which is relay on text might not be a good option since the text 
					// will change so, if we are going to use it then we have to use Thread.sleep
					// or we can use another locators xpath and use them without Thread.sleep like below

					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
					// break;
				}
				if(j==items.length) {
					break;
				}
				
				
				

			}
		

			
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
