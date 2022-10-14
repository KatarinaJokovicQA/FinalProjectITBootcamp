package org.Selenium.pom.pages;

import org.Selenium.pom.base.WithChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CheckoutPage extends WithChromeDriver {

    @FindBy(id = "billing_first_name") // probaj sa ovim
    private WebElement firstNameFld;
    //private final By firstNameFld = (By.id("billing_first_name"));
    private final By lastNameFld = (By.id("billing_last_name"));
    private final By countryRegionFld = (By.id("billing_country"));
    private final By stateFld = (By.id("billing_state"));
    private final By addressLineOneFld = (By.id("billing_address_1"));
    private final By billingCityFld = (By.id("billing_city"));
    private final By billingPostCodeFld = (By.id("billing_postcode"));
    private final By billingEmailFld = (By.id("billing_email"));
    private final By placeOrderBtn1 = (By.id("place_order"));
    private final By placeOrderBtn2 = (By.id("place_order"));
    private final By clickHereToLoginLink = By.className("showlogin");
    private final By usernameFld = By.id("username");
    private final By passwordFld = By.id("password");
    private final By loginBtn = By.name("login");

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); // configuracija page factory
    }

    public CheckoutPage enterFirstName (String firstname){
        //cistije je ovako
        firstNameFld.clear();
        firstNameFld.sendKeys(firstname);
        return this;
    }
    public CheckoutPage enterLastName (String lastName){
        driver.findElement(lastNameFld).clear();
        driver.findElement(lastNameFld).sendKeys(lastName);
        return this;
    }
    public CheckoutPage selectCountryRegion (String countryName){
        Select countries = new Select(driver.findElement(countryRegionFld));
        countries.selectByVisibleText(countryName);
        return this;
    }
    public CheckoutPage selectState (String stateName){
        Select states = new Select(driver.findElement(stateFld));
        states.selectByVisibleText(stateName);
        return this;
    }
    public CheckoutPage enterAddressLineOne (String addressLineOne){
        driver.findElement(addressLineOneFld).clear();
        driver.findElement(addressLineOneFld).sendKeys(addressLineOne);
        return this;
    }
    public CheckoutPage enterCity (String city){
        driver.findElement(billingCityFld).clear();
        driver.findElement(billingCityFld).sendKeys(city);
        return this;
    }
    public CheckoutPage enterPostCode (String postCode){
        driver.findElement(billingPostCodeFld).clear();
        driver.findElement(billingPostCodeFld).sendKeys(postCode);
        return this;
    }
    public CheckoutPage enterEmail (String email){
        driver.findElement(billingEmailFld).clear();
        driver.findElement(billingEmailFld).sendKeys(email);
        return this;
    }
    public void placeOrder (){
        System.out.println("KLIKEN JA TO BRE");
        driver.findElement(placeOrderBtn1).click();
    }
    public void placeGuestOrder (){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.findElement(placeOrderBtn2).click();
    }
    public void clickHereToLoginLink () {
        driver.findElement(clickHereToLoginLink).click();
    }

    public CheckoutPage enterUserName (String username) {
        driver.findElement(usernameFld).clear();
        driver.findElement(usernameFld).sendKeys(username);
        return this;
    }

    public CheckoutPage enterPassword (String password) {
        driver.findElement(passwordFld).clear();
        driver.findElement(passwordFld).sendKeys(password);
        return this;
    }

    public CheckoutPage clickLoginButton () {
        driver.findElement(loginBtn).click();
        return this;
    }

    public CheckoutPage login (String username, String password) {
        return enterUserName(username).enterPassword(password).clickLoginButton();
    }
}
