package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.time.Duration;
import java.util.List;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected Faker faker;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected ErrorMessagePage errorMessagePage;
    protected SignupPage signupPage;
    protected ProfilePage profilePage;
    protected LocalePage localePage;
    protected AdminCitiesPage adminCitiesPage;

    @BeforeClass

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jpbou\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://vue-demo.daniel-avellaneda.com/");
        faker = new Faker();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        homePage = new HomePage(driver,driverWait);
        loginPage = new LoginPage(driver, driverWait);
        errorMessagePage = new ErrorMessagePage(driver, driverWait);
        signupPage = new SignupPage(driver, driverWait);
        profilePage = new ProfilePage(driver, driverWait);
        localePage = new LocalePage(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver,driverWait);
    }

    @AfterMethod
    public void afterMethod() {
        List<WebElement> backToHome = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]"));
        if (backToHome.size() == 1) {
            loginPage.logout();
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
