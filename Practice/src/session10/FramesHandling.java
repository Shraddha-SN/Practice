package session10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nalaw\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://jqueryui.com/droppable/");

		System.out.println(driver.findElements(By.tagName("iframe")).size());
//		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
//		Actions a = new Actions(driver);
//		a.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
//		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(0);
		Actions a1 = new Actions(driver);
		a1.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
		driver.switchTo().defaultContent();
		driver.close();
	}

}
