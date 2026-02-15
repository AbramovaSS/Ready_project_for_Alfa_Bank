package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BlogPage {

    private final SelenideElement
            pageTitle = $(".intro__content");

    @Step("Переход на страницу c заголовком \"{value}\"")
    public BlogPage checkPageTitle(String value) {
        pageTitle.shouldHave(text(value));
        return this;
    }




}
