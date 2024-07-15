package session11;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetLinksFromUI {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nalaw\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerWebElement = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerWebElement.findElements(By.tagName("a")).size());
		WebElement footerUrls = driver.findElement(By.cssSelector("div#gf-BIG tr td:nth-child(1)"));
		System.out.println(footerUrls.findElements(By.tagName("a")).size());
		for(int i=1;i<footerUrls.findElements(By.tagName("a")).size();i++) {
			String clickOnUrls = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerUrls.findElements(By.tagName("a")).get(i).sendKeys(clickOnUrls);
			Thread.sleep(5000L);
		}
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		driver.quit();
	}

}