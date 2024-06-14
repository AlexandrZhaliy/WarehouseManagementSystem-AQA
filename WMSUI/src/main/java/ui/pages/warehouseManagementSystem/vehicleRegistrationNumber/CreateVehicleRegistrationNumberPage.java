package ui.pages.warehouseManagementSystem.vehicleRegistrationNumber;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;
import ui.pages.warehouseManagementSystem.articles.CreateNewArticlePage;
import ui.pages.warehouseManagementSystem.articles.MainArticlesPage;

import static com.codeborne.selenide.Selenide.$x;

public class CreateVehicleRegistrationNumberPage extends WarehouseManagementSystemMainPage {
    public static SelenideElement linkButton = $x("//button[text()='Link']");
    public static SelenideElement frontPlateInput = $x("//span[contains(@id, 'vehicleregistrationnumbercreatemodel-front_plate')]");
    public static SelenideElement rearPlateInput = $x("//span[contains(@id, 'vehicleregistrationnumbercreatemodel-rear_plate')]");
    public static SelenideElement registrationNumberInput = $x("//*[contains(@id, 'vehicleregistrationnumbercreatemodel-registration_number')]");

    @Step("Type Registration number - {number}")
    public CreateVehicleRegistrationNumberPage typeRegistrationNumber(String number) {
        registrationNumberInput.click();
        Selenide.sleep(2000);
        registrationNumberInput.shouldBe(Condition.visible).sendKeys(number);
        return this;
    }
    @Step("Select Front plate - {plate}")
    public CreateVehicleRegistrationNumberPage selectFrontPlate(String plate) {
        selectInAutocomplete(frontPlateInput, plate);
        return this;
    }

    @Step("Select Rear plate - {plate}")
    public CreateVehicleRegistrationNumberPage selectRearPlate(String plate) {
        selectInAutocomplete(rearPlateInput, plate);
        return this;
    }

    @Step("click Link button")
    public VehicleRegistrationNumberPage clickLinkButton(){
        linkButton.click();
        Selenide.sleep(2000);
        return new VehicleRegistrationNumberPage();
    }
}
