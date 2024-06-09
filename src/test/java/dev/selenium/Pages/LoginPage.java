package dev.selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    By usernameBy= By.name("txtLoginid");

    By passwordBy =By.name("txtpassword");

    By loginBy=By.name("btnLogin");

    public void login(String username, String password){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginBy).click();
    }

}
