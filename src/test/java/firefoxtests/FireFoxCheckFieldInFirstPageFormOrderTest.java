package firefoxtests;

import pages.HomePage;
import pages.OrderFormFirstPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxCheckFieldInFirstPageFormOrderTest {

    private WebDriver driver;
    private static final String BASE_URL = "https://qa-scooter.education-services.ru/";

    @BeforeEach
    public void setUp() {
        FirefoxOptions options = new FirefoxOptions(); // Драйвер для браузера FireFox
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "", " "})
    public void checkNameField(String name) {
        HomePage homePage = new HomePage(driver);
        OrderFormFirstPage formFirstPage = new OrderFormFirstPage(driver);
        homePage.clickOrderButtonInHeader();
        formFirstPage.setUserName(name);
        formFirstPage.clickContinueButton();
        Assertions.assertEquals("Введите корректное имя", formFirstPage.getNameFieldErrorText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "", " "})
    public void checkLastNameField(String lastName) {
        HomePage homePage = new HomePage(driver);
        OrderFormFirstPage formFirstPage = new OrderFormFirstPage(driver);
        homePage.clickOrderButtonInHeader();
        formFirstPage.setLastName(lastName);
        formFirstPage.clickContinueButton();
        Assertions.assertEquals("Введите корректную фамилию", formFirstPage.getLastNameFieldErrorText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"test"})
    public void checkAdressField(String adress) {
        HomePage homePage = new HomePage(driver);
        OrderFormFirstPage formFirstPage = new OrderFormFirstPage(driver);
        homePage.clickOrderButtonInHeader();
        formFirstPage.setUserAdress(adress);
        formFirstPage.clickContinueButton();
        Assertions.assertEquals("Введите корректный адрес", formFirstPage.getAdressFieldErrorText());
    }

    @Test
    public void checkMetroStationField() {
        HomePage homePage = new HomePage(driver);
        OrderFormFirstPage formFirstPage = new OrderFormFirstPage(driver);
        homePage.clickOrderButtonInHeader();
        formFirstPage.clickContinueButton();
        Assertions.assertEquals("Выберите станцию", formFirstPage.getMetroStationFieldErrorText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "", " "})
    public void checkTelephoneField(String telephone) {
        HomePage homePage = new HomePage(driver);
        OrderFormFirstPage formFirstPage = new OrderFormFirstPage(driver);
        homePage.clickOrderButtonInHeader();
        formFirstPage.setUserTelephone(telephone);
        formFirstPage.clickContinueButton();
        Assertions.assertEquals("Введите корректный номер", formFirstPage.getTelephoneFieldErrorText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
