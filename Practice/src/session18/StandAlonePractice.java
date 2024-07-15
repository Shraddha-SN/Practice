package session18;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v114.input.model.DragData;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAlonePractice {

	public static void main(String[] args) throws InterruptedException {
		String productToBuy = "IPHONE 13 PRO";
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.findElement(By.id("userEmail")).sendKeys("sn10@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("1234567890Sa@");
		driver.findElement(By.id("login")).click();
		
		List<WebElement> products = driver.findElements(By.cssSelector(".card-body"));
		WebElement prod = products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productToBuy)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		
		List<WebElement> items = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = items.stream().anyMatch(item -> item.getText().equalsIgnoreCase(productToBuy));
		System.out.println(match);
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".infoWrap button:first-of-type")).click();
		
//		Actions a = new Actions(driver);
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("india");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
//		driver.findElement(By.cssSelector("section.ta-results button:nth-child(3)")).click();
//		driver.findElement(By.cssSelector("a.btnn.action__submit")).click();
		
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'ta-item')]")));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector("a.btnn.action__submit")).click();
		
		String title = driver.findElement(By.cssSelector("h1.hero-primary")).getText();
		title.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
		
		driver.close();
	}
}
