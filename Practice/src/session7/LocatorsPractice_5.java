
//Url used is https://rahulshettyacademy.com/locatorspractice/
package session7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class LocatorsPractice_5 {

	public static void main(String[] args) throws InterruptedException {
		String name = "Shraddha";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nalaw\\Downloads\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		
		String password = getPassword(driver);
	
		driver.findElement(By.cssSelector("input#chkboxOne")).click();
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Shraddha");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		System.out.println("Logged out successfully...!!!");
		driver.close();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Shraddha");
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("ajnalawade41@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");
		driver.findElement(By.xpath("//div/button[1]/following-sibling::button")).click();
		String pass = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		String pass1 = pass.split("'")[1];
		String password = pass1.split("'")[0];
		driver.findElement(By.cssSelector("div button:nth-child(1)")).click();
		Thread.sleep(1000);
		return password;
	}
}
