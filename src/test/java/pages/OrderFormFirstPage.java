package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderFormFirstPage {
    private WebDriver driver;

    //Локатор имени пользователя
    private By nameField = By.cssSelector("div input[placeholder='* Имя']");
    //Локатор фамилии пользователя
    private By lastNameField = By.cssSelector("div input[placeholder='* Фамилия']");
    //Локатор адреса
    private By adressField = By.cssSelector("div input[placeholder='* Адрес: куда привезти заказ']");
    //Локатор поля
    private By metroStationField = By.cssSelector("div input[placeholder='* Станция метро']");
    //Локатор метро из списка
    private By exampleMetroStatin = By.cssSelector(".select-search__select div");
    //Локатор телефона пользователя
    private By telephoneField = By.cssSelector("div input[placeholder='* Телефон: на него позвонит курьер']");
    //Локатор для нажатии на кнопку далее
    private By continueButton = By.xpath(".//button[text()='Далее']");

    //Локатор ошибки в помле имени
    private By errorFielNameText = By.xpath("//div[contains(text(),'Введите корректное имя')]");
    //Локатор ошибки в поле фамилии
    private By errorFieldLastNameText = By.xpath("//div[contains(text(),'Введите корректную фамилию')]");
    //Локатор ошибки в поле адреса
    private By errorFieldAdressText = By.xpath("//div[contains(text(),'Введите корректный адрес')]");
    //Локатор ошибки в поле станции метро
    private By errorFieldMetroStationText = By.xpath("//div[contains(text(),'Выберите станцию')]");
    //Локатор ошибки в поле телефона пользователя
    private By errorFieldTelephoneText = By.xpath("//div[contains(text(),'Введите корректный номер')]");

    public OrderFormFirstPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод для получения имени
    public void setUserName(String userName){
        driver.findElement(nameField).sendKeys(userName);
    }

    //Метод обработки ошибки в поле имени
    public String getNameFieldErrorText(){
        return driver.findElement(errorFielNameText).getText();
    }

    //Метод для получения фамилии
    public void setLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    //Метод обработки ошибки в поле фамилии
    public String getLastNameFieldErrorText(){
        return driver.findElement(errorFieldLastNameText).getText();
    }

    //Шаг с получением имени и фамилии пользователя
    public void stepNameAndLastName(String userName, String lastName){
        setUserName(userName);
        setLastName(lastName);
    }

    //Метод для получения адреса пользователя
    public void setUserAdress(String adress){
        driver.findElement(adressField).sendKeys(adress);
    }

    public String getAdressFieldErrorText(){
        return driver.findElement(errorFieldAdressText).getText();
    }

    //Метод для получения названия станции метро
    public void clickMetroStation(){
        driver.findElement(metroStationField).click();
    }

    //Метод получения текста ошибки в поле станции метро
    public String getMetroStationFieldErrorText(){
        return driver.findElement(errorFieldMetroStationText).getText();
    }

    //Метод для клика по первому элементу станции из списка
    public void clickExampleMetroStatin(){
        List<WebElement> options = driver.findElements(exampleMetroStatin);
        options.get(0).click();
    }

    public void stepMetroStation(){
        clickMetroStation();
        clickExampleMetroStatin();
    }

    //Метод для получения телефона
    public void setUserTelephone(String telephone){
        driver.findElement(telephoneField).sendKeys(telephone);
    }

    //Метод для получения ошибки в поле телефона
    public String getTelephoneFieldErrorText(){
        return driver.findElement(errorFieldTelephoneText).getText();
    }

    //Нажимаю на кнопку Далее и перехожу на вторую страницу
    //формы оформления заказа
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }

    public void stepFirstOrderPage(String userName, String lastName, String adress, String telephone){
        stepNameAndLastName(userName, lastName);
        setUserAdress(adress);
        stepMetroStation();
        setUserTelephone(telephone);
        clickContinueButton();
    }
}
