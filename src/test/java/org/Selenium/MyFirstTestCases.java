package org.Selenium;

import org.Selenium.pom.base.BaseTest;
import org.Selenium.pom.pages.HomePage;
import org.Selenium.pom.pages.StorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyFirstTestCases extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {


        driver.get("https://askomdch.com");

        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.clickStoreMenuLink();
        Thread.sleep(2000);
        storePage.search("Blue");
        Thread.sleep(3000);
        Assert.assertEquals(storePage.getTitle(),"Search results: “Blue”");

        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(3000);
        storePage.clickViewCart();


//        driver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
//        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
//        driver.findElement(By.cssSelector("button[value='Search']")).click();
//        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(), "Search results: “Blue”");
//        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.cssSelector("a[title='View cart']")).click();





//
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
//        Assert.assertEquals(
//                driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(), "Blue Shoes"
//        );
//        driver.findElement(By.cssSelector(".checkout-button")).click();
//        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
//        driver.findElement(By.id("billing_last_name")).sendKeys("user");
//        driver.findElement(By.id("billing_address_1")).sendKeys("San Francisco");
//        driver.findElement(By.id("billing_city")).sendKeys("San Francisco");
//        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
//        driver.findElement(By.id("billing_email")).sendKeys("askomdch@gmail.com");
//        driver.findElement(By.id("place_order")).click();
//        Thread.sleep(5000);
//        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-notice")).getText(), "Thank you. Your order has been received.");

    }
    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
        driver.findElement(By.cssSelector("button[value='Search']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(), "Search results: “Blue”");
        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("a[title='View cart']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        Assert.assertEquals(
                driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(), "Blue Shoes"
        );
        driver.findElement(By.cssSelector(".checkout-button")).click();
        driver.findElement(By.className("showlogin")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("username")).sendKeys("demouser2");
        driver.findElement(By.id("password")).sendKeys("demopwd");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
        driver.findElement(By.id("billing_last_name")).sendKeys("user");
        driver.findElement(By.id("billing_address_1")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_city")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
        driver.findElement(By.id("billing_email")).clear();
        driver.findElement(By.id("billing_email")).sendKeys("askomdch@gmail.com");
        driver.findElement(By.id("place_order")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-notice")).getText(), "Thank you. Your order has been received.");


    }
}

