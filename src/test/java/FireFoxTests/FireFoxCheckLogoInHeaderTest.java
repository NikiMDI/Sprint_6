package FireFoxTests;

import Pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxCheckLogoInHeaderTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        FirefoxOptions options = new FirefoxOptions(); // Драйвер для браузера FireFox
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.education-services.ru/");
    }

    //На сайте не кликается и даже не происходит редиректа
    @Test
    public void checkLogoScooterInHeader() {
        HomePage homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.checkLogoScooter());
    }

    @Test
    public void checkLogoYandexInHeader() {
        HomePage homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.clickLogoYandex());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
