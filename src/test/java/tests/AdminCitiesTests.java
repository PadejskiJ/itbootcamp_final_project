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

    //Test #1: Visits the admin cities page and list cities
    //    • admin email: admin@admin.com
    //    • admin password: 12345
    //assert: Verifikovati da se u url-u stranice javlja /admin/cities ruta
    //        Verifikovati postojanje logout dugmeta
    @Test
    public void verifyLogoutBtn() {
        homePage.goToLogin();
        loginPage.login("admin@admin.com", "12345");

        adminCitiesPage.getAdminBtn().click();

        adminCitiesPage.getCitiesBtn().click();

        String expectedResult1 = "https://vue-demo.daniel-avellaneda.com/admin/cities";
        String actualResult1 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult1, expectedResult1);

        String expectedResult2 = "LOGOUT";
        String actualResult2 = loginPage.getLogoutBtn().getText();
        Assert.assertEquals(actualResult2, expectedResult2);
        loginPage.logout();
    }

    //Test #2:
    // kreirati grad
    //assert: Verifikovati da poruka sadrzi tekst Saved successfully
    @Test
    public void verifyNewCityMessage() {
        homePage.goToLogin();
        loginPage.login("admin@admin.com", "12345");

        adminCitiesPage.getAdminBtn().click();

        adminCitiesPage.getCitiesBtn().click();

        adminCitiesPage.getNewItemBtn().click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        adminCitiesPage.getInputNewItem().sendKeys("Zrenjanin");

        adminCitiesPage.getSaveNewItem().click();

        Assert.assertTrue(adminCitiesPage.getSavedMessage().getText().contains("Saved successfully"));
    }

    //Podaci:edituje se grad koji je u testu 2 kreiran na isto ime + "- edited" (primer: Beograd – Beograd edited)
    //assert: Verifikovati da poruka sadrzi tekst Saved successfully
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

    //Test #4:
    //Podaci:editovani grad iz testa #3
    //assert: Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
    @Test
    public void verifySearchCity() {
        homePage.goToLogin();
        loginPage.login("admin@admin.com", "12345");

        adminCitiesPage.getAdminBtn().click();

        adminCitiesPage.getCitiesBtn().click();

        //adminCitiesPage.getSearchCity().sendKeys("Zrenjanin");
    }


    //Test #5: Delete city
    //Podaci:editovani grad iz testa #3
    //assert:
    //    • U polje za pretragu uneti staro ime grada
    //    • Sacekati da broj redova u tabeli bude 1
    //    • Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
    //    • Kliknuti na dugme Delete iz prvog reda
    //    • Sacekati da se dijalog za brisanje pojavi
    //    • Kliknuti na dugme Delete iz dijaloga
    //    • Sacekati da popu za prikaz poruke bude vidljiv
    //    • Verifikovati da poruka sadrzi tekst Deleted successfully
    @Test
    public void test5DeleteCityAndVerifyMessage() {

        adminCitiesPage.clickDeleteCity("Zrenjanin");

    }
}
