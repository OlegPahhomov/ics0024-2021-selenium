package gm.taltech.ee.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
    private final By mainTitle = By.tagName("h1");
    private final By formAuthenticationLink = By.linkText("Form Authentication");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open(){
        driver.get("https://the-internet.herokuapp.com/");
        return this;
    }

    public boolean isAt() {
        return driver.findElement(mainTitle).getText().equals("Welcome to the-internet");
    }

    public void goToAuthenticationPage() {
        driver.findElement(formAuthenticationLink).click();
    }

//    public FormAuthenticationPage goToAuthenticationPage() {
//        driver.findElement(formAuthenticationLink).click();
//        return new FormAuthenticationPage(driver);
//    }

//    private final By dragAndDropLink = By.linkText("Drag and Drop");
//    private final By multipleWindowsLink = By.linkText("Multiple Windows");
//    public DragAndDropPage clickDragAndDropLink() {
//        driver.findElement(dragAndDropLink).click();
//        return new DragAndDropPage(driver);
//    }
//
//    public MultipleWindows clickMultipleWindowsLink() {
//        driver.findElement(multipleWindowsLink).click();
//        return new MultipleWindows(driver);
//    }
}
