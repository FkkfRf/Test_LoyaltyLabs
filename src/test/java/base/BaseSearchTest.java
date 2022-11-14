package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class BaseSearchTest {

    @BeforeAll
    static void setUp() {
        String browserName = System.getProperty("browser", "chrome");
        String browserVer = System.getProperty("browserVersion", "100");
        String browserSize = System.getProperty("browserSize", "1920x1050");
        String remoteUrl = System.getProperty("remote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        step("Устанавливаем интеграцию с Selenide", () -> {
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        });
        step("Устанавливаем конфигурацию", () -> {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        });
        step("Открываем тестируемый сайт в заданной конфигурации браузера", () -> {
            baseUrl = "https://google.com/";
            Configuration.browser = browserName;
            Configuration.browserVersion = browserVer;
            Configuration.browserSize = browserSize;
            Configuration.holdBrowserOpen = true;
            open(baseUrl);
        });

    }

    @AfterEach
    void addAttachments() {
        step("прикрепляем логи и отчеты выполнения", () -> {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        });
    }

    @AfterAll
    static void CloseWebDriver() {
        step("закрываем вебдрайвер", () -> {
            Selenide.closeWebDriver();
        });
    }

}

