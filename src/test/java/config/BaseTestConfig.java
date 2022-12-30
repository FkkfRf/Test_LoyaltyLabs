package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        //"classpath:config/local.properties"
        "classpath:config/${env}.properties",
        "classpath:config/${env}.properties"
})
public interface BaseTestConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://loylabs.ru/")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browserSize")
    String getBrowserSize();

    @Key("remoteUrl")
    String getRemoteURL();
}

