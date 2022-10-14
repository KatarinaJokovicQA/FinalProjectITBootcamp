package org.Selenium.pom.components;

import org.Selenium.pom.base.WithChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BelowFooter extends WithChromeDriver {
    private final By belowFooterWrapper = By.className("site-below-footer-wrap");
    private final By copyright = By.className("ast-footer-copyright");
    private final By poweredBy = By.className("site-footer-below-section-2");
    public BelowFooter(WebDriver driver) {
        super(driver);
    }

    public String getCopyrightText () {
        return driver.findElement(copyright).getText();
    }

    public String getPoweredBy () {
        return driver.findElement(belowFooterWrapper).findElement(poweredBy).getText();
    }
}
