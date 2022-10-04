package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ErrorMessagePage;
import pages.HomePage;
import pages.LoginPage;


public class LoginTest extends BaseTest{

    //assert: • Verifikovati da se u url-u stranice javlja ruta /login
    @Test
    public void test1VisitsTheLoginPage () {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        HomePage loginBtn = new HomePage(driver);
        loginBtn.goToLogin();
        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }
    //    • Verifikovati da polje za unos emaila za atribut type ima vrednost email
    //    • Verifikovati da polje za unos lozinke za atribut type ima vrednost password
    @Test
    public void test2ChecksInputTypes () {
        LoginPage emailField = new LoginPage(driver);
        LoginPage passwordField = new LoginPage(driver);
        emailField.getEmailField().getAttribute("type");
        Assert.assertEquals(emailField.getEmailField().getAttribute("type"),"email");
        Assert.assertEquals(passwordField.getPasswordField().getAttribute("type"), "password");

        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }
    //Test #3: Displays errors when user does not exist
    //Podaci:random email i password koristeći faker libarary
    //asssert:
    //    • Verifikovati da greska sadrzi poruku User does not exists
    //    • Verifikovati da se u url-u stranice javlja /login ruta
    @Test
    public void test3UserDoesntExist (){
        String emailFake = faker.internet().emailAddress();
        String passwordFake = faker.internet().password();
        LoginPage login = new LoginPage(driver);
        login.login(emailFake,passwordFake);

        ErrorMessagePage error = new ErrorMessagePage(driver);
        String expectedResult1 = "User does not exists";
        String actualResult1 = error.getErrorMessage().getText();
        Assert.assertEquals(actualResult1, expectedResult1);

        String expectedResult2 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult2 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult2, expectedResult2);
    }
        //Test #4: Displays errors when password is wrong
        //Podaci: email i random password koristeći faker libarary
        //asssert:
        //    • Verifikovati da greska sadrzi poruku Wrong password
        //    • Verifikovati da se u url-u stranice javlja /login ruta
    @Test
    public void test4PasswordIsWrong (){
        String email = "admin@admin.com";
        String passwordFake = faker.internet().password();
        LoginPage login = new LoginPage(driver);
        login.login(email,passwordFake);

        ErrorMessagePage error = new ErrorMessagePage(driver);
        String expectedResult3 = "User does not exists";
        String actualResult3 = error.getErrorWrongPassword().getText();
        Assert.assertEquals(actualResult3,expectedResult3);

        String expectedResult4 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult4 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult4, expectedResult4);
    }

    //Test #5: Login
    //Podaci:
    //    • email: admin@admin.com
    //    • password: 12345
    //asssert:
    //    • Verifikovati da se u url-u stranice javlja /home ruta
    @Test
    public void test5Login (){
        LoginPage login = new LoginPage(driver);
        login.login("admin@admin.com", "12345");

        String expectedResult5 = "https://vue-demo.daniel-avellaneda.com/home";
        String actualResult5 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult5, expectedResult5);
    }
    //Test #6: Logout
    //assert:
    //    • Verifikovati da je dugme logout vidljivo na stranici
    //    • Verifikovati da se u url-u stranice javlja /login ruta
    //    • Verifikovati da se nakon pokušaja otvaranja /home rute, u url-u stranice javlja /login ruta
    @Test
    public void test6Logout (){
        String expectedResult6 = "LOGOUT";
        LoginPage logoutBtn = new LoginPage(driver);
        String actualResult6 = logoutBtn.getLogoutBtn().getText();
        Assert.assertEquals(actualResult6, expectedResult6);

        String expectedResult7 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult7 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult7, expectedResult7);

        HomePage homeBtn = new HomePage(driver);
        homeBtn.goToHome();
        String expectedResult8 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult8 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult8, expectedResult8);
    }
}