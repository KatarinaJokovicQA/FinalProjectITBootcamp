package org.Selenium;

import org.Selenium.pom.base.BaseHelper;
import org.Selenium.pom.base.BaseTest;
import org.Selenium.pom.components.Banner;
import org.Selenium.pom.components.FeaturedProducts;
import org.Selenium.pom.components.Recirculation;
import org.Selenium.pom.pages.CartPage;
import org.Selenium.pom.pages.CheckoutPage;
import org.Selenium.pom.pages.HomePage;
import org.Selenium.pom.pages.StorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestCases extends BaseTest {

    public void wait(int milliseconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(milliseconds));
    }

    @Test
    public void navigationLinks() {
        driver.get("https://askomdch.com");

        HomePage homePage = new HomePage(driver);

        driver.get(homePage.getHomeLinkMenuHref());
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/");

        driver.get(homePage.getStoreLinkMenuHref());
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/store/");

        driver.get(homePage.getMenLinkMenuHref());
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/product-category/men/");

        driver.get(homePage.getWomanLinkMenuHref());
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/product-category/women/");

        driver.get(homePage.getAccessoriesLinkMenuHref());
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/product-category/accessories/");

        driver.get(homePage.getAccountLinkMenuHref());
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/account/");

        driver.get(homePage.getAboutLinkMenuHref());
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/about/");

        driver.get(homePage.getContactUsLinkMenuHref());
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/contact-us/");

    }

    @Test
    public void verifyHomeBannerComponent() {
        driver.get("https://askomdch.com");

        HomePage homePage = new HomePage(driver);

        Banner banner = homePage.getBannerComponent();

        Assert.assertEquals(banner.getBannerTitle(), "Raining Offers for Hot Summer!");
        Assert.assertEquals(banner.getBannerDescription(), "25% OFF On all products");
        Assert.assertEquals(banner.getBannerShopNowButtonText(), "SHOP NOW");
        Assert.assertEquals(banner.getBannerFindMoreButtonText(), "FIND MORE");

        driver.get(banner.getBannerShopNowButtonHref());
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/store");

        driver.navigate().back();
        driver.get(banner.getBannerFindMoreButtonHref());
        Assert.assertEquals(driver.getCurrentUrl(), "https://askomdch.com/contact-us/");

    }

    @Test
    public void verifyHomeRecirculationComponent() {
        driver.get("https://askomdch.com");

        BaseHelper baseHelper = new BaseHelper();
        HomePage homePage = new HomePage(driver);

        Recirculation recirculation = homePage.getRecirculationComponent();

        String[] titles = recirculation.getTitles();
        String[] expectedTitles = {"20% Off on Tank Tops", "Latest Eyewear", "Let’s Suit Up"};

        baseHelper.validateStringArray(titles,expectedTitles);

        String[] descriptions = recirculation.getDescriptions();
        String[] expectedDescriptions = {"Lorem ipsum dolor sit amet consectetur","Lorem ipsum dolor sit amet consectetur","Lorem ipsum dolor sit amet consectetur"};
        baseHelper.validateStringArray(descriptions,expectedDescriptions);

        String[] buttonsTexts = recirculation.getButtonsTexts();
        String[] expectedButtonTexts = {"SHOP NOW", "SHOP NOW", "CHECK OUT"};
        baseHelper.validateStringArray(buttonsTexts,expectedButtonTexts);

        String[] buttonsHrefs = recirculation.getArrayOfLinkHrefs();
        String[] expectedButtonsHrefs = {"https://askomdch.com/product-category/women/", "https://askomdch.com/product-category/men/", "https://askomdch.com/product-category/accessories/"};
        baseHelper.validateStringArray(buttonsHrefs,expectedButtonsHrefs);

        List<WebElement> images = recirculation.getImages();
        baseHelper.validateIsImageVisible(images);
    }
    @Test
    public void verifyFeaturedProductsComponent() {
        driver.get("https://askomdch.com");

        BaseHelper baseHelper = new BaseHelper();
        HomePage homePage = new HomePage(driver);

        FeaturedProducts featuredProducts = homePage.getFeaturedProductsComponent();

        Assert.assertEquals(featuredProducts.getTitle(), "Featured Products");

        //Images are visible
        baseHelper.validateIsImageVisible(featuredProducts.getImages());
        //Each product has title
        baseHelper.validateIfTextInElementExists(featuredProducts.getProductTitles());
        //Each category has name (CREATE ENUM FOR PRODUCT CATEGORIES)
        baseHelper.validateIfTextInElementExists(featuredProducts.getProductCategories());
        //Each product has prices
        baseHelper.validateIfTextInElementExists(featuredProducts.getProductPrices());
        //Each product has ADD TO CART button
        baseHelper.validateIfTextInElementIsEqualTo(featuredProducts.getAddToCartButtons(),"ADD TO CART");
        //Click every ADD TO CART BUTTON and verify it reveals "View cart" link, and check if link is correct
        baseHelper.validateIfTextInElementIsEqualTo(featuredProducts.clickAllAddToCartButtons().getViewCartElements(),"View cart");
        baseHelper.validateIfLinksHrefsIsEqualTo(featuredProducts.clickAllAddToCartButtons().getViewCartElements(),"https://askomdch.com/cart/");

    }
    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://askomdch.com");

        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.navigateToStoreUsingMenu();
        wait(1000);
        storePage.search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

        storePage.clickAddToCartBtn("Blue Shoes");
        CartPage cartPage = storePage.clickViewCart();
        wait(1000);
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckoutPage checkoutPage = cartPage.checkOut();
        checkoutPage.enterFirstName("demo").
                enterLastName("user").
                enterAddressLineOne("San Francisco").
                enterCity("San Francisco").
                enterPostCode("94188").
                enterEmail("askomdch@gmail.com").
                placeOrder();
        wait(1000);
        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-notice")).getText(), "Thank you. Your order has been received.");

    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {

        driver.get("https://askomdch.com");

        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.navigateToStoreUsingMenu();
        wait(1000);
        storePage.search("Blue");
        wait(1000);
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

        storePage.clickAddToCartBtn("Blue Shoes");
        CartPage cartPage = storePage.clickViewCart();
        wait(1000);
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckoutPage checkoutPage = cartPage.checkOut();
        checkoutPage.clickHereToLoginLink();
        wait(1000);

        checkoutPage.
                login("demouser2", "demopwd").
                enterFirstName("demo").
                enterLastName("user").
                selectCountryRegion("United States (US)").
                enterAddressLineOne("San Francisco").
                selectState("California").
                enterCity("San Francisco").
                enterPostCode("94188").
                enterEmail("askomdch@gmail.com").
                placeOrder();

        wait(5000);
        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-notice")).getText(), "Thank you. Your order has been received.");
    }


}

