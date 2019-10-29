package gm.taltech.ee.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By mainTitle = By.tagName("h1");
    private By formAuthenticationLink = By.linkText("Form Authentication");
    private By dynamicLoadingLink = By.linkText("Dynamic Loading");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAt() {
        return driver.findElement(mainTitle).getText().equals("Welcome to the-internet");
    }

    public void clickFormAuthenticationLink() {
        driver.findElement(formAuthenticationLink).click();
    }

    public void clickDynamicLoadingLink() {
        driver.findElement(dynamicLoadingLink).click();
    }
}
