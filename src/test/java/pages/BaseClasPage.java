package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClasPage {

    private WebDriver driver;
    private WebDriverWait driverWait;



    public BaseClasPage(WebDriver driver) {
        this.driver = driver;

    }

    public WebDriver getDriver() {
        return driver;
    }
}
