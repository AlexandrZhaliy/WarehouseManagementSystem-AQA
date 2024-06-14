package ui.pages.warehouseManagementSystem.installationKits;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;
import ui.pages.warehouseManagementSystem.trackerDevices.GroupTrackerDevicesPage;
import ui.pages.warehouseManagementSystem.vehicleRegistrationNumber.CreateVehicleRegistrationNumberPage;

import static com.codeborne.selenide.Selenide.$x;

public class CreateInstallationKitPage extends WarehouseManagementSystemMainPage {
    public static SelenideElement saveButton = $x("//button[text()='Save']");
    public static SelenideElement frontBleTrackerInput = $x("//span[contains(@id, 'installationkitcreateform-front_tracker_id')]");
    public static SelenideElement rearBleTrackerInput = $x("//span[contains(@id, 'installationkitcreateform-rear_tracker_id')]");

    public static SelenideElement frontPlateInput = $x("//span[contains(@id, 'installationkitcreateform-front_license_plate_id')]");
    public static SelenideElement rearPlateInput = $x("//span[contains(@id, 'installationkitcreateform-rear_license_plate_id')]");
    public static SelenideElement onboardingGpsTrackerInput = $x("//span[contains(@id, 'installationkitcreateform-gps_tracker_id')]");

    @Step("Select Front plate - {plate}")
    public CreateInstallationKitPage selectFrontPlate(String plate) {
        selectInAutocomplete(frontPlateInput, plate);
        return this;
    }

    @Step("Select Rear plate - {plate}")
    public CreateInstallationKitPage selectRearPlate(String plate) {
        selectInAutocomplete(rearPlateInput, plate);
        return this;
    }
    @Step("Select GPS Tracker - {tracker}")
    public CreateInstallationKitPage selectGpsTracker(String tracker) {
        selectInAutocomplete(onboardingGpsTrackerInput, tracker);
        return this;
    }
    @Step("Select Front Ble Tracker - {tracker}")
    public CreateInstallationKitPage selectFrontBleTracker(String tracker) {
        selectInAutocomplete(frontBleTrackerInput, tracker);
        return this;
    }

    @Step("Select Rear Ble Tracker - {tracker}")
    public CreateInstallationKitPage selectRearBleTracker(String tracker) {
        selectInAutocomplete(rearBleTrackerInput, tracker);
        return this;
    }

    @Step("click Save button")
    public InstallationKitsPage clickSaveButton(){
        saveButton.click();
        saveButton.shouldBe(Condition.hidden);
        return new InstallationKitsPage();
    }
}
