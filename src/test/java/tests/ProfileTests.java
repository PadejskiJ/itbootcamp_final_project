package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest{

    //Test #1: Edits profile
//Podaci:random podaci korišćenjem faker library-ja
//assert:
//    • Verifikovati da je prikazana poruka Profile saved successfuly
//    • Verifikovati da svaki input sada za value atribut ima vrednost koja je uneta u okviru forme
    @Test
    public void test1 () {
        homePage.goToLogin();
        loginPage.login("admin@admin.com", "12345");
        profilePage.fiilMyProfile();

        Assert.assertTrue(profilePage.getProfileSavedMessage().getText().contains("Profile saved successfuly"));

        Assert.assertEquals(profilePage.getProfileName().getAttribute("value"),"Name");
        Assert.assertEquals(profilePage.getProfilePhone().getAttribute("value"), "Phone");
        Assert.assertEquals(profilePage.getProfileCity().getAttribute("value"), "City");
        Assert.assertEquals(profilePage.getProfileCountry().getAttribute("value"), "Country");
        Assert.assertEquals(profilePage.getProfileTwiter().getAttribute("value"), "Twitter");
        Assert.assertEquals(profilePage.getProfileGitHub().getAttribute("value"), "GitHub");


    }
}
