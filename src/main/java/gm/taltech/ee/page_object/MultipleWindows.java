package gm.taltech.ee.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;


public class MultipleWindows {
    private final By buttonClickHere = By.linkText("Click Here");
    private final By newWindowHeading = By.tagName("h3");

    private WebDriver driver;

    public MultipleWindows(WebDriver driver) {
        this.driver = driver;
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
