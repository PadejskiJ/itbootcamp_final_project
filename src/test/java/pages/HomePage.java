package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By loginPageBtn = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span");
    private By homeBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[1]");

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLoginPageBtn() {
        return getDriver().findElement(loginPageBtn);
    }

    public WebElement getHomeBtn() {
        return getDriver().findElement(homeBtn);
    }

    public void goToLogin() {
        getLoginPageBtn().click();
    }
}
