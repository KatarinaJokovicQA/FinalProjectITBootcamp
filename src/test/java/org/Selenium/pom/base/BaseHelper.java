package org.Selenium.pom.base;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class BaseHelper {
    public void validateStringArray(String[] values, String[] expectedValues) {
        // ovde smo ostavili assert u metodi, ali, generalno savet je da bude u testu zbog citiljosti
        // ako su nizovi razlicite duzine nema smisla da vrsimo komparaciju
        if (values.length != expectedValues.length) {
            Assert.fail("The arrays should be of same size when comparing");
        }

        for (int i = 0; i < values.length; i++) {
            Assert.assertEquals(values[i], expectedValues[i]);
        }
    }

    public boolean checkImagesVisibility(List<WebElement> imageElements) {
        // bolje je da nam assert bude u testu, zbog citiljvosti samog testa
        return imageElements.stream().allMatch(WebElement::isDisplayed);
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
