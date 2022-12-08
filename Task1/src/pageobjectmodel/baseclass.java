package pageobjectmodel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Properties;

public class baseclass {

	WebDriver driver;

	public WebDriver usechromeandlogin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/Selenium/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(1000);
		/*
		 * driver.findElement(By.xpath(objectclass.usernameobj)).sendKeys("7373140585");
		 * driver.findElement(By.xpath(objectclass.passwordobj)).sendKeys(
		 * "Arunkumar@8055");
		 * driver.findElement(By.xpath(objectclass.submitobj)).click();
		 */
		driver.findElement(By.xpath(objectclass.closebutton)).click();
		return driver;
	}

	public static void getproperty()  {

		try {
			Properties prop=new Properties();
			String projectlocation= System.getProperty("user.dir");
			InputStream input= new FileInputStream(projectlocation+"/configurations/config.properties");
			prop.load(input);
			String browser=prop.getProperty("baseURL");
			System.out.println(browser);
		}
		catch(Exception e){
			System.out.println(e.getMessage());  
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	public static void setproperty()  {

		try {
			Properties prop=new Properties();
			String projectlocation= System.getProperty("user.dir");
			OutputStream output= new FileOutputStream(projectlocation+"/configurations/config.properties");
			prop.setProperty("baseURL", "www.amazon.com");
			prop.store(output, null);
		}
		catch(Exception e){
			System.out.println(e.getMessage());  
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	
	

}


