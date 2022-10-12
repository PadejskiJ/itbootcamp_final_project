package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ErrorMessagePage;
import pages.LoginPage;
import pages.SignupPage;

public class SignupTests extends BaseTest {

    @Test
    public void verifyRouteSignup() {
        signupPage.signupPage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://vue-demo.daniel-avellaneda.com/signup");
    }

    @Test
    public void verifyInputTypesSignupPage() {
        signupPage.signupPage();

        signupPage.getEmailField().getAttribute("type");
        Assert.assertEquals(signupPage.getEmailField().getAttribute("type"), "email");

        signupPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(signupPage.getPasswordField().getAttribute("type"), "password");

        signupPage.getConfirmPasswordField().getAttribute("type");
        Assert.assertEquals(signupPage.getConfirmPasswordField().getAttribute("type"), "password");
    }

    @Test
    public void verifyDisplaysErrorsWhenUserAlreadyExists() {

        signupPage.signupPage();
        signupPage.signup("Test Test", "admin@admin.com", "123654", "123654");
        Assert.assertEquals(errorMessagePage.getErrorSignUp().getText(), "E-mail already exists");
        Assert.assertEquals(driver.getCurrentUrl(), "https://vue-demo.daniel-avellaneda.com/signup");
    }

    @Test
    public void verifySignupMessage() {
        signupPage.signupPage();
        signupPage.signup("Jelena Padejski", "jelena.padejski@itbootcamp.rs", "123456", "123456");

        Assert.assertEquals(signupPage.getVerifySignupMessage().getText(), "IMPORTANT: Verify your account");
    }
}
