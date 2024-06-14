package ui.pages.base;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Objects;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BasePage{

    //=================Autocomplete=================
    public static SelenideElement searchInput = $x("//*[contains(@class, 'search--dropdown')]//*[contains(@class, 'search__field')]");
    public static ElementsCollection results = $$x("//li[contains(@class, 'results__option')]");
    //=================Autocomplete=================

    /**
     * Method to navigate specific url
     */
    @Step("Open page {url}")
    public void goToUrl(String url) {
        open(url);
    }

    /**
     * Clean the text field first and then enter the text
     */
    protected void clearAndType(SelenideElement element, String value) {
        while (!Objects.equals(element.getAttribute("value"), "")) {
            element.sendKeys(Keys.BACK_SPACE);
        }
        element.setValue(value);
    }

    /**
     * Check message on the page
     */
    public void checkMessage(String message) {
        $(byText(message)).shouldBe(Condition.visible);
    }

    /**
     * Wrapper for Selenide element by ID
     *
     * @return SelenideElement
     */
    public SelenideElement $id(String id) {
        return $(By.id(id));
    }

    public void selectInAutocomplete(SelenideElement element, String option){
        element.shouldBe(Condition.exist).click();
        searchInput.sendKeys(option);
        results.shouldBe(CollectionCondition.sizeGreaterThanOrEqual(1)).find(Condition.partialText(option)).click();
    }

    public <T extends BasePage> T refreshPage(Class<T> clazz){
        Selenide.refresh();
        try {
            T instanse = clazz.newInstance();
            return instanse;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
