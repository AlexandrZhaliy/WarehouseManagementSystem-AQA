package ui.pages.warehouseManagementSystem.trackerDevices;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;
import ui.pages.warehouseManagementSystem.vehicleRegistrationNumber.VehicleRegistrationNumberPage;

import static com.codeborne.selenide.Selenide.$x;

public class CreateGroupTrackerDevicesPage extends warehouseManagementSystemMainPage {
    public static SelenideElement saveButton = $x("//button[text()='Save']");
    public static SelenideElement linkButton = $x("//button[text()='Link']");

    public static SelenideElement frontBleTrackerInput = $x("//span[contains(@id, 'trackerdevicesform-front_tracker')]");
    public static SelenideElement rearBleTrackerInput = $x("//span[contains(@id, 'trackerdevicesform-rear_tracker')]");
    public static SelenideElement onboardingGpsTrackerInput = $x("//span[contains(@id, 'trackerdevicesform-gps_tracker')]");

    @Step("Select Front Ble Tracker - {tracker}")
    public CreateGroupTrackerDevicesPage selectGpsTracker(String tracker) {
        selectInAutocomplete(onboardingGpsTrackerInput, tracker);
        return this;
    }
    @Step("Select Front Ble Tracker - {tracker}")
    public CreateGroupTrackerDevicesPage selectFrontBleTracker(String tracker) {
        selectInAutocomplete(frontBleTrackerInput, tracker);
        return this;
    }

    @Step("Select Rear Ble Tracker - {tracker}")
    public CreateGroupTrackerDevicesPage selectRearBleTracker(String tracker) {
        selectInAutocomplete(rearBleTrackerInput, tracker);
        return this;
    }

    @Step("click Save button")
    public GroupTrackerDevicesPage clickSaveButton(){
        saveButton.click();
        Selenide.sleep(2000);
        return new GroupTrackerDevicesPage();
    }

    @Step("click Link button")
    public VehicleRegistrationNumberPage clickLinkButton(){
        linkButton.click();
        Selenide.sleep(2000);
        return new VehicleRegistrationNumberPage();
    }
}
