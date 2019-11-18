package gm.taltech.ee.selenium;

import gm.taltech.ee.page_object.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class TheInternetAppTests {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void set_up_driver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void open_driver() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void can_go_to_home_page2(){
        // go to home page
        driver.get("https://the-internet.herokuapp.com/");

        // should see title 'Welcome to the-internet'
        String title = driver.findElement(By.tagName("h1")).getText();

        assertThat(title, is("Welcome to the-internet"));
    }

    @Test
    public void should_login_to_secure_area_with_valid_credentials2(){
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

    @Test
    public void can_go_to_home_page() {
        assertThat(homePage.isAt(), is(true));
    }

    @Test
    public void should_login_to_secure_area_with_valid_credentials() {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);

        homePage.clickFormAuthenticationLink();
        formAuthenticationPage.enterUsername("tomsmith");
        formAuthenticationPage.enterPassword("SuperSecretPassword!");
        formAuthenticationPage.clickSubmit();

        assertThat(formAuthenticationPage.isSuccessNotificationDisplayed(), is(true));
    }

    @Test
    public void should_not_login_with_invalid_login() {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);

        homePage.clickFormAuthenticationLink();
        formAuthenticationPage.enterUsername("something");
        formAuthenticationPage.enterPassword("SuperSecretPassword!");
        formAuthenticationPage.clickSubmit();

        assertThat(formAuthenticationPage.isUsernameInvalidMessageDisplayed(), is(true));
    }

    @Test
    public void should_not_login_with_invalid_password() {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);

        homePage.clickFormAuthenticationLink();
        formAuthenticationPage.enterUsername("tomsmith");
        formAuthenticationPage.enterPassword("notcorrectpass");
        formAuthenticationPage.clickSubmit();

        assertThat(formAuthenticationPage.isPasswordInvalidMessageDisplayed(), is(true));
    }

    @Test
    public void should_logout() {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);

        homePage.clickFormAuthenticationLink();
        formAuthenticationPage.enterUsername("tomsmith");
        formAuthenticationPage.enterPassword("SuperSecretPassword!");
        formAuthenticationPage.clickSubmit();
        formAuthenticationPage.clickLogout();

        assertThat(formAuthenticationPage.isSuccessfullyLoggedOutMessageDisplayed(), is(true));
    }

    @Test
    public void should_change_location_of_blocks_after_drag_and_drop_to_BA() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);

        homePage.clickDragAndDropLink();
        dragAndDropPage.dragAonTopOfB();

        assertThat(dragAndDropPage.isTheFirstElementsHeaderText("B"), is(true));
    }

    @Test
    public void should_not_change_location_of_blocks_after_drag_and_drop_to_not_B() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);

        homePage.clickDragAndDropLink();
        dragAndDropPage.dragAonTopOfHeading();

        assertThat(dragAndDropPage.isTheFirstElementsHeaderText("A"), is(true));
    }

    @Test
    public void should_see_text_new_window_after_clicking_the_link_click_here() {
        MultipleWindows multipleWindows = new MultipleWindows(driver);

        homePage.clickMultipleWindowsLink();
        multipleWindows.clickClickHereButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().activeElement();

        assertThat(multipleWindows.isNewWindowTextAvailable(), is(true));

    }


    @AfterClass
    public void close_driver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
