package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage extends BaseClasPage {
    protected By signupBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]");
    protected By nameField = By.id("name");
    protected By emailField = By.id("email");
    protected By passwordField = By.id("password");
    protected By confirmPasswordField = By.id("confirmPassword");
    protected By signMeUpBtn = By.className("v-btn__content");
    protected By verifySignupMessage = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]");
    public SignupPage (WebDriver driver) {super(driver);}

    public WebElement getSignupBtn() {
        return getDriver().findElement(signupBtn);
    }
    public WebElement getNameField () { return getEmailField().findElement(nameField); }
    public WebElement getEmailField () {return getDriver().findElement(emailField);}
    public WebElement getPasswordField () {return getDriver().findElement(passwordField);}
    public WebElement getConfirmPasswordField () {return getDriver().findElement(confirmPasswordField);}
    public WebElement getSignMeUpBtn () {return getSignMeUpBtn().findElement(signMeUpBtn);}
    public WebElement getVerifySignupMessage () {return getVerifySignupMessage().findElement(verifySignupMessage);}
    public void signupPage (){
        getSignupBtn().click();
    }

    public void signup (String name, String email, String password, String confirmPassword) {
        getSignMeUpBtn().click();
    }




}
