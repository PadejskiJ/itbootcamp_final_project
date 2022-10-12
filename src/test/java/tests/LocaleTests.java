package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LocalePage;

public class LocaleTests extends BaseTest {

    //Test #1: Set locale to ES
    @Test
    public void verifyTextES() {

        localePage.chooseLanguageES();
        Assert.assertEquals(localePage.getHeaderText().getText(), "Página de aterrizaje");
    }

    //Test #2: Set locale to EN
    @Test
    public void verifyTextEN() {

        localePage.chooseLanguageEN();
        Assert.assertEquals(localePage.getHeaderText().getText(), "Landing");
    }

    //Test #3: Set locale to FR
    @Test
    public void verifyTextFR() {

        localePage.chooseLanguageFR();
        Assert.assertEquals(localePage.getHeaderText().getText(), "Page d'atterrissage");
    }
}
