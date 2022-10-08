package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class AuthRoutesTests extends BaseTest{

    //Test #1: Forbids visits to home url if not authenticated
    //assert:
    //    • Ucitati /home stranu kada korisnik nije ulogovan
    //    • Verifikovati da se u url-u stranice javlja ruta /login
    @Test
    public void test1 (){
        HomePage login = new HomePage(driver);
        login.goToLogin();
        String expectedResult1 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult1 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult1, expectedResult1);
    }

    //Test #2: Forbids visits to profile url if not authenticated
    //assert:
    //    • Ucitati /profile stranu
    //    • Verifikovati da se u url-u stranice javlja ruta /login
    @Test
    public void test2 () {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String expectedResult2 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult2 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult2, expectedResult2);
    }

    //Test #3: Forbids visits to admin cities url if not authenticated
    //assert:
    //    • Ucitati /admin/cities stranu
    //    • Verifikovati da se u url-u stranice javlja ruta /login
    @Test
    public void test3 () {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String expectedResult3 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult3 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult3, expectedResult3);
    }

    //Test #4: Forbids visits to admin users url if not authenticated
    //assert:
    //    • Ucitati /admin/users stranu
    //    • Verifikovati da se u url-u stranice javlja ruta /login
    @Test
    public void test4 () {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String expectedResult4 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult4 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult4, expectedResult4);
    }
}
