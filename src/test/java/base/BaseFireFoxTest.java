package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseFireFoxTest {

    protected WebDriver driver;
    protected static final String BASE_URL = "https://qa-scooter.education-services.ru/";

    @BeforeEach
    public void setUp() {
        FirefoxOptions options = new FirefoxOptions(); // Драйвер для браузера FireFox
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
