package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlfaBankTests extends tests.TestBase {

    @Test
    @DisplayName("Форма рекомендации. Поле \"Телефон\" обязательно для заполнения")
    void phoneNumberFieldIsRequiredInRecommendFormTest() {
        recommendPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setСonsent()
                .setSubmit()
                .checkNumberPhone("Это обязательное поле");
    }

    @Test
    @DisplayName("Форма рекомендации. Ввод некорректного значения в поле \"Электронная почта\"")
    void enterIncorrectValueInEmailTest() {
        recommendPage.openPage()
                .setEmail("рус@домен.рф")
                .checkEmail("Некорректное значение");
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
                .checkNumberVerification("Подтвердите номер телефона");
    }

    @Test
    @DisplayName("Поиск вакансии QA")
    void jobSearchTest() {
        homePage.openPage()
                .setVacancy("QA")
                .checkTag("Тестирование");
    }

    @Test
    @DisplayName("Переход на страницу \"Всё о работе\"")
    void goToBlogTest() {
        homePage.openPage()
                .setTab();
        blogPage.checkPageTitle("Полезные статьи о карьере в Альфа‑Банке");
    }
}

