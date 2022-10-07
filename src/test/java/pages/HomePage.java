package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BaseClasPage{
    protected By loginPageBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");
    protected By homeBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[1]");

    public HomePage (WebDriver driver) {super(driver);}

    public WebElement getLoginPageBtn() {
        return getDriver().findElement(loginPageBtn);
    }
    public WebElement getHomeBtn (){return getDriver().findElement(homeBtn);}

    public void goToLogin (){
        getLoginPageBtn().click();
    }

    public void goToHome (){
        getHomeBtn().click();
    }


}
