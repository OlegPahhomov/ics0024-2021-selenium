package gm.taltech.ee;

import gm.taltech.ee.page_object.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TheInternetAppTests {

    private WebDriver driver;

    @BeforeClass
    public void set_up_driver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void open_driver() {

        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void can_go_to_home_page() {
        HomePage homePage = new HomePage(driver);

        assertThat(homePage.isAt(), is(true));
    }

    @Test
    public void should_login_to_secure_area_with_valid_credentials() {
        HomePage homePage = new HomePage(driver);
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);

        homePage.clickFormAuthenticationLink();
        formAuthenticationPage.enterUsername("tomsmith");
        formAuthenticationPage.enterPassword("SuperSecretPassword!");
        formAuthenticationPage.clickSubmit();

        assertThat(formAuthenticationPage.isSuccessNotificationDisplayed(), is(true));
    }

    @Test
    public void should_login_to_secure_area_with_invalid_credentials() {
        HomePage homePage = new HomePage(driver);
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);

        homePage.clickFormAuthenticationLink();
        formAuthenticationPage.enterUsername("nublugameboytetris");
        formAuthenticationPage.enterPassword("oksana");
        formAuthenticationPage.clickSubmit();

        assertThat(formAuthenticationPage.isErrorNotificationDisplayed(), is(true));
    }

    @Test
    public void should_see_hello_world_after_loading() {
        HomePage homePage = new HomePage(driver);
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);

        homePage.clickDynamicLoadingLink();
        dynamicLoadingPage.clickExampleOne();
        dynamicLoadingPage.clickStart();

        assertThat(dynamicLoadingPage.isHelloWorldVisible(), is(true));
    }

    @Test
    public void should_select_option_one() {
        HomePage homePage = new HomePage(driver);
        DropdownPage dropdownPage = new DropdownPage(driver);

        homePage.clickDropdownLink();
        dropdownPage.selectOptionOne();

        assertThat(dropdownPage.isOptionOneSelected(), is(true));
    }

    @Test
    public void should_see_view_profile_link_on_hover() {
        HomePage homePage = new HomePage(driver);
        HoversPage hoversPage = new HoversPage(driver);

        homePage.clickHoverLink();
        hoversPage.hoverOverFirstProfile();

        assertThat(hoversPage.isViewProfileLinkVisible(), is(true));
    }

    @AfterClass
    public void close_driver() {
        if (driver != null) {
            driver.close();
        }
    }
}
