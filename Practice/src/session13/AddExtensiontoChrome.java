package session13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddExtensiontoChrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nalaw\\Downloads\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		
		//Add extension to chrome
		options.addExtensions();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}

}
