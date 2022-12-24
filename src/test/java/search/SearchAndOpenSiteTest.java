package search;

import base.BaseSearchTest;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchAndOpenSiteTest extends BaseSearchTest {
    @Feature("Поиск сайта фирмы Loyalty Labs. Открытие сайта")
    @Story("Запуск поисковика. Поисковая строка: Loyalty Labs")
    @Owner("FkkffRf")
    @Severity(SeverityLevel.BLOCKER)
    @Link(url = "https://loylabs.ru/")
    @DisplayName("Поиск сайта loylabs.ru")
    @Test
    void SearchSiteInGoogle() {

        step("Открываем поисковик google ", () -> open(baseUrl));

        step("проверяем наличие Loyalty Labs в результатах поиска", () -> {
            Selenide.clearBrowserCookies();
            Selenide.clearBrowserLocalStorage();
            $("[name=q]").setValue("Loyalty Labs").pressEnter();
            $("[id=search]").shouldHave(text("Loyalty Labs: "));
        });
        step("Открываем сайт из результатов поиска, проверяем заголовок", () -> {
            $(byText("Loyalty Labs: ")).click();
            $(".elementor-heading-title").shouldHave(text("с гарантией результата"));
        });

    }

}
