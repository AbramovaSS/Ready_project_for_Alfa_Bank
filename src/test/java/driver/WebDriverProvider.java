package driver;

import com.codeborne.selenide.Configuration;
import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
import java.util.Objects;

public class WebDriverProvider {
    private final WebConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebConfig.class, System.getProperties());
    }

    public WebConfig getConfig() {
        return config;
    }

    public void configure() {
        Configuration.browser = config.getBrowserName();

        String browserVersion = config.getBrowserVersion();
        if (Objects.nonNull(browserVersion)) {
            Configuration.browserVersion = config.getBrowserVersion();
        }

        Configuration.browserSize = config.getBrowserSize();
        Configuration.baseUrl = config.getBaseUrl();

        if (config.isRemote()) {
            Configuration.remote = String.valueOf(remoteUrl());
            Configuration.browserCapabilities = getCapabilities();
        }

    }

    private String remoteUrl() {
        var url = config.getRemoteUrl();
        if (Objects.nonNull(config.getRemoteUsername()) && Objects.nonNull(config.getRemotePassword())) {
            url = url.replace("://", "://" + config.getRemoteUsername() + ":" + config.getRemotePassword() + "@");
        }
        return url;
    }

    private DesiredCapabilities getCapabilities() {
        var capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        return capabilities;
    }
}
