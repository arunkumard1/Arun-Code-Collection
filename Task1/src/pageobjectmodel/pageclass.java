package pageobjectmodel;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageclass {

	public List capturealloptions(WebDriver driver) throws InterruptedException {
		List<WebElement> allopt = driver.findElements(By.xpath(objectclass.alloptionsobj));
		return allopt;
	}

}
