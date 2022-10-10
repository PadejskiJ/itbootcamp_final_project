package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest {

    //Test #1: Edits profile
//Podaci:random podaci korišćenjem faker library-ja
//assert:
//    • Verifikovati da je prikazana poruka Profile saved successfuly
//    • Verifikovati da svaki input sada za value atribut ima vrednost koja je uneta u okviru forme
    @Test
    public void verifyProfileInputs() {
        homePage.goToLogin();
        loginPage.login("admin@admin.com", "12345");
        profilePage.fiilMyProfile();

        Assert.assertTrue(profilePage.getProfileSavedMessage().getText().contains("Profile saved successfuly"));

        String expectedName = profilePage.getProfileName().getText();
        String expectedPhone = profilePage.getProfilePhone().getText();
        String expectedCity = profilePage.getProfileCity().getText();
        String expectedCountry = profilePage.getProfileCountry().getText();
        String expectedTwiter = profilePage.getProfileTwiter().getText();
        String expectedGitHub = profilePage.getProfileGitHub().getText();


        Assert.assertEquals(profilePage.getProfileName().getAttribute("value"), expectedName);
        Assert.assertEquals(profilePage.getProfilePhone().getAttribute("value"), expectedPhone);
        Assert.assertEquals(profilePage.getProfileCity().getAttribute("value"), expectedCity);
        Assert.assertEquals(profilePage.getProfileCountry().getAttribute("value"), expectedCountry);
        Assert.assertEquals(profilePage.getProfileTwiter().getAttribute("value"), expectedTwiter);
        Assert.assertEquals(profilePage.getProfileGitHub().getAttribute("value"), expectedGitHub);

    }
}
