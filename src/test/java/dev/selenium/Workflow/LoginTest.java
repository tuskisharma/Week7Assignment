package dev.selenium.Workflow;

import dev.selenium.Assertions.LoginAssertions;
import dev.selenium.Pages.HomePage;
import dev.selenium.Pages.LoginPage;
import dev.selenium.Utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginTest {
    WebDriver driver;
    @BeforeTest
    public void setUp() throws IOException {
        WebDriverUtils wd=new WebDriverUtils(driver);
        wd.DriverSelection("chrome");
        driver= wd.driver;
        driver.manage().window().maximize();
        driver.get("https://techedge.techcanvass.co/Login.aspx");
    }
    @Test(priority = 0)
    public void ValidLoginTest(){
        LoginPage login=new LoginPage(driver);
        login.login("tushar.sharma@moolya.com","msd206chn");
        LoginAssertions assertions=new LoginAssertions(driver);
        assertions.loginAssertion();
    }
    @Test(priority = 1)
    public void InvalidLoginTest() throws InterruptedException {
        LoginPage login2=new LoginPage(driver);
        HomePage hp=new HomePage(driver);
        hp.logout();
        Thread.sleep(2000);
        login2.login("tushar.sharma@moolya.com","duduh");
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
