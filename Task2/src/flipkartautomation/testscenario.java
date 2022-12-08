package flipkartautomation;

import org.openqa.selenium.WebDriver;

public class testscenario {

	public static void main(String[] args) throws Exception  {
		baseclass bc= new baseclass();
		pageclass pg= new pageclass();
		WebDriver driver=bc.launchchromeBrowser();
		bc.LoginUsername(driver, "7373140585","Arunkumar@8055");
		pg.searchiphone(driver,"iphone14");
		pg.alllinksofiphone(driver);
		String parentWindow = pg.chooseonephoneandgetprice(driver);
		pg.windowhandling(driver,parentWindow);
		//pg.closeWebDriver(driver);
	}
}
