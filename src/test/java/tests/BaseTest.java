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

    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jpbou\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
       // driverWait = new WebDriverWait(driverWait);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://vue-demo.daniel-avellaneda.com/");
        faker = new Faker();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        errorMessagePage = new ErrorMessagePage(driver);
        signupPage = new SignupPage(driver);
        profilePage = new ProfilePage(driver);
        localePage = new LocalePage(driver);
        adminCitiesPage = new AdminCitiesPage(driver);

    }
    @AfterMethod
    public void afterMethod (){
        LoginPage logoutBtn = new LoginPage(driver);
        List< WebElement> backToHome = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]"));
        if (backToHome.size()==1){
            logoutBtn.logout();
        }
    }

    @AfterClass
    public void afterClass(){driver.close();}

}
