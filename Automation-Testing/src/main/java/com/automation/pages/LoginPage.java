package com.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.base.BasePage;
public class LoginPage extends BasePage {
 // Username selector is grounded in the HTML you supplied. Confirm the other two in DevTools.
 private final By usernameField=By.xpath("/html/body/main/form/label[1]/input");
 private final By passwordField=By.xpath("/html/body/main/form/label[2]/input"); 
 private final By loginButton=By.xpath("/html/body/main/form/button");
 public LoginPage(WebDriver driver){super(driver);}
 public void login(String username, String password) {

	    enterText(usernameField, username);
	    enterText(passwordField, password);
	    click(loginButton);

	    wait.until(
	        ExpectedConditions.urlContains("/catalogue")
	    );
	}
}