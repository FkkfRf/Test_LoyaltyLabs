package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/local.properties"
})
public interface BaseTestConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://loylabs.ru/")
    String getBaseUrl();

    @Key("searchUrl")
    @DefaultValue("https://google.com/")
    String getSearchUrl();

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

