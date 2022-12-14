package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {
    private By signupBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]");
    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("confirmPassword");
    private By signMeUpBtn = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button");
    private By verifySignupMessage = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]");

    public SignupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getSignupBtn() {
        return getDriver().findElement(signupBtn);
    }

    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }

    public WebElement getConfirmPasswordField() {
        return getDriver().findElement(confirmPasswordField);
    }

    public WebElement getSignMeUpBtn() {
        return getDriver().findElement(signMeUpBtn);
    }

    public WebElement getVerifySignupMessage() {
        return getDriver().findElement(verifySignupMessage);
    }

    public void signupPage() {
        getSignupBtn().click();
    }

    public void signup(String name, String email, String password, String confirmPassword) {
        getNameField().sendKeys(name);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(confirmPassword);
        getSignMeUpBtn().click();
    }
}
