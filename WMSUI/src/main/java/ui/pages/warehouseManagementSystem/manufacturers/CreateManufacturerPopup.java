package ui.pages.warehouseManagementSystem.manufacturers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.base.BasePage;
import ui.pages.warehouseManagementSystem.suppliers.AllSuppliersTab;

import static com.codeborne.selenide.Selenide.$x;

public class CreateManufacturerPopup extends BasePage {

    public static SelenideElement nameInput = $x("//*[contains(@id, 'manufacturermodel-name')]");
    public static SelenideElement groupInput = $x("//span[contains(@id, 'manufacturermodel-group_id')]");
    public static SelenideElement saveButton = $x("//button[contains(text(), 'Save')]");

    @Step("Type Manufacturer name - {name}")
    public CreateManufacturerPopup manufacturerName(String name) {
        nameInput.shouldBe(Condition.visible).click();
        nameInput.sendKeys(name);
        return this;
    }

    @Step("Type Manufacturer Group - {group}")
    public CreateManufacturerPopup manufacturerGroup(String group) {
        selectInAutocomplete(groupInput, group);
        return this;
    }

    @Step("click 'Save' button")
    public AllManufacturersTab clickSaveButton() {
        saveButton.click();
        saveButton.shouldBe(Condition.hidden);
        return new AllManufacturersTab();
    }
}
