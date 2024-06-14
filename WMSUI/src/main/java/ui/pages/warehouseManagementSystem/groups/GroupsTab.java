package ui.pages.warehouseManagementSystem.groups;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.InnerMainPage;
import ui.pages.warehouseManagementSystem.companies.CreateOwnCompanyPopup;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class GroupsTab extends InnerMainPage {
    public static SelenideElement createNewGroupButton = $x("//a[contains(., 'Create new group')]");
    public static SelenideElement groupListButton = $x("//span[contains(@id, 'select2-w0-container')]");

    @Step("click Create new group Button")
    public CreateNewGroupPage clickCreateNewGroupButton(){
        createNewGroupButton.click();
        return new CreateNewGroupPage();
    }
    @Step("Select group type {group}")
    public GroupsTab selectGroupType(String group) {
        groupListButton.click();
        results.find(Condition.partialText(group)).click();
        return this;
    }
}
