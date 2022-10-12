package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorMessagePage extends BasePage {
    private By errorMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");
    private By errorWrongPassword = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");
    private By errorSignUp = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li");

    public ErrorMessagePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getErrorMessage() {
        return getDriver().findElement(errorMessage);
    }

    public WebElement getErrorWrongPassword() {
        return getDriver().findElement(errorWrongPassword);
    }

    public WebElement getErrorSignUp() {
        return getDriver().findElement(errorSignUp);
    }
}
