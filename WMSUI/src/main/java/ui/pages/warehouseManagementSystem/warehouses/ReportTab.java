package ui.pages.warehouseManagementSystem.warehouses;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ReportTab extends WarehousePage {
    public static SelenideElement totalAmountText = $x("//*[contains(@class, 'card')][./*[contains(., 'Total amount')]]//*[@class='card-body']");
    public static SelenideElement totalReservedAmountText = $x("//*[contains(@class, 'card')][./*[contains(., 'Total reserved amount')]]//*[@class='card-body']");
    public static SelenideElement archiveWarehouseButton = $x("//a[contains(., 'Archive warehouse')]");
    public static SelenideElement restoreWarehouseButton = $x("//a[contains(., 'Restore warehouse')]");

    public static String TRANSFER_UNIQUE_ARTICLES = "Transfer (Unique articles)";
    public static String DEPRECIATE_UNIQUE_ARTICLES = "Depreciate from warehouseManagementSystem";

    @Step("verify 'Total amount' is - {amount}")
    public ReportTab verifyTotalAmountIs(String amount) {
        totalAmountText.shouldHave(Condition.text(amount));
        return this;
    }
    @Step("restore warehouse")
    public AllWarehousesTab restoreWarehouse() {
        restoreWarehouseButton.click();
        Selenide.confirm();
        return new AllWarehousesTab();
    }
    @Step("archive warehouse")
    public AllWarehousesTab archiveWarehouse() {
        archiveWarehouseButton.click();
        Selenide.confirm();
        return new AllWarehousesTab();
    }

    @Step("archive warehouse with error")
    public WarehouseArchiveRestrictionsPage archiveWarehouseWithError() {
        archiveWarehouseButton.click();
        Selenide.confirm();
        return new WarehouseArchiveRestrictionsPage();
    }
    @Step("verify 'Total reserved amount' is - {amount}")
    public ReportTab verifyTotalReservedAmountIs(String amount) {
        totalReservedAmountText.shouldHave(Condition.text(amount));
        return this;
    }
    public ReportTab verifyRowIsVisibleWithTexts(String... text) {
        super.verifyRowIsVisibleWithTexts(text);
        return this;
    }


}
