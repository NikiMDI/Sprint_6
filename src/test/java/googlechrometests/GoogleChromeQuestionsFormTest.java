package googlechrometests;

import base.BaseGoogleChromeTest;
import pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoogleChromeQuestionsFormTest extends BaseGoogleChromeTest {

    @Test
    public void checkListQUestionsInForm(){
        HomePage homePage = new HomePage(driver);
        homePage.clickQuestionsListButton();
        Assertions.assertTrue(homePage.getTextInQuestionForm().contains("Да, обязательно. Всем самокатов! И Москве, и Московской области."),
                                                                    "Текст последнего элемента не отображается");
    }
}
