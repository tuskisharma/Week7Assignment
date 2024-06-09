package dev.selenium;

import dev.selenium.Utils.PropertiesFileUtils;
import dev.selenium.Utils.WaitUtils;
import dev.selenium.Utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class SeleniumPractice1 {
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
    public void Test1() throws InterruptedException, IOException {
        Actions ac=new Actions(driver);
        PropertiesFileUtils tp=new PropertiesFileUtils();
        tp.readProperties();
        WaitUtils wu=new WaitUtils(driver);
        wu.explicitWait(10,"txtLoginid");
        driver.findElement(By.name("txtLoginid"))
                .sendKeys(tp.getUsername());
        System.out.println(driver.getTitle());
        driver.findElement(By.name("txtpassword"))
                .sendKeys(tp.getPassword());
        driver.findElement(By.name("btnLogin")).click();
        WebElement wb=driver.findElement(By.xpath("//li[@class='dropdown main-drop']/a"));
        ac.moveToElement(wb).perform();
        System.out.println(wb.getText());

    }
    @Test(priority = 1)
    public void Test2() throws InterruptedException {
        //Thread.sleep(5000);
        WebElement invoice=driver
                .findElement(By.xpath("//div[@id='Divmenu']/ul/li[4]/ul/li[2]/a/span"));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(d-> invoice.isDisplayed());
        invoice.click();

    }
   @AfterTest
    public void teardown(){
        driver.quit();
    }
}


