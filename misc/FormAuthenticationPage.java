package gm.taltech.ee.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

public class FormAuthenticationPage extends Page {

    private final By mainTitle = By.tagName("h2");
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By submitButton = By.xpath("//button[@type='submit']");
    private final By logoutButton = By.linkText("Logout");
    private final By successNotification = By.cssSelector(".flash.success");
    private final By errorNotification = By.cssSelector(".flash.error");

    public FormAuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public void submitForm(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSubmit();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }

    public boolean isSuccessNotificationDisplayed() {
        try {
            driver.findElement(successNotification);
            return true;
        } catch (ElementNotVisibleException e) {
            // log exception
            return false;
        }
    }

    public boolean isUsernameInvalidMessageDisplayed() {
        try {
            return driver.findElement(errorNotification).getText().contains("Your username is invalid!");
        } catch (ElementNotVisibleException e) {
            // log exception
            return false;
        }
    }

    public boolean isPasswordInvalidMessageDisplayed() {
        try {
            return driver.findElement(errorNotification).getText().contains("Your password is invalid!");
        } catch (ElementNotVisibleException e) {
            // log exception
            return false;
        }
    }

    public boolean isSuccessfullyLoggedOutMessageDisplayed() {
        try {
            return driver.findElement(successNotification).getText().contains("You logged out of the secure area!");
        } catch (ElementNotVisibleException e) {
            // log exception
            return false;
        }
    }

    public boolean isAt() {
        return driver.findElement(mainTitle).getText().equals("Login Page");
    }
}
