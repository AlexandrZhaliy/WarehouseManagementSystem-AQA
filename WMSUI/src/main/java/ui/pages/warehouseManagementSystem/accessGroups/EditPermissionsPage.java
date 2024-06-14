package ui.pages.warehouseManagementSystem.accessGroups;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.models.CategoryTitles;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class EditPermissionsPage extends warehouseManagementSystemMainPage {

    public static String checkboxesInSectionXpath = "//*[contains(.,'%s') and contains(@class, 'content-card')]//table//input";
    public static String fullAccessCheckboxXpath = "//h4[contains(.,'%s')]//following-sibling::label//input";
    public static SelenideElement rolePatternsDropdawn = $x("//button[contains(.,'Role patterns')]");
    public static String rolePatternsListWithNameInputXpath = "//input[@value='%s']";
    public static String selectedRolePatternsListWithNameXpath = "//label[contains (@for, 'access-patterns') and contains(.,'%s')]";
    public static SelenideElement rolePatternCounter = $x("//*[text()='Role patterns']//following-sibling::span");
    public static SelenideElement saveBtn = $x("//button[contains(.,'Save changes')]");
    public static SelenideElement successMsg = $x("//div[contains(@class, 'alert-success')]");
    public static SelenideElement categorySectionTitle = $x("//h4[contains(.,'Category')]");
    public static ElementsCollection categoryList = $$x("//li//lable");
    public static String sectionListInListXpath = "//*[contains(.,'%s') and contains(@class, 'content-card')]//table//input";
    public static SelenideElement searchByCategoryField = $x("//input[@placeholder = 'Search by category']");
    public static SelenideElement resetBtn = $x("//button[contains(.,'Reset')]");
    public static SelenideElement categoryCounter = $x("//h4[text()='Category']//following-sibling::span");
    public static String categoryListInListXpath = "//label[contains(.,'%s')]";
    public static SelenideElement searchByPatternInput = $x("//input[@id='access-patterns__search']");

    @Step("Verify {title} in Main page section")
    public EditPermissionsPage verifyTitleMainPage(String category) {
        categorySectionTitle.shouldHave(text(category));
        return this;
    }

    @Step("Select full access for section with title - {title}")
    public EditPermissionsPage selectFullAccess(CategoryTitles title) {
        $x(format(fullAccessCheckboxXpath, title.getName())).shouldBe(visible).click();
        return this;
    }

    @Step("Verify  full access checkbox is selected for section with title - {title}")
    public EditPermissionsPage verifyCheckboxIsSelectedFullAccess(CategoryTitles title) {
        $x(format(fullAccessCheckboxXpath, title.getName())).shouldBe(selected);
        return this;
    }

    @Step("Click 'Save' button")
    public EditPermissionsPage clickSaveBtn() {
        saveBtn.click();
        return this;
    }

    @Step("Verify Success save edit permission message")
    public EditPermissionsPage verifySuccessEditPermissionMessage() {
        successMsg.shouldBe(visible);
        successMsg.shouldHave(text("Acces Group updated"));
        return this;
    }

    @Step("Select {title} category")
    public EditPermissionsPage selectCategory(CategoryTitles title) {
        $x(format(categoryListInListXpath, title.getName())).click();
        return this;
    }

    @Step("Verify all checkboxes in section {title} are selected")
    public EditPermissionsPage verifyAllCheckboxesAreSelectedInSection(CategoryTitles title) {
        $$x(format(checkboxesInSectionXpath, title)).forEach(selenideElement -> selenideElement.shouldBe(selected));
        return this;
    }

    @Step("Type {text} key in Search by Category field")
    public EditPermissionsPage typeSearchTitleByCategoryField(String text) {
        searchByCategoryField.clear();
        searchByCategoryField.sendKeys(text);
        return this;
    }

    @Step("Verify Search Results have text - {searchKey}")
    public EditPermissionsPage verifySearchResultsInCategoryListHasText(String searchKey) {
        categoryList.forEach(selenideElement -> selenideElement.shouldHave(text(searchKey)));
        return this;
    }

    @Step("Reset selected category")
    public EditPermissionsPage resetSelectedCategory() {
        resetBtn.shouldBe(visible);
        resetBtn.click();
        return this;
    }

    @Step("Verify all checkboxes in section {title} are not selected")
    public EditPermissionsPage verifyAllCheckboxesAreNotSelectedInSection(CategoryTitles title) {
        $$x(format(checkboxesInSectionXpath, title.getName())).forEach(selenideElement -> selenideElement.shouldNotBe(selected));
        return this;
    }

    @Step("Verify category counter has number {counter}")
    public EditPermissionsPage verifyCategoryCounter(String counter) {
        categoryCounter.shouldHave(text(counter));
        return this;
    }

    @Step("Open Role patterns dropdawn")
    public EditPermissionsPage openRolePatternsDropdawn() {
        rolePatternsDropdawn.click();
        return this;
    }

    @Step("Select {role} in Role  Patterns Dropdawn List")
    public EditPermissionsPage selectRoleInRolePatternsDropdawnList(String role) {
        $x(format(selectedRolePatternsListWithNameXpath, role)).shouldBe(visible).click();
        return this;
    }

    @Step("Verify Selected {role} in Role Patterns Dropdawn List")
    public EditPermissionsPage verifySelectedRoleInRolePatternsDropdawnList(String role) {
        $x(format(rolePatternsListWithNameInputXpath, role)).shouldBe(selected);
        return this;
    }

    @Step("Verify role pattern counter has number - {counter}")
    public EditPermissionsPage verifyRolePatternCounter(String count) {
        rolePatternCounter.shouldHave(text(count));
        return this;
    }

    @Step("Type {role} in search role pattern input")
    public EditPermissionsPage searchRoleInRolePatternSearchField(String role){
        searchByPatternInput.clear();
        searchByPatternInput.type(role);
        return this;
    }

}