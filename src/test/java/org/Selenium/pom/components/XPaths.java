package org.Selenium.pom.components;

public enum XPaths {

    WRAPPER_ELEMENT("//form[contains(@action, '/signup')]//input[contains(@type, 'text')]");

    private String xpath;

    private XPaths(String xpath) {
        this.xpath = xpath;
    }

    public String getXpath() {
        return this.xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }
}
