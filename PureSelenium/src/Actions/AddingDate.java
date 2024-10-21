package Actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AddingDate {

	public static void main(String[] args) throws InterruptedException {

		String date = "10" ;
		String month = "6" ;
		String year = "2027";
		String [] expected = { month , date, year};

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.manage().window().maximize();
		// first we have to open the window of date calendar 
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		// then we have to click on month first and then on year and both are located at the same place
		// so we will repeat that step twice in order to navigate inside
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		// we are getting the year based on xpath with text and will made it as hard coding 
		// by declaring the value so that we can be able to change it accordingly 
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		

		// first of all select all elements then pass the hard coding of month and since we have it as String
		// we convert it to integer Integer.parseInt(month)-1 the reason of adding -1 because the index start from 1
		// so in case we want to select 6 which is June then we have to select 5 which will be very confusing 
		// so the best way to add -1 to be in good order.
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		
		// now we do assertion and we have to get the text normally we get like below
		//System.out.println(driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).getText());
		// but the code was written as sub classes so we will get dynamic elements and get the value as list
		List <WebElement> actualList =driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int  i = 0 ; i< actualList.size() ; i++) {
			System.out.println(actualList.get(i).getAttribute("value"));
			Assert.assertEquals(actualList.get(i).getAttribute("value"), expected[i]);
			System.out.println(expected[i]);
		}
		
		// until here we get almost 90% of our need now we but date, month, year inside array as expected
		// and then we put assertion inside the loop 
		
		Thread.sleep(7000);
		driver.close();
	}

}
