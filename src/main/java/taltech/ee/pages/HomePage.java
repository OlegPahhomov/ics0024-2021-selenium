package taltech.ee.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
    private final By mainTitle = By.tagName("h1");
    private final By formAuthenticationLink = By.linkText("Form Authentication");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public FormAuthenticationPage goToAuthenticationPage() {
        driver.findElement(formAuthenticationLink).click();
        return new FormAuthenticationPage(driver);
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    public boolean isAt(){
        return driver.findElement(mainTitle).getText().equals("Welcome to the-internet");
    }
}
