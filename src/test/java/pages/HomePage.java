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
    // список вопросов
    private By questionsList = By.cssSelector(".Home_FAQ__3uVm4>div>div>div>div");
    // список ответов
    private By answersList = By.cssSelector(".accordion__panel p");
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

    //Кликаем по вопросу из списка
    public void clickQuestionByIndex(int index) {
        List<WebElement> questions = driver.findElements(questionsList);
        WebElement question = questions.get(index);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", question);

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(question));

        question.click();
    }

    //Метод для получения текста элемента в списке важных вопросов
    public String getAnswerTextByIndex(int index) {
        List<WebElement> answers = driver.findElements(answersList);

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(answers.get(index)));

        return answers.get(index).getText();
    }

    //Метод, который кликает по логотипу самоката
    public String checkLogoScooter(){
        driver.findElement(logoScooter).click();
        return driver.getCurrentUrl();
    }

    //Метод, который кликает по логотипу яндекса
    public boolean clickLogoYandex() {
        driver.findElement(logoYandex).click();
        return true;
    }
}
