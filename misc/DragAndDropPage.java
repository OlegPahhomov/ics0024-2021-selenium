package gm.taltech.ee.misc;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.URL;

import static java.lang.Thread.currentThread;
import static java.nio.charset.Charset.defaultCharset;
import static java.util.Objects.requireNonNull;

public class DragAndDropPage extends Page {

    private final By blockA = By.id("column-a");
    private final By blockB = By.id("column-b");
    private final By heading = By.className("example");

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void dragAonTopOfHeading() {
        WebElement blockAElement = driver.findElement(blockA);
        WebElement headingElement = driver.findElement(heading);

        dragAndDrop(blockAElement, headingElement);
    }

    public void dragAonTopOfB() {
        WebElement blockAElement = driver.findElement(blockA);
        WebElement blockBElement = driver.findElement(blockB);

        dragAndDrop(blockAElement, blockBElement);
    }

    private void dragAndDrop(WebElement source, WebElement target) {
        URL url = currentThread().getContextClassLoader().getResource("DragAndDrop.js");
        try {
            String script = IOUtils.toString(requireNonNull(url), defaultCharset());
            script += "simulateHTML5DragAndDrop(arguments[0], arguments[1])";
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript(script, source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isTheFirstElementsHeaderText(String headerText) {
        System.out.println(driver.findElement(blockA).findElement(By.tagName("header")).getText());
        return driver.findElement(blockA).findElement(By.tagName("header")).getText().equals(headerText);
    }
}
