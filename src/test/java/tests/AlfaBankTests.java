package tests;

import data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BlogPage;
import pages.HomePage;
import pages.RecommendPage;

import static data.TestData.*;

public class AlfaBankTests extends tests.TestBase {

    HomePage homePage = new HomePage();
    RecommendPage recommendPage = new RecommendPage();
    BlogPage blogPage = new BlogPage();
    TestData testData = new TestData();

    @Test
    @DisplayName("Форма рекомендации. Поле \"Телефон\" обязательно для заполнения")
    void phoneNumberFieldIsRequiredInRecommendFormTest() {
        recommendPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setСonsent()
                .setSubmit()
                .checkNumberPhone(HINT_EMPTY);
    }

    @Test
    @DisplayName("Форма рекомендации. Ввод некорректного значения в поле \"Электронная почта\"")
    void enterIncorrectValueInEmailTest() {
        recommendPage.openPage()
                .setEmail(EMAIL)
                .checkEmail(HINT_INVALID);
    }

    @Test
    @DisplayName("Форма рекомендации. Отправка рекомендации без подтверждения номера телефона")
    void SendRecommendationWithoutPhoneNumberVerificationTest() {
        recommendPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setNumberPhone(testData.numberPhone)
                .setСonsent()
                .setSubmit()
                .checkNumberVerification(HINT_CONFIRMATION);
    }

    @Test
    @DisplayName("Поиск вакансии QA")
    void jobSearchTest() {
        homePage.openPage()
                .setVacancy(VALUE_VACANCY)
                .checkTag(TAG);
    }

    @Test
    @DisplayName("Переход на страницу \"Всё о работе\"")
    void goToBlogTest() {
        homePage.openPage()
                .setTab();
        blogPage.checkPageTitle(PAGE_TITLE);
    }

    @Test
    @DisplayName("Переход на страницу статьи блога")
    void goToPageBlogTest() {
        homePage.openPage()
                .setTab();
        blogPage.checkPageTitle(PAGE_TITLE)
                .tapFirstSearchResult()
                .verifyTitleResult();
    }

    @Test
    @DisplayName("Возврат домой при клике на лого")
    void goToHomeTest() {
        homePage.openPage()
                .setTab();
        blogPage.checkPageTitle(PAGE_TITLE)
                .clickLogo();
        homePage.checkTitleHome();


    }
}

