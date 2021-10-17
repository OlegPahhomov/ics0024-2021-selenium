package taltech.ee.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final By mainTitle = By.tagName("h1");
    private final By formAuthenticationLink = By.linkText("Form Authentication");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAuthenticationPage() {
        driver.findElement(formAuthenticationLink).click();
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    public boolean isAt(){
        return driver.findElement(mainTitle).getText().equals("Welcome to the-internet");
    }
}
