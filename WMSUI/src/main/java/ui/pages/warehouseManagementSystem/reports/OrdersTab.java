package ui.pages.warehouseManagementSystem.reports;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class OrdersTab extends ReportsPage{
    public static SelenideElement headerText = $x("//h4[contains(., 'Orders Reports')]");
    public static SelenideElement warehouseInput = $x("//span[contains(@id, 'selectWarehouseId')]");
    public static SelenideElement createExelReportButton = $x("//button[contains(., 'Create excel report')]");

    @Step("Create Orders report")
    public OrdersTab createOrdersReport(String warehouse) {
        createReportButton.click();
        selectInAutocomplete(warehouseInput, warehouse);
        createExelReportButton.click();
        createExelReportButton.shouldBe(Condition.hidden);
        return this;
    }

    public OrdersTab verifyRowIsVisibleWithTexts(String... text) {
        super.verifyRowIsVisibleWithTexts(text);
        return this;
    }
}
