package org.Selenium.pom.components;

import org.Selenium.pom.base.WithChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Services extends WithChromeDriver {
    private final By servicesWrapperElement = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[1]/div[4]");

    public Services(WebDriver driver) {
        super(driver);
    }
    public List<WebElement> getImages() {
        return driver.findElement(servicesWrapperElement).findElements(By.tagName("img"));
    }
    public List<WebElement> getServicesTitles () {
        return driver.findElement(servicesWrapperElement).findElements(By.cssSelector("h6"));
    }
    public List<WebElement> getServicesDescription () {
        return driver.findElement(servicesWrapperElement).findElements(By.cssSelector("p"));
    }
}
