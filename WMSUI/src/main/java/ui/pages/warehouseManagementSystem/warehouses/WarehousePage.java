package ui.pages.warehouseManagementSystem.warehouses;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import static com.codeborne.selenide.Selenide.$x;

public class WarehousePage extends warehouseManagementSystemMainPage {

    public static SelenideElement reportTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'Report')]");

    @Step("Open 'Report' tab")
    public ReportTab openReportTab(){
        reportTab.click();
        return new ReportTab();
    }

}
