package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends  BaseClasPage{
protected By emailField = By.id("email");
protected By passwordField = By.id("password");
protected By loginBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span");
protected By logoutBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");
public LoginPage (WebDriver driver) {super(driver);}


public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }

public WebElement getLoginBtn() {
        return getDriver().findElement(loginBtn);
    }

public WebElement getLogoutBtn() {
        return getDriver().findElement(loginBtn);
    }

public void login(String email, String password){
        getEmailField().clear();
        getPasswordField().clear();
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginBtn().click();
        }

public void logout (){
        getLogoutBtn().click();

}



}
