package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import data.TestData;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
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

    private static final WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

    @BeforeAll
    @DisplayName("Инициализация тестового окружения для тестов")
    static void testPrecondition() {
        String remoteUrl = webConfig.getRemoteUrl();
        Configuration.baseUrl = webConfig.getBaseUrl();
        Configuration.browser = webConfig.getBrowserName();
        Configuration.browserVersion = webConfig.getBrowserVersion();
        Configuration.browserSize = webConfig.getBrowserSize();

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