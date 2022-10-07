package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ErrorMessagePage;
import pages.LoginPage;
import pages.SignupPage;

public class SignupTests extends BaseTest{

    //assert: Verifikovati da se u url-u stranice javlja /signup ruta
    @Test
    public void test1VisitsTheSignupPage (){
        SignupPage signupBtn = new SignupPage(driver);
        signupBtn.signupPage();
        String expectedResult1 = "https://vue-demo.daniel-avellaneda.com/signup";
        String actualResult1 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult1,expectedResult1);
    }

    //assert:
    //    • Verifikovati da polje za unos emaila za atribut type ima vrednost email
    //    • Verifikovati da polje za unos lozinke za atribut type ima vrednost password
    //    • Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password
    @Test
    public void test2ChecksInputTypes (){
        SignupPage signupBtn = new SignupPage(driver);
        signupBtn.signupPage();
        SignupPage emailField = new SignupPage(driver);
        SignupPage passwordField = new SignupPage(driver);
        SignupPage confirmPasswordField = new SignupPage(driver);

        emailField.getEmailField().getAttribute("type");
        Assert.assertEquals(emailField.getEmailField().getAttribute("type"), "email");

        passwordField.getPasswordField().getAttribute("type");
        Assert.assertEquals(passwordField.getPasswordField().getAttribute("type"), "password");

        confirmPasswordField.getConfirmPasswordField().getAttribute("type");
        Assert.assertEquals(confirmPasswordField.getConfirmPasswordField().getAttribute("type"), "password");
    }

    //Test #3:
    //Podaci:
    //    • name: Test Test
    //    • email: admin@admin.com
    //    • password: 123654
    //    • confirm password: 123654
    //assert:
    //    • Verifikovati da greska sadrzi poruku E-mail already exists
    //    • Verifikovati da se u url-u stranice javlja /signup ruta
    @Test
    public void test3DisplaysErrorsWhenUserAlreadyExists (){
        SignupPage signupBtn = new SignupPage(driver);
        signupBtn.signupPage();
        SignupPage signUp = new SignupPage(driver);
        signUp.signup("Test Test","admin@admin.com", "123654", "123654");
        String expectedResult2 = "E-mail already exists";
        ErrorMessagePage errorSignUp = new ErrorMessagePage(driver);
        String actualResult2 = errorSignUp.getErrorSignUp().getText();
        Assert.assertEquals(actualResult2,expectedResult2);
        String expectedResult3 = "https://vue-demo.daniel-avellaneda.com/signup";
        Assert.assertEquals(driver.getCurrentUrl(), expectedResult3);
    }

    //Test #4: Signup
    //Podaci:
    //    • name: Ime i prezime polaznika
    //    • email template: ime.prezime@itbootcamp.rs
    //    • password: 123456
    //    • confirm password: 123456
    //assert:
    //    • Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT: Verify your account
    @Test
    public void test4Signup (){
        SignupPage signupBtn = new SignupPage(driver);
        signupBtn.signupPage();
        SignupPage signUp = new SignupPage(driver);
        signUp.signup("Jelena Padejski", "jelena.padejski@itbootcamp.rs", "123456", "123456");
        SignupPage verifyMessage = new SignupPage(driver);
        verifyMessage.getVerifySignupMessage().getText();
        Assert.assertEquals(verifyMessage.getVerifySignupMessage().getText(), "IMPORTANT: Verify your account");
    }

}
