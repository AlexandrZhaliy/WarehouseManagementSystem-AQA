package ui.pages.warehouseManagementSystem.storageUnits;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.warehouseManagementSystem.warehouseManagementSystemMainPage;

import static com.codeborne.selenide.Selenide.$x;

public class UnitsPage extends warehouseManagementSystemMainPage {

    public static SelenideElement allUnitsTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'All units')]");
    public static SelenideElement archiveTab = $x("//*[contains(@class, 'secondary-navigation')]//a[contains(., 'Archive')]");
    public static SelenideElement alertText = $x("//*[contains(@class, 'alert-success')]");

    @Step("Open 'All Units' tab")
    public AllUnitsTab openAllUnitsTab(){
        allUnitsTab.click();
        return new AllUnitsTab();
    }

    @Step("Open 'Archive' tab")
    public ArchiveTab openArchiveTab(){
        archiveTab.click();
        return new ArchiveTab();
    }
}