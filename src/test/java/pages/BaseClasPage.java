package pages;

import org.openqa.selenium.WebDriver;

public class BaseClasPage {

    private WebDriver driver;

    public BaseClasPage (){

    }

    public BaseClasPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }




}
