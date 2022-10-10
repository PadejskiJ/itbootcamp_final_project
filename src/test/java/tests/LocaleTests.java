package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LocalePage;

public class LocaleTests extends BaseTest{

    //Test #1: Set locale to ES
    //assert:
    //    • Postaviti jezik na ES
    //    • Verifikovati da se na stranici u hederu javlja tekst Página de aterrizaje
    @Test
    public void test1 () {

        String expectedResult1 = "Página de aterrizaje";

        localePage.getLanguageBtn().click();
        localePage.getSpanishBtn().click();
        localePage.getHomeBtn().click();

        String actualResult1 = localePage.getHeaderText().getText();
        Assert.assertEquals(actualResult1, expectedResult1);
    }
    //Test #2: Set locale to EN
    //assert:
    //    • Postaviti jezik na EN
    //    • Verifikovati da se na stranici u hederu javlja tekst
    @Test
    public void test2 () {
        String expectedResult2 = "Landing";

        localePage.getLanguageBtn().click();
        localePage.getEnglishBtn().click();

        String actrualResult2 = localePage.getHeaderText().getText();
        Assert.assertEquals(actrualResult2,expectedResult2);
    }
    //Test #3: Set locale to FR
    //assert:
    //    • Postaviti jezik na FR
    //    • Verifikovati da se na stranici u hederu javlja tekst Page d'atterrissage
    @Test
    public void test3 () {
        String expectedResult3 = "Page d'atterrissage";

        localePage.getLanguageBtn().click();
        localePage.getFrenchBtn().click();

        String actrualResult3 = localePage.getHeaderText().getText();
        Assert.assertEquals(actrualResult3,expectedResult3);
    }
}
