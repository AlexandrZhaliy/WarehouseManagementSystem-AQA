package ui.pages.warehouseManagementSystem.companies;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import static com.codeborne.selenide.Selenide.$x;

public class CompaniesPage extends warehouseManagementSystemMainPage {

    public static SelenideElement allCompaniesTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'All companies')]");
    public static SelenideElement archiveTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'Archive')]");
    public static SelenideElement alertText = $x("//*[contains(@class, 'alert-success')]");

    @Step("Open 'All companies' tab")
    public AllCompaniesTab openAllCompaniesTab() {
        allCompaniesTab.click();
        return new AllCompaniesTab();
    }

    @Step("Open 'Archive' tab")
    public ArchiveTab openArchiveTab() {
        archiveTab.click();
        return new ArchiveTab();
    }
}