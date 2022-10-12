package org.Selenium.pom.pages;

import org.Selenium.pom.base.BasePage;
import org.Selenium.pom.components.Banner;
import org.Selenium.pom.components.FeaturedProducts;
import org.Selenium.pom.components.Recirculation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By homeMenuLink = By.cssSelector("#menu-item-1226 > a");
    private final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");
    private final By menMenuLink = By.cssSelector("#menu-item-1228 > a");
    private final By womanMenuLink = By.cssSelector("#menu-item-1229 > a");
    private final By accessoriesMenuLink = By.cssSelector("#menu-item-1230 > a");
    private final By accountMenuLink = By.cssSelector("#menu-item-1237 > a");
    private final By aboutMenuLink = By.cssSelector("#menu-item-1232 > a");
    private final By contactUsMenuLink = By.cssSelector("#menu-item-1233 > a");


    public HomePage(WebDriver driver) {
        super(driver);
    }
    public FeaturedProducts getFeaturedProductsComponent () {
        return new FeaturedProducts(driver);
    }
    public Banner getBannerComponent () {
        return new Banner(driver);
    }
    public Recirculation getRecirculationComponent () {
        return new Recirculation(driver);
    }
    public StorePage navigateToStoreUsingMenu() {
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }

    public String getHomeLinkMenuHref() {
        return driver.findElement(homeMenuLink).getAttribute("href");
    }

    public String getStoreLinkMenuHref() {
        return driver.findElement(storeMenuLink).getAttribute("href");
    }

    public String getMenLinkMenuHref() {
        return driver.findElement(menMenuLink).getAttribute("href");
    }

    public String getWomanLinkMenuHref() {
        return driver.findElement(womanMenuLink).getAttribute("href");
    }

    public String getAccessoriesLinkMenuHref() {
        return driver.findElement(accessoriesMenuLink).getAttribute("href");
    }

    public String getAccountLinkMenuHref() {
        return driver.findElement(accountMenuLink).getAttribute("href");
    }

    public String getAboutLinkMenuHref() {
        return driver.findElement(aboutMenuLink).getAttribute("href");
    }

    public String getContactUsLinkMenuHref() {
        return driver.findElement(contactUsMenuLink).getAttribute("href");
    }


}
