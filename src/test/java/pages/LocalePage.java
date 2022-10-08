package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocalePage extends BaseClasPage{

    protected By languageBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button");
    protected By spanishBtn = By.xpath("//*[@id=\"list-item-136\"]");

    protected By englishBtn = By.xpath("//*[@id=\"list-item-134\"]");

    protected By franchBtn = By.xpath("//*[@id=\"list-item-138\"]");

    public LocalePage (WebDriver driver) {super(driver);}

    public WebElement getLanguageBtn (){return getDriver().findElement(languageBtn);}
    public WebElement getSpanishBtn () { return getDriver().findElement(spanishBtn);}
    public WebElement getEnglishBtn () {return getDriver().findElement(englishBtn);}
    public WebElement getFranchBtn () { return  getDriver().findElement(franchBtn);}

}
