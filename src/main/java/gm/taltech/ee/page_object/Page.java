package gm.taltech.ee.page_object;

import org.openqa.selenium.WebDriver;

public abstract class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }
}
