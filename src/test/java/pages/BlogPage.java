package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BlogPage {

    private final SelenideElement
            pageTitle = $(".intro__content"),
            resultTitle = $(".intro__title"),
            logo = $("use[href*='#logo']");

    private final ElementsCollection firstSearchResult = $$(".comfort-vacancies");

    @Step("Переход на страницу c заголовком \"{value}\"")
    public BlogPage checkPageTitle(String value) {
        pageTitle.shouldHave(text(value));
        return this;
    }

    @Step("Нажать на первую статью блога")
    public BlogPage tapFirstSearchResult() {
        firstSearchResult.first().click();
        return this;
    }

    @Step("Проверить, что страница со статьей открывается")
    public BlogPage verifyTitleResult() {
        resultTitle.shouldBe(visible);
        return this;
    }

    @Step("Нажать на лого")
    public BlogPage clickLogo() {
        logo.click();
        return this;
    }





}
