package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private final SelenideElement
            searchInput = $(".SearchBarWidget_search-bar__input__18IWy"),
            tag = $(".VacanciesItem_vacancy__bl_container___ziAK");

    @Step("Открыть главную страницу https://job.alfabank.ru/")
    public HomePage openPage() {
        open("/");
        return this;
    }
    @Step("Ввести в строку поиска \"{value}\"")
    public HomePage setVacancy(String value) {
        searchInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Нажать на таб \"Всё о работе\"")
    public HomePage setTab() {
        String tabName = "Всё о работе";
        $(byText(tabName)).click();
        return this;
    }

    @Step("Проверить, что появляется вакансия с тегом \"{value}\"")
    public HomePage checkTag(String value) {
        tag.$(byText(value)).shouldHave(text(value));
        return this;
    }

}
