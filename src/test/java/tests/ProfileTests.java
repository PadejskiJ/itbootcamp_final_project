package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest{
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    ProfilePage myProfile = new ProfilePage(driver);



    //Test #1: Edits profile
//Podaci:random podaci korišćenjem faker library-ja
//assert:
//    • Verifikovati da je prikazana poruka Profile saved successfuly
//    • Verifikovati da svaki input sada za value atribut ima vrednost koja je uneta u okviru forme
    @Test
    public void test1 () {
        homePage.goToLogin();
        loginPage.login("admin@admin.com", "12345");
        myProfile.fiilMyProfile();

        Assert.assertTrue(myProfile.getProfileSavedMessage().getText().contains("Profile saved successfuly"));

        Assert.assertEquals(myProfile.getProfileName().getAttribute("value"),"Name");
        Assert.assertEquals(myProfile.getProfilePhone().getAttribute("value"), "Phone");
        Assert.assertEquals(myProfile.getProfileCity().getAttribute("value"), "City");
        Assert.assertEquals(myProfile.getProfileCountry().getAttribute("value"), "Country");
        Assert.assertEquals(myProfile.getProfileTwiter().getAttribute("value"), "Twitter");
        Assert.assertEquals(myProfile.getProfileGitHub().getAttribute("value"), "GitHub");


    }
}
