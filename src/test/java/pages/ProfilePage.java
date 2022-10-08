package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;

public class ProfilePage extends BaseClasPage{
    protected By myProfileBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");

    Faker faker = new Faker();
    String name = faker.name().firstName();
    String phone = faker.number().digits();
    String city = faker.address().city();
    String country = faker.address().country();
    String twiter = faker.bothify("https://???????.com");
    String gitHub = faker.bothify("https://???????.com");

}
