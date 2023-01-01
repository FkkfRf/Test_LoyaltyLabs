package page;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final static String TITLE_TEXT = "Разработка IT решений";
    public static MainPage openPage() {
        open(baseUrl);
        $(".elementor-heading-title").shouldHave(text(TITLE_TEXT));
        return null;
    }
    public static MainPage clickLogoElement() {
        $(".astra-logo-svg").click();
        $(".elementor-heading-title").shouldHave(text(TITLE_TEXT));
        return null;
    }
    public static MainPage testMenuElements(String nameMenuElement){
        $$(".menu-item ").findBy(text(nameMenuElement)).click();
        return null;
    }
    public static MainPage testClickableElements(String nameClicableElement) {
        $$(".make-column-clickable-elementor").findBy(text(nameClicableElement)).click();
        return null;
    }
    public static MainPage testButtonClick(String nameButtonElement){
        $$(".elementor-button").findBy(text(nameButtonElement)).click();
        return null;
    }



}
