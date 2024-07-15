//package session9;
//
//import java.time.Duration;
//import java.util.NoSuchElementException;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Wait;
//
//import com.google.common.base.Function;
//
//public class FluentWait {
//
//	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nalaw\\Downloads\\chromedriver.exe");
//
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//		driver.manage().window().maximize();
//		
//		driver.findElement(By.id("start")).click();
//		Wait<WebDriver> wait = new FluentWait(driver)
//			       .withTimeout(Duration.ofSeconds(30L))
//			       .pollingEvery(Duration.ofSeconds(5L))
//			       .ignoring(NoSuchElementException.class);
//
//			   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
//			     public WebElement apply(WebDriver driver) {
//			       return driver.findElement(By.id("foo"));
//			     }
//			   });
//	}
//
//}
