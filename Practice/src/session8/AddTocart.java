package session8;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddTocart {

	public static void main(String[] args) throws InterruptedException {
		int j=0;
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nalaw\\Downloads\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		
		String[] itemsNeeded = {"Brocolli","Cucumber","Apple","Raspberry"};
		
		List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));
		Thread.sleep(3000);
		for(int i=0;i<items.size();i++) {
			String veggies = items.get(i).getText();
			String[] veggies1 = veggies.split("-");
			String veggies2 = veggies1[0].trim();
			
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			
			if(itemsNeededList.contains(veggies2)) {
				j++;
				driver.findElements(By.cssSelector("div[class='product-action'] button")).get(i).click();
				if(j==itemsNeeded.length)
					break;
			}
		}
	driver.close();
	}
}
