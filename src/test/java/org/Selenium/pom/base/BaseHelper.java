package org.Selenium.pom.base;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class BaseHelper {
    public void validateStringArray(String[] values, String[] expectedValues) {

        for (int i = 0; i < values.length; i++) {
            Assert.assertEquals(values[i], expectedValues[i]);
        }
    }

    public void validateIsImageVisible(List<WebElement> imageElements) {
        for (int i = 0; i < imageElements.size(); i++) {
            Assert.assertEquals(imageElements.get(i).isDisplayed(),true);
        }
    }

    public void validateIfTextInElementExists(List<WebElement> elements) {
        for (int i = 0; i < elements.size(); i++) {
            Assert.assertEquals(elements.get(i).getText() != "",true );
        }
    }

    public void validateElementsTextsIsEqualToStringArray(List<WebElement> elements,String[] textValues) {
        for (int i = 0; i < elements.size(); i++) {
            Assert.assertEquals(elements.get(i).getText(),textValues[i]);
        }
    }

    public void validateIfTextInElementIsEqualTo(List<WebElement> elements, String expectedValue) {
        for (int i = 0; i < elements.size(); i++) {
            Assert.assertEquals(elements.get(i).getText(), expectedValue);
        }
    }
    public void validateIfLinksHrefsIsEqualTo(List<WebElement> elements, String expectedHref) {
        for (int i = 0; i < elements.size(); i++) {
            Assert.assertEquals(elements.get(i).getAttribute("href"), expectedHref);
        }
    }
    public void validateIfLinksHrefsIsEqualToHrefsArray(List<WebElement> elements, String[] expectedHrefs) {
        for (int i = 0; i < elements.size(); i++) {
            Assert.assertEquals(elements.get(i).getAttribute("href"), expectedHrefs[i]);
        }
    }
}
