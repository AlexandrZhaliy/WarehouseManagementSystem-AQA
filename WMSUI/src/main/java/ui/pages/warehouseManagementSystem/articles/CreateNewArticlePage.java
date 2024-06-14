package ui.pages.warehouseManagementSystem.articles;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.models.ArticleGroup;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CreateNewArticlePage extends warehouseManagementSystemMainPage {
    public static SelenideElement nameInput = $x("//*[@id='article-name']");
    public static SelenideElement storageUnitInput = $x("//span[contains(@id, 'article-unit_id')]");
    public static SelenideElement groupInput = $x("//span[contains(@id, 'article-group_id')]");
    public static SelenideElement storageUnitNameInput = $x("//*[@id='unit-value']");
    public static SelenideElement numberInput = $x("//*[@id='article-serial_number']");
    public static SelenideElement addStorageUnitButton = $x("//button[@id='article-unit_id-ajax-create-btn']");
    public static SelenideElement modalSaveButton = $x("//*[@id='createUnitForm']//button[contains(.,'Save')]");
    public static SelenideElement saveButton = $x("//button[contains(.,'Save')]");

    @Step("Type article name - {name}")
    public CreateNewArticlePage articleName(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    @Step("Type Module Number - {number}")
    public CreateNewArticlePage moduleNumber(String number) {
        numberInput.sendKeys(number);
        return this;
    }

    @Step("click 'Add Storage Unit' button")
    public CreateNewArticlePage clickAddStorageUnit(){
        addStorageUnitButton.click();
        return this;
    }

    @Step("Type Storage Unit name - {name}")
    public CreateNewArticlePage storageUnitName(String name) {
        storageUnitNameInput.sendKeys(name);
        return this;
    }

    @Step("click 'Save Add Storage Unit' button")
    public CreateNewArticlePage clickSaveAddStorageUnit(){
        modalSaveButton.doubleClick();
        modalSaveButton.shouldNotBe(visible);
        return this;
    }

    public CreateNewArticlePage addStorageUnit(String name){
        clickAddStorageUnit();
        storageUnitName(name);
        clickSaveAddStorageUnit();
        return this;
    }

    @Step("Select Storage Unit - {storageUnit}")
    public CreateNewArticlePage selectStorageUnit(String storageUnit) {
        selectInAutocomplete(storageUnitInput, storageUnit);
        return this;
    }

    @Step("Select Group - {storageUnit}")
    public CreateNewArticlePage selectGroup(ArticleGroup group) {
        selectInAutocomplete(groupInput, group.getName());
        return this;
    }

    @Step("click Save button")
    public MainArticlesPage saveNewArticle(){
        saveButton.click();
        saveButton.shouldBe(Condition.hidden);
        return new MainArticlesPage();
    }
}
