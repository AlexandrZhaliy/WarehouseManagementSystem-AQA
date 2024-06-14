package ui.pages.warehouseManagementSystem.installationOrders;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;
import ui.pages.warehouseManagementSystem.installationKits.InstallationKitsPage;

import static com.codeborne.selenide.Selenide.$x;

public class InstallationOrderPage extends warehouseManagementSystemMainPage {
    public static SelenideElement saveAndContinueButton = $x("//button[text()='Save and continue']");
    public static SelenideElement reportDefectButton = $x("//a[text()='Report Defect']");
    public static SelenideElement frontPlateInput = $x("//span[contains(@id, 'installationorderform-front_license_plate_id')]");
    public static SelenideElement rearPlateInput = $x("//span[contains(@id, 'installationorderform-back_license_plate_id')]");
    public static SelenideElement gpsTrackerInput = $x("//span[contains(@id, 'installationorderform-tracker_id')]");

    @Step("Select Front plate - {plate}")
    public InstallationOrderPage selectFrontPlate(String plate) {
        selectInAutocomplete(frontPlateInput, plate);
        return this;
    }

    @Step("Select Rear plate - {plate}")
    public InstallationOrderPage selectRearPlate(String plate) {
        selectInAutocomplete(rearPlateInput, plate);
        return this;
    }
    @Step("Select GPS Tracker - {tracker}")
    public InstallationOrderPage selectGpsTracker(String tracker) {
        selectInAutocomplete(gpsTrackerInput, tracker);
        return this;
    }

    @Step("click Save And Continue button")
    public ApproveInstallationOrderPage clickSaveAndContinueButton(){
        saveAndContinueButton.click();
        Selenide.sleep(2000);
        return new ApproveInstallationOrderPage();
    }

    @Step("click 'Report Defect' button")
    public InstallationOrdersAllOrdersTab clickReportDefectButton(){
        reportDefectButton.click();
        Selenide.confirm();
        return new InstallationOrdersAllOrdersTab();
    }


}
