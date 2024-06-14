package ui.pages.warehouseManagementSystem.accessGroups;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import static com.codeborne.selenide.Selenide.$x;

public class CreateNewRolePage extends warehouseManagementSystemMainPage {
    public static SelenideElement nameInput = $x("//input[contains(@id, 'form-create-new-role__name')]");
    public static SelenideElement descriptionInput = $x("//textarea[contains(@id, 'form-create-new-role__description')]");

    public static SelenideElement createAndConfigureButton = $x("//button[contains(., 'Create and configure')]");

    @Step("click 'Create and configure' Button")
    public AddPermissionsPage clickCreateAndConfigureButton(){
        createAndConfigureButton.click();
        return new AddPermissionsPage();
    }
    @Step("Type 'name' - {name}")
    public CreateNewRolePage name(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    @Step("Type 'description' - {description}")
    public CreateNewRolePage description(String description) {
        descriptionInput.sendKeys(description);
        return this;
    }
}
