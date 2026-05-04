package firefoxtests;

import base.BaseFireFoxTest;
import pages.HomePage;
import pages.OrderFormFirstPage;
import pages.OrderFormSecondPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FireFoxCheckOrderUsingButtonInHeaderAndBodyTest extends BaseFireFoxTest {

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
}
