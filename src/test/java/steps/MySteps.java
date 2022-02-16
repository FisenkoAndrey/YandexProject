package steps;

import com.codeborne.selenide.Condition;
import com.sun.imageio.plugins.wbmp.WBMPImageReader;
import io.cucumber.java.bg.И;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static sun.plugin.javascript.navig.JSType.Option;

public class MySteps {
    @И("^на экране присутствует поле \"([^\"]*)\"$")
    public void checkField(String fieldName) {
        String xpath;
        switch (fieldName) {
            case "Почта": {
                xpath = "//*[text()='Почта']";
                break;
            }
            case "Почтовый ящик": {
                xpath = "//*[text()='Диск']";
                break;
            }
            case "Адрес электронной почты": {
                xpath = "//*[@title='artdrozddrozdov@yandex.ru']";
                break;
            }
            case "Дата и время отправки": {
                xpath = "//*[@class='Header_dateLink_Y2p9n qa-MessageViewer-Header-dateLink']";
                break;
            }
            default: {
                xpath = "//*[text()='" + fieldName + "']";
            }
        }
        $(byXpath(xpath)).shouldBe(Condition.visible);
    }

    @И("^на экране заполняется поле \"([^\"]*)\" значением \"([^\"]*)\"$")
    public void fillField(String fieldName, String value) {
        String xpath;
        switch (fieldName) {
            case "Кому": {
                xpath = "(//div[@class='composeYabbles'])[1]";
                break;
            }
            default: {
                xpath = "(//*[(.//text()='" + fieldName + "' or .//@placeholder='" + fieldName + "') and .//input])[last()]//input";

            }
        }
        $(byXpath(xpath)).setValue(value);
        sleep(1000);
    }

    @И("^на экране нажать кнопку \"([^\"]*)\"$")
    public void clickButton(String buttonName) {
        String xpath;
        switch (buttonName) {
            case "Кому": {
                xpath = "//*[(@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l')]";
                break;
            }
                case "Аватар": {
                    xpath = "(//*[@class='user-pic__image'])[1]";
                    break;
                }
                    case "Письмо": {
                        xpath = "(//*[@class='mail-MessageSnippet-FromText'])[1]";
                        break;
                    }
            case "artemtestofanov": {
                xpath = "//*[@class='CurrentAccount-login']";
                break;
            }
            case "Войти в другой аккаунт": {
                xpath = "//*[@class='AddAccountButton-text']";
                break;
            }
                default: {
                    xpath = "//*[text()='" + buttonName + "' or normalize-space()='" + buttonName + "']";
                }
            }
            $(byXpath(xpath)).click();
            sleep(1000);
        }

        @И("^перейти на экран \"([^\"]*)\"$")
        //switchTo().window(1);
        public void switchToWindow (String screenNumber){
            int i = Integer.parseInt(screenNumber);
            switchTo().window(i);

        }

        @И("^из выпадающего списка выбрать значение \"([^\"]*)\"$")
        public void selectByValue (String value){
            $(By.name("Day")).selectOptionByValue("7");
            sleep(5000);
        }

//    public void checkSelectByValue(){
//        Object driver;
//        Select select = new Select(driver.FindElement(byId("dropdown")));
//        select.selectByValue("7");
//        Object webElement = select.getFirstSelectedOption();
//        assertEquals( expected; "Option 7", option.getText());
    }




