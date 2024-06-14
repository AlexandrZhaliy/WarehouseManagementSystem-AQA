package ui.pages.warehouseManagementSystem.trackerDevices;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;
import ui.pages.warehouseManagementSystem.vehicleRegistrationNumber.CreateVehicleRegistrationNumberPage;

import static com.codeborne.selenide.Selenide.$x;

public class GroupTrackerDevicesPage extends warehouseManagementSystemMainPage {
    public static SelenideElement createNewGroupButton = $x("//a[contains(., 'Create new group')]");
    @Step("click Create New Group button")
    public CreateGroupTrackerDevicesPage clickCreateNewGroupButton(){
        createNewGroupButton.click();
        return new CreateGroupTrackerDevicesPage();
    }
}
