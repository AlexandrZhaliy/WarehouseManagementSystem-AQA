package ui.pages.warehouseManagementSystem.installationKits;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;
import utilsHelper.DataProvider;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class InstallationKitsPage extends warehouseManagementSystemMainPage {
    public static SelenideElement createNewKitButton = $x("//a[contains(., 'Create new kit')]");

    public String installationKitNumberXpath = "//tr[contains(., '%s')]//td[1]";
    public String vehicleRegNumberXpath = "//tr[contains(., '%s')]//td[2]";

    public static String installationKitNumber;

    @Step("click Create New Kit button")
    public CreateInstallationKitPage clickCreateNewKitButton(){
        createNewKitButton.click();
        return new CreateInstallationKitPage();
    }

    @Step("Save Installation Kit number")
    public InstallationKitsPage saveInstallationKitNumber(String installationWarehouse) {
        installationKitNumber = $x(format(installationKitNumberXpath, installationWarehouse)).getText();
        return this;
    }

    @Step("Save 'Vehicle Registration Number'")
    public InstallationKitsPage saveVehicleRegistrationNumber(DataProvider provider) {
        provider.vehicleRegistrationNumber = $x(format(vehicleRegNumberXpath, provider.warehouseName)).getText();
        return this;
    }
}
