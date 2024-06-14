package ui.pages.warehouseManagementSystem.warehouses;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;
import ui.pages.warehouseManagementSystem.articles.InformationTab;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class WarehouseArchiveRestrictionsPage extends warehouseManagementSystemMainPage {
    public static SelenideElement alertText = $x("//*[contains(@class, 'alert-warning')]");
    public static String articleWithNameXpath = "//td[contains(., '%s')]";


    @Step("verify 'alert error' text is - {text}")
    public WarehouseArchiveRestrictionsPage verifyAlertTextIsVisible(String text) {
        alertText.shouldHave(text(text));
        return this;
    }


    @Step("verify Row with text is visible in table - {text}")
    public WarehouseArchiveRestrictionsPage verifyArticleWithTextIsVisible(String text) {
        $x(format(articleWithNameXpath, text)).shouldBe(Condition.visible);
        return this;
    }

    @Step("open Article with text - {text}")
    public InformationTab openArticleWithName(String text) {
        $x(format(articleWithNameXpath, text)).click();
        return new InformationTab();
    }

}
