package com.automation.testbase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.automation.driver.DriverFactory;
import com.automation.utils.ConfigReader;
public class BaseTest {
 protected WebDriver driver;
 @BeforeMethod public void setUp(){
	 DriverFactory.startBrowser();driver=DriverFactory.getDriver();driver.get(ConfigReader.get("app.url"));
	 }
}
