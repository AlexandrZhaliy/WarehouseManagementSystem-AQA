package ui.pages.warehouseManagementSystem.manufacturers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import static com.codeborne.selenide.Selenide.$x;

public class ManufacturersPage extends warehouseManagementSystemMainPage {

    public static SelenideElement allManufacturersTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'All manufacturers')]");
    public static SelenideElement archiveTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'Archive')]");
    public static SelenideElement alertText = $x("//*[contains(@class, 'alert-success')]");

    @Step("Open 'All Manufacturers' tab")
    public AllManufacturersTab openAllManufacturersTab(){
        allManufacturersTab.click();
        return new AllManufacturersTab();
    }

    @Step("Open 'Archive' tab")
    public ArchiveTab openArchiveTab(){
        archiveTab.click();
        return new ArchiveTab();
    }
}
