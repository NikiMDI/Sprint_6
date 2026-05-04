package googlechrometests;

import base.BaseGoogleChromeTest;
import pages.HomePage;
import pages.OrderFormFirstPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GoogleChromeCheckFieldInFirstPageFormOrderTest extends BaseGoogleChromeTest {

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
}
