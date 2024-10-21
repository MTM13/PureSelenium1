package GetDataFromExcel;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingItemsIntoCart {

	public static void main(String[] args) throws InterruptedException {
		
		//this class need to be modify in order to be able to read from excel file
		
		
		
		
		

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		driver.manage().window().maximize();

		// in this scenario we handle one item by name to add into cart since we don't
		// have actual xpath
		// so we create a list and store them inside and iterate with loop and search by
		// text
		// once we find the text with IF() statement then safely click it
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));

		String[] items = { "Cucumber", "Apple", "Corn", "Mango" };

		// But if we want to select multiple items in this case we can declare an array
		// and
		// convert that array to array list for easy search and so that we can use the
		// contains method to check
		// while doing iteration inside it

		for (int i = 0; i < product.size(); i++) {

			String[] name = product.get(i).getText().split("-");
			String format = name[0].trim();

			List all = Arrays.asList(items);

			// Thread.sleep(2000);
			if (all.contains(format)) {

				// driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                //with this xpath which is relay on text might not be a good option since the text 
				// will change so, if we are going to use it then we have to use Thread.sleep
				// or we can use another locators xpath and use them without Thread.sleep like below

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// break;
			}

		}
	}

}
