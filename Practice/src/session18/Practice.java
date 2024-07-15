package session18;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

public class Practice {

	public static void main(String[] args) throws InterruptedException {
		String requiredProduct = "ADIDAS ORIGINAL";
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		
		driver.findElement(By.id("userEmail")).sendKeys("sn10@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("1234567890Sa@");
		driver.findElement(By.id("login")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		List<WebElement> products = driver.findElements(By.cssSelector(".card-body"));
		WebElement prod = products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(requiredProduct)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		List<WebElement> itemsInCart = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean flag = itemsInCart.stream().anyMatch(itemsInCarts->itemsInCarts.getText().equalsIgnoreCase(requiredProduct));
		Assert.assertTrue(flag);
		driver.close();
	}

}
