package ui.pages.warehouseManagementSystem.storageUnits;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.base.BasePage;
import ui.pages.warehouseManagementSystem.manufacturers.AllManufacturersTab;

import static com.codeborne.selenide.Selenide.$x;

public class CreateStorageUnitPopup extends BasePage {

    public static SelenideElement valueInput = $x("//*[contains(@id, 'unitmodel-value')]");
    public static SelenideElement saveButton = $x("//button[contains(text(), 'Save')]");

    @Step("Type 'Value' - {name}")
    public CreateStorageUnitPopup storageUnitValue(String name) {
        valueInput.shouldBe(Condition.visible).click();
        valueInput.sendKeys(name);
        return this;
    }

    @Step("click 'Save' button")
    public AllUnitsTab clickSaveButton() {
        saveButton.click();
        saveButton.shouldBe(Condition.hidden);
        return new AllUnitsTab();
    }
}
