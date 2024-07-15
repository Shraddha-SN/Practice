package session14;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortingOfTableWithStream {

	public static void main(String[] args) {
		List<String> values;
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nalaw\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> vegNames = driver.findElements(By.xpath("//tr/td[1]"));

		List<String> originalList = vegNames.stream().map(s -> s.getText()).collect(Collectors.toList());

		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		Assert.assertTrue(originalList.equals(sortedList));

		do {
			List<WebElement> vegNames1 = driver.findElements(By.xpath("//tr/td[1]"));
			values = vegNames1.stream().filter(s -> s.getText().contains("Tomato")).map(s -> getVeggiePrice(s))
					.collect(Collectors.toList());
			values.forEach(a -> System.out.println(a));
			if (values.size() < 1) {
				driver.findElement(By.xpath("//a[contains(@aria-label,'Next')]")).click();
			}
		} while (values.size() < 1);
		driver.close();
	}

	public static String getVeggiePrice(WebElement s) {
		String priceValue = s.findElement(By.xpath("//tr/td[1]/following-sibling::td[1]")).getText();
		return priceValue;
	}
}