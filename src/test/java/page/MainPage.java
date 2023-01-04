package page;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final static String TITLE_TEXT = "Разработка IT решений";
    public MainPage openPage() {
        open(baseUrl);
        $(".elementor-heading-title").shouldHave(text(TITLE_TEXT));
        return this;
    }
    public MainPage clickLogoElement() {
        $(".astra-logo-svg").click();
        $(".elementor-heading-title").shouldHave(text(TITLE_TEXT));
        return this;
    }
    public MainPage clickMenuElement(String nameMenuElement){
        $$(".menu-item ").findBy(text(nameMenuElement)).click();
        return this;
    }
    public MainPage clickElement(String nameClicableElement) {
        $$(".make-column-clickable-elementor").findBy(text(nameClicableElement)).click();
        return this;
    }
    public MainPage clickButton(String nameButtonElement){
        $$(".elementor-button").findBy(text(nameButtonElement)).click();
        return this;
    }
}
