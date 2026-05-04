package googlechrometests;

import base.BaseGoogleChromeTest;
import pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoogleChromeCheckLogoInHeaderTest extends BaseGoogleChromeTest {

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
