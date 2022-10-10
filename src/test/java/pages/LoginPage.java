package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
protected By emailField = By.xpath("//*[@id=\"email\"]");
protected By passwordField = By.id("password");
protected By loginBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span");
protected By logoutBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");
public LoginPage (WebDriver driver, WebDriverWait driverWait) {super(driver,driverWait);}


public WebElement getEmailField() {return getDriver().findElement(emailField);}

public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }

public WebElement getLoginBtn() {return getDriver().findElement(loginBtn);}

public WebElement getLogoutBtn() { return getDriver().findElement(logoutBtn); }

public void login(String email, String password){
        getEmailField().clear();
        getPasswordField().clear();
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginBtn().click();
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

public void logout (){
        getLogoutBtn().click();
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

}
