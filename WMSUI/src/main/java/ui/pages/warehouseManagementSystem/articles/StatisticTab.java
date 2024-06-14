package ui.pages.warehouseManagementSystem.articles;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.models.ArticleStatus;
import ui.pages.warehouseManagementSystem.warehouses.WarehousePage;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class StatisticTab extends ArticlePage {
    public static SelenideElement totalAmountText = $x("//*[contains(@class, 'card')][./*[contains(., 'Total amount')]]//*[@class='card-body']");
    public static SelenideElement totalReservedAmountText = $x("//*[contains(@class, 'card')][./*[contains(., 'Total reserved amount')]]//*[@class='card-body']");
    public static SelenideElement headerText = $x("//*[contains(@id, 'moduleTitle') and contains(., 'Statistic')]");

    public static String TRANSFER_UNIQUE_ARTICLES = "Transfer (Unique articles)";

    @Step("verify 'Total amount' is - {amount}")
    public StatisticTab verifyTotalAmountIs(String amount) {
        totalAmountText.shouldHave(Condition.text(amount));
        return this;
    }

    @Step("verify 'Total reserved amount' is - {amount}")
    public StatisticTab verifyTotalReservedAmountIs(String amount) {
        totalReservedAmountText.shouldHave(Condition.text(amount));
        return this;
    }
}
