package dev.selenium;

import dev.selenium.Utils.PropertiesFileUtils;
import dev.selenium.Utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class Login {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws IOException {
        WebDriverUtils wd = new WebDriverUtils(driver);
        wd.DriverSelection("chrome");
        driver = wd.driver;
        driver.manage().window().maximize();
        driver.get("https://techedge.techcanvass.co/Login.aspx");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test(priority = 0)
    public void Test1() throws InterruptedException, IOException {
        Actions ac = new Actions(driver);
        PropertiesFileUtils tp = new PropertiesFileUtils();
        tp.readProperties();
        driver.findElement(By.name("txtLoginid"))
                .sendKeys(tp.getUsername());
        System.out.println(driver.getTitle());
        driver.findElement(By.name("txtpassword"))
                .sendKeys(tp.getPassword());
        driver.findElement(By.name("btnLogin")).click();
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
