package gm.taltech.ee.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By mainTitle = By.tagName("h1");
    private By formAuthenticationLink = By.linkText("Form Authentication");
    private By dynamicLoadingLink = By.linkText("Dynamic Loading");
    private By dropdownLink = By.linkText("Dropdown");
    private By hoversLink = By.linkText("Hovers");
    private By dragAndDropLink = By.linkText("Drag and Drop");

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

    public void clickDropdownLink() {
        driver.findElement(dropdownLink).click();
    }

    public void clickHoverLink() {
        driver.findElement(hoversLink).click();
    }

    public void clickDragAndDropLink() {
        driver.findElement(dragAndDropLink).click();
    }
}
