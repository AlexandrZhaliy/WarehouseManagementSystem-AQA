package ui.pages.warehouseManagementSystem.installationOrders;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class ApproveInstallationOrderPage extends warehouseManagementSystemMainPage {
    public static SelenideElement submitButton = $x("//button[text()='Submit']");
    public static SelenideElement frontPlateInput = $x("//*[contains(@id, 'installationorderapproveform-front_plate')]");
    public static SelenideElement rearPlateInput = $x("//*[contains(@id, 'installationorderapproveform-rear_plate')]");

    @Step("upload Front plate img")
    public ApproveInstallationOrderPage selectFrontPlateImg() {
        frontPlateInput.uploadFile(new File(filePath));
        return this;
    }

    @Step("upload Rear plate img")
    public ApproveInstallationOrderPage selectRearPlateImg() {
        rearPlateInput.uploadFile(new File(filePath));
        return this;
    }

    @Step("click Submit button")
    public InstallationOrdersAllOrdersTab clickSubmitButton(){
        submitButton.click();
        Selenide.sleep(2000);
        return new InstallationOrdersAllOrdersTab();
    }
}
