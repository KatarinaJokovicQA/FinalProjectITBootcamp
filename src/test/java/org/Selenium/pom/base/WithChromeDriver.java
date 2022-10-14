package org.Selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WithChromeDriver {
    public WebDriver driver;

    public WithChromeDriver(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this); // mozda nam ovde i ne treba
    }
}
