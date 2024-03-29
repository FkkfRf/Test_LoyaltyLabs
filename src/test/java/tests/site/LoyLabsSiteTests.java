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
@Feature("Проверка  главной страницы сайта")
@Owner("FkkfRf")
@Link(url = "https://loylabs.ru/")
public class LoyLabsSiteTests extends BaseTest {
    MainPage MainPage = new MainPage();
    @Story("Открытие страниц через пункты верхнего меню")

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

    @Story("Проверка элементов разделов")
    @DisplayName("Раздел 'В чем мы сильны'")
    @CsvFileSource(resources = "/developmentSourse.csv", numLinesToSkip = 0)
    @ParameterizedTest(name = "Выбран {0}")
    void selectDevelomentTest(String elementor, String header) {
        step("Открываем сайт", () -> {
            MainPage.openPage();
        });
        step("Кликаем элемент раздела ", () -> {
            MainPage.clickElement(elementor);
        });
        step("Проверяем название открывшейся страницы ", () -> {
            $("h1").shouldHave(text(String.valueOf(header)));
        });
    }

    @Story("Проверка элементов разделов")
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
