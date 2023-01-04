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
    MainPage MainPage = new MainPage();

    @Feature("Проверка главной страницы сайта")
    @Story("Открытие страниц через пункты верхнего меню")
    @Owner("FkkfRf")
    @Link(url = "https://loylabs.ru/")
    @DisplayName("Главное меню: ")
    @ValueSource(strings = {"Услуги", "Проекты", "Блог", "О компании", "Контакты"})
    @ParameterizedTest(name = "Выбран {0}")
    void openPagesFromTopMenu(String elementor) {
        step("Открываем сайт", () -> {
            MainPage.openPage();
        });
        step("Кликаем элемент меню", () -> {
            MainPage.clickMenuElement(elementor);
        });
        step("Проверяем название открывшейся страницы", () -> {
            $("h1").shouldHave(text(String.valueOf(elementor)));
        });
    }

    @Feature("Проверка главной страницы сайта")
    @Story("Проверка элементов разделов")
    @Owner("FkkfRf")
    @Link(url = "https://loylabs.ru/")
    @DisplayName("Раздел 'В чем мы сильны'")
    @CsvFileSource(resources = "/developmentSourse.csv", numLinesToSkip = 0)
    @ParameterizedTest(name = "Выбран {0}")
    void selectDevelomentTest(String elementor, String header) {
        step("Открываем сайт", () -> {
            MainPage.openPage();
        });
        step("Кликаем элемент раздела", () -> {
            MainPage.clickElement(elementor);
        });
        step("Проверяем название открывшейся страницы", () -> {
            $("h1").shouldHave(text(String.valueOf(header)));
        });
    }

    @Feature("Проверка главной страницы сайта")
    @Story("Проверка элементов разделов")
    @Owner("FkkfRf")
    @Link(url = "https://loylabs.ru/ ")
    @DisplayName(" Раздел 'Проекты'")
    @Test
    void selectProjectsFromButtonTest() {
        step("Открываем сайт", () -> {
            MainPage.openPage();
        });
        step("Кликаем кнопку 'Все проекты'", () -> {
            MainPage.clickButton("Все проекты");
        });
        step("Проверяем название открывшейся страницы ", () -> {
            $("h1").shouldHave(text("Проекты"));
        });
    }
}
