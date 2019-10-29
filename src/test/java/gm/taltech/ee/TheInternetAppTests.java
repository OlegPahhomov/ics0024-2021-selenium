package gm.taltech.ee;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class TheInternetAppTests {

    private WebDriver driver;

    @BeforeClass
    public void set_up_driver(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void open_driver(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void can_go_to_home_page(){
        String title = driver.findElement(By.tagName("h1")).getText();

        assertThat(title, is("Welcome to the-internet"));
    }

    @Test
    public void should_login_to_secure_area_with_valid_credentials(){
        // open Form Authentication
        driver.findElement(By.linkText("Form Authentication")).click();
        // enter valid username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        // enter valid password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        // click Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // should see success notification
        WebElement webElement = driver.findElement(cssSelector(".flash.success"));
        assertThat(webElement, notNullValue());
    }

    @Test
    public void should_see_hello_world_after_loading() throws InterruptedException {
        // got to Dynamic Loading page
        driver.findElement(By.linkText("Dynamic Loading")).click();
        // Click Example 1 link
        driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
        // Click button Start
        driver.findElement(By.cssSelector("#start > button")).click();
        // should see Hello World

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10000);
        WebElement helloWorldElement = webDriverWait.until(visibilityOfElementLocated(cssSelector("#finish > h4")));

        String helloWorld = helloWorldElement.getText();
        assertThat(helloWorld, is("Hello World!"));
    }

    @AfterClass
    public void close_driver(){
        if(driver != null){
            driver.close();
        }
    }
}
