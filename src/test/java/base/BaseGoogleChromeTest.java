package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseGoogleChromeTest {

    protected WebDriver driver;
    protected static final String BASE_URL = "https://qa-scooter.education-services.ru/";

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions(); // Драйвер для браузера Chrome
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
