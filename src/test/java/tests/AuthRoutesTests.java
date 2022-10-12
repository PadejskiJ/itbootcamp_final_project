package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class AuthRoutesTests extends BaseTest {

    //Test #1: Forbids visits to home url if not authenticated
    @Test
    public void verifyHomeURL() {
        homePage.goToLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://vue-demo.daniel-avellaneda.com/login");
    }

    //Test #2: Forbids visits to profile url if not authenticated
    @Test
    public void verifyProfileURL() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        Assert.assertEquals(driver.getCurrentUrl(), "https://vue-demo.daniel-avellaneda.com/login");
    }

    //Test #3: Forbids visits to admin cities url if not authenticated
    @Test
    public void verifyAdminCitiesURL() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(), "https://vue-demo.daniel-avellaneda.com/login");
    }

    //Test #4: Forbids visits to admin users url if not authenticated
    @Test
    public void verifyAdminUsersURL() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        Assert.assertEquals(driver.getCurrentUrl(), "https://vue-demo.daniel-avellaneda.com/login");
    }
}
