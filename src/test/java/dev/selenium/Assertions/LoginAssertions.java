package dev.selenium.Assertions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import dev.selenium.Utils.WaitUtils;
import dev.selenium.Utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginAssertions {
    public LoginAssertions(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
    By HomepageTextBy=By.xpath("//h4[text()='Selenium Training (Advance)']");
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
    public String loginAssertion(){
        WaitUtils wait=new WaitUtils(driver);
        wait.explicitWait(50,"//h4[text()='Selenium Training (Advance)']");
        String expectedResult="Selenium Training (Advance)";
        String actualResult=driver.findElement(HomepageTextBy).getText();
        System.out.println(actualResult);
        Assert.assertEquals(actualResult,expectedResult);
        extent.attachReporter(spark);
        extent.createTest("MyFirstTest")
                .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
        extent.flush();
        return actualResult;
    }

}
