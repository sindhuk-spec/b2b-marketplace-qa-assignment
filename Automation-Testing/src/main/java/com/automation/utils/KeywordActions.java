package com.automation.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.automation.base.BasePage;
/** Reusable keyword layer for common Selenium actions. */
public class KeywordActions {
 private final BasePage page;
 public KeywordActions(WebDriver driver){page=new BasePage(driver);}
 public void CLICK(By by) throws InterruptedException{page.click(by);}
 public void ENTER_TEXT(By by,String value){page.enterText(by,value);}
 public String GET_TEXT(By by){return page.getText(by);}
 public boolean VERIFY_DISPLAYED(By by){return page.isDisplayed(by);}
 public void WAIT_FOR_VISIBLE(By by){page.waitForVisible(by);}
 public void SCROLL_TO(By by){page.scrollTo(by);}
}
