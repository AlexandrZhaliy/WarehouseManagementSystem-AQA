package ui.pages.warehouseManagementSystem.articles;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.models.ArticleStatus;

import static com.codeborne.selenide.Selenide.$x;

public class InformationTab extends ArticlePage {
    public static SelenideElement storageUnitInput = $x("//span[contains(@id, 'article-unit_id')]");
    public static SelenideElement saveButton = $x("//button[contains(.,'Save')]");

    @Step("Select Storage Unit - {storageUnit}")
    public InformationTab selectStorageUnit(String storageUnit) {
        selectInAutocomplete(storageUnitInput, storageUnit);
        return this;
    }

    @Step("click Save button")
    public InformationTab saveArticle(){
        saveButton.click();
        return this;
    }
}
