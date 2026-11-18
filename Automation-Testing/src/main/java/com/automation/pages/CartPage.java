package com.automation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BasePage;

public class CartPage extends BasePage {

    private final By cartHeading = By.xpath("//h1[normalize-space()='Cart']");

    private final By cartProducts = By.xpath("/html/body/main/table/tbody/tr[1]/td[1]");
    private final By cartLineTotalPrices = By.xpath("//td[starts-with(normalize-space(), '₹')]");

    private final By checkoutButton = By.xpath("//a[@data-testid='go-checkout']");

    private final By checkoutHeading = By.xpath("//h1[normalize-space()='Checkout']");
    
    private final By Placeordrbtn = By.cssSelector("button[data-testid='place-order']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartDisplayed() {
        return isDisplayed(cartHeading);
    }

    public int getCartProductCount() {
        return driver.findElements(cartProducts).size();
    }

    public void proceedCheck() {
        click(checkoutButton);
    }
    public List<Double> getProductPrices() {

        List<WebElement> priceElements =
                driver.findElements(cartLineTotalPrices);

        List<Double> prices = new ArrayList<>();

        for (WebElement element : priceElements) {

            String priceText = element.getText()
                    .replace(",", "")
                    .replaceAll("[^0-9.]", "");

            if (priceText.isBlank()) {
                throw new IllegalStateException(
                        "Unable to read a Cart product price");
            }

            prices.add(Double.parseDouble(priceText));
        }

        return prices;
    }


    public boolean isCheckoutDisplayed() {
        return isDisplayed(checkoutHeading);
        
    }
    public void placeOrder() {
        click(Placeordrbtn);
    }
}