package GoogleChromeTests;
import Pages.HomePage;
import Pages.OrderFormFirstPage;
import Pages.OrderFormSecondPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleChromeCheckOrderUsingButtonInHeaderAndBodyTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions(); // Драйвер для браузера Chrome
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.education-services.ru/");
    }

    @ParameterizedTest
    @CsvSource({
            "Иван, Петров, Москва ул. Ленина 10, +79991234567, 2026-05-10, Позвонить за час",
            "Анна, Смирнова, Санкт-Петербург Невский 25, +79876543210, 2026-05-12, Не звонить",
            "Дмитрий, Иванов, Казань Кремлевская 1, +79161234567, 2026-05-15, Оставить у двери",
            "Елена, Кузнецова, Новосибирск Красный проспект 50, +79261231212, 2026-05-20, Оставить у двери"
    })
    public void checkOrderUsingButtonInHeaderTest(String userName, String lastName, String adress, String telephone,
                                                  String dateOrder, String comment) {
        HomePage homePage = new HomePage(driver);
        OrderFormFirstPage orderFormFirstPage = new OrderFormFirstPage(driver);
        OrderFormSecondPage orderFormSecondPage = new OrderFormSecondPage(driver);

        homePage.clickOrderButtonInHeader();
        orderFormFirstPage.stepFirstOrderPage(userName, lastName, adress, telephone);
        orderFormSecondPage.stepSecondOrderPage(dateOrder, comment);
        orderFormSecondPage.clickConfirmOderButton();

        Assertions.assertTrue(orderFormSecondPage.getOrderMadeText().contains("Заказ оформлен"), "Текст успешного оформления заказа не отображается");
    }

    @ParameterizedTest
    @CsvSource({
            "Иван, Петров, Москва ул. Ленина 10, +79991234567, 2026-05-10, Позвонить за час",
            "Анна, Смирнова, Санкт-Петербург Невский 25, +79876543210, 2026-05-12, Не звонить",
            "Дмитрий, Иванов, Казань Кремлевская 1, +79161234567, 2026-05-15, Оставить у двери",
            "Елена, Кузнецова, Новосибирск Красный проспект 50, +79261231212, 2026-05-20, Оставить у двери"
    })
    public void checkOrderUsingButtonInBodyTest(String userName, String lastName, String adress, String telephone,
                                                String dateOrder, String comment) {
        HomePage homePage = new HomePage(driver);
        OrderFormFirstPage orderFormFirstPage = new OrderFormFirstPage(driver);
        OrderFormSecondPage orderFormSecondPage = new OrderFormSecondPage(driver);

        homePage.clickOrderButtonInBody();
        orderFormFirstPage.stepFirstOrderPage(userName, lastName, adress, telephone);
        orderFormSecondPage.stepSecondOrderPage(dateOrder, comment);
        orderFormSecondPage.clickConfirmOderButton();

        Assertions.assertTrue(orderFormSecondPage.getOrderMadeText().contains("Заказ оформлен"), "Текст успешного оформления заказа не отображается");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
