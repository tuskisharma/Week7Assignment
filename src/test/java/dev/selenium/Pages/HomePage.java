package dev.selenium.Pages;

import dev.selenium.Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    By sidebarBy=By.xpath("(//div[@class='sidebar-social'])[2]/li/a/span");

    By logoutbtnBy=By.xpath("//a[@title='Logout']");

    public void logout(){
       WebElement sidebar= driver.findElement(sidebarBy);
       WaitUtils wait=new WaitUtils(driver);
       wait.explicitWait(20,"(//div[@class='sidebar-social'])[2]/li/a/span");
       sidebar.click();
       driver.findElement(logoutbtnBy).click();

    }
}
