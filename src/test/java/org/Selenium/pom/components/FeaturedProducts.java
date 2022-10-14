package org.Selenium.pom.components;

import org.Selenium.pom.base.WithChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FeaturedProducts extends WithChromeDriver {
    private final By featuredProductsWrapperElement = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[1]/div[3]");

    public FeaturedProducts(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(featuredProductsWrapperElement).findElement(By.cssSelector("h2")).getText();
    }
    public List<WebElement> getImages() {
        return driver.findElement(featuredProductsWrapperElement).findElements(By.tagName("img"));
    }

    public List<WebElement> getProductTitles () {
        return driver.findElement(featuredProductsWrapperElement).findElement(By.cssSelector("ul")).findElements(By.cssSelector("h2"));
    }
    public List<WebElement> getProductCategories () {
        return driver.findElement(featuredProductsWrapperElement).findElement(By.cssSelector("ul")).findElements(By.cssSelector(".ast-woo-product-category"));
    }
    public List<WebElement> getProductPrices () {
        return driver.findElement(featuredProductsWrapperElement).findElement(By.cssSelector("ul")).findElements(By.cssSelector(".price"));
    }
    public List<WebElement> getAddToCartButtons () {
        return driver.findElement(featuredProductsWrapperElement).findElement(By.cssSelector("ul")).findElements(By.cssSelector(".add_to_cart_button"));
    }
    public FeaturedProducts clickAllAddToCartButtons () {
        for (int i = 0; i <getAddToCartButtons().size() ; i++) {
            getAddToCartButtons().get(i).click();
        }
        return this;
    }
    public List<WebElement> getViewCartElements () {
        return driver.findElement(featuredProductsWrapperElement).findElement(By.cssSelector("ul")).findElements(By.cssSelector(".added_to_cart"));
    }
}
