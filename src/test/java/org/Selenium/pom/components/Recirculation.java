package org.Selenium.pom.components;

import org.Selenium.pom.base.WithChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Recirculation extends WithChromeDriver {
    private final By wrapperElement = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[1]/div[2]");

    public Recirculation(WebDriver driver) {
        super(driver);
    }

    private String[] getArrayOfElementsTexts(String elementSelector) {
        List elements = driver.findElement(wrapperElement).findElements(By.tagName(elementSelector));

        String[] texts = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = (WebElement) elements.get(i);
            texts[i] = element.getText();
        }
        return texts;
    }

    public String[] getArrayOfLinkHrefs() {
        List elements = driver.findElement(wrapperElement).findElements(By.tagName("a"));

        String[] hrefs = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = (WebElement) elements.get(i);
            hrefs[i] = element.getAttribute("href");
        }
        return hrefs;
    }

    public String[] getTitles() {
        return getArrayOfElementsTexts("h3");
    }

    public String[] getDescriptions() {
        return getArrayOfElementsTexts("p");
    }

    public String[] getButtonsTexts() {
        return getArrayOfElementsTexts("a");
    }

    public List <WebElement> getImages() {
        return driver.findElement(wrapperElement).findElements(By.tagName("img"));
    }
}
