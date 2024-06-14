package ui.pages.warehouseManagementSystem.companies;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;
import ui.pages.warehouseManagementSystem.articles.InformationTab;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class CompanyArchiveRestrictionsPage extends warehouseManagementSystemMainPage {
    public static SelenideElement alertText = $x("//*[contains(@class, 'alert-warning')]");
    public static String warehouseWithNameXpath = "//td[contains(., '%s')]";


    @Step("verify 'alert error' text is - {text}")
    public CompanyArchiveRestrictionsPage verifyAlertTextIsVisible(String text) {
        alertText.shouldHave(text(text));
        return this;
    }


    @Step("verify Row with text is visible in table - {text}")
    public CompanyArchiveRestrictionsPage verifyWarehouseWithTextIsVisible(String text) {
        $x(format(warehouseWithNameXpath, text)).shouldBe(Condition.visible);
        return this;
    }

    @Step("open Warehouse with text - {text}")
    public InformationTab openWarehouseWithName(String text) {
        $x(format(warehouseWithNameXpath, text)).click();
        return new InformationTab();
    }

}
