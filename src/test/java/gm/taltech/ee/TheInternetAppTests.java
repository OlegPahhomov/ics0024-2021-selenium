package gm.taltech.ee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TheInternetAppTests {

    private WebDriver driver = new ChromeDriver();

    @Test
    public void can_go_to_home_page(){
        // go to home page
        driver.get("https://the-internet.herokuapp.com/");

        // should see title 'Welcome to the-internet'
        String title = driver.findElement(By.tagName("h1")).getText();

        assertThat(title, is("Welcome to the-internet"));
    }

    @AfterClass
    public void closeDriver(){
        if(driver != null){
            driver.close();
        }
    }
}
