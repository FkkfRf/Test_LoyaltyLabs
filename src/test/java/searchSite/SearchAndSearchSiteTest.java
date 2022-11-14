package searchSite;

import base.BaseSearchTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchAndSearchSiteTest extends BaseSearchTest {
    @Feature("Поиск сайта фирмы Loyalty Labs. Открытие сайта")
    @Story("Запуск поисковика. Поисковая строка: Loyalty Labs")
    @Owner("FkkffRf")
    @Severity(SeverityLevel.BLOCKER)
    @Link(url = "https://loylabs.ru/")
    @DisplayName("Поиск сайта loylabs.ru")
    @Test
    void SearchSiteInGoogle() {
        step("Открываем поисковик google ", () -> {


        });
        step("проверяем наличие Loyalty Labs в результатах поиска", () -> {
            $("[name=q]").setValue("Loyalty Labs").pressEnter();
            $("[id=search]").shouldHave(text("Loyalty Labs: Разработка IT решений для бизнеса на заказ"));
        });
        step("Открываем сайт из результатов поиска, проверяем заголовок", () -> {
            $(byText("Loyalty Labs: Разработка IT решений для бизнеса на заказ")).click();
            $(".elementor-heading-title").shouldHave(text("с гарантией результата"));
        });

    }

}
