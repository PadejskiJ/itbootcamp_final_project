package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ErrorMessagePage;
import pages.HomePage;
import pages.LoginPage;


public class LoginTest extends BaseTest {

    @Test
    public void verifyRouteLogin() {
        homePage.goToLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://vue-demo.daniel-avellaneda.com/login");
    }

    @Test
    public void verifyInputTypesLoginPage() {
        loginPage.getEmailField().getAttribute("type");
        Assert.assertEquals(loginPage.getEmailField().getAttribute("type"), "email");
        Assert.assertEquals(loginPage.getPasswordField().getAttribute("type"), "password");
        Assert.assertEquals(driver.getCurrentUrl(), "https://vue-demo.daniel-avellaneda.com/login");
    }

    @Test
    public void verifyUserDoesntExist() {
        String emailFake = faker.internet().emailAddress();
        String passwordFake = faker.internet().password();
        loginPage.login(emailFake, passwordFake);

        Assert.assertEquals(errorMessagePage.getErrorMessage().getText(), "User does not exists");
        Assert.assertEquals(driver.getCurrentUrl(), "https://vue-demo.daniel-avellaneda.com/login");
    }

    @Test
    public void verifyPasswordIsWrong() {
        String email = "admin@admin.com";
        String passwordFake = faker.internet().password();
        loginPage.login(email, passwordFake);

        Assert.assertEquals(errorMessagePage.getErrorWrongPassword().getText(), "User does not exists");
        Assert.assertEquals(driver.getCurrentUrl(), "https://vue-demo.daniel-avellaneda.com/login");
    }

    @Test
    public void verifyRouteHomeWhenAdmin() {
        homePage.getLoginPageBtn().click();
        loginPage.login("admin@admin.com", "12345");

        Assert.assertEquals(driver.getCurrentUrl(), "https://vue-demo.daniel-avellaneda.com/home");
    }

    @Test
    public void verifyLogout() {
        homePage.goToLogin();
        loginPage.login("admin@admin.com", "12345");

        Assert.assertEquals(loginPage.getLogoutBtn().getText(), "LOGOUT");
        loginPage.logout();

        Assert.assertEquals(driver.getCurrentUrl(), "https://vue-demo.daniel-avellaneda.com/login");

        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertEquals(driver.getCurrentUrl(), "https://vue-demo.daniel-avellaneda.com/login");
    }
}
