package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminCitiesPage extends BasePage {
protected By adminBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");
    protected By citiesBtn = By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]");
    protected By newItemBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    protected By inputNewItem = By.xpath("//*[@id=\"name\"]");
    protected By saveNewItem = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");
    protected By savedMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    private By editBtn = By.id("edit");
    private By editField = By.id("name");

    private By saveButtonEditField = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");

    private By tableCityRows = By.xpath("//table/tbody/tr");

    private By editCityMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");

    private By deleteBtn = By.id("delete");
    private By deleteConfirmButton = By.xpath("//button/span[contains(text(), 'Delete')]");
    private String cityName;

    public AdminCitiesPage (WebDriver driver, WebDriverWait driverWait) {super(driver, driverWait);}

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

    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<WebElement> getTableCityRows(){
        return getDriver().findElements(tableCityRows);
    }

    public By getTableCityRowsLocator() {
        return tableCityRows;
    }
    public WebElement getEditBtn () {return getDriver().findElement(editBtn);}
    public WebElement getEditField () {return getDriver().findElement(editField);}
    public WebElement getSaveButtonEditField () {return getDriver().findElement(saveButtonEditField);}
    public WebElement getEditCityMessage (){return getDriver().findElement(editCityMessage);}
    public WebElement getDeleteBtn (){return getDriver().findElement(deleteBtn);}
    public WebElement getDeleteConfirmButton() {
        return getDriver().findElement(deleteConfirmButton);
    }

    public void clickEditCity (String city) {
        for (int i = 0; i < getTableCityRows().size(); i++) {
            WebElement singleRow = getTableCityRows().get(i);
            if (singleRow.getText().contains(city)) {
                singleRow.findElement(editBtn).click();
                break;
            }
        }
    }
    //getCityName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);

    public void editCity(String newName) {

        getEditField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getEditField().sendKeys(newName);
        getSaveButtonEditField().click();
    }


    public void clickDeleteCity (String city) {
        for (int i = 0; i < getTableCityRows().size(); i++) {
            WebElement singleRow = getTableCityRows().get(i);
            if (singleRow.getText().contains(city)) {
                singleRow.findElement(deleteBtn).click();
                break;
            }
        }
    }
}
