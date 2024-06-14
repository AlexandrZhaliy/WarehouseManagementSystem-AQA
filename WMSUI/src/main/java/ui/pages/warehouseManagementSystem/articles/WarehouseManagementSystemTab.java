package ui.pages.warehouseManagementSystem.articles;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class warehouseManagementSystemTab extends ArticlePage {

    public static SelenideElement editButton = $x("//button[contains(@id, 'warehouseManagementSystemEdit')]");
    public static SelenideElement inputMinimumQuantity = $x("//input[contains(@id, 'minimum_quantity')]");
    public static SelenideElement messageCreatedNewWarehouseManagementSystem = $x("//*[contains(@id, 'success')]");
    public static SelenideElement inputCriticalQuantity = $x("//input[contains(@id, 'critical_quantity')]");
    public static SelenideElement inputConsolidatedWarehouse = $x("//*[contains(@id, 'consolidatedWarehouseIdSelect-container')]");

    public static SelenideElement saveButton = $x("//button[contains(@id, 'warehouseManagementSystemSave')]");
    public static SelenideElement resetButton = $x("//button[contains(@id, 'resetToggleButton')]");
    public static SelenideElement addWarehouseButton = $x("//button[contains(text(), 'Add Warehouse')]");
    public static SelenideElement selectWarehouseManagementSystemSpecificWarehouseForm = $x("//*[@id='warehouseManagementSystemSpecificWarehouseForm']//span[contains(@class, 'select2-selection__rendered')]");
    public static SelenideElement modalInputMinimumQuantity = $x("//input[contains(@id, 'warehouseManagementSystemspecificwarehouseform-minimum_quantity')]");
    public static SelenideElement modalInputCriticalQuantity = $x("//input[contains(@id, 'warehouseManagementSystemspecificwarehouseform-critical_quantity')]");
    public static SelenideElement modalFormSubmit = $x("//button[contains(@type, 'submit') and contains(text(), 'Add')]");


    @Step("Verify after created new warehouseManagementSystem control message is visible with text: {expectedText}")
    public warehouseManagementSystemTab createdNewwarehouseManagementSystemMessage(String expectedText) {
        messageCreatedNewwarehouseManagementSystem.shouldHave(Condition.exactText(expectedText));
        return this;
    }

    @Step("Select warehouse - {name}")
    public warehouseManagementSystemTab selectWarehousewarehouseManagementSystem(String name) {
        selectInAutocomplete(inputConsolidatedWarehouse, name);
        return this;
    }

    @Step("Type amount - {amount}")
    public warehouseManagementSystemTab typeMinimumQuantityInputwarehouseManagementSystem(String amount) {
        inputMinimumQuantity.sendKeys(amount);
        return this;
    }

    @Step("Type amount - {amount}")
    public warehouseManagementSystemTab typeCriticalQuantityInputwarehouseManagementSystem(String amount) {
        inputCriticalQuantity.sendKeys(amount);
        return this;
    }

    @Step("Select warehouse - {name}")
    public warehouseManagementSystemTab selectWarehousewarehouseManagementSystemModal(String name) {
        selectInAutocomplete(selectwarehouseManagementSystemSpecificWarehouseForm, name);
        return this;
    }

    @Step("Type amount - {amount}")
    public warehouseManagementSystemTab typeModalMinimumQualitywarehouseManagementSystem(String amount) {
        modalInputMinimumQuantity.sendKeys(amount);
        return this;
    }

    @Step("Type amount - {amount}")
    public warehouseManagementSystemTab typeModalCriticalQualitywarehouseManagementSystem(String amount) {
        modalInputCriticalQuantity.sendKeys(amount);
        return this;
    }

    @Step("Click 'Edit' button")
    public warehouseManagementSystemTab clickEditButton() {
        editButton.click();
        return this;
    }

    @Step("Click 'Reset button' button")
    public warehouseManagementSystemTab clickResetButton() {
        resetButton.click();
        return this;
    }

    @Step("Click 'Add warehouse button' button")
    public warehouseManagementSystemTab clickAddWarehouseButton() {
        addWarehouseButton.click();
        return this;
    }

    @Step("Click 'Save button' button")
    public warehouseManagementSystemTab clickSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("Click 'Add' button")
    public warehouseManagementSystemTab modalAddButtonClick() {
        modalFormSubmit.click();
        return this;
    }
}
