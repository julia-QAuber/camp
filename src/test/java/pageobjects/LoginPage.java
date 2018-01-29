package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {



    private WebDriver driver;

    private By username = By.xpath("//input[@name='email']");
    private By password = By.xpath("//input[@name='password']");
    private By loginButton = By.id("login");
    private By titleText = By.xpath("//p[@class='text-center pv login-title']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeUserName(String email) {
        driver.findElement(username).sendKeys(email);

    }

    public void typePassword(String password) {
        driver.findElement(this.password).sendKeys(password);

    }

    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();

    }


    public String getLoginTitle() {
        return driver.findElement(titleText).getText();
    }

}
