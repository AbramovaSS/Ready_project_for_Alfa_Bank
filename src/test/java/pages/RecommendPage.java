package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RecommendPage {

    private final SelenideElement
            firstNameInput = $("[name='firstName']"),
            lastNameInput = $("[name='lastName']"),
            emailInput = $("[name='email']"),
            numberPhone = $("[name='phone']"),
            checkboxWrapper = $(".checkbox__box"),
            submit = $("[type='submit']"),
            errorEmail = $(".input__sub"),
            errorPhone = $(".input__sub"),
            numberVerificationError = $(".input__sub");

    @Step("Перейти на страницу рекомендаций")
    public RecommendPage openPage() {
        open("/recommend");
        $("#form-response_recommend").$(byText("Хочу быть рекомендателем"));
        return this;
    }

    @Step("Ввести имя \"{value}\" в поле \"Имя\"")
    public RecommendPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Ввести фамилию \"{value}\" в поле \"Фамилия\"")
    public RecommendPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Ввести email \"{value}\" в поле \"Электронная почта\"")
    public RecommendPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Ввести номер телефона \"{value}\" в поле \"Телефон\"")
    public RecommendPage setNumberPhone(String value) {
        numberPhone.setValue(value);
        return this;
    }

    @Step("Отметить чек-бокс \"Даю свое согласие на обработку и использование моих персональных данных\"")
    public RecommendPage setСonsent() {
        checkboxWrapper.click();
        return this;
    }

    @Step("Нажать на кнопку \"Отправить\"")
    public RecommendPage setSubmit() {
        submit.click();
        return this;
    }

    @Step("Проверить, что под полем \"Телефон\" появился текст ошибки \"{value}\"")
    public RecommendPage checkNumberPhone(String value) {
        errorPhone.shouldHave(text(value));
        return this;
    }

    @Step("Проверить, что под полем \"Электронная почта\" появился текст ошибки \"{value}\"")
    public RecommendPage checkEmail(String value) {
        errorEmail.shouldHave(text(value));
        return this;
    }

    @Step("Проверить, что под полем \"Электронная почта\" появился текст ошибки \"{value}\"")
    public RecommendPage checkNumberVerification(String value) {
        numberVerificationError.shouldHave(text(value));
        return this;
    }
}
