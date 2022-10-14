package org.Selenium.pom.components;

import org.Selenium.pom.base.WithChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Footer extends WithChromeDriver {
    private final By quickLinksWrapper = By.cssSelector(".site-footer-primary-section-1");
    private final By forHerWrapper = By.cssSelector(".site-footer-primary-section-2");
    private final By forHimWrapper = By.cssSelector(".site-footer-primary-section-3");
    private final By aodOnMobileWrapper = By.cssSelector(".site-footer-primary-section-4");
    private final By footerWrapper = By.className("site-primary-footer-wrap");
    private final By footerTitles = By.className("widget-title");


    public Footer(WebDriver driver) {
        super(driver);
    }

    public WebElement getFooterWrapper() {
        return driver.findElement(footerWrapper);
    }

    public List<WebElement> getFooterTitles() {
        return getFooterWrapper().findElements(footerTitles);
    }

    public WebElement getQuickLinksWrapper() {
        return driver.findElement(quickLinksWrapper);
    }

    public WebElement getForHerLinkWrapper() {
        return driver.findElement(forHerWrapper);
    }

    public WebElement getFoHimLinkWrapper() {
        return driver.findElement(forHimWrapper);
    }

    public WebElement getAodMobileLinkWrapper() {
        return driver.findElement(aodOnMobileWrapper);
    }

    public List<WebElement> getQuickLinks() {
        return getQuickLinksWrapper().findElements(By.tagName("a"));
    }

    public List<WebElement> getForHerLinks() {
        return getForHerLinkWrapper().findElements(By.tagName("a"));
    }

    public List<WebElement> getForHimLinks() {
        return getFoHimLinkWrapper().findElements(By.tagName("a"));
    }
    public List<WebElement> getAodMobileLInks() {
        return getAodMobileLinkWrapper().findElements(By.tagName("a"));
    }
}
