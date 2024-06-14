package ui.pages.warehouseManagementSystem.reports;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class InstallationOrdersTab extends ReportsPage{
    public static SelenideElement headerText = $x("//h4[contains(., 'Installation Orders Reports')]");
    public static SelenideElement warehouseInput = $x("//span[contains(@id, 'selectWarehouseId')]");
    public static SelenideElement createExelReportButton = $x("//button[contains(., 'Create excel report')]");

    @Step("Create Installation Orders report")
    public InstallationOrdersTab createInstallationOrdersReport(String warehouse) {
        createReportButton.click();
        selectInAutocomplete(warehouseInput, warehouse);
        createExelReportButton.click();
        createExelReportButton.shouldBe(Condition.hidden);
        return this;
    }

    public InstallationOrdersTab verifyRowIsVisibleWithTexts(String... text) {
        super.verifyRowIsVisibleWithTexts(text);
        return this;
    }
}
