package org.Selenium.pom.base;

import org.openqa.selenium.WebDriver;

public class WithChromeDriver {
    public WebDriver driver;

    public WithChromeDriver(WebDriver driver){
        this.driver = driver;
    }
}
