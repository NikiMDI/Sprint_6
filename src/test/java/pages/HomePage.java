package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    //Локатор кнопки заказа в хедере
    private By orderButtonInHeader = By.cssSelector("div button[class='Button_Button__ra12g']");
    //Локатор кнопки заказа в теле
    private By orderButtonInBody = By.cssSelector("div button[class='Button_Button__ra12g Button_UltraBig__UU3Lp']");
    //Локатор, который ищет список важных вопросов
    private By questionsListButton = By.cssSelector(".Home_FAQ__3uVm4>div>div>div>div");
    //Локатор, который ищет текст ответа на последний вопрос в списке важных вопросов
    private By textEndElementInList = By.xpath("//p[contains(text(),'Да, обязательно. Всем самокатов! И Москве, и Московской области.')]");
    //Локатор, который ищет изображения логотипа самоката
    private By logoScooter = By.cssSelector(".Header_LogoScooter__3lsAR");
    //Локатор, который ищет логотип яндекса
    private By logoYandex = By.cssSelector(".Header_LogoYandex__3TSOI");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод для скроллинга к нужному элементу для работы с ним
    public void scrollIntoElement(By elementSearch){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementSearch));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        element.click();
    }

    //Кликаем по первой кнопке заказа в хедере (Первая точка входа)
    public void clickOrderButtonInHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(orderButtonInHeader));
        driver.findElement(orderButtonInHeader).click();
    }

    //Кликаем по второй кнопке в теле (Вторая точка входа)
    public void clickOrderButtonInBody() {
        scrollIntoElement(orderButtonInBody);
    }

    //Метод, который проходится по всему списку важных вопросов
    public void clickQuestionsListButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        int size = driver.findElements(questionsListButton).size();

        for (int i = 0; i < size; i++) {

            List<WebElement> questions = driver.findElements(questionsListButton);
            WebElement question = questions.get(i);

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", question);
            wait.until(ExpectedConditions.elementToBeClickable(question));

            try {
                question.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", question);
            }
        }
    }

    //Метод для получения текста элемента в списке важных вопросов
    public String getTextInQuestionForm(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(textEndElementInList));
        return driver.findElement(textEndElementInList).getText();
    }

    //Проверяем, что изображение присутствует
    public boolean checkLogoScooter(){
        return driver.findElement(logoScooter).isDisplayed();
    }

    //Метод, который кликает по логотипу яндекса
    public boolean clickLogoYandex() {
        driver.findElement(logoYandex).click();
        return true;
    }
}
