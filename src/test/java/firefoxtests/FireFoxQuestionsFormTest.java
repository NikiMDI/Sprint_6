package firefoxtests;

import base.BaseFireFoxTest;
import pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FireFoxQuestionsFormTest extends BaseFireFoxTest {

    @Test
    public void checkListQUestionsInForm(){
        HomePage homePage = new HomePage(driver);
        homePage.clickQuestionsListButton();
        Assertions.assertTrue(homePage.getTextInQuestionForm().contains("Да, обязательно. Всем самокатов! И Москве, и Московской области."),
                "Текст последнего элемента не отображается");
    }
}
