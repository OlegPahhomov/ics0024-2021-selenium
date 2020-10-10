package gm.taltech.ee.selenium;

import gm.taltech.ee.page_object.FormAuthenticationPage;
import gm.taltech.ee.page_object.HomePage;
import gm.taltech.ee.selenium.common.SeleniumTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Selenium3 extends SeleniumTest {

    @Test
    public void can_go_to_home_page() {
        assertThat(homePage.isAt(), is(true));
    }

    @Test
    public void should_login_to_secure_area_with_valid_credentials() {
        FormAuthenticationPage formAuthenticationPage = homePage.goToAuthenticationPage();
        assertThat(formAuthenticationPage.isAt(), is(true));
        formAuthenticationPage.submitForm("tomsmith", "SuperSecretPassword!");
        assertThat(formAuthenticationPage.isSuccessNotificationDisplayed(), is(true));
    }
}

