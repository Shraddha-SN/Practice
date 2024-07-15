package session15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocatorsPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nalaw\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//above
		WebElement above1 = driver.findElement(By.cssSelector("input[name='name']"));  
		System.out.println(driver.findElement(with(By.tagName("label")).above(above1)).getText());
		
		//below
		WebElement below1 = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(below1)).click();
		
		//right
		WebElement right1 = driver.findElement(By.xpath("//label[text()='Employment Status: ']"));
		driver.findElement(with(By.tagName("label")).toRightOf(right1)).click();
		
		//left
		WebElement left1 = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(left1)).click();
		
		Thread.sleep(4000);
		
		driver.close();
	}

}
