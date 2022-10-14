package org.Selenium;

import org.Selenium.pom.base.BaseHelper;
import org.Selenium.pom.base.BaseTest;
import org.Selenium.pom.components.*;
import org.Selenium.pom.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Calendar;
import java.util.List;

public class TestCases extends BaseTest {

    public void wait(int milliseconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(milliseconds));
    }

    @Test
    @Parameters({
            "homePage",
            "storePage",
            "productCategoryMenPage",
            "productCategoryWomanPage",
            "productCategoryAccessoriesPage",
            "accountPage",
            "aboutPage",
            "contactUsPage"
    })
    public void navigationLinks(
            String homePage,
            String storePage,
            String productCategoryMenPage,
            String productCategoryWomanPage,
            String productCategoryAccessoriesPage,
            String accountPage,
            String aboutPage,
            String contactUsPage
    ) {
        driver.get(homePage);

        HomePage homePageClass = new HomePage(driver);

        driver.get(homePageClass.getHomeLinkMenuHref());
        Assert.assertEquals(driver.getCurrentUrl(), homePage);

        driver.get(homePageClass.getStoreLinkMenuHref());
        Assert.assertEquals(driver.getCurrentUrl(), storePage);

        driver.get(homePageClass.getMenLinkMenuHref());
        Assert.assertEquals(driver.getCurrentUrl(), productCategoryMenPage);

        driver.get(homePageClass.getWomanLinkMenuHref());
        Assert.assertEquals(driver.getCurrentUrl(), productCategoryWomanPage);

        driver.get(homePageClass.getAccessoriesLinkMenuHref());
        Assert.assertEquals(driver.getCurrentUrl(), productCategoryAccessoriesPage);

        driver.get(homePageClass.getAccountLinkMenuHref());
        Assert.assertEquals(driver.getCurrentUrl(), accountPage);

        driver.get(homePageClass.getAboutLinkMenuHref());
        Assert.assertEquals(driver.getCurrentUrl(), aboutPage);

        driver.get(homePageClass.getContactUsLinkMenuHref());
        Assert.assertEquals(driver.getCurrentUrl(), contactUsPage);

    }

    @Test
    @Parameters({
            "homePage",
            "bannerTitle",
            "bannerDescription",
            "shopNowButtonText",
            "findMoreButtonText",
            "storePageHref",
            "contactUsPage"
    })
    public void verifyHomeBannerComponent(
            String homePage,
            String bannerTitle,
            String bannerDescription,
            String shopNowButtonText,
            String findMoreButtonText,
            String storePageHref,
            String contactUsPage
    ) {
        driver.get(homePage);

        Banner banner = new Banner(driver);

        Assert.assertEquals(banner.getBannerTitle(), bannerTitle);
        Assert.assertEquals(banner.getBannerDescription(), bannerDescription);
        Assert.assertEquals(banner.getBannerShopNowButtonText(), shopNowButtonText);
        Assert.assertEquals(banner.getBannerFindMoreButtonText(), findMoreButtonText);

        driver.get(banner.getBannerShopNowButtonHref());
        Assert.assertEquals(driver.getCurrentUrl(), storePageHref);

        driver.navigate().back();
        driver.get(banner.getBannerFindMoreButtonHref());
        Assert.assertEquals(driver.getCurrentUrl(), contactUsPage);

    }

    @Test
    @Parameters({
            "homePage",
            "recirculationTitle1",
            "recirculationTitle2",
            "recirculationTitle3",
            "recirculationDescription1",
            "recirculationDescription2",
            "recirculationDescription3",
            "button1Text",
            "button2Text",
            "button3Text",
            "productCategoryWomanPage",
            "productCategoryMenPage",
            "productCategoryAccessoriesPage"
    })
    public void verifyHomeRecirculationComponent(
            String homePage,
            String recirculationTitle1,
            String recirculationTitle2,
            String recirculationTitle3,
            String recirculationDescription1,
            String recirculationDescription2,
            String recirculationDescription3,
            String button1Text,
            String button2Text,
            String button3Text,
            String productCategoryWomanPage,
            String productCategoryMenPage,
            String productCategoryAccessoriesPage
    ) {
        driver.get(homePage);

        BaseHelper baseHelper = new BaseHelper();

        Recirculation recirculation = new Recirculation(driver);

        String[] titles = recirculation.getTitles();
        String[] expectedTitles = {recirculationTitle1, recirculationTitle2, recirculationTitle3};

        //ovo ce da radi ako ti treba proveravanje 2 niza.
        Assert.assertEquals(titles, expectedTitles);
        //ovo ce da radi ako ti nije bitan redosled, a proverava 2 niza
        //MatcherAssert.assertThat(List.of(titles), Matchers.containsInAnyOrder(List.of(expectedTitles)));
        //baseHelper.validateStringArray(titles, expectedTitles);

        String[] descriptions = recirculation.getDescriptions();
        String[] expectedDescriptions = {recirculationDescription1, recirculationDescription2, recirculationDescription3};
        baseHelper.validateStringArray(descriptions, expectedDescriptions);

        String[] buttonsTexts = recirculation.getButtonsTexts();
        String[] expectedButtonTexts = {button1Text, button2Text, button3Text};
        baseHelper.validateStringArray(buttonsTexts, expectedButtonTexts);

        String[] buttonsHrefs = recirculation.getArrayOfLinkHrefs();
        String[] expectedButtonsHrefs = {productCategoryWomanPage, productCategoryMenPage, productCategoryAccessoriesPage};
        baseHelper.validateStringArray(buttonsHrefs, expectedButtonsHrefs);

        List<WebElement> images = recirculation.getImages();
        Assert.assertTrue(baseHelper.checkImagesVisibility(images), "All images should be visible");
    }

    @Test
    @Parameters({
            "homePage",
            "featuredProductsTitle",
            "addToCartButtonText",
            "viewCartLinkText",
            "cartPage"
    })
    public void verifyFeaturedProductsComponent(
            String homePage,
            String featuredProductsTitle,
            String addToCartButtonText,
            String viewCartLinkText,
            String cartPage
    ) {
        driver.get(homePage);

        BaseHelper baseHelper = new BaseHelper();

        FeaturedProducts featuredProducts = new FeaturedProducts(driver);

        Assert.assertEquals(featuredProducts.getTitle(), featuredProductsTitle);

        Assert.assertTrue(baseHelper.checkImagesVisibility(featuredProducts.getImages()),
                "The featured products images should be visible");
        //Each product has title
        baseHelper.validateIfTextInElementExists(featuredProducts.getProductTitles());
        //Each category has name (@TODO:CREATE ENUM FOR PRODUCT CATEGORIES)
        baseHelper.validateIfTextInElementExists(featuredProducts.getProductCategories());
        //Each product has prices
        baseHelper.validateIfTextInElementExists(featuredProducts.getProductPrices());
        //Each product has ADD TO CART button
        baseHelper.validateIfTextInElementIsEqualTo(featuredProducts.getAddToCartButtons(), addToCartButtonText);
        //Click every ADD TO CART BUTTON and verify it reveals "View cart" link, and check if link is correct
        baseHelper.validateIfTextInElementIsEqualTo(featuredProducts.clickAllAddToCartButtons().getViewCartElements(), viewCartLinkText);
        baseHelper.validateIfLinksHrefsIsEqualTo(featuredProducts.clickAllAddToCartButtons().getViewCartElements(), cartPage);
    }
    @Test
    @Parameters({
            "homePage"
    })
    public void verifyServicesComponent(
            String homePage
    ) {
        driver.get(homePage);

        BaseHelper baseHelper = new BaseHelper();

        Services services = new Services(driver);

        Assert.assertTrue(baseHelper.checkImagesVisibility(services.getImages()),
                "The service images should be visible");
        baseHelper.validateIfTextInElementExists(services.getServicesTitles());
        baseHelper.validateIfTextInElementExists(services.getServicesDescription());
    }

    @Test
    @Parameters({
            "homePage",
            "footerColumnTitle1",
            "footerColumnTitle2",
            "footerColumnTitle3",
            "footerColumnTitle4",
            "aboutPage",
            "accountPage",
            "cartPage",
            "contactUsPage",
            "productCategoryWomanPage",
            "womanJeansPage",
            "womanShirtsPage",
            "womanShoesPage",
            "productCategoryAccessoriesPage",
            "productCategoryMenPage",
            "manJeansPage",
            "manShirtsPage",
            "manShoesPage",
            "appleStore",
            "googlePlayStore"
    })
    public void verifyFooter(
            String homePage,
            String footerColumnTitle1,
            String footerColumnTitle2,
            String footerColumnTitle3,
            String footerColumnTitle4,
            String aboutPage,
            String accountPage,
            String cartPage,
            String contactUsPage,
            String productCategoryWomanPage,
            String womanJeansPage,
            String womanShirtsPage,
            String womanShoesPage,
            String productCategoryAccessoriesPage,
            String productCategoryMenPage,
            String manJeansPage,
            String manShirtsPage,
            String manShoesPage,
            String appleStore,
            String googlePlayStore
    ) {
        driver.get(homePage);
        String[] expectedFooterTitles = new String[]{footerColumnTitle1,footerColumnTitle2,footerColumnTitle3,footerColumnTitle4};
        String[] expectedFooterQuickLinks = new String[]{homePage, aboutPage, accountPage, cartPage, contactUsPage};
        String[] expectedFooterForHerLinks = new String[]{productCategoryWomanPage,womanJeansPage,womanShirtsPage,womanShoesPage,productCategoryAccessoriesPage};
        String[] expectedFooterForHimLinks = new String[]{productCategoryMenPage,manJeansPage,manShirtsPage,manShoesPage,productCategoryAccessoriesPage};
        String[] expectedAodMobileLInks = new String[]{appleStore,googlePlayStore};

        BaseHelper baseHelper = new BaseHelper();

        Footer footer = new Footer(driver);

        baseHelper.validateElementsTextsIsEqualToStringArray(footer.getFooterTitles(), expectedFooterTitles);

        //Validate footer links
        baseHelper.validateIfLinksHrefsIsEqualToHrefsArray(footer.getQuickLinks(), expectedFooterQuickLinks);
        baseHelper.validateIfLinksHrefsIsEqualToHrefsArray(footer.getForHerLinks(), expectedFooterForHerLinks);
        baseHelper.validateIfLinksHrefsIsEqualToHrefsArray(footer.getForHimLinks(), expectedFooterForHimLinks);
        baseHelper.validateIfLinksHrefsIsEqualToHrefsArray(footer.getAodMobileLInks(), expectedAodMobileLInks);
    }

    @Test
    public void verifyBelowFooter() {
        BelowFooter belowFooter = new BelowFooter(driver);

        int year = Calendar.getInstance().get(Calendar.YEAR);

        //Validate text and copyright current year
        Assert.assertEquals(belowFooter.getCopyrightText(),"Copyright © "+year+" AskOmDch");
        Assert.assertEquals(belowFooter.getPoweredBy(),"Powered by AskOmDch");
    }

    @Test
    @Parameters({
            "homePage",
            "demoUserName",
            "demoPassword",
            "authCookieName"
    })
    public AccountPage loginWithExistingAccount (
            String homePage,
            String demoUserName,
            String demoPassword,
            String authCookieName
    ) {
        driver.get(homePage);
        HomePage homePageClass = new HomePage(driver);

        AccountPage accountPage = homePageClass.navigateToAccountUsingMenu();

        wait(2000);
        accountPage.
                enterUserName(demoUserName).
                enterPassword(demoPassword).
                clickLogin();

        //Check if user successfully logged in via cookie
        Assert.assertTrue(driver.manage().getCookies().toString().contains(authCookieName));
        return accountPage;
    }
    @Test
    @Parameters({
            "homePage",
            "demoUserName",
            "demoPassword",
            "authCookieName"
    })
    public void logout(
            String homePage,
            String demoUserName,
            String demoPassword,
            String authCookieName
    ) {
        loginWithExistingAccount(
                homePage,
                demoUserName,
                demoPassword,
                authCookieName
        ).clickLogout();

        wait(2000);
        Assert.assertFalse(driver.manage().getCookies().toString().contains("wordpress_logged_in"));
    }
    @Test
    @Parameters({
            "homePage",
            "username",
            "email",
            "password",
            "accountAlreadyRegisteredError"
    })
    public void createNewAccount(
            String homePage,
            String username,
            String email,
            String password,
            String accountAlreadyRegisteredError
    ) {
        driver.get(homePage);
        HomePage homePageClass = new HomePage(driver);

        AccountPage accountPage = homePageClass.navigateToAccountUsingMenu();

        wait(2000);
        accountPage.
                enterNewUsername(username).
                enterNewEmail(email).
                enterNewPassword(password).
                clickRegister();

        wait(2000);
        //Confirm successful login
        Assert.assertTrue(accountPage.getSuccessfulRegName().contains(username));
        // Logout
        accountPage.clickLogout();

        wait(2000);
        //Try to create new account with the same credentials
        accountPage.
                enterNewUsername(username).
                enterNewEmail(email).
                enterNewPassword(password).
                clickRegister();

        //Confirm error
        wait(500);
        Assert.assertEquals(accountPage.getErrorMessage(),accountAlreadyRegisteredError);
    }
    @Test
    @Parameters({
            "demoUserName",
            "homePage"
    })
    public void lostYourPassword (
            String demoUserName,
            String homePage
    ) {
        String expectedUrl = "https://askomdch.com/account/lost-password/?reset-link-sent=true";

        driver.get(homePage);
        HomePage homePageClass = new HomePage(driver);
        AccountPage accountPage = homePageClass.navigateToAccountUsingMenu();

        wait(2000);
        LostPasswordPage lostPasswordPage = accountPage.clickLostPassword();

        wait(2000);
        lostPasswordPage.enterUsername(demoUserName).clickResetPassword();

        wait(2000);
        //Verify email was sent via url params
        Assert.assertEquals(lostPasswordPage.driver.getCurrentUrl(), expectedUrl);
    }
    @Test
    @Parameters({
            "homePage",
            "searchTerm"
    })
    public void validateStoreSearch (
            String homePage,
            String searchTerm
    ) {
        driver.get(homePage);
        HomePage homePageClass = new HomePage(driver);
        StorePage storePage = homePageClass.navigateToStoreUsingMenu();

        wait(2000);
        storePage.search(searchTerm);
        Assert.assertEquals(storePage.getTitle(), "Search results: “"+searchTerm+"”");

        //Verify query params
        Assert.assertEquals(storePage.driver.getCurrentUrl(),"https://askomdch.com/?s="+searchTerm+"&post_type=product");
        //Search "jeans" should give at least 5 result count
        Assert.assertTrue(storePage.getNumberOfResults() >= 5);
        Assert.assertEquals(storePage.getNumberOfResults(),storePage.getProductImages().size());
    }
    @Test
    @Parameters({
            "homePage",
            "searchTermCheckout",
            "productName",
            "firstName",
            "lastName",
            "addressLine",
            "city",
            "postalCode",
            "checkoutEmail",
            "checkoutConfirmationMessage"
    })
    public void guestCheckoutUsingDirectBankTransfer(
            String homePage,
            String searchTermCheckout,
            String productName,
            String firstName,
            String lastName,
            String addressLine,
            String city,
            String postalCode,
            String checkoutEmail,
            String checkoutConfirmationMessage
    ) {
        driver.get(homePage);

        HomePage homePageClass = new HomePage(driver);
        StorePage storePage = homePageClass.navigateToStoreUsingMenu();
        wait(3000);
        storePage.search(searchTermCheckout);
        Assert.assertEquals(storePage.getTitle(), "Search results: “"+searchTermCheckout+"”");

        storePage.clickAddToCartBtn(productName);
        CartPage cartPage = storePage.clickViewCart();
        wait(3000);
        Assert.assertEquals(cartPage.getProductName(), productName);

        CheckoutPage checkoutPage = cartPage.checkOut();
        checkoutPage.enterFirstName(firstName).
                enterLastName(lastName).
                enterAddressLineOne(addressLine).
                enterCity(city).
                enterPostCode(postalCode).
                enterEmail(checkoutEmail).
                placeGuestOrder();

        wait(5000);
        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-notice")).getText(), checkoutConfirmationMessage);

    }

    @Test
    @Parameters({
            "homePage",
            "searchTermCheckout",
            "productName",
            "firstName",
            "lastName",
            "addressLine",
            "city",
            "postalCode",
            "checkoutEmail",
            "checkoutConfirmationMessage",
            "demoUserName",
            "demoPassword",
            "state",
            "country"
    })
    public void loginAndCheckoutUsingDirectBankTransfer(
            String homePage,
            String searchTermCheckout,
            String productName,
            String firstName,
            String lastName,
            String addressLine,
            String city,
            String postalCode,
            String checkoutEmail,
            String checkoutConfirmationMessage,
            String demoUserName,
            String demoPassword,
            String state,
            String country
    ) throws InterruptedException {
        driver.get(homePage);

        HomePage homePageClass = new HomePage(driver);
        StorePage storePage = homePageClass.navigateToStoreUsingMenu();
        wait(2000);
        storePage.search(searchTermCheckout);
        wait(2000);
        Assert.assertEquals(storePage.getTitle(), "Search results: “"+searchTermCheckout+"”");

        storePage.clickAddToCartBtn(productName);
        CartPage cartPage = storePage.clickViewCart();
        wait(2000);
        Assert.assertEquals(cartPage.getProductName(), productName);

        CheckoutPage checkoutPage = cartPage.checkOut();
        checkoutPage.clickHereToLoginLink();
        wait(2000);

        checkoutPage.login(demoUserName, demoPassword).
            enterFirstName(firstName).
            enterLastName(lastName).
            selectCountryRegion(state).
            enterAddressLineOne(addressLine).
            selectState(country).
            enterCity(city).
            enterPostCode(postalCode).
            enterEmail(checkoutEmail);

        Thread.sleep(2000);
        checkoutPage.placeOrder();

        wait(5000);
        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-notice")).getText(), checkoutConfirmationMessage);
    }
}
