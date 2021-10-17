//package gm.taltech.ee.selenium;
//
//import gm.taltech.ee.secretpages.FormAuthenticationPage;
//import gm.taltech.ee.selenium.common.SeleniumTest;
//import org.testng.annotations.Test;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//public class Selenium3 extends SeleniumTest {
//
//    @Test
//    public void can_go_to_home_page() {
//        assertThat(homePage.isAt(), is(true));
//    }
//
//    @Test
//    public void should_login_to_secure_area_with_valid_credentials() {
//        FormAuthenticationPage formAuthenticationPage = homePage.goToAuthenticationPage();
//        assertThat(formAuthenticationPage.isAt(), is(true));
//        formAuthenticationPage.submitForm("tomsmith", "SuperSecretPassword!");
//        assertThat(formAuthenticationPage.isSuccessNotificationDisplayed(), is(true));
//    }
//}
//
