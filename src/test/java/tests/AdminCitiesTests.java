package tests;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminCitiesTests extends BaseTest {

    public void setUp() {
        adminCitiesPage.setCityName("Zrenjanin");
    }

    //Test #1: Visits the admin cities page and list cities, logout btn
    @Test
    public void verifyLogoutBtn() {
        String expectedURL = "https://vue-demo.daniel-avellaneda.com/admin/cities";
        String expectedBtnName = "LOGOUT";

        homePage.goToLogin();
        loginPage.login("admin@admin.com", "12345");
        adminCitiesPage.getAdminBtn().click();
        adminCitiesPage.getCitiesBtn().click();

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(loginPage.getLogoutBtn().getText(), expectedBtnName);
        loginPage.logout();
    }

    @Test
    public void verifyNewCityMessage() {
        homePage.goToLogin();
        loginPage.login("admin@admin.com", "12345");
        adminCitiesPage.getAdminBtn().click();
        adminCitiesPage.getCitiesBtn().click();
        adminCitiesPage.getNewItemBtn().click();
        adminCitiesPage.getInputNewItem().sendKeys("Zrenjanin");
        adminCitiesPage.getSaveNewItem().click();

        Assert.assertTrue(adminCitiesPage.getSavedMessage().getText().contains("Saved successfully"));
    }

    @Test
    public void verifyEditCityMessage() {
        homePage.goToLogin();
        loginPage.login("admin@admin.com", "12345");
        adminCitiesPage.getAdminBtn().click();
        adminCitiesPage.getCitiesBtn().click();
        adminCitiesPage.clickEditCity("Zrenjanin");
        adminCitiesPage.editCity("Zrenjanin - edited");

        Assert.assertTrue(adminCitiesPage.getEditCityMessage().getText().contains("Saved successfully"));
    }

    //Test #4: Search city
    @Test (dependsOnMethods = "verifyEditCityMessage")
    public void verifySearchCity()  {
        homePage.goToLogin();
        loginPage.login("admin@admin.com", "12345");
        adminCitiesPage.getAdminBtn().click();
        adminCitiesPage.getCitiesBtn().click();
        adminCitiesPage.getSearchBtn().sendKeys("Zrenjanin");
        Assert.assertTrue(adminCitiesPage.getSearchCity().getText().contains("Zrenjanin"));
    }

    //Test #5: Delete city
    @Test (dependsOnMethods = "verifyEditCityMessage, verifySearchCity")
    public void test5DeleteCityAndVerifyMessage() {
        adminCitiesPage.clickDeleteCity("Zrenjanin");
        Assert.assertEquals(adminCitiesPage.getDeleteConfirmButton().getText(), "Deleted successfully");

    }
}
