package ui.pages.warehouseManagementSystem.companies;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class CreateOwnCompanyPopup extends BasePage {
    public static SelenideElement companyNameInput = $x("//*[contains(@id, 'company_name')]");
    public static SelenideElement companyEmailInput = $x("//*[contains(@id, 'company_email')]");
    public static SelenideElement companyOrgNumberInput = $x("//*[contains(@id, 'org_number')]");
    public static SelenideElement companyAddressInput = $x("//*[contains(@id, 'company_address')]");
    public static SelenideElement companyZipInput = $x("//*[contains(@id, 'company_zip')]");
    public static SelenideElement companyCityInput = $x("//*[contains(@id, 'company_city')]");
    public static SelenideElement companyCountryInput = $x("//span[contains(@id, 'company_country')]");
    public static SelenideElement companyGroupInput = $x("//span[contains(@id, 'company_group')]");

    public static SelenideElement warehouseNameInput = $x("//*[contains(@id, 'warehouse_name')]");
    public static SelenideElement warehouseEmailInput = $x("//*[contains(@id, 'warehouse_email')]");
    public static SelenideElement warehouseAddressInput = $x("//*[contains(@id, 'warehouse_address')]");
    public static SelenideElement warehouseZipInput = $x("//*[contains(@id, 'warehouse_zip')]");
    public static SelenideElement warehouseCityInput = $x("//*[contains(@id, 'warehouse_city')]");
    public static SelenideElement warehouseNumberInput = $x("//*[contains(@id, 'designation_number')]");
    public static SelenideElement warehouseGroupInput = $x("//span[contains(@id, 'warehouse_group')]");
    public static SelenideElement warehouseTypeInput = $x("//span[contains(@id, 'warehouse_type')]");
    public static SelenideElement createButton = $x("//button[contains(text(), 'Create')]");

    @Step("Type company name - {name}")
    public CreateOwnCompanyPopup companyName(String name) {
        companyNameInput.shouldBe(Condition.visible).click();
        companyNameInput.sendKeys(name);
        return this;
    }

    @Step("Type company email - {email}")
    public CreateOwnCompanyPopup companyEmail(String email) {
        companyEmailInput.sendKeys(email);
        return this;
    }

    @Step("Type company org number - {number}")
    public CreateOwnCompanyPopup companyOrgNumber(String number) {
        companyOrgNumberInput.sendKeys(number);
        return this;
    }

    @Step("Type company address - {address}")
    public CreateOwnCompanyPopup companyAddress(String address) {
        companyAddressInput.sendKeys(address);
        return this;
    }

    @Step("Type company Zip - {zip}")
    public CreateOwnCompanyPopup companyZip(String zip) {
        companyZipInput.sendKeys(zip);
        return this;
    }

    @Step("Type company City - {city}")
    public CreateOwnCompanyPopup companyCity(String city) {
        companyCityInput.sendKeys(city);
        return this;
    }

    @Step("Type company Country - {country}")
    public CreateOwnCompanyPopup companyCountry(String country) {
        selectInAutocomplete(companyCountryInput, country);
        return this;
    }

    @Step("Type company Group - {group}")
    public CreateOwnCompanyPopup companyGroup(String group) {
        selectInAutocomplete(companyGroupInput, group);
        return this;
    }

    @Step("Type warehouse Name - {name}")
    public CreateOwnCompanyPopup warehouseName(String name) {
        warehouseNameInput.sendKeys(name);
        return this;
    }

    @Step("Type warehouse Type - {type}")
    public CreateOwnCompanyPopup warehouseType(String type) {
        selectInAutocomplete(warehouseTypeInput, type);
        return this;
    }

    @Step("Type warehouse Email - {email}")
    public CreateOwnCompanyPopup warehouseEmail(String email) {
        warehouseEmailInput.sendKeys(email);
        return this;
    }

    @Step("Type warehouse Address - {address}")
    public CreateOwnCompanyPopup warehouseAddress(String address) {
        warehouseAddressInput.sendKeys(address);
        return this;
    }

    @Step("Type warehouse Zip - {zip}")
    public CreateOwnCompanyPopup warehouseZip(String zip) {
        warehouseZipInput.sendKeys(zip);
        return this;
    }

    @Step("Type warehouse City - {city}")
    public CreateOwnCompanyPopup warehouseCity(String city) {
        warehouseCityInput.sendKeys(city);
        return this;
    }

    @Step("Type warehouse Number - {number}")
    public CreateOwnCompanyPopup warehouseNumber(String number) {
        warehouseNumberInput.sendKeys(number);
        return this;
    }

    @Step("Type warehouse Group - {group}")
    public CreateOwnCompanyPopup warehouseGroup(String group) {
        selectInAutocomplete(warehouseGroupInput, group);
        return this;
    }

    @Step("click create button")
    public AllCompaniesTab clickCreateButton() {
        createButton.click();
        Selenide.sleep(2000);
        return new AllCompaniesTab();
    }
}
