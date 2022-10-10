package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocalePage extends BaseClasPage{

    private By languageBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button");
    private By spanishBtn = By.xpath("v-list-item v-list-item--link theme--light btnES");

    private By englishBtn = By.xpath("v-list-item v-list-item--link theme--light btnEN");

    private By frenchBtn = By.xpath("v-list-item v-list-item--link theme--light btnFR");
    private By homeBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[1]");
    private By headerText = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");

    public LocalePage (WebDriver driver) {super(driver);}

    public WebElement getLanguageBtn (){return getDriver().findElement(languageBtn);}
    public WebElement getSpanishBtn () { return getDriver().findElement(spanishBtn);}
    public WebElement getEnglishBtn () {return getDriver().findElement(englishBtn);}
    public WebElement getFrenchBtn() { return  getDriver().findElement(frenchBtn);}
    public WebElement getHomeBtn () {return  getDriver().findElement(homeBtn);}
    public WebElement getHeaderText () {return  getDriver().findElement(headerText);}

}
