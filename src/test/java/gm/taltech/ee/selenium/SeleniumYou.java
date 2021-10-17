package gm.taltech.ee.selenium;

import gm.taltech.ee.selenium.common.SeleniumTest;
import org.testng.annotations.Test;
import taltech.ee.pages.FormAuthenticationPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SeleniumYou extends SeleniumTest {

    @Test
    public void should_not_login_with_invalid_login() {
        FormAuthenticationPage formAuthenticationPage = homePage.goToAuthenticationPage();
        assertThat(formAuthenticationPage.isAt(), is(true));

        formAuthenticationPage.submitForm("useruser", "SuperSecretPassword!");

        assertThat(formAuthenticationPage.isUsernameInvalidMessageDisplayed(), is(true));
    }

    @Test
    public void should_not_login_with_invalid_password() {
        FormAuthenticationPage formAuthenticationPage = homePage.goToAuthenticationPage();
        assertThat(formAuthenticationPage.isAt(), is(true));

        formAuthenticationPage.submitForm("tomsmith", "tomsmith");

        assertThat(formAuthenticationPage.isPasswordInvalidMessageDisplayed(), is(true));
    }

    @Test
    public void should_login_then_logout() {
        FormAuthenticationPage formAuthenticationPage = homePage.goToAuthenticationPage();
        assertThat(formAuthenticationPage.isAt(), is(true));

        formAuthenticationPage.submitForm("tomsmith", "SuperSecretPassword!");
        formAuthenticationPage.clickLogout();
        assertThat(formAuthenticationPage.isSuccessfullyLoggedOutMessageDisplayed(), is(true));
    }

    @Test
    public void should_change_location_of_blocks_after_drag_and_drop_to_BA() {
    }

    @Test
    public void should_not_change_location_of_blocks_after_drag_and_drop_to_not_B() {
    }

    @Test
    public void should_see_text_new_window_after_clicking_the_link_click_here() {
    }
}
