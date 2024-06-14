package ui.pages.warehouseManagementSystem.vehicleRegistrationNumber;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;
import ui.pages.warehouseManagementSystem.articles.MainArticlesPage;

import static com.codeborne.selenide.Selenide.$x;

public class VehicleRegistrationNumberPage extends warehouseManagementSystemMainPage {
    public static SelenideElement createNewRegNumberButton = $x("//a[contains(., 'Create new registration number')]");
    @Step("click Create new registration number button")
    public CreateVehicleRegistrationNumberPage clickCreateNewRegNumberButton(){
        createNewRegNumberButton.click();
        return new CreateVehicleRegistrationNumberPage();
    }
}
