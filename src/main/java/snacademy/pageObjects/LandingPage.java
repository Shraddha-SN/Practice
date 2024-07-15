package snacademy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userName;
	
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	
	public void loginApplication(String email, String password) {
		userName.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
	}
	
	public void goTo() {
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
