
package com.automation.base;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.automation.utils.ConfigReader;

public class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        int waitTime = ConfigReader.getInt("explicit.wait");

        this.wait = new WebDriverWait(
            driver,
            Duration.ofSeconds(waitTime)
        );
    }

    public void click(By by) {
        wait.until(
            ExpectedConditions.elementToBeClickable(by)
        ).click();
    }

    public void enterText(By by, String value) {

        WebElement e = wait.until(
            ExpectedConditions.elementToBeClickable(by)
        );

        e.click();
        e.clear();
        e.sendKeys(value);

        System.out.println("Expected value: " + value);
        System.out.println("Actual value: " + e.getAttribute("value"));

        System.out.println("Field value after typing: "
                + e.getDomProperty("value"));
    }

    public String getText(By by) {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(by)
        ).getText().trim();
    }

    public boolean isDisplayed(By by) {
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(by)
            ).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void waitForVisible(By by) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(by)
        );
    }

    public void scrollTo(By by) {
        WebElement e = wait.until(
            ExpectedConditions.presenceOfElementLocated(by)
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});", e
        );
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
