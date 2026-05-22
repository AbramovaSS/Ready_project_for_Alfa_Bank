package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:local.properties"
})

public interface WebConfig extends Config {

    @Key("browserName")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("browserVersion")
    @DefaultValue("128")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("remoteUrl")
    @DefaultValue("")
    String getRemoteUrl();

    @Key("remoteUsername")
    String getRemoteUsername();

    @Key("remotePassword")
    String getRemotePassword();

    @Key("baseUrl")
    @DefaultValue("https://job.alfabank.ru")
    String getBaseUrl();
}
