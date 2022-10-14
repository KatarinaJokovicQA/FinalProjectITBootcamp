package org.Selenium.pom.components;

import org.Selenium.pom.base.WithChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Banner extends WithChromeDriver {
    private final By title = By.cssSelector(".wp-block-cover__inner-container h1");
    private final By description = By.cssSelector(".wp-block-cover__inner-container h3");
    private final By shopNowButton = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]");
    private final By findMore = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]");
    public Banner(WebDriver driver) {
        super(driver);
    }

    public String getBannerTitle () {
        return driver.findElement(title).getText();
    }
    public String getBannerDescription () {
        return driver.findElement(description).getText();
    }
    public String getBannerShopNowButtonText () {
        return driver.findElement(shopNowButton).getText();
    }
    public String getBannerShopNowButtonHref () {
        return driver.findElement(shopNowButton).getAttribute("href");
    }
    public String getBannerFindMoreButtonText () {
        return driver.findElement(findMore).getText();
    }
    public String getBannerFindMoreButtonHref () {
        return driver.findElement(findMore).getAttribute("href");
    }
}
