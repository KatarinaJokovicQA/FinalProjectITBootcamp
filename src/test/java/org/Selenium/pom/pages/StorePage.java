package org.Selenium.pom.pages;

import org.Selenium.pom.base.WithChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StorePage extends WithChromeDriver {
    private final By searchFld = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By viewCartLink =  By.cssSelector("a[title='View cart']");
    private final By productsWrapper = By.cssSelector(".products");
    private final By showingParagraph = By.cssSelector(".woocommerce-result-count");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public String getHeadTitle () {
        return driver.getTitle();
    }
    private StorePage enterTextInSearchFld(String txt) {
        driver.findElement(searchFld).sendKeys(txt);
        return this;
    }
    public List<WebElement> getProductImages () {
        return driver.findElement(productsWrapper).findElements(By.tagName("img"));
    }
    public int getNumberOfResults () {
        String resultsText = driver.findElement(showingParagraph).getText();
        String numberOnly= resultsText.replaceAll("[^0-9]", "");
        return Integer.parseInt(numberOnly);
    }
    public StorePage search(String txt) {
        enterTextInSearchFld(txt).clickSearchBtn();
        return this;
    }

    private StorePage clickSearchBtn() {
        driver.findElement(searchBtn).click();
        return this;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public By getAddToCartElement (String productName) {
        return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
    }

    public StorePage clickAddToCartBtn (String productName) {
        By addToCartBtn = getAddToCartElement(productName);
        driver.findElement(addToCartBtn).click();
        return this;
    }

    public CartPage clickViewCart () {
        driver.findElement(viewCartLink).click();
        return new CartPage(driver);
    }
}
