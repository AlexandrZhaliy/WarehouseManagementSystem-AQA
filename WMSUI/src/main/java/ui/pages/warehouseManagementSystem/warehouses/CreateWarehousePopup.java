package ui.pages.warehouseManagementSystem.warehouses;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.models.WarehousesType;
import ui.pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class CreateWarehousePopup extends BasePage {
    public static SelenideElement nameInput = $x("//*[@id='warehouse-name']");
    public static SelenideElement emailInput = $x("//*[@id='warehouse-email']");
    public static SelenideElement addressInput = $x("//*[@id='warehouse-address']");
    public static SelenideElement zipInput = $x("//*[@id='warehouse-zip']");
    public static SelenideElement cityInput = $x("//*[@id='warehouse-city']");
    public static SelenideElement numberInput = $x("//*[@id='warehouse-number']");
    public static SelenideElement groupInput = $x("//span[contains(@id, 'group_id')]");
    public static SelenideElement companyInput = $x("//span[contains(@id, 'warehouse-company_id')]");
    public static SelenideElement typeInput = $x("//span[contains(@id, 'warehouse-type')]");
    public static SelenideElement searchInput = $x("//*[contains(@class, 'search__field')]");
    public static SelenideElement saveButton = $x("//button[contains(., 'Save')]");

    @Step("Type warehouse Name - {name}")
    public CreateWarehousePopup warehouseName(String name) {
        nameInput.click();
        nameInput.shouldBe(Condition.visible).sendKeys(name);
        return this;
    }

    @Step("Type warehouse type - {type}")
    public CreateWarehousePopup warehouseType(WarehousesType type) {
        typeInput.click();
        results.find(Condition.partialText(type.getName())).click();
        return this;
    }

    @Step("Type warehouse email - {email}")
    public CreateWarehousePopup warehouseEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Type warehouse Address - {address}")
    public CreateWarehousePopup warehouseAddress(String address) {
        addressInput.sendKeys(address);
        return this;
    }

    @Step("Type warehouse Zip - {zip}")
    public CreateWarehousePopup warehouseZip(String zip) {
        zipInput.sendKeys(zip);
        return this;
    }

    @Step("Type warehouse City - {city}")
    public CreateWarehousePopup warehouseCity(String city) {
        cityInput.sendKeys(city);
        return this;
    }

    @Step("Type warehouse Number - {number}")
    public CreateWarehousePopup warehouseNumber(String number) {
        numberInput.sendKeys(number);
        return this;
    }

    @Step("Save Warehouse creation")
    public AllWarehousesTab saveWarehouseCreation() {
        saveButton.click();
        saveButton.shouldBe(Condition.hidden);
        return new AllWarehousesTab();
    }

    @Step("Type warehouse Group - {group}")
    public CreateWarehousePopup warehouseGroup(String group) {
        selectInAutocomplete(groupInput, group);
        return this;
    }

    @Step("Type warehouse Company - {company}")
    public CreateWarehousePopup warehouseCompany(String company) {
        selectInAutocomplete(companyInput, company);
        return this;
    }
}
