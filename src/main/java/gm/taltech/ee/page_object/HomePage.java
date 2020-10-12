package gm.taltech.ee.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By mainTitle = By.tagName("h1");
    private By formAuthenticationLink = By.linkText("Form Authentication");
    private By dragAndDropLink = By.linkText("Drag and Drop");
    private By multipleWindowsLink = By.linkText("Multiple Windows");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage open(){
        driver.get("https://the-internet.herokuapp.com/");
        return this;
    }

    public boolean isAt() {
        return driver.findElement(mainTitle).getText().equals("Welcome to the-internet");
    }

    public FormAuthenticationPage goToAuthenticationPage() {
        driver.findElement(formAuthenticationLink).click();
        return new FormAuthenticationPage(driver);
    }

    public DragAndDropPage clickDragAndDropLink() {
        driver.findElement(dragAndDropLink).click();
        return new DragAndDropPage(driver);
    }

    public MultipleWindows clickMultipleWindowsLink() {
        driver.findElement(multipleWindowsLink).click();
        return new MultipleWindows(driver);
    }
}
