package ui.pages.warehouseManagementSystem.articles;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.models.ArticleStatus;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ActionsTab extends ArticlePage {
    public static SelenideElement warehouseInput = $x("//span[contains(@id, 'ransactionActionWarehouseToId')]");
    public static SelenideElement amountInput = $x("//*[@id='transactionActionAmount']");
    public static SelenideElement statusInput = $x("//span[contains(@id, 'transactionwarehouseinactionform-status')]");
    public static SelenideElement submitButton = $x("//button[contains(text(), 'Submit')]");

    @Step("click Submit button")
    public TransactionsTab clickSubmitButton() {
        submitButton.click();
        submitButton.shouldNotBe(visible);
        return new TransactionsTab();
    }

    @Step("Select warehouse - {name}")
    public ActionsTab warehouseName(String name) {
        selectInAutocomplete(warehouseInput, name);
        return this;
    }

    @Step("Select status - {status}")
    public ActionsTab selectStatus(ArticleStatus status) {
        selectInAutocomplete(statusInput, status.getName());
        return this;
    }

    @Step("Type amount - {amount}")
    public ActionsTab amountNumber(String amount) {
        amountInput.sendKeys(amount);
        return this;
    }


}
