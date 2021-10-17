package gm.taltech.ee.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;


public class MultipleWindows extends Page {
    private final By buttonClickHere = By.linkText("Click Here");
    private final By newWindowHeading = By.tagName("h3");

    public MultipleWindows(WebDriver driver) {
        super(driver);
    }

    public void clickClickHereButton() {
        driver.findElement(buttonClickHere).click();
    }

    public boolean isNewWindowTextAvailable() {
        try {
            driver.findElement(newWindowHeading);
            return true;
        } catch (ElementNotVisibleException e) {
            return false;
        }
    }

}
