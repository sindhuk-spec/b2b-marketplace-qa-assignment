package com.automation.driver;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.automation.utils.ConfigReader;
public final class DriverFactory {
private static WebDriver driver;
private DriverFactory(){}
public static void startBrowser()
{
  if(!ConfigReader.get("browser").equalsIgnoreCase("chrome")) throw new IllegalArgumentException("Only Chrome is configured.");
 
  WebDriverManager.chromedriver().setup();
  ChromeOptions options = new ChromeOptions();

  Map<String, Object> prefs = new HashMap<>();

  // Disable password manager
  prefs.put("credentials_enable_service", false);

  // Disable password saving
  prefs.put("profile.password_manager_enabled", false);

  // Disable password leak detection
  prefs.put("profile.password_manager_leak_detection", false);

  options.setExperimentalOption("prefs", prefs);

  options.setAcceptInsecureCerts(true);
  options.addArguments("--ignore-certificate-errors");
  options.addArguments("--start-maximized");
  options.setExperimentalOption(
    "excludeSwitches",
    Arrays.asList("enable-automation")
);

  // Disable HTTPS-First automatic upgrade
  options.addArguments(
      "--disable-features=HttpsFirstBalancedModeAutoEnable"
  );

  driver = new ChromeDriver(options);
}

public static WebDriver getDriver(){if(driver==null) throw new IllegalStateException("Browser not started"); return driver;}
public static void quitBrowser(){if(driver!=null){driver.quit();driver=null;}}
} 