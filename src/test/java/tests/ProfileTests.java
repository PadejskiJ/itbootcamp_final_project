package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class ProfileTests extends BaseTest{
//Test #1: Edits profile
//Podaci:random podaci korišćenjem faker library-ja
//assert:
//    • Verifikovati da je prikazana poruka Profile saved successfuly
//    • Verifikovati da svaki input sada za value atribut ima vrednost koja je uneta u okviru forme
    @Test
    public void test1 () {
        HomePage homePage = new HomePage(driver);
        homePage.goToLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin@admin.com", "12345");

    }
}
