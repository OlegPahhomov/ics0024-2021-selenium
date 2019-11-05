package gm.taltech.ee.selenium;

import gm.taltech.ee.page_object.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
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
    public void should_login_to_secure_area_with_invalid_credentials() {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);

        homePage.clickFormAuthenticationLink();
        formAuthenticationPage.enterUsername("nublugameboytetris");
        formAuthenticationPage.enterPassword("oksana");
        formAuthenticationPage.clickSubmit();

        assertThat(formAuthenticationPage.isErrorNotificationDisplayed(), is(true));
    }

    @Test
    public void should_see_hello_world_after_loading() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);

        homePage.clickDynamicLoadingLink();
        dynamicLoadingPage.clickExampleOne();
        dynamicLoadingPage.clickStart();

        assertThat(dynamicLoadingPage.isHelloWorldVisible(), is(true));
    }

    @Test
    public void should_select_option_one() {
        DropdownPage dropdownPage = new DropdownPage(driver);

        homePage.clickDropdownLink();
        dropdownPage.selectOptionOne();

        assertThat(dropdownPage.isOptionOneSelected(), is(true));
    }

    @Test
    public void should_see_view_profile_link_on_hover() {
        HoversPage hoversPage = new HoversPage(driver);

        homePage.clickHoverLink();
        hoversPage.hoverOverFirstProfile();

        assertThat(hoversPage.isViewProfileLinkVisible(), is(true));
    }

    @Test
    public void should_change_location_of_blocks_after_drag_and_drop_to_BA() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);

        homePage.clickDragAndDropLink();
        dragAndDropPage.dragAonTopOfB();

        assertThat(dragAndDropPage.isTheFirstElementsHeaderText("B"), is(true));
    }

    @AfterClass
    public void close_driver() {
        if (driver != null) {
            driver.close();
        }
    }
}
