package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;

public class BaseTest {

    protected WebDriver driver;
    protected Faker faker;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jpbou\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://vue-demo.daniel-avellaneda.com/");
        faker = new Faker();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

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
