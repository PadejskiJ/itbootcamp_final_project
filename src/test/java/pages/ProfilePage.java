package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {
    private By myProfileBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");
    private By profileName = By.id("name");
    private By profilePhone = By.id("phone");
    private By profileCity = By.id("city");
    private By profileCountry = By.id("country");
    private By profileTwiter = By.id("urlTwitter");
    private By profileGitHub = By.id("urlGitHub");
    private By profileSaveBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");
    private By profileSavedMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]");
    Faker faker = new Faker();
    String name = faker.name().firstName();
    String phone = faker.number().digits(7);
    String city = "New York";
    String country = faker.address().country();
    String twiter = "https://" + faker.internet().domainName();
    String gitHub = "https://" + faker.internet().domainName();

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getMyProfileBtn() {
        return getDriver().findElement(myProfileBtn);
    }

    public WebElement getProfileName() {
        return getDriver().findElement(profileName);
    }

    public WebElement getProfilePhone() {
        return getDriver().findElement(profilePhone);
    }

    public WebElement getProfileCity() {
        return getDriver().findElement(profileCity);
    }

    public WebElement getProfileCountry() {
        return getDriver().findElement(profileCountry);
    }

    public WebElement getProfileTwiter() {
        return getDriver().findElement(profileTwiter);
    }

    public WebElement getProfileGitHub() {
        return getDriver().findElement(profileGitHub);
    }

    public WebElement getProfileSaveBtn() {
        return getDriver().findElement(profileSaveBtn);
    }

    public WebElement getProfileSavedMessage() {
        return getDriver().findElement(profileSavedMessage);
    }

    public void fiilMyProfile() {
        getMyProfileBtn().click();
        getProfileName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getProfileName().sendKeys(name);
        getProfilePhone().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getProfilePhone().sendKeys(phone);
        getProfileCity().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getProfileCity().sendKeys(city);
        getProfileCountry().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getProfileCountry().sendKeys(country);
        getProfileTwiter().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getProfileTwiter().sendKeys(twiter);
        getProfileGitHub().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getProfileGitHub().sendKeys(gitHub);
        getProfileSaveBtn().click();
    }
}
