package ui.pages.warehouseManagementSystem.suppliers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class CreateSuppliersPopup extends BasePage {
    public static SelenideElement supplierNameInput = $x("//*[contains(@id, 'suppliercreatemodel-name')]");
    public static SelenideElement supplierEmailInput = $x("//*[contains(@id, 'suppliercreatemodel-email')]");
    public static SelenideElement supplierOrgInput = $x("//*[contains(@id, 'suppliercreatemodel-org_number')]");
    public static SelenideElement supplierZipInput = $x("//*[contains(@id, 'suppliercreatemodel-zip')]");
    public static SelenideElement supplierCityInput = $x("//*[contains(@id, 'suppliercreatemodel-city')]");
    public static SelenideElement supplierAddressInput = $x("//*[contains(@id, 'suppliercreatemodel-address')]");
    public static SelenideElement supplierGroupInput = $x("//span[contains(@id, 'suppliercreatemodel-group')]");
    public static SelenideElement supplierCountryInput = $x("//span[contains(@id, 'suppliercreatemodel-country')]");
    public static SelenideElement createButton = $x("//button[contains(text(), 'Create')]");

    @Step("Type supplier name - {name}")
    public CreateSuppliersPopup supplierName(String name) {
        supplierNameInput.shouldBe(Condition.visible).click();
        supplierNameInput.sendKeys(name);
        return this;
    }

    @Step("Type supplier email - {email}")
    public CreateSuppliersPopup supplierEmail(String email) {
        supplierEmailInput.sendKeys(email);
        return this;
    }

    @Step("Type supplier org number - {number}")
    public CreateSuppliersPopup supplierOrgNumber(String number) {
        supplierOrgInput.sendKeys(number);
        return this;
    }

    @Step("Type supplier address - {address}")
    public CreateSuppliersPopup supplierAddress(String address) {
        supplierAddressInput.sendKeys(address);
        return this;
    }

    @Step("Type supplier Zip - {zip}")
    public CreateSuppliersPopup supplierZip(String zip) {
        supplierZipInput.sendKeys(zip);
        return this;
    }

    @Step("Type supplier City - {city}")
    public CreateSuppliersPopup supplierCity(String city) {
        supplierCityInput.sendKeys(city);
        return this;
    }

    @Step("Type supplier Country - {country}")
    public CreateSuppliersPopup supplierCountry(String country) {
        selectInAutocomplete(supplierCountryInput, country);
        return this;
    }

    @Step("Type supplier Group - {group}")
    public CreateSuppliersPopup supplierGroup(String group) {
        selectInAutocomplete(supplierGroupInput, group);
        return this;
    }

    @Step("click create button")
    public AllSuppliersTab clickCreateButton() {
        createButton.scrollIntoView(true);
        createButton.click();
        createButton.shouldBe(Condition.hidden);
        return new AllSuppliersTab();
    }
}
