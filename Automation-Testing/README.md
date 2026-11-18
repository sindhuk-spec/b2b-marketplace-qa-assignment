# Simple Keyword-Driven Selenium Framework

Starter framework: Maven + Java 17 + Selenium + TestNG + POM + reusable keyword actions + Extent Reports.

## Import
1. Extract the ZIP.
2. Eclipse: File > Import > Maven > Existing Maven Projects.
3. Select this folder and Finish.
4. Right-click project > Maven > Update Project.

## Configure
- `src/main/resources/config.properties`: application URL and browser.
- `src/main/resources/testdata.properties`: buyer credentials and product test data.
- Replace all `YOUR_...` placeholders with your own values.
- Do not commit/share testdata.properties; it is listed in .gitignore.

## Locators
The username locator uses the HTML you supplied: `data-testid="username"`.
Password and login button locators are placeholders. Catalogue/cart locators are also placeholders.
Inspect the live application's HTML and replace them before execution. The framework cannot assume
the sample data-testid values exist in your application.

## Run
Run `testng.xml` as TestNG Suite, or run `mvn test` from the project directory.
Extent report: `reports/BuyerTestReport.html`.

## Current scope
Includes a starter Buyer login test and catalogue/cart Page Object scaffolding for Buyer steps 13-28.
The full product/cart flow is not yet wired because actual catalogue/cart locators and page behavior
have not been supplied. Seller and checkout flows are intentionally excluded.
