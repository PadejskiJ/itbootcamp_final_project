package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.HomePage;
import pages.LoginPage;

/*
Test #4: Search city
Podaci: editovani grad iz testa #3
assert: 
    • Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage

Test #5: Delete city
Podaci: editovani grad iz testa #3
assert: 
    • U polje za pretragu uneti staro ime grada
    • Sacekati da broj redova u tabeli bude 1
    • Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
    • Kliknuti na dugme Delete iz prvog reda
    • Sacekati da se dijalog za brisanje pojavi
    • Kliknuti na dugme Delete iz dijaloga
    • Sacekati da popu za prikaz poruke bude vidljiv
    • Verifikovati da poruka sadrzi tekst Deleted successfully
 */

public class AdminCitiesTests extends BaseTest {

    //Test #1: Visits the admin cities page and list cities
    //    • admin email: admin@admin.com
    //    • admin password: 12345
    //assert: Verifikovati da se u url-u stranice javlja /admin/cities ruta
    //        Verifikovati postojanje logout dugmeta
    @Test
    public void test1VisitsTheAdminCitiesPage () {
        HomePage loginPageBtn = new HomePage(driver);
        loginPageBtn.goToLogin();
        LoginPage loginBtn = new LoginPage(driver);
        loginBtn.login("admin@admin.com", "12345");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        AdminCitiesPage admitBtn = new AdminCitiesPage(driver);
        admitBtn.getAdminBtn().click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        AdminCitiesPage citiesBtn = new AdminCitiesPage(driver);
        citiesBtn.getCitiesBtn().click();

        String expectedResult1 = "https://vue-demo.daniel-avellaneda.com/admin/cities";
        String actualResult1 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult1, expectedResult1);

        String expectedResult2 = "LOGOUT";
        LoginPage logoutBtn = new LoginPage(driver);
        String actualResult2 = logoutBtn.getLogoutBtn().getText();
        Assert.assertEquals(actualResult2, expectedResult2);
        logoutBtn.logout();
    }

    //Test #2:
    //Podaci:random grad korisćenjem faker library-ja
    //assert: Verifikovati da poruka sadrzi tekst Saved successfully
    @Test
    public void test2CreateNewCity (){
        HomePage loginPageBtn = new HomePage(driver);
        loginPageBtn.goToLogin();
        LoginPage loginBtn = new LoginPage(driver);
        loginBtn.login("admin@admin.com", "12345");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        AdminCitiesPage admitBtn = new AdminCitiesPage(driver);
        admitBtn.getAdminBtn().click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        AdminCitiesPage citiesBtn = new AdminCitiesPage(driver);
        citiesBtn.getCitiesBtn().click();

        AdminCitiesPage newItemBtn = new AdminCitiesPage(driver);
        newItemBtn.getNewItemBtn().click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        AdminCitiesPage inputNewItem = new AdminCitiesPage(driver);
        inputNewItem.getInputNewItem().sendKeys("Zrenjanin");

        AdminCitiesPage saveNewItem = new AdminCitiesPage(driver);
        saveNewItem.getSaveNewItem().click();

        AdminCitiesPage savedMessage = new AdminCitiesPage(driver);
        savedMessage.getSavedMessage().getText();
        String expectedResult3 = "Saved successfully";
        //treba contains
    }

    //Podaci:edituje se grad koji je u testu 2 kreiran na isto ime + - edited (primer: Beograd – Beograd edited)
    //assert: Verifikovati da poruka sadrzi tekst Saved successfully
    @Test
    public void test3EditCity (){
        AdminCitiesPage editCity = new AdminCitiesPage(driver);
        editCity.getEditCity().click();
        AdminCitiesPage editCityWrite = new AdminCitiesPage(driver);
        editCityWrite.getEditCity().sendKeys("");

    }

}