package org.Selenium.pom.pages;

import org.Selenium.pom.base.WithChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends WithChromeDriver {
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By newUsernameField = By.id("reg_username");
    private final By newEmailField = By.id("reg_email");
    private final By newPasswordField = By.id("reg_password");
    private final By loginButton = By.cssSelector("button[name='login']");
    private final By registerButton = By.cssSelector("button[name='register']");
    private final By logoutLink = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[1]/div[2]/div[1]/div[2]/div[1]/p[1]/a[1]");
    private final By successfulRegText = By.cssSelector(".woocommerce-MyAccount-content");
    private final By errorMessage = By.className("woocommerce-error");
    private final By lostPasswordLink = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/form[1]/p[4]/a[1]");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
    public String getSuccessfulRegName () {
        return driver.findElement(successfulRegText).getText();
    }
    public AccountPage enterUserName(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }
    public LostPasswordPage clickLostPassword() {
        driver.findElement(lostPasswordLink).click();
        return new LostPasswordPage(driver);
    }
    public AccountPage enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public void clickLogin () {
        driver.findElement(loginButton).click();
    }
    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }
    public AccountPage enterNewUsername(String username) {
        driver.findElement(newUsernameField).sendKeys(username);
        return this;
    }
    public AccountPage enterNewEmail(String email) {
        driver.findElement(newEmailField).sendKeys(email);
        return this;
    }
    public AccountPage enterNewPassword(String password) {
        driver.findElement(newPasswordField).sendKeys(password);
        return this;
    }
    public void clickRegister() {
        driver.findElement(registerButton).click();
    }
}
