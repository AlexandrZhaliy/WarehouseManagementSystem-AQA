package ui.pages.warehouseManagementSystem.accessGroups;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class AddPermissionsPage extends warehouseManagementSystemMainPage {
    public static String fullAccessCheckbox = "//h4[contains(., '%s')]/following-sibling::label//input";
    public static SelenideElement allocateOrdersFullAccessButton = $x(format(fullAccessCheckbox, "Allocate Orders"));
    public static SelenideElement articlesFullAccessButton = $x(format(fullAccessCheckbox, "Articles"));

    public static SelenideElement saveChangesButton = $x("//button[contains(., 'Save changes')]");
    public static SelenideElement groupUpdatedAlert = $x("//*[contains(., 'Acces Group updated') and contains(@class, 'alert')]");

    @Step("click 'Save changes' Button")
    public AddPermissionsPage clickSaveChangesButton(){
        saveChangesButton.click();
        groupUpdatedAlert.shouldBe(visible);
        return this;
    }

    @Step("click Allocate Orders Full access button")
    public AddPermissionsPage clickAllocateOrdersFullAccessButton(){
        allocateOrdersFullAccessButton.click();
        return this;
    }

    @Step("click Articles Full access button")
    public AddPermissionsPage clickArticlesFullAccessButton(){
        articlesFullAccessButton.click();
        return this;
    }
}
