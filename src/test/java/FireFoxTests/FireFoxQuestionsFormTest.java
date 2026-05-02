package FireFoxTests;

import Pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxQuestionsFormTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        FirefoxOptions options = new FirefoxOptions(); // Драйвер для браузера FireFox
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.education-services.ru/");
    }

    @Test
    public void checkListQUestionsInForm(){
        HomePage homePage = new HomePage(driver);
        homePage.clickQuestionsListButton();
        Assertions.assertTrue(homePage.getTextInQuestionForm().contains("Да, обязательно. Всем самокатов! И Москве, и Московской области."),
                "Текст последнего элемента не отображается");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
