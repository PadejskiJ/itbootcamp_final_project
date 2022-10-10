package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ErrorMessagePage;
import pages.LoginPage;
import pages.SignupPage;

public class SignupTests extends BaseTest{

    //assert: Verifikovati da se u url-u stranice javlja /signup ruta
    @Test
    public void test1VisitsTheSignupPage (){

        signupPage.signupPage();
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
        signupPage.signupPage();

        signupPage.getEmailField().getAttribute("type");
        Assert.assertEquals(signupPage.getEmailField().getAttribute("type"), "email");

        signupPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(signupPage.getPasswordField().getAttribute("type"), "password");

        signupPage.getConfirmPasswordField().getAttribute("type");
        Assert.assertEquals(signupPage.getConfirmPasswordField().getAttribute("type"), "password");
    }
    //    • name: Test Test
    //    • email: admin@admin.com
    //    • password: 123654
    //    • confirm password: 123654
    //assert:
    //    • Verifikovati da greska sadrzi poruku E-mail already exists
    //    • Verifikovati da se u url-u stranice javlja /signup ruta
    @Test
    public void test3DisplaysErrorsWhenUserAlreadyExists (){

        signupPage.signupPage();
        signupPage.signup("Test Test","admin@admin.com", "123654", "123654");
        String expectedResult2 = "E-mail already exists";
        String actualResult2 = errorMessagePage.getErrorSignUp().getText();
        Assert.assertEquals(actualResult2,expectedResult2);
        String expectedResult3 = "https://vue-demo.daniel-avellaneda.com/signup";
        Assert.assertEquals(driver.getCurrentUrl(), expectedResult3);
    }
    //    • name: Ime i prezime polaznika
    //    • email template: ime.prezime@itbootcamp.rs
    //    • password: 123456
    //    • confirm password: 123456
    //assert: Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT: Verify your account
    @Test
    public void test4Signup (){
        signupPage.signupPage();
        signupPage.signup("Jelena Padejski", "jelena.padejski@itbootcamp.rs", "123456", "123456");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(signupPage.getVerifySignupMessage().getText(), "IMPORTANT: Verify your account");
    }
}
