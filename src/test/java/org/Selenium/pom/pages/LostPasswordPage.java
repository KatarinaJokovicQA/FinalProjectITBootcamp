package org.Selenium.pom.pages;

import org.Selenium.pom.base.WithChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LostPasswordPage extends WithChromeDriver {
    private final By usernameField = By.id("user_login");
    private final By resetPasswordButton = By.cssSelector("button[value='Reset password']");
    public LostPasswordPage(WebDriver driver) {
        super(driver);
    }

    public LostPasswordPage enterUsername (String username ) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }
    public void clickResetPassword () {
        driver.findElement(resetPasswordButton).click();
    }
}
