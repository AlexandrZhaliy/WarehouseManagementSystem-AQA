package ui.pages.warehouseManagementSystem.orders;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.models.ArticleStatus;
import ui.pages.warehouseManagementSystem.articles.ArticlePage;
import ui.pages.warehouseManagementSystem.articles.TransactionsTab;

import static com.codeborne.selenide.Selenide.$x;

public class InformationTab extends OrderPage {
    public static SelenideElement doneButton = $x("//button[contains(., 'Done')]");
    public static SelenideElement receivedButton = $x("//button[contains(., 'Received')]");
    public static SelenideElement depreciatedButton = $x("//button[contains(., 'Depreciated')]");
    public static SelenideElement submitButton = $x("//button[contains(., 'Submit')]");

    @Step("click 'Depreciated' button")
    public InformationTab clickDepreciatedButton() {
        depreciatedButton.click();
        submitButton.shouldBe(Condition.visible).click();
        submitButton.shouldBe(Condition.hidden);
        return new InformationTab();
    }
    @Step("click 'Done' button")
    public InformationTab clickDoneButton() {
        doneButton.click();
        submitButton.shouldBe(Condition.visible).click();
        submitButton.shouldBe(Condition.hidden);
        return new InformationTab();
    }

    @Step("click 'Received' button")
    public InformationTab clickReceivedButton() {
        receivedButton.click();
        submitButton.shouldBe(Condition.visible).click();
        submitButton.shouldBe(Condition.hidden);
        return new InformationTab();
    }
}
