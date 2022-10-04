package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected Faker faker;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jpbou\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://vue-demo.daniel-avellaneda.com/");
        faker = new Faker();
        driver.manage().deleteAllCookies();

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
