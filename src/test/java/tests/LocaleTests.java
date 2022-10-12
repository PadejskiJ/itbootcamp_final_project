package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LocalePage;

public class LocaleTests extends BaseTest{

    //Test #1: Set locale to ES
    @Test
    public void verifyTextES () {

        String expectedResult1 = "Página de aterrizaje";

        localePage.chooseLanguageES();

        String actualResult1 = localePage.getHeaderText().getText();
        Assert.assertEquals(actualResult1, expectedResult1);
    }
    //Test #2: Set locale to EN
    @Test
    public void verifyTextEN () {
        String expectedResult2 = "Landing";

        localePage.chooseLanguageEN();

        String actrualResult2 = localePage.getHeaderText().getText();
        Assert.assertEquals(actrualResult2,expectedResult2);
    }
    //Test #3: Set locale to FR
    @Test
    public void verifyTextFR () {
        String expectedResult3 = "Page d'atterrissage";

        localePage.chooseLanguageFR();

        String actrualResult3 = localePage.getHeaderText().getText();
        Assert.assertEquals(actrualResult3,expectedResult3);
    }
}
