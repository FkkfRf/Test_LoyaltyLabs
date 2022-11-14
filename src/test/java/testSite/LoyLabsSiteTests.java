package testSite;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoyLabsSiteTests extends BaseTest{
    @Feature("Проверка открытия страниц сайта через меню.")
    @Story("Открытие страниц через пункты верхнего меню")
    @Owner("FkkffRf")
    @Severity(SeverityLevel.BLOCKER)
    @Link(url = "https://loylabs.ru/")
    @DisplayName("Выбираем пункты верхнего меню.")
    @ValueSource(strings = {"Услуги","Проекты","Блог","О компании","Контакты"})
    @ParameterizedTest(name = "Выбран {0}")
    void openPagesFromTopMenu(String elementor) {
        open(baseUrl);
        $(byText(String.valueOf(elementor))).click();
        $("h1").shouldHave(text(String.valueOf(elementor)));
    }
    @Story("Открытие страниц раздела 'Как мы работаем' ")
    @Owner("FkkffRf")
    @Severity(SeverityLevel.BLOCKER)
    @Link(url = "https://loylabs.ru/")
    @DisplayName("Выбираем пункты меню.  ")
    @ValueSource(strings = {"Выделенная команда","Time & Material","Software as a service (SaaS)","Fixed Price"})
    @ParameterizedTest(name = "Выбран {0}")
    void openPagesFromClickableElementor(String elementor) {
        open(baseUrl);
        $(byText("Услуги")).click();
        $(byText(String.valueOf(elementor))).click();
        $("h1").shouldHave(text(String.valueOf(elementor)));
        $(byText("Все услуги →")).click();
        $("h1").shouldHave(text("Услуги"));
        $("h2").shouldHave(text("Как мы работаем"));


    }
}
