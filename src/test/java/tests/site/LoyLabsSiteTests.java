package tests.site;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import page.Page;

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
        step("Открываем сайт в заданной конфигурации браузера", () -> {
            Page.openPage();
        });
        step("проверяем выбор элемента", () -> {
            Page.testMenuElements(elementor);
            $("h1").shouldHave(text(String.valueOf(elementor)));
            Page.clickLogoElement();
            Page.testButtonClick("Заказать бесплатную консультацию");
        });
    }

    @Feature("Проверка главной страницы сайта")
    @Story("Проверка элементов разделов")
    @Owner("FkkfRf")
    @Link(url = "https://loylabs.ru/")
    @DisplayName("'В чем мы сильны'")
    @CsvFileSource(resources = "/developmentSourse.csv", numLinesToSkip = 0)
    @ParameterizedTest(name = "Выбран {0} {1}")
    void selectDevelomentTest(String elementor, String header) {
        step("Открываем сайт в заданной конфигурации браузера", () -> {
            Page.openPage();
        });
        step("Проверяем выбор элемента", () -> {
            Page.testClickableElements(elementor);
            $("h1").shouldHave(text(String.valueOf(header)));
            Page.clickLogoElement();
        });
    }

    @Feature("Проверка главной страницы сайта")
    @Story("Проверка элементов разделов")
    @Owner("FkkfRf")
    @Link(url = "https://loylabs.ru/")
    @DisplayName("Раздел 'Проекты'")
    @Test
    void selectProjectsTest() {
        step("Открываем сайт в заданной конфигурации браузера", () -> {
            Page.openPage();
        });
        step("Проверяем выбор элемента", () -> {
            Page.testButtonClick("Все проекты");
            Page.clickLogoElement();
        });
    }
}
