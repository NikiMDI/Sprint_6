package GoogleChromeTests;

import Pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleChromeCheckLogoInHeaderTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions(); // Драйвер для браузера Chrome
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
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
