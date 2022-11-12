package testSite;

import base.BaseTest;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoyLabsSiteTests extends BaseTest{
    @ValueSource(strings = {"Услуги","Проекты","Блог","О компании","Контакты"})
    @DisplayName("Выбираем пункт меню ")
    @ParameterizedTest(name = "Выбран {0}")
    void setCityOnWorldWeatherSite(String elementor) {
        $(byText(String.valueOf(elementor))).click();
        $(byText(String.valueOf(elementor))).shouldHave(new Text(elementor));
    }
}
