package flipkartautomation;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class pageclass {

	public void searchiphone(WebDriver driver, String SearchCriteria) throws StaleElementReferenceException, Exception {
		try {
			WebElement we = driver.findElement(By.xpath(objectclass.searchbar));
			we.sendKeys(SearchCriteria);
			we.sendKeys(Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}catch (StaleElementReferenceException e1) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			searchiphone(driver, SearchCriteria);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alllinksofiphone(WebDriver driver) throws StaleElementReferenceException, InterruptedException {
		try {
			List<WebElement> alllinks = driver.findElements(By.xpath(objectclass.alliphoneobj));
			System.out.println("total count is" + alllinks.size());

			for (WebElement a : alllinks) {
				System.out.println("available iphone:" + a.getText());
			}

		} catch (StaleElementReferenceException e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			alllinksofiphone(driver);
		}
	}

	public String chooseonephoneandgetprice(WebDriver driver) throws Exception {
		String parentWindow = null;
		try {
			List<WebElement> chooseone = driver.findElements(By.xpath(objectclass.alliphoneobj));
			parentWindow = driver.getWindowHandle();
			for (WebElement one : chooseone) {
				if(one.getText().contains("APPLE iPhone 14 ((PRODUCT)RED, 256 GB")) {
					one.click();
				}
				
			}
			
//			for (int i = 0; i < chooseone.size(); i++) {
//				
//				String linkTxt = chooseone.get(i).getText();
//				if (linkTxt.contains("APPLE iPhone 14 ((PRODUCT)RED, 256 GB")) {
//					chooseone.get(i).click();
//				}
//			}
		} catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			e.printStackTrace();
		}
		System.out.println("parentwindow is"+parentWindow);
	return parentWindow;
	}
	
	public void windowhandling(WebDriver driver, String parentWindow) throws org.openqa.selenium.NoSuchElementException {
		try {
			Set<String> TotalWindowSet =driver.getWindowHandles();
			for (String curWindowhandle : TotalWindowSet) {
				if(parentWindow.equals(curWindowhandle)) {
					
				}else {
					driver.switchTo().window(curWindowhandle);
					System.out.println("parent window"+parentWindow);
					System.out.println("child window"+curWindowhandle);
					WebElement d= driver.findElement(By.xpath("//div[@class='CXW8mj _3nMexc']"));
					d.click();
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_DOWN);
					robot.keyRelease(KeyEvent.VK_DOWN);
					Thread.sleep(5000);
					robot.keyPress(KeyEvent.VK_DOWN);
					robot.keyRelease(KeyEvent.VK_DOWN);
					Thread.sleep(5000);

					/*
					 * d.sendKeys(Keys.ARROW_DOWN); Thread.sleep(5000); d.sendKeys(Keys.ARROW_DOWN);
					 * Thread.sleep(5000);
					 */
					driver.findElement(By.xpath(objectclass.buybtn)).click();
				}
			}
			
		} catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			e.printStackTrace();
			windowhandling(driver, parentWindow);
		}
	}
	
	

	/*public void closeWebDriver(WebDriver driver) throws StaleElementReferenceException, InterruptedException {
		try {
			driver.quit();
		} catch (StaleElementReferenceException e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.quit();
		}*/
//	}
}
