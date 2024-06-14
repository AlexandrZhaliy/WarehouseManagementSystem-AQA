package ui.pages.warehouseManagementSystem.orders;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;
import ui.pages.warehouseManagementSystem.articles.ActionsTab;
import ui.pages.warehouseManagementSystem.articles.UnicityTab;

import static com.codeborne.selenide.Selenide.$x;

public class OrdersPage extends warehouseManagementSystemMainPage {

    public static SelenideElement allOrdersTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'All orders')]");
    public static SelenideElement draftsTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'Drafts')]");

    @Step("Open All orders tab")
    public ActionsTab openAllOrdersTab(){
        allOrdersTab.click();
        return new ActionsTab();
    }

    @Step("Open Drafts tab")
    public UnicityTab openDraftsTab(){
        draftsTab.click();
        return new UnicityTab();
    }
}
