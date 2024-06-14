package ui.pages.warehouseManagementSystem.suppliers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;
import ui.pages.warehouseManagementSystem.articles.ActionsTab;

import static com.codeborne.selenide.Selenide.$x;

public class SuppliersPage extends warehouseManagementSystemMainPage {

    public static SelenideElement allSuppliersTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'All suppliers')]");
    public static SelenideElement archiveTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'Archive')]");
    public static SelenideElement alertText = $x("//*[contains(@class, 'alert-success')]");

    @Step("Open 'Suppliers' tab")
    public ActionsTab openSuppliersTab(){
        allSuppliersTab.click();
        return new ActionsTab();
    }

    @Step("Open 'Archive' tab")
    public ArchiveTab openArchiveTab(){
        archiveTab.click();
        return new ArchiveTab();
    }
}
