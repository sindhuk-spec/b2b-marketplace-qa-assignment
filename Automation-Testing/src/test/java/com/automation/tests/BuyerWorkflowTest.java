package com.automation.tests;
import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.automation.listeners.ExtentReportListener;
import com.automation.pages.BuyerCataloguePage;
import com.automation.pages.CartPage;
import com.automation.pages.LoginPage;
import com.automation.testbase.BaseTest;
import com.automation.utils.ConfigReader;
@Listeners(ExtentReportListener.class)
public class BuyerWorkflowTest extends BaseTest {
	@BeforeMethod
 public void buyerLoginTest() throws InterruptedException{
  String username=ConfigReader.getTestData("buyer.username");
  String password=ConfigReader.getTestData("buyer.password");
  Assert.assertFalse(username.startsWith("YOUR_"),"Set buyer.username in testdata.properties");
  Assert.assertFalse(password.startsWith("YOUR_"),"Set buyer.password in testdata.properties");
  new LoginPage(driver).login(username,password);
 }

@Test
public void addTwoProductsToCartTest() throws InterruptedException {
	SoftAssert softAssert = new SoftAssert();
    // Create Buyer Catalogue Page Object
    BuyerCataloguePage catalogue =
            new BuyerCataloguePage(driver);

    


    //  PRODUCT 1

    // Step 1: Verify Buyer Catalogue
    Assert.assertTrue(
            catalogue.isCatalogueDisplayed(),
            "Buyer Catalogue page is not displayed");

    // Step 2: Search Product 1
    catalogue.selectProduct1();
    catalogue.addToCart();

    Assert.assertTrue(catalogue.isSuccessMessageDisplayed());



    // Step 6: Verify Success Message
    Assert.assertTrue(
            catalogue.isSuccessMessageDisplayed(),
            "Product 1 was not added to Cart");


    // Step 7: Click Catalogue Menu
    catalogue.clickCatalogue();

    Assert.assertTrue(
            catalogue.isCatalogueDisplayed(),
            "Unable to return to Buyer Catalogue");

    // Step 8: Search Product 2
    catalogue.selectProduct2();
    catalogue.addToCart();

    // Step 12: Verify Success Message
    Assert.assertTrue(
            catalogue.isSuccessMessageDisplayed(),
            "Product 2 was not added to Cart");

    System.out.println(
            "PASS: Product 1 and Product 2 added to Cart");
    
    CartPage cart = new CartPage(driver);

    Assert.assertTrue(cart.isCartDisplayed(),
            "Cart page is not displayed");
    ExtentReportListener.logPass(
            "Cart page displayed successfully");
    //Price validation
    List<Double> prices = cart.getProductPrices();

    double price1 = prices.get(0);
    double price2 = prices.get(2);

    System.out.println("Product 1 Price: Rs. " + price1);
    System.out.println("Product 2 Price: Rs. " + price2);

    System.out.println("Minimum required per line item: Rs. 2000");

    //Assert.assertEquals(cart.getCartProductCount(), 2,
          //  "Cart does not contain two products");

    cart.proceedCheck();

    Assert.assertTrue(cart.isCheckoutDisplayed(),
            "Checkout page is not displayed");
    ExtentReportListener.logPass(
            "Proceed to Checkout button clicked");
    
    Assert.assertTrue(cart.isCheckoutDisplayed(),
            "Checkout page is not displayed");

    ExtentReportListener.logPass(
            "Checkout page displayed successfully");
    softAssert.assertAll();

}

}
