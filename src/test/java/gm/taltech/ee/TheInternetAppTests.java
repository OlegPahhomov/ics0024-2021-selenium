package gm.taltech.ee;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class TheInternetAppTests {

    private WebDriver driver = new ChromeDriver();

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
        WebElement webElement = driver.findElement(By.cssSelector(".flash.success"));
        assertThat(webElement, notNullValue());
    }

    @AfterClass
    public void close_driver(){
        if(driver != null){
            driver.close();
        }
    }
}
