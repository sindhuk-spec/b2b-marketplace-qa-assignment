package com.automation.pages;
import org.openqa.selenium.By;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import com.automation.base.BasePage;
/** Replace sample data-testid locators with actual application locators after inspection. */
public class BuyerCataloguePage extends BasePage {
 private final By catalogueHeading=By.xpath("/html/body/main/h1");
 private final By product01= By.xpath("//a[@href='/c/sindhu-e20196/product/243']"); 
 private final By product02= By.xpath("/html/body/main/table/tbody/tr[3]/td[2]/a"); 

 private final By addToCartButton=By.xpath("//button[@data-testid='add-to-cart']");
 //Back to catalogue
  private final By catalogue=By.xpath("/html/body/header/nav/a[1]");
 private final By productPrice2 = By.xpath("/html/body/main/table/tbody/tr/td[5]");
 private final By addcartsuccessMessage=By.xpath("/html/body/main/p[1]");
 private final By openCartButton=By.xpath("");
 
 public BuyerCataloguePage(WebDriver driver){super(driver);}
 public boolean isCatalogueDisplayed(){return isDisplayed(catalogueHeading);}
 public void selectProduct1() throws InterruptedException {
	    click(product01);
	}

	public void selectProduct2() throws InterruptedException {
	    click(product02);
	}

 public void clickCatalogue() throws InterruptedException {
	    click(catalogue);
	}

 public String getProductPrice(){return getText(productPrice2);}
 public void addToCart() throws InterruptedException{click(addToCartButton);}
 public boolean isSuccessMessageDisplayed(){return isDisplayed(addcartsuccessMessage);}
 public void openCart() throws InterruptedException{click(openCartButton);}
 
 

}
