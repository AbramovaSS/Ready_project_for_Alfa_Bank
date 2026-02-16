package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.TestData;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.BlogPage;
import pages.HomePage;
import pages.RecommendPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    HomePage homePage = new HomePage();
    RecommendPage recommendPage = new RecommendPage();
    BlogPage blogPage = new BlogPage();
    TestData testData = new TestData();

    @BeforeAll
    @DisplayName("Инициализация тестового окружения для тестов")
    static void testPrecondition() {

        String baseUrl = System.getProperty("baseUrl", "https://job.alfabank.ru");
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "128");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String remoteUrl = System.getProperty("remoteUrl", null);
        Configuration.baseUrl = baseUrl;
        Configuration.browser = browser;
        Configuration.browserVersion = version;
        Configuration.browserSize = browserSize;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = remoteUrl;
    }

    @BeforeEach
    @DisplayName("Добавление Allure-логирования для каждого теста")
    public void beforeEachTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }


}