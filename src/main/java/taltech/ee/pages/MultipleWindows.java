package taltech.ee.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

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
            List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(browserTabs.get(1));
            boolean newWindow = driver.findElement(newWindowHeading).getText().equals("New Window");
            driver.close();
            driver.switchTo().window(browserTabs.get(0));
            return newWindow;
        } catch (ElementNotVisibleException e) {
            return false;
        }
    }

}
