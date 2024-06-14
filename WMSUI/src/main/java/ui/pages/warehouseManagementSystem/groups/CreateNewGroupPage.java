package ui.pages.warehouseManagementSystem.groups;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.InnerMainPage;
import ui.pages.warehouseManagementSystem.companies.CreateOwnCompanyPopup;

import static com.codeborne.selenide.Selenide.$x;

public class CreateNewGroupPage extends InnerMainPage {
    public static SelenideElement groupNameInput = $x("//*[contains(@id, 'group-name')]");
    public static SelenideElement typeInput = $x("//span[contains(@id, 'type-id')]");
    public static SelenideElement parentInput = $x("//span[contains(@id, 'parent-id')]");
    public static SelenideElement submitButton = $x("//button[contains(text(), 'Submit')]");

    @Step("Type group type - {type}")
    public CreateNewGroupPage type(String type) {
        selectInAutocomplete(typeInput, type);
        return this;
    }

    @Step("Type parent type - {type}")
    public CreateNewGroupPage parent(String type) {
        selectInAutocomplete(parentInput, type);
        return this;
    }

    @Step("Type group name - {name}")
    public CreateNewGroupPage groupName(String name) {
        groupNameInput.sendKeys(name);
        return this;
    }

    @Step("click submit button")
    public GroupsTab clickSubmitButton() {
        submitButton.click();
        Selenide.sleep(2000);
        return new GroupsTab();
    }
}
