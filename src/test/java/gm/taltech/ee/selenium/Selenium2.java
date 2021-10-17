//package gm.taltech.ee.selenium;
//
//import gm.taltech.ee.secretpages.FormAuthenticationPage;
//import gm.taltech.ee.secretpages.HomePage;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//public class Selenium2 {
//
//    private WebDriver driver;
//    private HomePage homePage;
//
//    @BeforeClass
//    public void set_up_driver() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        homePage = new HomePage(driver);
//    }
//
//    @BeforeMethod
//    public void open_driver() {
//        homePage.open();
//    }
//
//    @Test
//    public void can_go_to_home_page() {
//        assertThat(homePage.isAt(), is(true));
//    }
//
//    @Test
//    public void should_login_to_secure_area_with_valid_credentials() {
//        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);
//
//        homePage.goToAuthenticationPage();
//        assertThat(formAuthenticationPage.isAt(), is(true));
//        formAuthenticationPage.enterUsername("tomsmith");
//        formAuthenticationPage.enterPassword("SuperSecretPassword!");
//        formAuthenticationPage.clickSubmit();
//
//        assertThat(formAuthenticationPage.isSuccessNotificationDisplayed(), is(true));
//    }
//
//    @AfterClass
//    public void close_driver() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
