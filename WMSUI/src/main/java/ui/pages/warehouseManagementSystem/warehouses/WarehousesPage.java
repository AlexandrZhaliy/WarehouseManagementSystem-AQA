package ui.pages.warehouseManagementSystem.warehouses;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import static com.codeborne.selenide.Selenide.$x;

public class WarehousesPage extends warehouseManagementSystemMainPage {

    public static SelenideElement allWarehousesTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'All warehouses')]");
    public static SelenideElement archiveTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'Archive')]");
    public static SelenideElement alertText = $x("//*[contains(@class, 'alert-success')]");

    @Step("Open 'Actions' tab")
    public AllWarehousesTab openAllWarehousesTab(){
        allWarehousesTab.click();
        return new AllWarehousesTab();
    }

    @Step("Open 'Archive' tab")
    public ArchiveTab openArchiveTab(){
        archiveTab.click();
        return new ArchiveTab();
    }
}