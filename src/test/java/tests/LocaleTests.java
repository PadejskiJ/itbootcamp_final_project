package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocalePage;

public class LocaleTests extends BaseTest{

    //Test #1: Set locale to ES
    //assert:
    //    • Postaviti jezik na ES
    //    • Verifikovati da se na stranici u hederu javlja tekst Página de aterrizaje
    @Test
    public void test1 () {
        LocalePage languageBtn = new LocalePage(driver);
        languageBtn.getLanguageBtn().click();
        LocalePage spanishBtn = new LocalePage(driver);
        spanishBtn.getSpanishBtn().click();
        String expectedResult1 = "";
        String actrualResult1 = ;
        Assert.assertEquals(actrualResult1,expectedResult1);
    }
    //Test #2: Set locale to EN
    //assert:
    //    • Postaviti jezik na EN
    //    • Verifikovati da se na stranici u hederu javlja tekst Landing
    @Test
    public void test2 () {
        LocalePage languageBtn = new LocalePage(driver);
        languageBtn.getLanguageBtn().click();
        LocalePage englishBtn = new LocalePage(driver);
        englishBtn.getEnglishBtn().click();
        String expectedResult2 = "";
        String actrualResult2 = ;
        Assert.assertEquals(actrualResult2,expectedResult2);
    }
    //Test #3: Set locale to FR
    //assert:
    //    • Postaviti jezik na FR
    //    • Verifikovati da se na stranici u hederu javlja tekst Page d'atterrissage
    @Test
    public void test3 () {
        LocalePage languageBtn = new LocalePage(driver);
        languageBtn.getLanguageBtn().click();
        LocalePage franchBtn = new LocalePage(driver);
        franchBtn.getFranchBtn().click();
        String expectedResult3 = "";
        String actrualResult3 = ;
        Assert.assertEquals(actrualResult3,expectedResult3);
    }
}
