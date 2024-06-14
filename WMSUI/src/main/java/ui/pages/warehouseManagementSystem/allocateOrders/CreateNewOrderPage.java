package ui.pages.warehouseManagementSystem.allocateOrders;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.models.PlateShape;
import ui.models.VehicleType;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;
import utils.Utils;

import static com.codeborne.selenide.Selenide.$x;

public class CreateNewOrderPage extends warehouseManagementSystemMainPage {
    public static SelenideElement allocateButton = $x("//button[text()='Allocate']");
    public static SelenideElement addNewVinButton = $x("//button[@id='addNewVinButton']");
    public static SelenideElement serviceTypeInput = $x("//span[contains(@id, 'allocateordercreateform-service_type')]");
    public static SelenideElement newVinInput = $x("//input[contains(@id, 'allocateordercreateform-vin')]");
    public static SelenideElement tinInput = $x("//input[contains(@id, 'allocateordercreateform-tin')]");
    public static SelenideElement applicationReferenceNumberInput = $x("//input[contains(@id, 'allocateordercreateform-applicationreferencenumber')]");

    public static SelenideElement warehouseInput = $x("//span[contains(@id, 'allocateordercreateform-warehouse_id')]");
    public static SelenideElement registrationPlateCategoryInput = $x("//span[contains(@id, 'allocateordercreateform-platecategory')]");
    public static SelenideElement vehicleTypeInput = $x("//span[contains(@id, 'allocateordercreateform-vehicletype')]");
    public static SelenideElement frontPlateInput = $x("//span[contains(@id, 'allocateordercreateform-frontshape')]");
    public static SelenideElement registrationPlateInput = $x("//span[contains(@id, 'allocateordercreateform-installation_kit_id')]");
    public static SelenideElement rearPlateInput = $x("//span[contains(@id, 'allocateordercreateform-rearshape')]");
    public static SelenideElement registrationNumberInput = $x("//span[contains(@id, 'allocateordercreateform-installation_kit_id')]");

    @Step("Select Front plate shape - {plate}")
    public CreateNewOrderPage selectFrontPlateShape(PlateShape plate) {
        selectInAutocomplete(frontPlateInput, plate.getName());
        return this;
    }

    @Step("Select Registration plate - {plate}")
    public CreateNewOrderPage selectRegistrationPlate(String plate) {
        selectInAutocomplete(registrationPlateInput, plate);
        return this;
    }

    @Step("Select Rear plate shape - {plate}")
    public CreateNewOrderPage selectRearPlateShape(PlateShape plate) {
        selectInAutocomplete(rearPlateInput, plate.getName());
        return this;
    }
    @Step("Select Service Type - {type}")
    public CreateNewOrderPage selectServiceType(String type) {
        selectInAutocomplete(serviceTypeInput, type);
        return this;
    }
    @Step("Select Warehouse - {warehouse}")
    public CreateNewOrderPage selectWarehouse(String warehouse) {
        Selenide.sleep(2000);
        warehouseInput.scrollIntoView(false);
        selectInAutocomplete(warehouseInput, warehouse);
        return this;
    }

    @Step("Select 'Registration Plate Category' - {category}")
    public CreateNewOrderPage selectRegistrationPlateCategory(String category) {
        selectInAutocomplete(registrationPlateCategoryInput, category);
        return this;
    }

    @Step("Select 'Vehicle Type' - {type}")
    public CreateNewOrderPage selectVehicleType(VehicleType type) {
        selectInAutocomplete(vehicleTypeInput, type.getName());
        return this;
    }

    @Step("Select Registration Number - {regNumber}")
    public CreateNewOrderPage selectRegistrationNumber(String regNumber) {
        selectInAutocomplete(registrationNumberInput, regNumber);
        return this;
    }

    @Step("Type VIN Number - {vinNumber}")
    public CreateNewOrderPage typeVin(String vinNumber) {
        newVinInput.click();
        newVinInput.sendKeys(vinNumber);
        return this;
    }

    @Step("Type TIN Number - {number}")
    public CreateNewOrderPage typeTin(String number) {
        tinInput.sendKeys(number);
        return this;
    }

    @Step("Type 'Application Reference Number'")
    public CreateNewOrderPage typeApplicationReferenceNumber() {
        applicationReferenceNumberInput.sendKeys(String.valueOf(Utils.getAbsRandomInt()));
        return this;
    }
    @Step("click Allocate button")
    public AllocateAllOrdersTab clickAllocateButton(){
        allocateButton.scrollIntoView(true).click();
        allocateButton.shouldNotBe(Condition.visible);
        return new AllocateAllOrdersTab();
    }

    @Step("click Add new Vin button")
    public CreateNewOrderPage clickAddNewVinButton(){
        addNewVinButton.click();
        return this;
    }
}
