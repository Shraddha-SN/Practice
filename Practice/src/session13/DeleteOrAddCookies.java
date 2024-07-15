package session13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v114.input.model.DragData;

public class DeleteOrAddCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nalaw\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();//to delete all cookies
		driver.manage().deleteCookieNamed("");//delete particular cookies
//		driver.manage().addCookie();//to add cookies
		driver.manage().window().maximize();
	}

}
