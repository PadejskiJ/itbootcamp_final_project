package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest {

    //Test #1: Edits profile
    @Test
    public void verifyProfileInputs() {

        String expectedName = profilePage.getProfileName().getText();
        String expectedPhone = profilePage.getProfilePhone().getText();
        String expectedCity = profilePage.getProfileCity().getText();
        String expectedCountry = profilePage.getProfileCountry().getText();
        String expectedTwiter = profilePage.getProfileTwiter().getText();
        String expectedGitHub = profilePage.getProfileGitHub().getText();

        homePage.goToLogin();
        loginPage.login("admin@admin.com", "12345");
        profilePage.fiilMyProfile();

        Assert.assertTrue(profilePage.getProfileSavedMessage().getText().contains("Profile saved successfuly"));
        Assert.assertEquals(profilePage.getProfileName().getAttribute("value"), expectedName);
        Assert.assertEquals(profilePage.getProfilePhone().getAttribute("value"), expectedPhone);
        Assert.assertEquals(profilePage.getProfileCity().getAttribute("value"), expectedCity);
        Assert.assertEquals(profilePage.getProfileCountry().getAttribute("value"), expectedCountry);
        Assert.assertEquals(profilePage.getProfileTwiter().getAttribute("value"), expectedTwiter);
        Assert.assertEquals(profilePage.getProfileGitHub().getAttribute("value"), expectedGitHub);
    }
}
