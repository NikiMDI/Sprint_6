package GoogleChromeTests;

import Pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleChromeQuestionsFormTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions(); // Драйвер для браузера Chrome
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
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
