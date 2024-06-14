package ui.pages.warehouseManagementSystem.reports;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import static com.codeborne.selenide.Selenide.$x;

public class ReportsPage extends warehouseManagementSystemMainPage {
    public static SelenideElement createReportButton = $x("//button[contains(., 'Create report')]");

    public static SelenideElement articlesTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'Articles')]");
    public static SelenideElement warehousesTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'Warehouses')]");
    public static SelenideElement ordersTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'Orders')]");
    public static SelenideElement installationOrdersTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'Installation Orders')]");

    @Step("Open 'Installation Orders' tab")
    public InstallationOrdersTab openInstallationOrdersTab() {
        installationOrdersTab.click();
        InstallationOrdersTab.headerText.shouldBe(Condition.visible);
        return new InstallationOrdersTab();
    }
    @Step("Open 'Orders' tab")
    public OrdersTab openOrdersTab() {
        ordersTab.click();
        OrdersTab.headerText.shouldBe(Condition.visible);
        return new OrdersTab();
    }
    @Step("Open 'Warehouses' tab")
    public WarehousesTab openWarehousesTab() {
        warehousesTab.click();
        WarehousesTab.headerText.shouldBe(Condition.visible);
        return new WarehousesTab();
    }

    @Step("Open 'Articles' tab")
    public ArticlesTab openArticlesTab() {
        articlesTab.click();
        ArticlesTab.headerText.shouldBe(Condition.visible);
        return new ArticlesTab();
    }
}