package ui.pages.warehouseManagementSystem.reports;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class WarehousesTab extends ReportsPage{
    public static SelenideElement headerText = $x("//h4[contains(., 'Warehouses Reports')]");
    public static SelenideElement warehouseInput = $x("//span[contains(@id, 'selectWarehouseId')]");
    public static SelenideElement createExelReportButton = $x("//button[contains(., 'Create excel report')]");

    @Step("Create Warehouse report")
    public WarehousesTab createWarehouseReport(String warehouse) {
        createReportButton.click();
        selectInAutocomplete(warehouseInput, warehouse);
        createExelReportButton.click();
        createExelReportButton.shouldBe(Condition.hidden);
        return this;
    }

    public WarehousesTab verifyRowIsVisibleWithTexts(String... text) {
        super.verifyRowIsVisibleWithTexts(text);
        return this;
    }
    @Step("verify Downloaded File Has Name - {name}")
    public WarehousesTab verifyDownloadedFileWithTextHasName(String name, String... text){
        File downloadedFile;
        try {
            downloadedFile = $x(super.getRowWithTextXpath(text) + "//a").download();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(downloadedFile.getName().contains(name), "Assert failed real file name is - " + downloadedFile.getName());
        return this;
    }
}
