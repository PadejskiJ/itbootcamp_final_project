package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ErrorMessagePage;
import pages.HomePage;
import pages.LoginPage;


public class LoginTest extends BaseTest {

    //assert: • Verifikovati da se u url-u stranice javlja ruta /login
    @Test
    public void verifyRouteLogin() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        homePage.goToLogin();
        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void verifyInputTypesLoginPage() {
        loginPage.getEmailField().getAttribute("type");
        Assert.assertEquals(loginPage.getEmailField().getAttribute("type"), "email");
        Assert.assertEquals(loginPage.getPasswordField().getAttribute("type"), "password");

        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verifyUserDoesntExist() {
        String emailFake = faker.internet().emailAddress();
        String passwordFake = faker.internet().password();
        loginPage.login(emailFake, passwordFake);

        String expectedResult1 = "User does not exists";
        String actualResult1 = errorMessagePage.getErrorMessage().getText();
        Assert.assertEquals(actualResult1, expectedResult1);

        String expectedResult2 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult2 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult2, expectedResult2);
    }

    @Test
    public void verifyPasswordIsWrong() {
        String email = "admin@admin.com";
        String passwordFake = faker.internet().password();
        loginPage.login(email, passwordFake);

        String expectedResult3 = "User does not exists";
        String actualResult3 = errorMessagePage.getErrorWrongPassword().getText();
        Assert.assertEquals(actualResult3, expectedResult3);

        String expectedResult4 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult4 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult4, expectedResult4);
    }

    @Test
    public void verifyRouteHomeWhenAdmin() {
        homePage.getLoginPageBtn().click();
        loginPage.login("admin@admin.com", "12345");

        String expectedResult5 = "https://vue-demo.daniel-avellaneda.com/home";
        String actualResult5 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult5, expectedResult5);
    }

    @Test
    public void verifyLogout() {
        homePage.goToLogin();
        loginPage.login("admin@admin.com", "12345");

        String expectedResult6 = "LOGOUT";
        String actualResult6 = loginPage.getLogoutBtn().getText();
        Assert.assertEquals(actualResult6, expectedResult6);
        loginPage.logout();

        String expectedResult7 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult7 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult7, expectedResult7);

        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedResult8 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult8 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult8, expectedResult8);
    }
}
