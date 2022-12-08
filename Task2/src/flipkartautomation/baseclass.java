package flipkartautomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseclass {

	WebDriver driver;

	public WebDriver launchchromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:/Selenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		//driver.findElement(By.xpath(objectclass.usernameobj)).sendKeys("7373140585");
		//driver.findElement(By.xpath(objectclass.passwordobj)).sendKeys("Arunkumar@8055");
		//driver.findElement(By.xpath(objectclass.submitobj)).click();
		return driver;
	}

	public void LoginUsername(WebDriver driver, String usernameValue, String passwordvalue) throws StaleElementReferenceException, InterruptedException {
		try {
			WebElement usernameWebEle = driver.findElement(By.xpath(objectclass.usernameobj));
			usernameWebEle.sendKeys(usernameValue);
			WebElement passwordWebEle = driver.findElement(By.xpath(objectclass.passwordobj));
			passwordWebEle.sendKeys(passwordvalue);
			driver.findElement(By.xpath(objectclass.submitobj)).click();

			
		} catch (StaleElementReferenceException e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			LoginUsername(driver,usernameValue,passwordvalue);
		}
	}
	
	public WebDriverWait webdriverwait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait;
	}
}
