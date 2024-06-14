package ui.pages.warehouseManagementSystem.orders;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import ui.models.SendArticleType;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;
import ui.pages.warehouseManagementSystem.articles.MainArticlesPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CreateNewOrderPage extends warehouseManagementSystemMainPage {
    public static SelenideElement nameInput = $x("//*[@id='article-name']");
    public static SelenideElement companyFromInput = $x("//span[contains(@id, 'transportfromdestinationdata-company_id')]");
    public static SelenideElement companyToInput = $x("//span[contains(@id, 'transporttodestinationdata-company_id')]");
    public static SelenideElement companyWarehouseFromInput = $x("//span[contains(@id, 'transportfromdestinationdata-warehouse_id')]");
    public static SelenideElement companyWarehouseToInput = $x("//span[contains(@id, 'transporttodestinationdata-warehouse_id')]");
    public static ElementsCollection articlesInput = $$x("//span[contains(@id, 'article_id')]");
    public static ElementsCollection installationKitInput = $$x("//span[contains(@id, 'installation_kit_id')]");
    public static ElementsCollection articlesTypeInput = $$x("//span[contains(@id, 'template_type')]");
    public static ElementsCollection articlesAmountInput = $$x("//input[contains(@id, '-amount')]");

    public static SelenideElement deliveryDateInput = $x("//*[@id='informationdata-delivery_date']");
    public static SelenideElement addArticlesButton = $x("//button[@id='addArticleButton']");
    public static SelenideElement addKitButton = $x("//button[@id='addKitButton']");
    public static SelenideElement saveAndConfirmButton = $x("//button[contains(.,'Save and confirm')]");
    public static SelenideElement saveButton = $x("//button[contains(.,'Save')]");
    public static ElementsCollection uniqArticleSearchInput = $$x("//*[contains(@id, 'uniqueArticleIdFiel')]//*[contains(@class, 'search__field')]");


    @Step("Click 'Save and confirm' button")
    public OrdersPage clickSaveAndConfirmButton() {
        saveAndConfirmButton.scrollIntoView(true).click();
        saveAndConfirmButton.shouldBe(Condition.hidden);
        return new OrdersPage();
    }

    @Step("Click 'Add Articles'")
    public CreateNewOrderPage clickAddArticlesButton() {
        addArticlesButton.scrollIntoView(true).click();
        return this;
    }

    @Step("Click 'Add Installation Kit'")
    public CreateNewOrderPage clickAddInstallationKitButton() {
        addKitButton.scrollIntoView(true).click();
        return this;
    }


    @Step("Type 'Delivery date' - {date}")
    public CreateNewOrderPage typeDeliveryDate(String date) {
        deliveryDateInput.sendKeys(date);
        return this;
    }

    @Step("Select 'Article' - {article}")
    public CreateNewOrderPage selectArticle(String article) {
        selectInAutocomplete(articlesInput.last(), article);
        return this;
    }

    @Step("Select 'Installation Kit' - {number}")
    public CreateNewOrderPage selectInstallationKitNumber(String number) {
        selectInAutocomplete(installationKitInput.last(), number);
        return this;
    }

    @Step("Select 'Article amount' - {amount}")
    public CreateNewOrderPage selectArticleAmount(String amount) {
        articlesAmountInput.last().sendKeys(amount);
        return this;
    }

    @Step("Select 'Uniq Article' - {article}")
    public CreateNewOrderPage selectUniqArticle(String article) {
        uniqArticleSearchInput.last().sendKeys(article);
        results.shouldBe(CollectionCondition.sizeGreaterThanOrEqual(1)).find(Condition.partialText(article)).click();
        return this;
    }

    @Step("Select 'Article Type' - {articleType}")
    public CreateNewOrderPage selectArticleType(SendArticleType articleType) {
        selectInAutocomplete(articlesTypeInput.last(), articleType.getName());
        return this;
    }

    @Step("Select 'From company' - {company}")
    public CreateNewOrderPage selectFromCompany(String company) {
        selectInAutocomplete(companyFromInput, company);
        return this;
    }

    @Step("Select 'From company warehouse' - {warehouse}")
    public CreateNewOrderPage selectFromCompanyWarehouse(String warehouse) {
        Selenide.sleep(2000);
        selectInAutocomplete(companyWarehouseFromInput, warehouse);
        return this;
    }

    @Step("Select 'To company warehouse' - {warehouse}")
    public CreateNewOrderPage selectToCompanyWarehouse(String warehouse) {
        Selenide.sleep(2000);
        selectInAutocomplete(companyWarehouseToInput, warehouse);
        return this;
    }

    @Step("Select 'To company' - {company}")
    public CreateNewOrderPage selectToCompany(String company) {
        selectInAutocomplete(companyToInput, company);
        return this;
    }

    @Step("click Save button")
    public MainArticlesPage saveNewArticle() {
        saveButton.click();
        return new MainArticlesPage();
    }
}
