package firefoxtests;

import base.BaseFireFoxTest;
import pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FireFoxCheckLogoInHeaderTest extends BaseFireFoxTest {

    //На сайте не кликается и даже не происходит редиректа
    @Test
    public void checkLogoScooterInHeader() {
        HomePage homePage = new HomePage(driver);
        Assertions.assertEquals(BASE_URL, homePage.checkLogoScooter());
    }

    @Test
    public void checkLogoYandexInHeader() {
        HomePage homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.clickLogoYandex());
    }
}
