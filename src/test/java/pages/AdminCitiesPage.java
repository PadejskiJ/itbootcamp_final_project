package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminCitiesPage extends BaseClasPage {
    protected By adminBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");
    protected By citiesBtn = By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]");
    protected By newItemBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    protected By inputNewItem = By.xpath("//*[@id=\"name\"]");
    protected By saveNewItem = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");
    protected By savedMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");

    private String city = "Zrenjanin";
    protected By editCity = By.id("edit");
    protected By editCityWrite = By.xpath("//*[@id=\"name\"]");
    protected By editCityWriteSaveBtn = By.id("app"); ////*[@id="app"]/div[3]/div/div/div[3]/button[2]/span

    protected By tableCityRows = By.xpath("//table/tbody/tr");
    protected By editCityMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");

    protected By searchCity = By.id("search");
    public List<WebElement> getTableCityRows(){
        return getDriver().findElements(tableCityRows);
    }
    public By getTableCityRowsLocator() {
        return tableCityRows;
    }
    public void editCity (String city) {
        for (int i = 0; i < getTableCityRows().size(); i++) {
            WebElement singleRow = getTableCityRows().get(i);
            if (singleRow.getText().contains(city)) {
                singleRow.findElement(editCity).click();
                break;
            }
        }
    }
    public AdminCitiesPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAdminBtn() {
        return getDriver().findElement(adminBtn);
    }

    public WebElement getCitiesBtn() {
        return getDriver().findElement(citiesBtn);
    }

    public WebElement getNewItemBtn() {
        return getDriver().findElement(newItemBtn);
    }

    public WebElement getInputNewItem() {
        return getDriver().findElement(inputNewItem);
    }

    public WebElement getSaveNewItem() {
        return getDriver().findElement(saveNewItem);
    }

    public WebElement getSavedMessage() {
        return getDriver().findElement(savedMessage);
    }

    public WebElement getEditCity() {
        return getDriver().findElement(editCity);
    }

    public WebElement getEditCityWrite() {
        return getDriver().findElement(editCityWrite);
    }

    public WebElement getEditCityWriteSaveBtn() {
        return getDriver().findElement(editCityWriteSaveBtn);
    }

    public WebElement getEditCityMessage() {
        return getDriver().findElement(editCityMessage);
    }

    public WebElement getSearchCity () {
        return  getDriver().findElement(searchCity);
    }

}
