package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrderFormSecondPage {
    private WebDriver driver;

    //Локатор даты приезда заказа
    private By dateOrderField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Локатор кнопки со списком аренды
    private By listOfRentalTypesButton = By.cssSelector("div span[class='Dropdown-arrow']");
    //Локатор выбора типа аренды по наименованию
    private By exampleRentalType = By.cssSelector(".Dropdown-menu div");
    //Локатор чек-бокса цвета самоката
    private By colorOfSkooterCheckBox = By.xpath(".//input[@id='black']");
    //Локатор комментария для курьера
    private By commentForCourierField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка для оформления заказа
    private By orderButtonMiddle = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM:nth-of-type(2)");
    //Локатор подтверждения заказа
    private By confirmOderButton = By.xpath(".//button[contains(@class,'Button_Button__ra12g Button_Middle__1CSJM') and text()='Да']");
    //Локатор успешно оформленного заказа
    private By orderMadeText = By.xpath("//div[contains(@class,'Order_ModalHeader') and contains(text(),'Заказ оформлен')]");

    public OrderFormSecondPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод для получения даты оформления заказа
    public void setDateOrderField(String date){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(dateOrderField));
        driver.findElement(dateOrderField).sendKeys(date);
    }

    //Метод на получение списка арендов
    public void clickListOfRentalTypeButton(){
        driver.findElement(listOfRentalTypesButton).click();
    }

    //Получение конкретной аренды по локатору
    public void clickExampleRentalTypeButton(){
        List<WebElement> options = driver.findElements(exampleRentalType);
        options.get(0).click();
    }

    //Объединил в один шаг действия в форме с арендой
    public void stepRental(){
        clickListOfRentalTypeButton();
        clickExampleRentalTypeButton();
    }

    //Метод для выбора цвета самоката
    public void clickColorOfSkooterCheckBox(){
        driver.findElement(colorOfSkooterCheckBox).click();
    }

    //Метод для получения комментария для Курьера
    public void setCommentForCourierField(String comment){
        driver.findElement(commentForCourierField).sendKeys(comment);
    }

    //Метод для нажатия на кнопку оформления заказа
    public void clickOrderButtonMiddle(){
        driver.findElement(orderButtonMiddle).click();
    }

    //Метод для проверки кнопки подтверждения оформления заказа
    public void clickConfirmOderButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(confirmOderButton));
        driver.findElement(confirmOderButton).click();
    }

    //Метод для получения текста, если заказ успешно оформлен
    public String getOrderMadeText(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(orderMadeText));
        return driver.findElement(orderMadeText).getText();
    }

    public void stepSecondOrderPage(String dateOrder, String comment){
        setDateOrderField(dateOrder);
        stepRental();
        clickColorOfSkooterCheckBox();
        setCommentForCourierField(comment);
        clickOrderButtonMiddle();
    }
}
