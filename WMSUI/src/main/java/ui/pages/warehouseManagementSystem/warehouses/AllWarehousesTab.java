package ui.pages.warehouseManagementSystem.warehouses;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class AllWarehousesTab extends WarehousesPage {
    public static SelenideElement createWarehouseButton = $x("//button[contains(., 'Create warehouse')]");
    public static String warehouseWithNameXpath = "//td[contains(., '%s')]";

    @Step("Click on Create Warehouse button")
    public CreateWarehousePopup clickOnCreateWarehouse(){
        createWarehouseButton.click();
        return new CreateWarehousePopup();
    }

    @Step("open warehouse in table using name - {name}")
    public ReportTab openWarehouseWithText(String name){
        $x(format(warehouseWithNameXpath, name)).click();
        return new ReportTab();
    }

    @Step("verify Row with text is NOT visible in table - {text}")
    public AllWarehousesTab verifyWarehouseWithTextIsNotVisible(String text) {
        $x(format(warehouseWithNameXpath, text)).shouldNotBe(Condition.exist);
        return this;
    }

    @Step("verify Row with text is visible in table - {text}")
    public AllWarehousesTab verifyWarehouseWithTextIsVisible(String text) {
        $x(format(warehouseWithNameXpath, text)).shouldBe(Condition.exist);
        return this;
    }
    @Step("verify 'alert success' text is - {text}")
    public AllWarehousesTab verifyAlertTextIsVisible(String text) {
        super.alertText.shouldHave(text(text));
        return new AllWarehousesTab();
    }
}
