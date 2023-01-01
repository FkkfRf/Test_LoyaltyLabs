package tests.site;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import page.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class LoyLabsSiteTests extends BaseTest {
    @Feature("Проверка главной страницы сайта")
    @Story("Открытие страниц через пункты верхнего меню")
    @Owner("FkkfRf")
    @Link(url = "https://loylabs.ru/")
    @DisplayName("Главное меню: ")
    @ValueSource(strings = {"Услуги", "Проекты", "Блог", "О компании", "Контакты"})
    @ParameterizedTest(name = "Выбран {0}")
    void openPagesFromTopMenu(String elementor) {
        step("Открываем тестируемый сайт в заданной конфигурации браузера", () -> {
            MainPage.openPage();
            MainPage.testMenuElements(elementor);
            $("h1").shouldHave(text(String.valueOf(elementor)));
            MainPage.clickLogoElement();
            MainPage.testButtonClick("Заказать бесплатную консультацию");
        });
    }
    @Feature("Проверка главной страницы сайта")
    @Story("Раздел 'В чем мы сильны'")
    @Owner("FkkfRf")
    @Link(url = "https://loylabs.ru/")
    @DisplayName("Разработка IT решений")
    @CsvFileSource(resources = "/developmentSourse.csv", numLinesToSkip = 0)
    @ParameterizedTest(name = "Выбран {0} {1}")
    void selectDevelomentTest(String elementor, String header) {
        MainPage.openPage();
        MainPage.testClickableElements(elementor);
        $("h1").shouldHave(text(String.valueOf(header)));
        MainPage.clickLogoElement();
    }
    @Feature("Проверка главной страницы сайта")
    @Story("Раздел 'Проекты'")
    @Owner("FkkfRf")
    @Link(url = "https://loylabs.ru/")
    @DisplayName("Разработка IT решений")
    @Test
    void selectProjectsTest() {
        MainPage.openPage();
        MainPage.testButtonClick("Все проекты");
        MainPage.clickLogoElement();
    }
}
