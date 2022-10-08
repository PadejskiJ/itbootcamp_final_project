package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminCitiesPage extends BaseClasPage{
    protected By adminBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");
    protected By citiesBtn = By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]");
    protected By newItemBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    protected By inputNewItem = By.xpath("//*[@id=\"name\"]");
    protected By saveNewItem = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");
    protected By savedMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    protected By editCity = By.xpath("//*[@id=\"edit\"]/span/i");
    protected By editCityWrite = By.xpath("//*[@id=\"name\"]");
    protected By editCityWriteSaveBtn = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");
    public AdminCitiesPage (WebDriver driver) {super(driver);}

    public WebElement getAdminBtn () {return getDriver().findElement(adminBtn);}
    public WebElement getCitiesBtn () {return getDriver().findElement(citiesBtn);}
    public WebElement getNewItemBtn () {return getDriver().findElement(newItemBtn);}
    public WebElement getInputNewItem () {return getDriver().findElement(inputNewItem);}
    public WebElement getSaveNewItem () {return getDriver().findElement(saveNewItem);}
    public WebElement getSavedMessage () {return getDriver().findElement(savedMessage);}
    public WebElement getEditCity () {return getDriver().findElement(editCity);}
    public WebElement getEditCityWrite () {return getDriver().findElement(editCityWrite);}
    public WebElement getEditCityWriteSaveBtn () {return getDriver().findElement(editCityWriteSaveBtn);}



}
